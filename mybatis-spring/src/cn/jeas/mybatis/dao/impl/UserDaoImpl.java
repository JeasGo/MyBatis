package cn.jeas.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.jeas.mybatis.dao.UserDao;
import cn.jeas.mybatis.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User queryUserById(int id) {
		SqlSession sqlSession = super.getSqlSession();
		User user = sqlSession.selectOne("queryUserById", id);
		// 不要关闭sqlSession
		return user;

	}

	@Override
	public List<User> queryUserByUsername(String username) {
		SqlSession sqlSession = super.getSqlSession();

		// 使用SqlSession执行操作
		List<User> list = sqlSession.selectList("queryUserByUsername", username);

		// 不要关闭sqlSession

		return list;
	}

	@Override
	public void saveUser(User user) {
		// 获取SqlSession
		SqlSession sqlSession = super.getSqlSession();

		// 使用SqlSession执行操作
		sqlSession.insert("saveUser", user);

		// 不用提交,事务由spring进行管理
		// 不要关闭sqlSession

	}

}
