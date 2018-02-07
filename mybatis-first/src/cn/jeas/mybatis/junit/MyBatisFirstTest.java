package cn.jeas.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jeas.mybatis.pojo.User;

public class MyBatisFirstTest {

	private SqlSessionFactory sqlSessionFactory = null;
	
	@Test
	public void testDeleteUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("deleteUserById",31);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testUpdateUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(26);
		user.setUsername("关羽");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("蜀国");

		sqlSession.update("updateUserById", user);
		
		// 需要进行事务提交
		sqlSession.commit();
		// 7. 释放资源
		sqlSession.close();

	}
	
	@Test
	public void testSaveUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("刘备12");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("蜀国");

		int insert = sqlSession.insert("saveUser", user);
		System.err.println(insert +"========================================"+ user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testQueryUserByUsername2(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String username = "王";
		List<Object> list = sqlSession.selectList("queryUserByUsername2", "王");
		for (Object user : list) {
			System.err.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void testQueryUserByUsername1() throws Exception {
		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 5. 执行SqlSession对象执行查询，获取结果User
		// 查询多条数据使用selectList方法
		List<Object> list = sqlSession.selectList("queryUserByUsername1", "%王%");
		// 6. 打印结果
		for (Object user : list) {
			System.out.println(user);
		}
		// 7. 释放资源
		sqlSession.close();
	}

	
	@Test
	public void testQueryUserById() throws Exception {
		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 5. 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		Object user = sqlSession.selectOne("queryUserById", 1);

		// 6. 打印结果
		System.out.println(user);

		// 7. 释放资源
		sqlSession.close();
	}

	
	@Before
	public void Test01() throws Exception{
		//创建sqlSessionfactory工厂
		// 1. 创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		//加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
}
