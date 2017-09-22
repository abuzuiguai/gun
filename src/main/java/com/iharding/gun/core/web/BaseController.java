/**   
* @Company: 杭州朗通信息技术有限公司 
* @Department: 系统软件部 
* @Description: 朗通智能辅助诊疗系统 
* @Address: 浙江省杭州市西湖区西斗门路3号 天堂软件园D-7B 
*/
package com.iharding.gun.core.web;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iharding.gun.core.api.Response;
import com.iharding.gun.core.api.ResponsePage;
import com.iharding.gun.core.service.BaseService;
import com.iharding.gun.util.ServletUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

/**
* @Title: BaseController.java 
* @Package com.iharding.gun.core.web
* @Description: springmvc Controller基类,通过泛型实现基本的增删查改、ajax返回列表数据以及简单的属性查询 
* 
* 例：
* List page     : GET /user/
* Create page   : GET /user/create
* Create action : POST /user/edit
* Update page   : GET /user/update/{id}
* Update action : POST /user/edit
* Delete action : GET /user/delete/{id}
* Delete action : POST /user/delete
* 
* @author 楼辉荣(Fyeman)   
* @date 2015年4月23日 下午10:46:04 
* @version V1.0
 */
public abstract class BaseController<T, E, ID extends Serializable> {
	
	protected String listView = null;
	protected String editView = null;
	protected String showView = null;
	
	private BaseService<T, E, ID> baseService;
	
	protected void setBaseService(BaseService<T, E, ID> baseService) {
		this.baseService = baseService;
	}
	
	protected void initBinder(WebDataBinder binder) { 
	}

	@RequestMapping("/select_by_primary_key")  
    @ResponseBody
    public Response<T> get(ID id){
        Response<T> response = new Response<T>();
		response.start();
		response.setData(baseService.selectByPrimaryKey(id));
        return response.success();
    }  
	
	@RequestMapping("/create")  
    @ResponseBody
    public Response<String> create(HttpServletRequest request, T record) {  
    	Response<String> response = new Response<String>();
		response.start();
		baseService.insert(record);
        return response.success();
    }

	@RequestMapping("/delete_list")
    @ResponseBody
    public Response<String> deleteList(HttpServletRequest request) throws Exception {
    	Response<String> response = new Response<String>();
		response.start();
		baseService.deleteList(ServletUtils.getParametersStartingWith(request, "search_"));
        return response.success();
    }

	@RequestMapping("/delete_by_primary_key")  
    @ResponseBody
    public Response<String> deleteByPrimaryKey(ID id) throws Exception {  
    	Response<String> response = new Response<String>();
		response.start();
		baseService.deleteByPrimaryKey(id);
        return response.success();
    }
	
	@RequestMapping("/delete_by_primary_keies")  
    @ResponseBody
    public Response<String> deleteByPrimaryKeies(@RequestParam(value = "ids[]") ID[] ids) throws Exception {  
    	Response<String> response = new Response<String>();
		response.start();
		baseService.deleteByPrimaryKeies(ids);
        return response.success();
    }
	
	@RequestMapping("/update_by_primary_key_selective")  
    @ResponseBody
    public Response<String> updateByPrimaryKeySelective(T record) {  
    	Response<String> response = new Response<String>();
		response.start();
		baseService.updateByPrimaryKeySelective(record);
        return response.success();
    }
	
	@RequestMapping("/update_by_primary_key")  
    @ResponseBody
    public Response<String> updateByPrimaryKey(T record) {  
    	Response<String> response = new Response<String>();
		response.start();
		baseService.updateByPrimaryKey(record);
        return response.success();
    }

	@RequestMapping("/select_list")  
    @ResponseBody
    public Response<List<T>> selectList(HttpServletRequest request) {  
    	Response<List<T>> response = new Response<List<T>>();
		response.start();
		if (baseService == null) {
			initBinder(null);
		}
		response.setData(baseService.selectList(ServletUtils.getParametersStartingWith(request, "search_")));
        return response.success();
    }
	
	@RequestMapping("/select_list_wrapper")  
    @ResponseBody
    public Response<List<E>> selectListWrapper(HttpServletRequest request) {  
    	Response<List<E>> response = new Response<List<E>>();
		response.start();
		if (baseService == null) {
			initBinder(null);
		}
		response.setData(baseService.selectListWrapper(ServletUtils.getParametersStartingWith(request, "search_")));
        return response.success();
    }
	
	@RequestMapping("/page")  
    @ResponseBody
    public ResponsePage<T> page(HttpServletRequest request, Integer pageNum, Integer pageSize){  
    	ResponsePage<T> response = new ResponsePage<T>();
		response.start();
		PageInfo<T> pageInfo = baseService.selectListPage(ServletUtils.getParametersStartingWith(request, "search_"), pageNum == 0 ? (pageNum + 1) : pageNum, pageSize);
		response.setRows(pageInfo.getList());
		response.setTotal(pageInfo.getTotal());
        return response.success();
    }
	
	@RequestMapping("/select_wrapper_by_primary_key")  
    @ResponseBody
    public Response<E> selectWrapperByPrimaryKey(Long id){  
        Response<E> response = new Response<E>();
		response.start();
		response.setData(baseService.selectWrapperByPrimaryKey(id));
        return response.success();
    } 
	
	@RequestMapping("/page_wrapper")
    @ResponseBody
    public ResponsePage<E> pageWrapper(HttpServletRequest request, Integer pageNum, Integer pageSize){  
    	ResponsePage<E> response = new ResponsePage<E>();
		response.start();
		PageInfo<E> pageInfo = baseService.selectListWrapperPage(ServletUtils.getParametersStartingWith(request, "search_"), pageNum == 0 ? (pageNum + 1) : pageNum, pageSize);
		response.setRows(pageInfo.getList());
		response.setTotal(pageInfo.getTotal());
        return response.success();
    }
}
