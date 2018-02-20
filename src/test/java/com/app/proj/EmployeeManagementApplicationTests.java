package com.app.proj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.proj.config.DataSourceConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DataSourceConfiguration.class)
public class EmployeeManagementApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Loading");
	}

}
