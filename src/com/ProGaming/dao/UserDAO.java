package com.ProGaming.dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.ProGaming.model.User;


public interface UserDAO {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(UserDAO.class.getName());
	
	public boolean insertUser(User u);
	
	public ArrayList<User> getUser();
	
	public User getUserById(int id);
	
	public boolean updateUser(User u);
	
	public boolean deleteUser(int id);
	
	public int login(User u);
	
	public boolean UpdatePass(int id,String oldpass, String newpass);
	
	public int countUser();
}
