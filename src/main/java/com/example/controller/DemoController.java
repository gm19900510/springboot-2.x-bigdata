package com.example.controller;

import com.example.entity.DemoDTO;
import com.example.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("rawtypes")
@Api(value = "DemoController")
@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@ApiOperation(value = "创建Hive表")
	@RequestMapping(value = "create/hive", method = RequestMethod.POST)
	public String createHive() {
		long startTime = System.currentTimeMillis();
		demoService.createHiveTable();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return "hive表创建成功  运行时间：" + time + "ms";
	}
	
	@ApiOperation(value = "创建Hbase表")
	@RequestMapping(value = "create/hbase", method = RequestMethod.POST)
	public String createHbase() {
		long startTime = System.currentTimeMillis();
		demoService.createHbaseTable();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return "hbase表创建  运行时间：" + time + "ms";
	}
	
	@ApiOperation(value = "插入Hive通过hive2 jdbc形式 ")
	@RequestMapping(value = "insert/hive/hive2/jdbc", method = RequestMethod.POST)
	public String insertHiveTableByHiveJDBC(DemoDTO demo) {
		long startTime = System.currentTimeMillis();
		demoService.insertHiveTableByHiveJDBC(demo);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return "插入数据成功  运行时间：" + time + "ms";
	}

	@ApiOperation(value = "查询Hive通过hive2 jdbc形式 ")
	@RequestMapping(value = "query/hive/hive2/jdbc", method = RequestMethod.GET)
	public String queryHiveTableByHiveJDBC() {
		long startTime = System.currentTimeMillis();
		List list = demoService.queryHiveTableByHiveJDBC();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return list.toString() + "  运行时间：" + time + "ms";
	}

	@ApiOperation(value = "插入Hive通过impala jdbc形式 ")
	@RequestMapping(value = "insert/hive/impala/jdbc", method = RequestMethod.POST)
	public String insertHiveTableByImpalaJDBC(DemoDTO demo) {
		long startTime = System.currentTimeMillis();
		demoService.insertHiveTableByImpalaJDBC(demo);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return "插入数据成功  运行时间：" + time + "ms";
	}

	@ApiOperation(value = "查询Hive通过impala jdbc形式 ")
	@RequestMapping(value = "query/hive/impala/jdbc", method = RequestMethod.GET)
	public String queryHiveTableByImpalaJDBC() {
		long startTime = System.currentTimeMillis();
		List list = demoService.queryHiveTableByImpalaJDBC();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return list.toString() + "  运行时间：" + time + "ms";
	}
	
	@ApiOperation(value = "插入Hive通过presto jdbc形式 ")
	@RequestMapping(value = "insert/hive/presto/jdbc", method = RequestMethod.POST)
	public String insertHiveTableByPrestoJDBC(DemoDTO demo) {
		long startTime = System.currentTimeMillis();
		demoService.insertHiveTableByPrestoJDBC(demo);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return "插入数据成功  运行时间：" + time + "ms";
	}

	@ApiOperation(value = "查询Hive通过presto jdbc形式 ")
	@RequestMapping(value = "query/hive/presto/jdbc", method = RequestMethod.GET)
	public String queryHiveTableByPrestoJDBC() {
		long startTime = System.currentTimeMillis();
		List list = demoService.queryHiveTableByPrestoJDBC();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return list.toString() + "  运行时间：" + time + "ms";
	}
	
	@ApiOperation(value = "插入Hbase")
	@RequestMapping(value = "insert/hbase", method = RequestMethod.POST)
	public String inserHbase(DemoDTO demo) {
		long startTime = System.currentTimeMillis();
		demoService.insertHbaseTable(demo);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return "插入数据成功  运行时间：" + time + "ms";
	}

	@ApiOperation(value = "查询Hbase")
	@RequestMapping(value = "query/hbase", method = RequestMethod.GET)
	public String queryHbase() {
		long startTime = System.currentTimeMillis();
		List list = demoService.queryHbaseTable();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return list.toString() + "  运行时间：" + time + "ms";
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "查询Hive中的表")
	@RequestMapping(value = "query/hive/tables", method = RequestMethod.GET)
	public String queryHiveTables() {
		long startTime = System.currentTimeMillis();
		List<Map> list = demoService.showHiveTables();
		List<String> result = list.stream().map(m-> m.get("Table").toString()).collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return result.toString() + "  运行时间：" + time + "ms";
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "查询Hbase中的表")
	@RequestMapping(value = "query/hbasee/tables", method = RequestMethod.GET)
	public String queryHbaseTables() {
		long startTime = System.currentTimeMillis();
		List<Map> list = demoService.showHbaseTables();
		List<String> result = list.stream().map(m-> m.get("Table").toString()).collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		return result.toString() + "  运行时间：" + time + "ms";
	}
}
