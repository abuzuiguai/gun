package com.iharding.gun.web;

import com.iharding.gun.common.Response;
import com.iharding.gun.model.PageDataInput;
import com.iharding.gun.model.PageDataOutput;
import com.iharding.gun.proxy.BlackAnalyzer;
import com.iharding.gun.proxy.BlackProxy;
import com.iharding.gun.util.Configuration;
import com.iharding.gun.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fyeman on 2017/9/15.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @ResponseBody
    @RequestMapping("/start")
    public Response<PageDataOutput> produce(PageDataInput input, PageDataOutput output) {
        Response<PageDataOutput> response = new Response<PageDataOutput>();
        response.start();
        try {
            if (StringUtils.isEmpty(input.getSimulator())) {
                input.setSimulator(Configuration.getProperty("application.simulator"));
            }

            BlackProxy proxy = null;
            switch (input.getSimulator()) {
                case "pc":
                    proxy = SpringContextUtil.getBean("blackAnalyzerPC");
                    break;
                case "android":
                    proxy = SpringContextUtil.getBean("blackAnalyzerAndroid");
                    break;
            }
            output = proxy.analyze(input, output);
            //结果处理  ResultContent添加方法

            response.setData(output);
        } catch (Exception e) {
            return response.failure(e.getMessage());
        }
        return response;
    }
}
