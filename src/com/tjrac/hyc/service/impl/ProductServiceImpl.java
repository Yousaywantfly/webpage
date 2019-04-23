package com.tjrac.hyc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tjrac.hyc.dao.ProductDao;
import com.tjrac.hyc.pojo.Product;
import com.tjrac.hyc.service.ProductService;

public class ProductServiceImpl implements ProductService {

	public ProductDao prodao;
	public SqlSessionFactory factory;
	public SqlSession session = null;

	public ProductServiceImpl() throws IOException {
		InputStream in = Resources.getResourceAsStream("config/mybatis.xml");
		factory = new SqlSessionFactoryBuilder().build(in);
	}

	@Override
	public List<Product> selectByname(String pname) {
		session = factory.openSession();
		prodao=session.getMapper(ProductDao.class);
		List<Product> list=prodao.selectByname("%"+pname+"%");
		System.out.println(list+"++");
		session.close();
		return list;
	}

	@Override
	public List<Product> selectall() {
		session = factory.openSession();
		prodao=session.getMapper(ProductDao.class);
		List<Product> list=prodao.selectall();
		session.close();
		return list;
	}

}
