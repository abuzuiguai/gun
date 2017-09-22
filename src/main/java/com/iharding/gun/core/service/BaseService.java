/**   
* @Company: 杭州朗通信息技术有限公司 
* @Department: 系统软件部 
* @Description: 朗通智能辅助诊疗系统 
* @Address: 浙江省杭州市西湖区西斗门路3号 天堂软件园D-7B 
*/
package com.iharding.gun.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface BaseService<T, E, ID extends Serializable> {
	
	T selectByPrimaryKey(ID id); 
	
	Long insert(T record);
	
	void deleteList(Map<String, Object> map) throws Exception;
	
	void deleteByPrimaryKey(ID id) throws Exception;
	
	void deleteByPrimaryKeies(ID[] ids) throws Exception;
	
	void updateByPrimaryKeySelective(T record);
	
	void updateByPrimaryKey(T record);
	
	List<T> selectList(Map<String, Object> map);
	
	PageInfo<T> selectListPage(Map<String, Object> map, Integer pageNo, Integer pageSize);
	
	/**
	 * 
	* @Title: selectWrapperByPrimaryKey  
	* @Description: 用户扩展信息
	* @param id
	* @return      
	* E    
	* @throws
	 */
	E selectWrapperByPrimaryKey(Long id);
	
	/**
	 * 
	* @Title: selectListWrapperPage  
	* @Description: 查询用户扩展信息列表（分页）
	* @param map
	* @param pageNo
	* @param pageSize
	* @return      
	* PageInfo<E>    
	* @throws
	 */
	PageInfo<E> selectListWrapperPage(Map<String, Object> map, Integer pageNo, Integer pageSize);

	
	/**
	 * @Description: 查询用户扩展信息列表（不分页）
	 * @param map
	 * @return
	 */
	List<E> selectListWrapper(Map<String, Object> map);

}
