package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.facebook.entity.*;
import com.facebook.utility.FacebookException;

public class FacebookDAO  implements FacebookDAOInterface{

	//static FacebookUser f[]=new FacebookUser[10];
	
	
	
	
	public int createProfileDAO(FacebookUser fu) throws Exception {
		

		int i=0;
		Connection con = null;
		try {
			if(fu.getName().equals("darshana")) {
				throw new FacebookException();
			}
		
		
		
		
		
		// step 1 load driver
		Class.forName("org.postgresql.Driver");
		
		//step 2 connect with database
		 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/capgemini","postgres","darshana");
		
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("insert into facebook values(?,?,?,?)");
		ps.setString(1, fu.getName());
		ps.setString(2, fu.getPassword());
		ps.setString(3, fu.getEmail());
        ps.setString(4, fu.getAddress());
        
        //step 4 execute query
         
        i=ps.executeUpdate();
        
		
		
	}
	
	catch(FacebookException fe) {
		fe.printStackTrace();
	}
	
	catch(ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	catch(SQLException e2) {
		e2.printStackTrace();
	}
	finally {
		try {
			con.close();
		}
		catch(Exception e3) {
			
		}
		
	}
		return i;
	}
	

	@Override
	public FacebookUser viewProfileDAO(FacebookUser fu) throws Exception {
		
		// step 1 load driver
				Class.forName("org.postgresql.Driver");
				
				//step 2 connect with database
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/capgemini","postgres","qwerty");
				
				//step 3 create query
				
				PreparedStatement ps=con.prepareStatement("select * from facebook where name=?");
				ps.setString(1, fu.getName());
				
				ResultSet res = ps.executeQuery();
				
				FacebookUser fb=null;
				
				if(res.next()) {
					fb=new FacebookUser();
					fb.setName(res.getString(1));
					fb.setPassword(res.getString(2));
					fb.setEmail(res.getString(3));
					fb.setAddress(res.getString(4));
				}
				return fb;
		        
		
	}

	@Override
	public int deleteProfileDAO(FacebookUser fu) throws Exception {
		
		int i =0;
		// step 1 load driver
		Class.forName("org.postgresql.Driver");
		
		//step 2 connect with database
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/capgemini","postgres","qwerty");
		
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("delete from facebook where name=?");
		ps.setString(1, fu.getName());
		
		i = ps.executeUpdate();
		return i;
		
		
		
	}

	@Override
	public int editProfileDAO(FacebookUser fu) throws Exception {
		int i =0;
		// step 1 load driver
		Class.forName("org.postgresql.Driver");
		
		//step 2 connect with database
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/capgemini","postgres","qwerty");
		
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("update facebook set name=? where email=?");
		ps.setString(1, fu.getName());
		ps.setString(2, fu.getEmail());
		
		i = ps.executeUpdate();
		return i;
		
	}

	@Override
	public void searchProfileDAO() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<FacebookUser> viewAllProfileDAO() throws Exception {
		
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/capgemini","postgres","qwerty");
		
		PreparedStatement ps=con.prepareStatement("select * from facebook");
				
		ResultSet res=ps.executeQuery();
		 ArrayList<FacebookUser> f=new ArrayList<FacebookUser>();  //generic collection means specific class object only your bag will accept, it will not accept other class object
		while(res.next()) {
			FacebookUser fb=new FacebookUser();
			fb.setName(res.getString(1));
			fb.setPassword(res.getString(2));
			fb.setEmail(res.getString(3));
			fb.setAddress(res.getString(4));
			
			f.add(fb);
		}
		return f;
	}
	
	public Map<String, Object> getAll(){
		Map<String, Object> m=new HashMap<String, Object>();
		
		ArrayList<String> notif=new ArrayList<String>();
		notif.add("person1 viewed profile");
		notif.add("person2 viewed profile");
		notif.add("person3 viewed profile");
		
		ArrayList<String> flist=new ArrayList<String>();
		flist.add("person1");
		flist.add("person2");
		flist.add("person3");
		
		m.put("notification", notif);
		m.put("friendlist",flist);
		
		return m;

	
	

	}

}
