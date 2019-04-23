package com.tjrac.hyc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tjrac.hyc.dao.SaveDao;
import com.tjrac.hyc.dao.UserDao;
import com.tjrac.hyc.pojo.Product;
import com.tjrac.hyc.pojo.Save;
import com.tjrac.hyc.pojo.User;
import com.tjrac.hyc.service.SaveService;

public class SaveServiceImpl implements SaveService {

	public SaveDao sdao;
	public SqlSessionFactory factory;
	public SqlSession session = null;

	public SaveServiceImpl() throws IOException {
		InputStream in = Resources.getResourceAsStream("config/mybatis.xml");
		factory = new SqlSessionFactoryBuilder().build(in);
	}

	@Override
	public boolean save(Save save) {
		session = factory.openSession();
		sdao = session.getMapper(SaveDao.class);
		boolean b = sdao.save(save);
		session.commit();
		session.close();
		return b;

	}

	@Override
	public boolean selectsave(Save save) {
		session = factory.openSession();
		sdao = session.getMapper(SaveDao.class);
		Save b = sdao.selectsave(save);
		session.close();
		if (b == null) {
			return true;
		} else {
			return false;
		}
	
	}

	@Override
	public boolean delete(Save save) {
		session = factory.openSession();
		sdao = session.getMapper(SaveDao.class);
		boolean b=sdao.delete(save);
		session.commit();
		session.close();
		return b;
	}

	@Override
	public List<Save> show(Save save) {
		session = factory.openSession();
		sdao = session.getMapper(SaveDao.class);
		List<Save> l=sdao.show(save);
		return l;
		
	}


}
