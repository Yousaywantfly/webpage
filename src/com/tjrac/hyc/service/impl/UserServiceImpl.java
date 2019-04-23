package com.tjrac.hyc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.tjrac.hyc.dao.UserDao;
import com.tjrac.hyc.pojo.User;
import com.tjrac.hyc.service.UserService;

public class UserServiceImpl implements UserService {

	public UserDao udao;
	public SqlSessionFactory factory;
	public SqlSession session=null;
	public UserServiceImpl() throws IOException {
		InputStream in = Resources.getResourceAsStream("config/mybatis.xml");
	    factory = new SqlSessionFactoryBuilder().build(in);
	}
	@Override
	public User judge(User user) {
		
			session=factory.openSession();
			udao=session.getMapper(UserDao.class);
			User b=udao.judge(user);
			session.close();
			return b;
		}
}