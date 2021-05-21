package com.ProGaming.dao;

import java.sql.*;
import java.util.ArrayList;


import com.ProGaming.util.DBConnectionUtil;
public class SiteTrafficDAOImpl {

	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public void hitCounter(int count){
		
		try {
			con = DBConnectionUtil.OpenConnection();
			pst = con.prepareStatement("Insert into traffic(count) values (?) ");
			pst.setInt(1, count);
			pst.executeUpdate();
			
			
			
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}
	}
public ArrayList <String> getTraffic(){
		
	ArrayList <String> al = new ArrayList<>();
		try {
			
			con = DBConnectionUtil.OpenConnection();
			pst = con.prepareStatement("select sum(count),CAST(date_ AS DATE) as date from traffic group by CAST(date_ AS DATE)");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int temp = rs.getInt(1);
				String date  = rs.getString(2);
				String number = Integer.toString(temp);
				al.add(date);
				al.add(number);
			}
			
			
			return al;
			
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return al;
		}
		
		
		
	
	
}
