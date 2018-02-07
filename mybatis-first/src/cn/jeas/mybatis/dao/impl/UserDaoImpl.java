package cn.jeas.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.jeas.mybatis.dao.UserDao;
import cn.jeas.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/* (non-Javadoc)
	 * @see cn.jeas.mybatis.dao.UserDao#queryUserById(int)
	 */
	@Override
	public User queryUserById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("queryUserById", id);
		sqlSession.close();

		return user;
	}

	@Override
	public List<User> queryUserByUsername(String name) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("queryUserByUsername", name);
		sqlSession.close();
		return list;
	}

	@Override
	public void saveUser(User user) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		sqlSession.insert("saveUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

}
