package com.ProGaming.dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.ProGaming.model.Game;

public interface GameDAO {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(GameDAO.class.getName());
	
	boolean	 addGame(Game g1 );
	
	ArrayList<Game> listGame();
	
	Game getGame(int id);
	
	boolean updateGame(Game g5);
	
	boolean deleteGame(int id);
	
	ArrayList<Game> getGamesbyCat(String cat);
	
	public int countGame();
	
	public ArrayList <String> getGamebyMonth();
	
	public ArrayList<Game> searchGame(String name);
	
}
