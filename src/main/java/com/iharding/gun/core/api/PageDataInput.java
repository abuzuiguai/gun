package com.iharding.gun.core.api;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by fyeman on 2017/9/15.
 */
@Getter
@Setter
public class PageDataInput<T> {
    private String simulator;
    private Long goodsId;
}
