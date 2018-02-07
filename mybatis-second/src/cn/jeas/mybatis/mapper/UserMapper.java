package cn.jeas.mybatis.mapper;

import java.util.List;

import cn.jeas.mybatis.pojo.Orders;
import cn.jeas.mybatis.pojo.QueryVo;
import cn.jeas.mybatis.pojo.User;

public interface UserMapper {

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	User queryUserById(int id);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	List<User> queryUserByUsername(String username);

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	void saveUser(User user);

	List<User> queryUserByQueryVo(QueryVo queryVo);

	int queryUserCount();

	List<User> queryUserByWhere(User user);

	List<User> queryUserByIds(QueryVo queryVo);

	List<Orders> queryOrderUserResultMap();

}
