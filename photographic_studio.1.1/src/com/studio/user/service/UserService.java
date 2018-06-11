package com.studio.user.service;

import java.util.List;

import com.studio.user.entity.User;

public interface UserService {
	//用户登录
	public User login(User user);
	//用户注册
	public void regist(User user);
	//通过激活码，发现用户
	public User findByCode(User user);
	//更改用户信息
	public void update(User existUser);
	//通过邮箱发现用户
	public User findByEmail(User user);
	//找回密码
	public void findPass(User user);
	//修改密码
	public void editPass(User user);
	//查询所有的用户
	public List<User> findAll(User user);
	
}
