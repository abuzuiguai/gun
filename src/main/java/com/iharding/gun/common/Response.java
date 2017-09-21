package com.iharding.gun.common;

import com.iharding.gun.util.Constants;
import com.iharding.gun.util.Status;

public class Response<T> implements java.io.Serializable {
    private static final long serialVersionUID = 8206448610408409499L;
    private Status status =  Status.PENDING;  //状态
    private long startTime = Constants.INVALIDATE_VALUE;                                  //起始时间
    private long endTime = Constants.INVALIDATE_VALUE;                                    //结束时间
    private String version="1.0";
    private String msg = Constants.MSG_SUCCESS;                                  //消息
    private T data = null;                                                                //序列化后的结果数据
    // 返回结果标志，默认成功0,失败 1 参数错误 -1 token丢失-2
    private int ret = Constants.RET_SUCCESS;

    private String token;
    //耗时
    private long timeConsum;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimeConsum() {
        return timeConsum;
    }

    public void setTimeConsum(long timeConsum) {
        this.timeConsum = timeConsum;
    }

    public Response(){
        super();
    }

    public Status getStatus() {
        return status;
    }

    /**
     * 在调用end()方法时，会自动设置状态，因此，如果调用了end()方法，就不要调用这个方法
     * @param status
     */
    public Response<T> setStatus(Status status) {
        this.status = status;
        return this;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getStartTime() {
        return startTime;
    }

    public Response<T> setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public long getEndTime() {
        return endTime;
    }

    public Response<T> setEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 设置状态和起始时间，表示操作正在进行
     */
    public Response<T> start(){
        this.setStatus(Status.RUNNING);
        this.setStartTime(System.currentTimeMillis());
        return this;
    }

    /**
     * 设置状态和时间，表示操作结束，没有失败
     */
    public Response<T> end(){
        this.setEndTime(System.currentTimeMillis());
        this.setTimeConsum(this.endTime-this.startTime);
        this.setStatus(Status.OK);
        return this;
    }

    /**
     * 设置状态和时间，表示操作结束，并且失败
     */
    public Response<T> endAndFailed(){
        this.setStatus(Status.FAIL);
        this.setEndTime(System.currentTimeMillis());
        return this;
    }

    /**
     * 非参数错误通用失败信息
     */
    public Response<T> failure(String msg) {
        this.msg = msg;
        this.ret = Constants.RET_FAIL;
        this.end();
        return this;
    }

    /**
     * 参数错误信息
     */
    public Response<T> paramFailure(String msg) {
        this.msg = msg;
        this.ret = Constants.RET_ERROR_PARAM;
        this.end();
        return this;
    }

    /**
     * 用户信息丢失
     */
    public Response<T> tokenFailure(String msg) {
        this.msg = msg;
        this.ret = Constants.RET_NO_TOKEN;
        this.end();
        return this;
    }

    /**
     * 通用成功
     */
    public Response<T> success() {
        this.end();
        return this;
    }

}
