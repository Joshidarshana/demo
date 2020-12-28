package com.facebook.controller;

import java.util.Map;

public interface FacebookControllerInterface {
	public void createProfile()throws Exception;
	public void viewProfile()throws Exception;

	public void deleteProfile()throws Exception;
	void editProfile()throws Exception;

	void searchProfile()throws Exception;

	public void viewAllProfile()throws Exception;
	
	public void getAll();
}