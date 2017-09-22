package com.iharding.gun.dao.www.model;
import java.io.Serializable;
/** 
* @Title: RouteInfo.java
* @Package: com.iharding.gun.dao.www.model
* @Description: 数据库操作接口类 
* @author: 楼辉荣
* @date: 2016年8月8日 下午17:16:23
* @version: V1.0
*/

@SuppressWarnings("serial")
public class RouteInfo implements Serializable {

	/****/
	private Long id;

	/****/
	private Long goodsId;

	/****/
	private String elementName;

	/****/
	private String elementType;

	/****/
	private String eventType;

	/****/
	private Integer orderNo;

	/****/
	private java.util.Date createDate;

	/****/
	private String remark;



	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}

	public Long getGoodsId(){
		return this.goodsId;
	}

	public void setElementName(String elementName){
		this.elementName = elementName;
	}

	public String getElementName(){
		return this.elementName;
	}

	public void setElementType(String elementType){
		this.elementType = elementType;
	}

	public String getElementType(){
		return this.elementType;
	}

	public void setEventType(String eventType){
		this.eventType = eventType;
	}

	public String getEventType(){
		return this.eventType;
	}

	public void setOrderNo(Integer orderNo){
		this.orderNo = orderNo;
	}

	public Integer getOrderNo(){
		return this.orderNo;
	}

	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}

	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
