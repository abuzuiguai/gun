package com.iharding.gun.proxy;

import com.iharding.gun.model.PageDataInput;
import com.iharding.gun.model.PageDataOutput;

/**
 * Created by fyeman on 2017/9/20.
 */
public abstract class BlackAnalyzer implements BlackProxy {
    public abstract PageDataOutput analyze(PageDataInput input, PageDataOutput output) throws Exception;
}
