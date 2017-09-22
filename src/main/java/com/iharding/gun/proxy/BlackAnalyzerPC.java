package com.iharding.gun.proxy;

import com.iharding.gun.core.api.PageDataInput;
import com.iharding.gun.core.api.PageDataOutput;
import com.iharding.gun.dao.www.model.wrapper.GoodsInfoWrapper;
import com.iharding.gun.dao.www.model.wrapper.RouteInfoWrapper;
import com.iharding.gun.service.www.GoodsInfoService;
import com.iharding.gun.service.www.WebsiteInfoService;
import com.iharding.gun.simulator.selenium.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fyeman on 2017/9/20.
 */
@Component(value="blackAnalyzerPC")
public class BlackAnalyzerPC extends BlackAnalyzer {
    @Autowired
    WebsiteInfoService websiteInfoService;
    @Autowired
    GoodsInfoService goodsInfoService;

    public PageDataOutput analyze(PageDataInput input, PageDataOutput output) throws Exception {
        super.initPCEnvironment();
        GoodsInfoWrapper goodsInfoWrapper = goodsInfoService.selectWrapperByPrimaryKey(input.getGoodsId());

        SeleniumUtil seleniumUtil = new SeleniumUtil();
        WebDriver driver = seleniumUtil.register(goodsInfoWrapper.getWebsiteInfoWrapper().getSite());

        for (RouteInfoWrapper routeInfoWrapper : goodsInfoWrapper.getRouteInfoWrapperList()) {
            seleniumUtil.createElement(driver, routeInfoWrapper);
        }
        driver.close();
        return output;
    }
}
