package com.iharding.gun.proxy;

import com.iharding.gun.core.api.PageDataInput;
import com.iharding.gun.core.api.PageDataOutput;
import com.iharding.gun.util.Configuration;

/**
 * Created by fyeman on 2017/9/20.
 */
public abstract class BlackAnalyzer implements BlackProxy {
    public abstract PageDataOutput analyze(PageDataInput input, PageDataOutput output) throws Exception;

    protected void initPCEnvironment() {
        if (System.getProperty("webdriver.firefox.bin") == null) {
            System.setProperty("webdriver.firefox.bin", Configuration.getProperty("webdriver.firefox.bin"));
        }
        if (System.getProperty("webdriver.gecko.driver") == null) {
            System.setProperty("webdriver.gecko.driver", Configuration.getProperty("webdriver.gecko.driver"));
        }
    }
}
