package com.iharding.gun.dao.www.model;
import java.io.Serializable;
/** 
* @Title: WebsiteInfo.java
* @Package: com.iharding.gun.dao.www.model
* @Description: 数据库操作接口类 
* @author: 楼辉荣
* @date: 2016年8月8日 下午17:16:23
* @version: V1.0
*/

@SuppressWarnings("serial")
public class WebsiteInfo implements Serializable {

	/****/
	private Long id;

	/****/
	private String name;

	/****/
	private String site;

	/****/
	private String type;

	/****/
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

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setSite(String site){
		this.site = site;
	}

	public String getSite(){
		return this.site;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
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
