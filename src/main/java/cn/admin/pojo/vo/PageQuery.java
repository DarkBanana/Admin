package cn.admin.pojo.vo;

/**
 * 分页查询参数类 2017年2月16日 上午11:01:52
 * 
 * @author yxf
 */
public class PageQuery {

	int page;
	int rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public PageQuery(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public PageQuery() {
		super();
	}

}
