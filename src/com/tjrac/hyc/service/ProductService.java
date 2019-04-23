package com.tjrac.hyc.service;

import java.util.List;

import com.tjrac.hyc.pojo.Product;

public interface ProductService {

	List<Product> selectByname(String pname);

	List<Product> selectall();

}
