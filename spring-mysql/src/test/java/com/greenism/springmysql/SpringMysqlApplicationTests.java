package com.greenism.springmysql;

import com.greenism.springmysql.bean.DemoBean;
import com.greenism.springmysql.dao.DemoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringMysqlApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Resource
	private DemoMapper demoMapper;
	@Test
	void contextLoads() {
	}
	@Test
	void mysqlTest(){
		String sql = "select * from t_demo";
		List<DemoBean> mysqlDemoBeanList = jdbcTemplate.query(sql, (resultSet, i) -> DemoBean.builder().id(resultSet.getInt("id"))
				.name(resultSet.getString("name"))
				.value(resultSet.getString("value"))
				.build());
		System.out.println("查询成功：");
		for(DemoBean mysqlDemoBean:mysqlDemoBeanList){
			System.out.println("id:"+mysqlDemoBean.getId()+",key:"+mysqlDemoBean.getName()+",value:"+mysqlDemoBean.getValue());
		}
		
	}
	@Test
	void mybatisPlusTest(){
		List<DemoBean> demoBeanList = demoMapper.selectList(null);
		demoBeanList.forEach(System.out::println);
	}
}
