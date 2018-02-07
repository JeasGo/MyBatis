package cn.jeas.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jeas.mybatis.dao.UserDao;
import cn.jeas.mybatis.dao.impl.UserDaoImpl;
import cn.jeas.mybatis.pojo.User;

public class UserDaoTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception{
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		this.sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
	}
	
	@Test
	public void testSaveUser() {
		// 创建DAO
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);

		// 创建保存对象
		User user = new User();
		user.setUsername("刘备");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("蜀国");
		// 执行保存
		userDao.saveUser(user);

		System.out.println(user);
	}

	
	@Test
	public void testQueryUserByUsername() {
		// 创建DAO

		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		// 执行查询
		List<User> list = userDao.queryUserByUsername("张");
		for (User user : list) {
			System.out.println(user);
		}
	}

	
	@Test
	public void testQueryUserById(){
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		
		User user = userDao.queryUserById(1);
		System.out.println(user);
	}
}
