package com.example.demo;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.entity.DemoDTO;
import com.example.service.DemoService;

@SuppressWarnings("rawtypes")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private DemoService demoService;

	@Test
	public void testInsertHiveTableByHiveJDBC() {
		DemoDTO demo = new DemoDTO();
		demo.setS1(5);
		demo.setS2("S2-0825");
		demo.setS3("S2-0825");
		demo.setS4("S2-0825");
	}

	@Test
	public void testQueryHiveTable() {

		List hiveQuery = demoService.queryHiveTableByHiveJDBC();
		System.out.println(hiveQuery);
		List impalaQuery = demoService.queryHiveTableByImpalaJDBC();
		System.out.println(impalaQuery);
		List prestoQuery = demoService.queryHiveTableByPrestoJDBC();
		System.out.println(prestoQuery);
	}
}
