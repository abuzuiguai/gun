package com.iharding.gun.service.www.impl;

import com.iharding.gun.core.service.BaseServiceImpl;
import com.iharding.gun.dao.www.mapper.CommentInfoMapper;
import com.iharding.gun.dao.www.model.CommentInfo;
import com.iharding.gun.dao.www.model.wrapper.CommentInfoWrapper;
import com.iharding.gun.service.www.CommentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentInfoServiceImpl extends BaseServiceImpl<CommentInfo, CommentInfoWrapper, Long> implements CommentInfoService {
	@Autowired
	CommentInfoMapper commentInfoMapper;
}
