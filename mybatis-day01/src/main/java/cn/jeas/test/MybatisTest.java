package cn.jeas.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.jeas.pojo.User;

public class MybatisTest {
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession session = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			System.out.println("SqlSession == >" + session);
			User user = (User) session.selectOne("userMapper.queryUserById", 1);
			
			System.out.println( "User ==>" + user);
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
	}
}
