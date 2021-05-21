package com.ProGaming.model;

public class Game {

	private int gID;
	private String gName;
	private int gCat[];
	private String gDes;
	private String gInst;
	private String gImg;
	private String gLink;
	
	public int getgID() {
		return gID;
	}
	public void setgID(int gID) {
		this.gID = gID;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}

	public int[] getgCat() {
		return gCat;
	}
	public void setgCat(int[] gCat) {
		this.gCat = gCat;
	}
	public String getgDes() {
		return gDes;
	}
	public void setgDes(String gDes) {
		this.gDes = gDes;
	}
	public String getgInst() {
		return gInst;
	}
	public void setgInst(String gInst) {
		this.gInst = gInst;
	}
	public String getgImg() {
		return gImg;
	}
	public void setgImg(String gImg) {
		this.gImg = gImg;
	}
	public String getgLink() {
		return gLink;
	}
	public void setgLink(String gLink) {
		this.gLink = gLink;
	}
	@Override
	public String toString() {
		return "Game [gID=" + gID + ", gName=" + gName + ", gCat=" + gCat + ", gDes=" + gDes + ", gImg=" + gImg
				+ ", gLink=" + gLink + "]";
	}
	
}
