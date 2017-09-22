/**   
* @Company: 杭州朗通信息技术有限公司 
* @Department: 系统软件部 
* @Description: 朗通智能辅助诊疗系统 
* @Address: 浙江省杭州市西湖区西斗门路3号 天堂软件园D-7B 
*/
package com.iharding.gun.core.orm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class Page<T> extends PageRequest implements Iterable<T> {
	/**
	 * 列表数据
	 */
	protected List<T> result = null;
	protected long totalItems = -1;

	public Page() {
	}

	/**
	* <p>Title: Page</p> 
	* <p>Description: 初始化参数</p> 
	* @param request
	 */
	public Page(PageRequest request) {
		this.pageNo = request.pageNo;
		this.pageSize = request.pageSize;
		this.countTotal = request.countTotal;
		this.orderBy = request.orderBy;
		this.orderDir = request.orderDir;
	}

	/**
	 * 获得页内的记录列表.
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * 设置页内的记录列表.
	 */
	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * 获得总记录数, 默认值为-1.
	 */
	public long getTotalItems() {
		return totalItems;
	}

	/**
	 * 设置总记录数.
	 */
	public void setTotalItems(final long totalItems) {
		this.totalItems = totalItems;
	}

	/** 
	 * 实现Iterable接口, 可以for(Object item : page)遍历使用
	 */
	public Iterator<T> iterator() {
		return result.iterator();
	}

	/**
	 * 根据pageSize与totalItems计算总页数.
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) totalItems / (double) getPageSize());

	}

	/**
	 * 是否还有下一页.
	 */
	public boolean hasNextPage() {
		return (getPageNo() + 1 <= getTotalPages());
	}

	/**
	 * 是否最后一页.
	 */
	public boolean isLastPage() {
		return !hasNextPage();
	}

	/**
	 * 取得下页的页号, 序号从1开始.
	 * 当前页为尾页时仍返回尾页序号.
	 */
	public int getNextPage() {
		if (hasNextPage()) {
			return getPageNo() + 1;
		} else {
			return getPageNo();
		}
	}

	/**
	 * 是否还有上一页.
	 */
	public boolean hasPrePage() {
		return (getPageNo() > 1);
	}

	/**
	 * 是否第一页.
	 */
	public boolean isFirstPage() {
		return !hasPrePage();
	}

	/**
	 * 取得上页的页号, 序号从1开始.
	 * 当前页为首页时返回首页序号.
	 */
	public int getPrePage() {
		if (hasPrePage()) {
			return getPageNo() - 1;
		} else {
			return getPageNo();
		}
	}

	/**
	 * 计算以当前页为中心的页面列表,如"首页,23,24,25,26,27,末页"
	 * @param count 需要计算的列表大小
	 * @return pageNo列表 
	 */
	public List<Integer> getSlider(int count) {
		int halfSize = count / 2;
		int totalPage = getTotalPages();

		int startPageNo = Math.max(getPageNo() - halfSize, 1);
		int endPageNo = Math.min(startPageNo + count - 1, totalPage);

		if (endPageNo - startPageNo < count) {
			startPageNo = Math.max(endPageNo - count, 1);
		}

		List<Integer> result = Lists.newArrayList();
		for (int i = startPageNo; i <= endPageNo; i++) {
			result.add(i);
		}
		return result;
	}
	
	/**
	 * 返回map对象，在ajax访问数据时使用
	 */
	public Map<String,Object> returnMap(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("totalSize", this.getTotalItems());
		map.put("totalPages", this.getTotalPages());
		map.put("nextPage", this.getNextPage());
		map.put("prePage", this.getPrePage());
		map.put("isLastPage", this.isLastPage());
		map.put("isFirstPage", this.isFirstPage());
		map.put("body", this.getResult());
		return map;
	}
}