package cn.admin.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * @author qiaorenjie
 *
 */
public class ResultInfo extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public ResultInfo() {
		put("code", 0);
	}
	
	public static ResultInfo error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static ResultInfo error(String msg) {
		return error(500, msg);
	}
	
	public static ResultInfo error(int code, String msg) {
		ResultInfo r = new ResultInfo();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static ResultInfo ok(String msg) {
		ResultInfo r = new ResultInfo();
		r.put("msg", msg);
		return r;
	}
	
	public static ResultInfo ok(Map<String, Object> map) {
		ResultInfo r = new ResultInfo();
		r.putAll(map);
		return r;
	}
	
	public static ResultInfo ok() {
		return new ResultInfo();
	}

	public ResultInfo put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
