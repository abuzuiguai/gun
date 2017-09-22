package com.iharding.gun.dao.www.model;
import java.io.Serializable;
/** 
* @Title: GoodsInfo.java
* @Package: com.iharding.gun.dao.www.model
* @Description: 数据库操作接口类 
* @author: 楼辉荣
* @date: 2016年8月8日 下午17:16:23
* @version: V1.0
*/

@SuppressWarnings("serial")
public class GoodsInfo implements Serializable {

	/****/
	private Long id;

	/****/
	private Long websiteId;

	/****/
	private String name;

	/****/
	private java.math.BigDecimal oldPrice;

	/****/
	private java.math.BigDecimal curPrice;

	/****/
	private String description;

	/**下架标识**/
	private String checkLabel;

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

	public void setWebsiteId(Long websiteId){
		this.websiteId = websiteId;
	}

	public Long getWebsiteId(){
		return this.websiteId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setOldPrice(java.math.BigDecimal oldPrice){
		this.oldPrice = oldPrice;
	}

	public java.math.BigDecimal getOldPrice(){
		return this.oldPrice;
	}

	public void setCurPrice(java.math.BigDecimal curPrice){
		this.curPrice = curPrice;
	}

	public java.math.BigDecimal getCurPrice(){
		return this.curPrice;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setCheckLabel(String checkLabel){
		this.checkLabel = checkLabel;
	}

	public String getCheckLabel(){
		return this.checkLabel;
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
