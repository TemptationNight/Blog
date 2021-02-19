package com.lucas.blog.myblog.aop;

/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.aop
 * @ClassName: ActionType
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/10/26 21:18
 * @Version: 1.0
 */
public enum ActionType {
	/**
	 * 操作类型
	 */
	UNKNOWN("unknown"),
	DELETE("delete"),
	SELECT("select"),
	UPDATE("update"),
	INSERT("insert");
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	ActionType(String s) {
		this.value = s;
	}

}


