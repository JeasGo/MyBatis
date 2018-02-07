package cn.jeas.mybatis.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jeas.mybatis.mapper.UserMapper;
import cn.jeas.mybatis.pojo.Orders;
import cn.jeas.mybatis.pojo.QueryVo;
import cn.jeas.mybatis.pojo.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	
	
	@Test
	public void testQueryOrderUserResultMap() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 使用userMapper执行根据条件查询用户
		List<Orders> list = userMapper.queryOrderUserResultMap();

		for (Orders o : list) {
			System.out.println(o);
		}

		// mybatis和spring整合，整合之后，交给spring管理
		sqlSession.close();

	}

	
	
	
	@Test
	public void testQueryUserByIds() {
		// mybatis和spring整合，整合之后，交给spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 创建Mapper接口的动态代理对象，整合之后，交给spring管理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 使用userMapper执行根据条件查询用户
		QueryVo queryVo = new QueryVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(10);
		ids.add(24);
		queryVo.setIds(ids);

		List<User> list = userMapper.queryUserByIds(queryVo);

		for (User u : list) {
			System.out.println(u);
		}

		// mybatis和spring整合，整合之后，交给spring管理
		sqlSession.close();
	}

	
	
	
	@Test
	public void testQueryUserByWhere() {
		// mybatis和spring整合，整合之后，交给spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 创建Mapper接口的动态代理对象，整合之后，交给spring管理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 使用userMapper执行根据条件查询用户
		User user = new User();
		user.setSex("1");
		user.setUsername("张");

		List<User> list = userMapper.queryUserByWhere(user);

		for (User u : list) {
			System.out.println(u);
		}

		// mybatis和spring整合，整合之后，交给spring管理
		sqlSession.close();
	}

	
	@Test
	public void testQueryUserCount() {
		// mybatis和spring整合，整合之后，交给spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 创建Mapper接口的动态代理对象，整合之后，交给spring管理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 使用userMapper执行查询用户数据条数
		int count = userMapper.queryUserCount();
		System.out.println(count);

		// mybatis和spring整合，整合之后，交给spring管理
		sqlSession.close();
	}

	
	@Test
	public void testQueryUserByQueryVo() {
		// mybatis和spring整合，整合之后，交给spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 创建Mapper接口的动态代理对象，整合之后，交给spring管理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 使用userMapper执行查询，使用包装对象
		QueryVo queryVo = new QueryVo();
		// 设置user条件
		User user = new User();
		user.setUsername("张");
		// 设置到包装对象中
		queryVo.setUser(user);

		// 执行查询
		List<User> list = userMapper.queryUserByQueryVo(queryVo);
		for (User u : list) {
			System.out.println(u);
		}

		// mybatis和spring整合，整合之后，交给spring管理
		sqlSession.close();
	}
	@Before
	public void init() throws Exception {
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
}
