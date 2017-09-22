package com.iharding.gun.dao.www.model;
import java.io.Serializable;
/** 
* @Title: CommentInfo.java
* @Package: com.iharding.gun.dao.www.model
* @Description: 数据库操作接口类 
* @author: 楼辉荣
* @date: 2016年8月8日 下午17:16:23
* @version: V1.0
*/

@SuppressWarnings("serial")
public class CommentInfo implements Serializable {

	/****/
	private Long id;

	/**概要**/
	private String title;

	/**评论内容**/
	private String comment;

	/**星级**/
	private String starLevel;

	/****/
	private java.util.Date createTime;



	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return this.comment;
	}

	public void setStarLevel(String starLevel){
		this.starLevel = starLevel;
	}

	public String getStarLevel(){
		return this.starLevel;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

}
