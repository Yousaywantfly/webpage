package com.tjrac.hyc.dao;

import java.util.List;

import com.tjrac.hyc.pojo.Product;
import com.tjrac.hyc.pojo.Save;



public interface SaveDao {

	public List<Save> findAll();

	public boolean save(Save save);

	public Save selectsave(Save save);

	public boolean delete(Save save);

	public List<Save> show(Save save);
	
}
