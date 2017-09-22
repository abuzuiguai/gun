package com.iharding.gun.web.controller;

import com.iharding.gun.dao.www.model.WebsiteInfo;
import com.iharding.gun.dao.www.model.wrapper.WebsiteInfoWrapper;
import com.iharding.gun.service.www.GoodsInfoService;
import com.iharding.gun.service.www.WebsiteInfoService;
import com.iharding.gun.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fyeman on 2017/9/22.
 */
@Controller
@RequestMapping("/website")
public class WebsiteInfoController extends WebController<WebsiteInfo, WebsiteInfoWrapper, Long> {
    @Autowired
    WebsiteInfoService websiteInfoService;
    protected void initBinder(WebDataBinder binder) {
        super.setBaseService(websiteInfoService);
    }
}
