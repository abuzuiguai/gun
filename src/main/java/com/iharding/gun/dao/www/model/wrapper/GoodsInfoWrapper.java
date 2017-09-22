package com.iharding.gun.dao.www.model.wrapper;

import com.google.common.collect.Lists;
import com.iharding.gun.dao.www.model.GoodsInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by fyeman on 2017/9/22.
 */
@Getter
@Setter
public class GoodsInfoWrapper extends GoodsInfo {
    List<RouteInfoWrapper> routeInfoWrapperList = Lists.newArrayList();
    WebsiteInfoWrapper websiteInfoWrapper;
}
