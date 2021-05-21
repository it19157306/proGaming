package com.ProGaming.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ProGaming.model.Gamer;
import com.ProGaming.util.DBConnectionUtil;

public class GamerDAOImpl implements GamerDAO{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(GamerDAOImpl.class.getName());
	
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	

	@Override
//	This method is used to add the customers to the database
	public boolean addGamer(Gamer g) {
		
		boolean flag = false;
		try {
			
		con = DBConnectionUtil.OpenConnection();
		pst = con.prepareStatement("Insert into Gamer(fname,lname,Username,Password,email,dob,Country) values (?,?,?,?,?,?,?)");
		
		pst.setString(1,g.getFname() );
		pst.setString(2,g.getLname() );
		pst.setString(3,g.getUsername() );
		pst.setString(4,g.getPass() );
		pst.setString(5,g.getEmail());
		pst.setString(6,g.getDob());
		pst.setString(7,g.getCountry());	
		pst.executeUpdate();

		flag = true;
		
		}catch(SQLException ex) {
			ex.printStackTrace();
			log.log(Level.SEVERE, ex.getMessage());
		}
		return flag;
	}
	
//	This method is used to display the customers from the database
	public ArrayList<Gamer> getGamer(){
		
		
		ArrayList <Gamer> al = new ArrayList<Gamer>();
		
		try {
			
			con = DBConnectionUtil.OpenConnection();
			st = con.createStatement();
			rs = st.executeQuery("Select * from Gamer");
			
			while(rs.next()) {
				Gamer g = new Gamer();
				g.setId(rs.getInt("id"));
				g.setFname(rs.getString("fname"));
				g.setLname(rs.getString("lname"));
				g.setUsername(rs.getString("Username"));
				g.setPass(rs.getString("Password"));
				g.setEmail(rs.getString("email"));
				g.setDob(rs.getString("dob"));
				g.setCountry(rs.getString("Country"));
				
				al.add(g);
				
			}
			
		}catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
//		} finally {
//			/*
//			 * Close prepared statement and database connectivity at the end
//			 * of transaction
//			 */
//			try {
//				if (pst != null) {
//					pst.close();
//				}
//				if (con != null) {
//						con.close();
//					
//				}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
//		
	
		return al;
		
	}
	public Gamer getGamerById(int id) {
		Gamer g = null;
		try {
			g = new Gamer();
			con = DBConnectionUtil.OpenConnection();
			pst = con.prepareStatement("Select * from Gamer where id = "+id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				g.setId(rs.getInt("id"));
				g.setFname(rs.getString("fname"));
				g.setLname(rs.getString("lname"));
				g.setUsername(rs.getString("Username"));
				g.setPass(rs.getString("Password"));
				g.setEmail(rs.getString("email"));
				g.setDob(rs.getString("dob"));
				g.setCountry(rs.getString("Country"));
			}
		}catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return g;
	}
	public boolean updateGamer(Gamer g) {
	
		boolean flag = false;
		try {
			
			con = DBConnectionUtil.OpenConnection();
			
			if(g.getEmail() == null) {
				pst = con.prepareStatement("Update Gamer set fname = ?,lname = ?,Username = ? ,dob = ?,Country = ? where id = "+ g.getId());
				
				pst.setString(1,g.getFname() );
				pst.setString(2,g.getLname() );
				pst.setString(3,g.getUsername() );
				pst.setString(4,g.getDob());
				pst.setString(5,g.getCountry());
			}else {
				pst = con.prepareStatement("Update Gamer set fname = ?,lname = ?,Username = ? ,email = ?,dob = ?,Country = ? where id = "+ g.getId());
				
				pst.setString(1,g.getFname() );
				pst.setString(2,g.getLname() );
				pst.setString(3,g.getUsername() );
				pst.setString(4,g.getEmail());
				pst.setString(5,g.getDob());
				pst.setString(6,g.getCountry());
			}
			
			pst.executeUpdate();
			
		
			flag = true;
			
			}catch(SQLException ex) {
				log.log(Level.SEVERE, ex.getMessage());
			}
			return flag;
	}
	public boolean deleteGamer(int id) {
		
		boolean flag = false;
		try {
			
			con = DBConnectionUtil.OpenConnection();
			pst = con.prepareStatement("Delete from Gamer where id = "+ id);			
			pst.executeUpdate();
			flag = true;
			
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			return flag;
	}
	public int authenticate(Gamer g) {
		
		try {
			con = DBConnectionUtil.OpenConnection();
			pst = con.prepareStatement("Select * from Gamer where email = ? and Password = ?");
			pst.setString(1, g.getEmail());
			pst.setString(2, g.getPass());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				int a = rs.getInt("id");
				return a;
			}else{
				return 0;
			}
		}catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return 0;

		
	}
	
	public String updatePass(int id,String oldPass, String newPass) {
		
		
		try {
			
			con = DBConnectionUtil.OpenConnection();
			pst = con.prepareStatement("Select Password from gamer where id = ? and Password = ?");
			
			pst.setInt(1,id );
			pst.setString(2,oldPass);
	
			rs = pst.executeQuery();
			
			if(rs.next()) {
				
				pst = con.prepareStatement("Update gamer set Password = ? where id = "+id);
				pst.setString(1,newPass);
				pst.executeUpdate();
				return "true";
			}
			else {
				return "false";
			}
			}catch(SQLException ex) {
				log.log(Level.SEVERE, ex.getMessage());
			}
			return "error";
	}
	
	public String updateEmail(int id,String oldEmail, String newEmail) {
		
		try {
			
			con = DBConnectionUtil.OpenConnection();
			pst = con.prepareStatement("Select email from gamer where id = ? and email= ?");
			
			pst.setInt(1,id );
			pst.setString(2,oldEmail);
	
			rs = pst.executeQuery();
			
			if(rs.next()) {
				
				pst = con.prepareStatement("Update gamer set email = ? where id = "+id);
				pst.setString(1,newEmail);
				pst.executeUpdate();
				return "true";
			}
			else {
				return "false";
			}
			}catch(SQLException ex) {
				log.log(Level.SEVERE, ex.getMessage());
			}
			return "error";
		
	}
	
	public int countGamers() {
		
		try {
			con = DBConnectionUtil.OpenConnection();
			st = con.createStatement();
			rs = st.executeQuery("Select count(id) from Gamer");
			int total = 0;
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			return total;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ArrayList <String> getGamersbyMonth(){
		
		ArrayList<String> g = new ArrayList<>();
	try {
		con = DBConnectionUtil.OpenConnection();
		st = con.createStatement();
		rs = st.executeQuery("select monthname(JoinedDate), count(id) from Gamer group by monthname(JoinedDate)");

		while(rs.next()) {
			String month = rs.getString(1);
			int temp = rs.getInt(2);
			String count = Integer.toString(temp);
			g.add(month);
			g.add(count);	
		}
		
		return g;
	}catch(SQLException e) {
		log.log(Level.SEVERE, e.getMessage());
	}
	
	return g;
	
	
}
}


