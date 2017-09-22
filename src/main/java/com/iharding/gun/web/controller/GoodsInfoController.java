package com.iharding.gun.web.controller;

import com.iharding.gun.core.web.BaseController;
import com.iharding.gun.dao.www.model.GoodsInfo;
import com.iharding.gun.dao.www.model.wrapper.GoodsInfoWrapper;
import com.iharding.gun.service.www.GoodsInfoService;
import com.iharding.gun.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fyeman on 2017/9/22.
 */
@Controller
@RequestMapping("/goods")
public class GoodsInfoController extends WebController<GoodsInfo, GoodsInfoWrapper, Long> {
    @Autowired
    GoodsInfoService goodsInfoService;
    protected void initBinder(WebDataBinder binder) {
        super.setBaseService(goodsInfoService);
    }
}
