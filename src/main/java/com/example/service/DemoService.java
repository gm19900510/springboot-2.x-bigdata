package com.example.service;

import java.util.List;
import com.example.entity.DemoDTO;

@SuppressWarnings("rawtypes")
public interface DemoService {

	public void createHiveTable();

	public void insertHiveTableByHiveJDBC(DemoDTO demo);

	public List queryHiveTableByHiveJDBC();

	public void insertHiveTableByImpalaJDBC(DemoDTO demo);

	public List queryHiveTableByImpalaJDBC();

	public void insertHiveTableByPrestoJDBC(DemoDTO demo);

	public List queryHiveTableByPrestoJDBC();

	public void createHbaseTable();

	public void insertHbaseTable(DemoDTO demo);

	public List queryHbaseTable();
	
	public List showHiveTables();
	
	public List showHbaseTables();
}
