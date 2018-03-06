package cn.jeas.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jeas.pojo.Order;

public class OrderMapperTest {

	private OrderMapper orderMapper;
	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		// 获取输入流，关联配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 读取配置，构建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 获取session,同时打开事务的自动提交，每一次操作都是个独立事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true); 
		
		// 传入SqlSession对象，构建DAO对象
		orderMapper = sqlSession.getMapper(OrderMapper.class);
	}

	@Test
	public void testQueryOrderWithUserAndOrderDetailsByOrderNumber(){
		Order order = orderMapper.queryOrderWithUserAndOrderDetailsByOrderNumber("20140921001");
		System.out.println(order);
	}
	
	
	@Test
	public void testQueryOrderWithUserByorderNumber() {
		Order order = orderMapper.queryOrderWithUserByorderNumber("20140921001");
		System.out.println(order);
	}

}
