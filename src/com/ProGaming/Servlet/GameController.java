package com.ProGaming.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ProGaming.dao.GameDAO;
import com.ProGaming.dao.GameDAOImpl;
import com.ProGaming.model.Category;
import com.ProGaming.model.Game;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/GameController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 5)

public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	 Specifies the directories to save the images
	private static final String SAVEPATH = "C:\\Users\\Mohammed Rishard\\eclipse-workspace\\ProGaming\\WebContent\\Utilities\\images\\Games";
	
	GameDAO gDAO = null;
	RequestDispatcher dis = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameController() {
		super();
		gDAO = new GameDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getParameter("action");

		if (action == null) {

			action = "list";

		}
		switch (action) {
		case "edit":
					editGame(req, res);
					break;
		
		case "play":
					editGame(req, res);
					break;
		case "delete":
					deleteGame(req, res);
					break;
		case "ADD":
					addGame(req, res);
					break;
							
		case "Dashboard" :
					dashGame(req,res);
					break;
					
		case "home":				
		case "register":					
		case "allGame":					
		case "myAccount":				
		case "updateAccount":
							homeGameDisplay(req,res);
							break;
		default:
					listGame(req, res);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getParameter("action");

		if(action!=null && action.equals("Dashboard")) {
			dashGame(req,res);
			
		}else if(action!=null && action.equals("search")) {
			searchGame(req, res);
			
		}else if(action!=null) {
			homeGameDisplay(req,res);
		}
		else {
		res.setContentType("text/html");
		Game g = new Game();
		
		String id = req.getParameter("gID");
		g.setgName(req.getParameter("gname"));
		g.setgInst(req.getParameter("gameinst"));
		g.setgDes(req.getParameter("gamedes"));
		g.setgLink(req.getParameter("gamelink"));
		
		//Stores the values from multiple select in a string array
		String[] catId   =req.getParameterValues("gcat");
		
		//Declare an integer array to store the category ids after converting them to int
		int[] cat = new int[catId.length];
		int temp;
		//Converts the elements in the string array and store them to the integer array
		for(int i=0;i < catId.length; i++)
		{
		    temp = Integer.parseInt(catId[i]);
		    cat[i] = temp;  
		}
		//Set the gCat property of the game object
		g.setgCat(cat);

		//	To check whether an image has been selected	
		boolean fileStatus = false;
		
		// Returns true if an image has been selected	
		if(req.getPart("gme-img").getSize()>0){
			fileStatus = true;
		}
		// Returns false if an image has not been selected	
		if(req.getPart("gme-img").getSize()<=0){
			fileStatus = false;
		}
		//	Extracts the image and saves it to the folder only if an image has been selected	
		if(fileStatus) {
			//Stores the image in a variable
			Part img = req.getPart("gme-img");
		
			//Creates Games directory if not found
		    File GamesDir=new File(SAVEPATH);
		    if(!GamesDir.exists()){
		       GamesDir.mkdirs();
		    }
		    //Extracts the file name from the image       
		     String imgName=extractfilename(img);
		     
		    //Saves the image in the specific location 
		     img.write(SAVEPATH + File.separator + imgName);
		     
		     //Stores the path
		     String filePath= SAVEPATH  + File.separator + imgName;
		     
		    //Sets image name to the object	    		
		     g.setgImg(imgName);
		     
		}else {
			
			g.setgImg(""); //Sets empty if an image has not been selected
		}
        
		if (id == null || id.isEmpty()) {
			
			gDAO.addGame(g);
		} else {
			
			try {
				g.setgID(Integer.parseInt(id));
				gDAO.updateGame(g);
			}catch(NumberFormatException e) {
				
			}
		}

		
			// Flag is sent to the list Game() to inform that a game has been added or updated		
			  req.setAttribute("flag", 1); 
			  listGame(req, res);
		}
		 
	}

	protected void listGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ArrayList<Game> g3 = new ArrayList<Game>();
		g3 = gDAO.listGame();
		req.setAttribute("glist", g3);
		dis = req.getRequestDispatcher("views/AllGames.jsp");
		dis.forward(req, res);
	}

	protected void editGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String action = req.getParameter("action");

		Game g4 = gDAO.getGame(Integer.parseInt(id));
		int arr[] = g4.getgCat();
		req.setAttribute("g", arr);
		req.setAttribute("game", g4);
		
		if(action != null && action.equals("play")) {
			homeGameDisplay(req,res);
		}
		else  {
			dis = req.getRequestDispatcher("CategoryController?action=GET");
			dis.forward(req, res);
		}
	}

	protected void deleteGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		boolean val = gDAO.deleteGame(id);
		
		if(val == true) {
			req.setAttribute("msg", "Gamer Deleted Successfully");
		}
		listGame(req, res);
	}

	protected void addGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		dis = req.getRequestDispatcher("CategoryController?action=GET");
		dis.forward(req, res);
		
	}
	
	protected void homeGameDisplay(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String action = req.getParameter("action");
		String cat = req.getParameter("cat");
		
		ArrayList<Game> g = new ArrayList<Game>();
		
		g= gDAO.getGamesbyCat("Trending");
		req.setAttribute("trending", g);
		
		g= gDAO.getGamesbyCat("Action");
		req.setAttribute("action", g);
		
		g= gDAO.getGamesbyCat("Racing");
		req.setAttribute("racing", g);
		
		g= gDAO.getGamesbyCat("Multiplayer");
		req.setAttribute("multiplayer", g);
		
		g= gDAO.getGamesbyCat("New");
		req.setAttribute("newgme", g);
		
		g= gDAO.getGamesbyCat("Featured Games");
		req.setAttribute("featured", g);
		
		g= gDAO.getGamesbyCat("Featured Games");
		req.setAttribute("featured", g);
		
		g= gDAO.getGamesbyCat("Shooting");
		req.setAttribute("shooting", g);
		
		g= gDAO.getGamesbyCat("Sports");
		req.setAttribute("sports", g);
		
		g= gDAO.getGamesbyCat("Stunt");
		req.setAttribute("stunt", g);
		if(cat != null) {
			g= gDAO.getGamesbyCat(cat);
			req.setAttribute("catgme", g);
		}
		
		if (action == null) {
			action = "";
		}
		if(action.equals("play") ) {
			dis = req.getRequestDispatcher("CategoryController?action=GET&location=Play");
			dis.forward(req, res);
		
		}else if(action.equals("allGame") ) {
			dis = req.getRequestDispatcher("CategoryController?action=GET&location=allGame");
			dis.forward(req, res);
		}else if(action.equals("myAccount")) {
			
			dis = req.getRequestDispatcher("CategoryController?action=GET&location=myAccount");
			dis.forward(req, res);	
	
		}else {
			
			dis = req.getRequestDispatcher("CategoryController?action=GET&location=Home");
			dis.forward(req, res);
		
		}
	}

	protected void dashGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ArrayList<Game> g = new ArrayList<Game>();
		ArrayList<String> al = new ArrayList<>();
		
		int total = gDAO.countGame();
		g= gDAO.getGamesbyCat("New");
		req.setAttribute("newgme", g);
		req.setAttribute("gTotal", total);
		al = gDAO.getGamebyMonth();
		req.setAttribute("totalGames", al);
		dis = req.getRequestDispatcher("SiteHitCounter");
		dis.forward(req,res);
			
	}
	protected void searchGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String search = req.getParameter("search");
		ArrayList<Game> g = new ArrayList<>();
		 g = gDAO.searchGame(search);
		if(g.isEmpty()) {
			req.setAttribute("notFound", "Sorry, Game not found. Please try again");
		}
		req.setAttribute("catgme", g);
		dis = req.getRequestDispatcher("CategoryController?action=GET&location=allGame");
		dis.forward(req, res);
	}
	
//Method to find the file name
	public String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}

		return "";

	}

}
