package com.facebook.service;

import java.util.ArrayList;
import java.util.Map;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {
	public int createProfileService(FacebookUser fu)throws Exception;
	public FacebookUser viewProfileService(FacebookUser fu)throws Exception;

	public int deleteProfileService(FacebookUser fu)throws Exception;
	public int editProfileService(FacebookUser fu)throws Exception;

	void searchProfileService()throws Exception;

	public ArrayList<FacebookUser> viewAllProfileService()throws Exception;
	public Map<String, Object> getAll();
}