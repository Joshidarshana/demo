package com.facebook.dao;

import java.util.ArrayList;
import java.util.Map;

import com.facebook.entity.FacebookUser;

public interface FacebookDAOInterface {
	public  int  createProfileDAO(FacebookUser fu) throws Exception;
	public FacebookUser  viewProfileDAO(FacebookUser fu) throws Exception;

	public int  deleteProfileDAO(FacebookUser fu)throws Exception;

	public int  editProfileDAO(FacebookUser fu)throws Exception;

	public void  searchProfileDAO()throws Exception;

	public ArrayList<FacebookUser> viewAllProfileDAO()throws Exception;;
	public Map<String, Object> getAll();
}
