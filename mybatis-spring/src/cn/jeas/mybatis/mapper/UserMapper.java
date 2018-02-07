package cn.jeas.mybatis.mapper;

import java.util.List;

import cn.jeas.mybatis.pojo.User;

public interface UserMapper {
	/**
	 * 根据用户id查询
	 * 
	 * @param id
	 * @return
	 */
	User queryUserById(int id);

	/**
	 * 根据用户名模糊查询用户
	 * 
	 * @param username
	 * @return
	 */
	List<User> queryUserByUsername(String username);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	void saveUser(User user);

}