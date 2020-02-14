package com.io.bean.autowired;

import org.springframework.stereotype.Repository;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Repository
public class AutowiredDao {
	private String flag = "1";

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "AutowiredDao{" +
				"flag='" + flag + '\'' +
				'}';
	}
}
