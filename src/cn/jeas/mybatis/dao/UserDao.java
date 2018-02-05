package cn.jeas.mybatis.dao;

import java.util.List;

import cn.jeas.mybatis.pojo.User;

public interface UserDao {
	/**
	 * 
	 * 功能:根据id查询用户
	 * Author:jeas
	 * @param id
	 * @return
	 * Time:2018年2月5日 下午8:39:26
	 */
	User queryUserById(int id);
	/**
	 * 
	 * 功能:根据用户名模糊查询
	 * Author:jeas
	 * @param id
	 * @return
	 * Time:2018年2月5日 下午8:40:26
	 */
	 List<User> queryUserByUsername(String name);
	
	 /**
	  * 功能:保存用户
	  * Author:jeas
	  * @param user
	  * Time:2018年2月5日 下午8:42:45
	  */
	 void saveUser(User user);
} 
