package cn.jeas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jeas.pojo.User;

public interface UserMapper {
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	User queryUserById(Long id);
	/**
	 * 查询全部用户
	 * @return
	 */
	List<User> queryAll();
	/**
	 * 添加用户
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 根据ID删除用户
	 * @param id
	 */
	void deleteUserById(Long id);

	
	User login(@Param("username")String username ,@Param("password")String password);
	
	List<User> queryUserLikeName(String username);
	
	User queryUserByUsernameAndPaaword(@Param("username")String username ,@Param("password")String password);
	
	List<User> queryMaleUserByName(@Param("name")String name);
	
	
	List<User> queryAllUserAndSort(@Param("orderType")Integer orderTrype);
	
	
	
	
	
	
	
	
	
	
}
