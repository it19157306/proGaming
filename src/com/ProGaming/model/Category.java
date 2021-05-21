package com.ProGaming.model;

public class Category {
	//define the fields
		private Integer cat_id;
		private  String name;
		private String cat_icon;
		
	
		//Generate the setters and Getters
		public Integer getCat_id() {
			return cat_id;
		}
		public void setCat_id(Integer cat_id) {
			this.cat_id = cat_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCat_icon() {
			return cat_icon;
		}
		public void setCat_icon(String cat_icon) {
			this.cat_icon = cat_icon;
		}
		@Override
		public String toString() {
			return "Category [cat_id=" + cat_id + ", name=" + name + ", cat_icon=" + cat_icon + "]";
		}
		
		
}
