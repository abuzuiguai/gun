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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iharding.gun.core.orm.EntityMapper;

abstract public class BaseServiceImpl<T, E, ID extends Serializable> implements BaseService<T, E, ID> {
	
	EntityMapper<T, E, ID> mapper;
	
	public void setEntityMapper(EntityMapper<T, E, ID> mapper) {
		this.mapper = mapper;
	}
	
	public T selectByPrimaryKey(ID id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	public Long insert(T record) {
		return mapper.insert(record);
	}
	
	public void deleteList(Map<String, Object> map) throws Exception {
		mapper.deleteList(map);
	}
	
	public void deleteByPrimaryKey(ID id) throws Exception {
		mapper.deleteByPrimaryKey(id);
	}
	
	public void deleteByPrimaryKeies(ID[] ids) throws Exception {
		mapper.deleteByPrimaryKeies(ids);
	}
	
	public void updateByPrimaryKeySelective(T record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public void updateByPrimaryKey(T record) {
		mapper.updateByPrimaryKey(record);
	}
	
	public List<T> selectList(Map<String, Object> map) {
		return mapper.selectList(map);
	}
	
	public PageInfo<T> selectListPage(Map<String, Object> map, Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<T> list = mapper.selectList(map);
		return new PageInfo<T>(list);
	}
	
	/**
	* 
	* @Title: selectWrapperByPrimaryKey  
	* @Description: 用户扩展信息
	* @param id
	* @return      
	* UserWrapper    
	* @throws
	 */
	public E selectWrapperByPrimaryKey(Long id) {
		return mapper.selectWrapperByPrimaryKey(id);
	}
	
	/**
	 * 
	* @Title: selectListWrapperPage  
	* @Description: 查询用户扩展信息列表（分页）
	* @param map
	* @param pageNo
	* @param pageSize
	* @return      
	* PageInfo<UserWrapper>    
	* @throws
	 */
	public PageInfo<E> selectListWrapperPage(Map<String, Object> map, Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<E> list = mapper.selectListWrapper(map);
		return new PageInfo<E>(list);
	}
	
	/**
	 * @Description: 查询用户扩展信息列表（不分页）
	 * @param map
	 * @return
	 */
	public List<E> selectListWrapper(Map<String, Object> map) {
		return mapper.selectListWrapper(map);
	}
	
}
