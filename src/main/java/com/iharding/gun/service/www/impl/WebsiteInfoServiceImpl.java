package com.iharding.gun.service.www.impl;

import com.iharding.gun.core.service.BaseServiceImpl;
import com.iharding.gun.dao.www.mapper.WebsiteInfoMapper;
import com.iharding.gun.dao.www.model.WebsiteInfo;
import com.iharding.gun.dao.www.model.wrapper.WebsiteInfoWrapper;
import com.iharding.gun.service.www.WebsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteInfoServiceImpl extends BaseServiceImpl<WebsiteInfo, WebsiteInfoWrapper, Long> implements WebsiteInfoService {
	@Autowired
	WebsiteInfoMapper websiteInfoMapper;
}
