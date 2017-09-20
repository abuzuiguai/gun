package com.iharding.gun.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by fyeman on 2017/9/15.
 */
@Getter
@Setter
public class Response<T> {
    T data;
}
