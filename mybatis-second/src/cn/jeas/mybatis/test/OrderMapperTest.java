package cn.jeas.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jeas.mybatis.mapper.OrdersMapper;
import cn.jeas.mybatis.pojo.Orders;

public class OrderMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	
	
	
	@Before
	public void init() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testQueryAll() {
		// 获取sqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 获取OrderMapper
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

		// 执行查询
		List<Orders> list = ordersMapper.queryOrderAll();
		for (Orders order : list) {
			System.out.println(order);
		}
	}

}
