package cn.jeas.mapper;

import java.io.InputStream;
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
	public void testQueryAllUserAndSort(){
		List<User> list = userMapper.queryAllUserAndSort(2);
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	
	
	@Test
	public void testQueryMaleUserByName (){
		List<User> list = userMapper.queryMaleUserByName("张");
		for (User user : list) {
			System.out.println(user);
		}
		
		
	}
	
	@Test
	public void testQueryUserByUsernameAndPaaword(){
		User user = userMapper.queryUserByUsernameAndPaaword("zhangsan", "123456");
		System.out.println(user);
		
	}
	
	@Test
	public void testQueryUserLikeName(){
		List<User> userlist = userMapper.queryUserLikeName("%zhang%");
		for (User user : userlist) {
			System.out.println(user);
		}
		
	}
	
	
	@Test
	public void testLogin(){
		
		User user = userMapper.login("zhangsan","123456");
		System.out.println(user);
		
	}
	
	
	@Test
	public void testInsertUser() {
		User user =  new User();
		user.setAge(34);
		user.setName("曹大婶");
		user.setSex(2);
		user.setuserName("傻逼张京安");
		userMapper.insertUser(user);
		System.out.println(user);
	}

}
