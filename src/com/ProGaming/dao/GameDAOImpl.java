package com.ProGaming.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ProGaming.model.Game;
import com.ProGaming.util.DBConnectionUtil;

public class GameDAOImpl implements GameDAO{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(GameDAOImpl.class.getName());
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs ;
	Statement s;
	
public boolean	 addGame(Game g1 ) {
	
	boolean flag = false;
	
		try {
			
			con = DBConnectionUtil.OpenConnection();
			
			
			
			ps = con.prepareStatement("Insert into game (gName,gDes,gInst,gImg,gLink) values (?,?,?,?,?)"); 
			ps.setString(1,g1.getgName() );
			ps.setString(2,g1.getgDes());
			ps.setString(3,g1.getgInst());
			ps.setString(4,g1.getgImg());
			ps.setString(5,g1.getgLink());
			ps.executeUpdate();
			
			//Returns the game ID of the inserted game
			ps = con.prepareStatement("Select gID from game where gName = '"+g1.getgName()+"'");
			rs = ps.executeQuery();
			if(rs.next()) {				
				g1.setgID(rs.getInt(1)); //Set the game id to the game object
			}
			//Insert the returned id and the category ids to the game_category table
			ps = con.prepareStatement("Insert into game_category values(?,?)");
			
			//Stores the game categories in an array
			int[] arr = g1.getgCat();
			
			//Insert one by one to the table
			for(int i = 0; i<arr.length;i++)
			{
				ps = con.prepareStatement("Insert into game_category values(?,?)");
				ps.setInt(1, g1.getgID());
				ps.setInt(2, arr[i]);
				ps.executeUpdate();
			}
			flag = true;
			
		}
		catch(SQLException ex){
			
			log.log(Level.SEVERE, ex.getMessage());
	
		}
		return flag;
	}	


