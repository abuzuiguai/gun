package com.iharding.gun.service.www.impl;

import com.iharding.gun.core.service.BaseServiceImpl;
import com.iharding.gun.dao.www.mapper.GoodsInfoMapper;
import com.iharding.gun.dao.www.mapper.RouteInfoMapper;
import com.iharding.gun.dao.www.mapper.WebsiteInfoMapper;
import com.iharding.gun.dao.www.model.GoodsInfo;
import com.iharding.gun.dao.www.model.wrapper.GoodsInfoWrapper;
import com.iharding.gun.dao.www.model.wrapper.RouteInfoWrapper;
import com.iharding.gun.service.www.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsInfo, GoodsInfoWrapper, Long> implements GoodsInfoService {
	@Autowired
	GoodsInfoMapper goodsInfoMapper;
	@Autowired
	WebsiteInfoMapper websiteInfoMapper;
	@Autowired
	RouteInfoMapper routeInfoMapper;
	/**
	 *
	 * @Title: selectWrapperByPrimaryKey
	 * @Description: 用户扩展信息
	 * @param id
	 * @return
	 * E
	 * @throws
	 */
	@Override
	public GoodsInfoWrapper selectWrapperByPrimaryKey(Long id) {
		GoodsInfoWrapper goodsInfoWrapper = goodsInfoMapper.selectWrapperByPrimaryKey(id);
		//站点信息
		goodsInfoWrapper.setWebsiteInfoWrapper(websiteInfoMapper.selectWrapperByPrimaryKey(goodsInfoWrapper.getWebsiteId()));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsId", id);
		List<RouteInfoWrapper> routeInfoWrapperList = routeInfoMapper.selectListWrapper(map);
		goodsInfoWrapper.setRouteInfoWrapperList(routeInfoWrapperList);

		return goodsInfoWrapper;
	}
}
