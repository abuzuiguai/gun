package com.iharding.gun.util;

/**
 * Created by fyeman on 2017/9/20.
 */
public class Constants {
    /**
     * 以下为接口返回公共属性定义常量
     */
    public static final String MSG_SUCCESS = "操作成功";	//操作成功
    public static final String MSG_FALURE = "操作失败";	//操作失败

    public static final long INVALIDATE_VALUE = -1;		//起止时间定义
    public static final int RET_SUCCESS = 0; 			//成功
    public static final int RET_FAIL = 1; 				//失败
    public static final int RET_ERROR_PARAM = -1; 		//参数校验失败
    public static final int RET_NO_TOKEN = -2; 	//用户token丢失
}
