package com.iharding.gun.proxy;

import com.iharding.gun.core.api.PageDataInput;
import com.iharding.gun.core.api.PageDataOutput;

/**
 * Created by fyeman on 2017/9/20.
 */
public interface BlackProxy {
    public PageDataOutput analyze(PageDataInput input, PageDataOutput output) throws Exception;
}
