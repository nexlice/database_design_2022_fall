package com.example;

public class dummy {
	private int ID;
	private String name;
	private int grade;
	
	public dummy(int ID, String name, int grade) {
		super();
		this.ID = ID;
		this.name = name;
		this.grade = grade;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public int getgrade() {
		return grade;
	}
	
	public void setgrade(int grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return "dummy [ID = " + ID + ", name= " + name + ", grade= " + grade + "]";
	}
}
