package cn.admin.util;

/**
 * json返回数据类型. <br/>
 * date: 2015年10月26日 上午9:34:50 <br/>
 *
 * @author songjiesdnu@163.com
 */
public class Result {
	
	
	private Integer draw;//表示请求次数
	private long recordsTotal;//总记录数
	private long recordsFiltered;//过滤后的总记录数
	
	private Object data;//具体的数据对象数组
	/**
	 * 表示请求次数 
	 * @return
	 */
	public Integer getDraw() {
		return draw;
	}
	/**
	 * 表示请求次数
	 * @param draw
	 */
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	/**
	 * 总记录数
	 * @return
	 */
	public long getRecordsTotal() {
		return recordsTotal;
	}
	/**
	 * 总记录数
	 * @param recordsTotal
	 */
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	/**
	 * 过滤后的总记录数
	 * @return
	 */
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	/**
	 * 过滤后的总记录数
	 * @param recordsFiltered
	 */
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	/**
	 * 具体的数据对象数组
	 * @return
	 */
	public Object getData() {
		return data;
	}
	/**
	 * 具体的数据对象数组
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
