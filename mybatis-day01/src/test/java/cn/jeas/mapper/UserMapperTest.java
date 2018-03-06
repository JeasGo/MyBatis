package cn.jeas.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jeas.pojo.User;



public class UserMapperTest {
	
	private UserMapper userMapper;
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
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Test
	public void testQueryUserById() {
		User user = userMapper.queryUserById(1L);
		System.out.println(user);
	}

	@Test
	public void testQueryAll() {
		List<User> list = userMapper.queryAll();
		for (User user : list) {
			System.out.println("User ===>"+ user);
		}
	}

	@Test
	public void testInsertUser() {
		User user =  new User();
		user.setAge(34);
		user.setName("曹大婶");
		user.setSex(2);
		user.setuserName("法正");
		userMapper.insertUser(user);
		System.out.println(user);
	}

	@Test
	public void testUpdateUser() {
		User user =  new User();
		user.setId(7L);
		user.setAge(34);
		user.setName("曹大神");
		user.setSex(2);
		user.setuserName("曹雪芹");
		user.setPassword("1212121");
		userMapper.updateUser(user);
	}

	@Test
	public void testDeleteUserById() {
		userMapper.deleteUserById(7L);
	}

}
