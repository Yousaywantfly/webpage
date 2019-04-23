package com.tjrac.hyc.service;

import java.util.List;

import com.tjrac.hyc.pojo.Product;
import com.tjrac.hyc.pojo.Save;

public interface SaveService {

	public boolean save(Save save);

	public boolean selectsave(Save save);

	public boolean delete(Save save);

	public List<Save> show(Save save);

}
