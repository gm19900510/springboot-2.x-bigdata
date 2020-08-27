package com.example.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "测试实体类")
public class DemoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "在HBASE中此为主键")
	private int s1;
	private String s2;
	private String s3;
	private String s4;
}
