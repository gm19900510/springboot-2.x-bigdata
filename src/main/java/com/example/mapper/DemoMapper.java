package com.example.mapper;

import java.util.List;
import com.example.entity.DemoDTO;

@SuppressWarnings("rawtypes")
public interface DemoMapper {

	void createHiveTable();

	void insertHive(DemoDTO demo);

	List queryHive();

	void createHbaseTable();

	void insertHbase(DemoDTO demo);

	List queryHbase();
}
