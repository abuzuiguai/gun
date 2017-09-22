package com.iharding.gun.web;

import com.iharding.gun.core.api.Response;
import com.iharding.gun.core.api.PageDataInput;
import com.iharding.gun.core.api.PageDataOutput;
import com.iharding.gun.core.web.BaseController;
import com.iharding.gun.proxy.BlackProxy;
import com.iharding.gun.util.Configuration;
import com.iharding.gun.util.SpringContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * Created by fyeman on 2017/9/15.
 */
@Controller
@RequestMapping("/web")
public class WebController<T, E, ID extends Serializable> extends BaseController<T, E, ID> {

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
