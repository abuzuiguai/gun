package com.iharding.gun.service.www.impl;

import com.iharding.gun.core.service.BaseServiceImpl;
import com.iharding.gun.dao.www.mapper.RouteInfoMapper;
import com.iharding.gun.dao.www.model.RouteInfo;
import com.iharding.gun.dao.www.model.wrapper.RouteInfoWrapper;
import com.iharding.gun.service.www.RouteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteInfoServiceImpl extends BaseServiceImpl<RouteInfo, RouteInfoWrapper, Long> implements RouteInfoService {
	@Autowired
	RouteInfoMapper routeInfoMapper;
}
