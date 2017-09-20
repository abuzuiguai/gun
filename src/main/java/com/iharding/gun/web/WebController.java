package com.iharding.gun.web;

import com.iharding.gun.common.Response;
import com.iharding.gun.model.PageDataInput;
import com.iharding.gun.model.PageDataOutput;
import org.springframework.stereotype.Controller;
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
    public Response<PageDataOutput> startProduce() {
        Response<PageDataOutput> response = new Response<PageDataOutput>();

//        output.setId(3L);
//        output.setName("楼");
//        response.setData(output);

        return response;
    }
}