 public ArrayList<Game> listGame(){
	
	 ArrayList<Game>g = new ArrayList<Game>();
	 
	 
	 try {
			
			con = DBConnectionUtil.OpenConnection();
			s = con.createStatement();
			rs = s.executeQuery("select * from game");
			
			while(rs.next()) {
				
				Game game = new Game();
				game.setgID(rs.getInt(1));
				game.setgName(rs.getString(2));		
				game.setgDes(rs.getString(4));
				game.setgImg(rs.getString(5));
				game.setgLink(rs.getString(6));
				
				
				g.add(game);
			}
			
	 }
	 
	 catch(SQLException e){
		 
		 log.log(Level.SEVERE, e.getMessage());
		 
	 }
	
	return g;
}
public Game getGame(int id) {
	 
	Game g2 = new Game();
	try{
		
		con = DBConnectionUtil.OpenConnection();
		s = con.createStatement();
		rs = s.executeQuery("select * from game where gID ="+ id);
		if(rs.next()) {
			
			g2.setgID(rs.getInt(1));
			g2.setgName(rs.getString(2));
			g2.setgDes(rs.getString(3));
			g2.setgInst(rs.getString(4));
			g2.setgImg(rs.getString(5));
			g2.setgLink(rs.getString(6));
			
		}
		s = con.createStatement();
		rs = s.executeQuery("select * from game_category where gID ="+ id);
		int i = 0;
		ArrayList<Integer> arr = new ArrayList<>();

		while(rs.next()) {	

			arr.add(rs.getInt("cat_id"));

		}
		//Converting arraylist to int array
		int[] cat = new int[arr.size()];
		
		try {
		int var = 0;
		for(Integer c : arr) {	
			cat[var] = c;
			var++;
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out of Bounds Exception " + e);
		}
		g2.setgCat(cat);

	}
	catch(SQLException e){
		
		log.log(Level.SEVERE, e.getMessage());
		 
	}
	return g2;
 }
public boolean	 updateGame(Game g5 ) {
	
	boolean flag = false;
	
		try {
			
			con = DBConnectionUtil.OpenConnection();
	
			//Checks whether the image has also been updated 
			if(g5.getgImg().isEmpty() || g5.getgImg() == null)
			{
				//This is executed only when the image is not updated
				
				//Updates the rest of the columns excluding the image name
				ps = con.prepareStatement("Update game Set gName = ? , gDes = ? ,gInst = ? , gLink = ? where gID = " + g5.getgID()); 
				ps.setString(1,g5.getgName() );
				ps.setString(2,g5.getgDes());
				ps.setString(3,g5.getgInst());
				ps.setString(4,g5.getgLink());
			
			}else {
				//This is executed only when the image is updated
				
				//Updates the rest columns including the image name
				ps = con.prepareStatement("Update game Set gName = ? , gDes = ? ,gInst = ? ,gImg = ?, gLink = ? where gID = " + g5.getgID()); 
				ps.setString(1,g5.getgName() );
				ps.setString(2,g5.getgDes());
				ps.setString(3,g5.getgInst());
				ps.setString(4,g5.getgImg());
				ps.setString(5,g5.getgLink());
					
					
			}
			
			ps.executeUpdate();
			
			//Delete the relevant record in game_category table
			ps = con.prepareStatement("Delete from game_category where gID = " + g5.getgID());
			ps.executeUpdate();
			//Stores the game categories in an array
			int[] arr = g5.getgCat();
			//Insert one by one to the table
			for(int i = 0; i<arr.length;i++)
			{
				ps = con.prepareStatement("Insert into game_category values(?,?)");
				ps.setInt(1, g5.getgID());
				ps.setInt(2, arr[i]);
				ps.executeUpdate();
			}
			
		
			flag = true;
			
		}
		catch(SQLException ex){
			
			log.log(Level.SEVERE, ex.getMessage());
	
		}
		return flag;
	}	

public boolean	 deleteGame(int id ) {
	
	boolean flag = false;
	
		try {
			
			con = DBConnectionUtil.OpenConnection();
			ps = con.prepareStatement("delete from game where gID = " +  id); 
			ps.executeUpdate();
			
			
			flag = true;
			
		}
		catch(SQLException ex){
			
			ex.printStackTrace();
	
		}
		return flag;
	}	
public ArrayList<Game> getGamesbyCat(String cat){
	
		ArrayList<Game>g = new ArrayList<Game>();
	 
	 
	 try {
			
			con = DBConnectionUtil.OpenConnection();
			s = con.createStatement();
			if(cat.equals("New") || cat.equals("All Game")) {
				rs = s.executeQuery("select g.gID,g.gName,g.gImg from game g order by g.gAddedDate DESC");
			}
			else {
			rs = s.executeQuery("select g.gID,g.gName,g.gImg from game g, category c, game_category gc where g.gID = gc.gID and c.cat_id = gc.cat_id and c.name = '"+cat+"' order by g.gAddedDate DESC");
			}
			while(rs.next()) {
				
				Game game = new Game();
				game.setgID(rs.getInt(1));
				game.setgName(rs.getString(2));		
				game.setgImg(rs.getString(3));			
				g.add(game);
			}
			
	 }
	 
	 catch(SQLException e){
		 
		 log.log(Level.SEVERE, e.getMessage());
		 
	 }
	
	return g;
	
	
}

public int countGame() {
	
	try {
		con = DBConnectionUtil.OpenConnection();
		s = con.createStatement();
		rs = s.executeQuery("Select count(gID) from Game");
		int total = 0;
		if(rs.next()) {
			total = rs.getInt(1);
		}
		
		return total;
	}catch(SQLException e) {
		log.log(Level.SEVERE, e.getMessage());
	}
	
	return 0;
	
}
public ArrayList <String> getGamebyMonth(){
	
		ArrayList<String> al = new ArrayList<>();
	try {
		con = DBConnectionUtil.OpenConnection();
		s = con.createStatement();
		rs = s.executeQuery("select monthname(gAddedDate), count(gID) from game group by monthname(gAddedDate)");

		while(rs.next()) {
			String month = rs.getString(1);
			int c = rs.getInt(2);
			String count = Integer.toString(c);
			al.add(month);
			al.add(count);	
		}
		
		return al;
	}catch(SQLException e) {
		log.log(Level.SEVERE, e.getMessage());
	}
	
	return al;
	
	
}

	public ArrayList<Game> searchGame(String name) {

		ArrayList<Game> g = new ArrayList<>();
		
		try{
			
			con = DBConnectionUtil.OpenConnection();
			s = con.createStatement();
			rs = s.executeQuery("select * from game where gName like '"+ name +"%'");
			while(rs.next()) {
			
				Game g2 = new Game();
				g2.setgID(rs.getInt(1));
				g2.setgName(rs.getString(2));
				g2.setgDes(rs.getString(3));
				g2.setgInst(rs.getString(4));
				g2.setgImg(rs.getString(5));
				g2.setgLink(rs.getString(6));
				
				g.add(g2);
			}
			
			return g;
		}catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return g;
	}
}

