package cn.admin.process.result;

/**
 * 系统提交结果结果类型
 * 
 * @author yxf 2017年1月24日 下午5:32:50
 */
public class SubmitResultInfo {

	public SubmitResultInfo(ResultInfo resultInfo) {
		this.resultInfo = resultInfo;
	}

	// 操作结果信息
	private ResultInfo resultInfo;

	public ResultInfo getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(ResultInfo resultInfo) {
		this.resultInfo = resultInfo;
	}

}
