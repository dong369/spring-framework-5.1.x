package com.io.mybatis;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 2020/4/4
 * @since 1.8
 */
public interface UserDaoI {
	@Select("SELECT * FROM goods")
	List<Map<String, Object>> getUser();
}
