package com.iharding.gun.core.orm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface EntityMapper<T, E, ID extends Serializable> {
	
	T selectByPrimaryKey(ID id);
	
	List<T> selectList(Map<String, Object> map);

    void deleteByPrimaryKey(ID id);
    
    void deleteByPrimaryKeies(ID[] ids);
    
    void deleteList(Map<String, Object> map);

    Long insert(T record);

    void updateByPrimaryKeySelective(T record);

    void updateByPrimaryKey(T record);
    
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
	* @return      
	* List<UserWrapper>    
	* @throws
	 */
	List<E> selectListWrapper(Map<String, Object> map);
	
}
