package com.tjrac.hyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tjrac.hyc.pojo.Product;



public interface ProductDao {
	
	@Select("select * from product where pname like #{pname}")
	List<Product> selectByname(String pname);

	@Select("select * from product ")
	List<Product> selectall();
  

}
