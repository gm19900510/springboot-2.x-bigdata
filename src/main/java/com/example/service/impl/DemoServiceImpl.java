package com.example.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.entity.DemoDTO;
import com.example.mapper.DemoMapper;
import com.example.mapper.HiveMapper;
import com.example.service.DemoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@SuppressWarnings("rawtypes")
@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	DemoMapper demoMapper;
	
	@Autowired
	HiveMapper hiveMapper;
	
	@Autowired
    private JdbcTemplate template;

	@Override
	@DS("hive")
	public void createHiveTable() {
		// TODO Auto-generated method stub
		demoMapper.createHiveTable();
	}

	@Override
	@DS("hive")
	public void insertHiveTableByHiveJDBC(DemoDTO demo) {
		// TODO Auto-generated method stub
		demoMapper.insertHive(demo);
	}

	@Override
	@DS("hive")
	public List queryHiveTableByHiveJDBC() {
		// TODO Auto-generated method stub
		/*return demoMapper.queryHive();*/
		return hiveMapper.queryHive();
	}

	@Override
	@DS("impala")
	public void insertHiveTableByImpalaJDBC(DemoDTO demo) {
		// TODO Auto-generated method stub
		demoMapper.insertHive(demo);
	}

	@Override
	@DS("impala")
	public List queryHiveTableByImpalaJDBC() {
		// TODO Auto-generated method stub
		return demoMapper.queryHive();
	}

	@Override
	@DS("presto")
	public void insertHiveTableByPrestoJDBC(DemoDTO demo) {
		// TODO Auto-generated method stub
		demoMapper.insertHive(demo);
	}

	@Override
	@DS("presto")
	public List queryHiveTableByPrestoJDBC() {
		// TODO Auto-generated method stub
		return demoMapper.queryHive();
	}

	@Override
	@DS("hbase")
	public void createHbaseTable() {
		// TODO Auto-generated method stub
		demoMapper.createHbaseTable();
	}

	@Override
	@DS("hbase")
	public void insertHbaseTable(DemoDTO demo) {
		// TODO Auto-generated method stub
		demoMapper.insertHbase(demo);
	}

	@Override
	@DS("hbase")
	public List queryHbaseTable() {
		return demoMapper.queryHbase();
	}

	@Override
	@DS("presto")
	public List showHiveTables() {
		return template.queryForList("show tables");
	}

	@Override
	@DS("hbase")
	public List showHbaseTables() {
		// TODO Auto-generated method stub
		return template.queryForList("select TABLE_NAME \"Table\" from SYSTEM.CATALOG where TABLE_TYPE='u'");
	}

}
