package com.studio.user.dao;

import java.util.List;

import com.studio.user.entity.User;

public interface UserDao {

	//用户注册
	public void regist(User user);
	// 用户登陆
	public User login(User user);
	//通过激活码查询用户
	public User findByCode(User user);
	//修改用户信息
	public void update(User existUser);
	//通过邮箱发现用户
	public User findByEmail(User user);
	//密码修改
	public void editPass(User user);
	//查询所有的用户信息
	public List<User> findAllUser(User user);


}
