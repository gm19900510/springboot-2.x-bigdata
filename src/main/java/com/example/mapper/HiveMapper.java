package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface HiveMapper {

	/**
	 * 映射不成功，因为结果集的列头携带表名信息，如：hive_test.s1映射到hive_test的s1属性将报错。所以select需要指定具体的列名或者指定别名
	 * 
	 * @return
	 */
	@Select("select s1,s2,s3,s4 from hive_test")
	List<Map<String, Object>> queryHive();
}
