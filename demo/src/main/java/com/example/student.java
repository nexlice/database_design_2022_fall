package com.example;

public class student {
	private int ID;
	private String name;
	private String dept_name;
	private int tot_cred;
	
	public student(Integer ID, String name, String dept_name, Integer tot_cred) {
		super();
		this.ID = ID;
		this.name = name;
		this.dept_name = dept_name;
		this.tot_cred = tot_cred;
	}
	
	public Integer getID() {
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
	
	public String getdept_name() {
		return dept_name;
	}
	
	public void setdept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public Integer gettot_cred() {
		return tot_cred;
	}
	
	public void settot_cred(Integer tot_cred) {
		this.tot_cred = tot_cred;
	}
	
	public String toString() {
		return "student [ID = " + ID + ", name= " + name + ", dept_name= " + dept_name + ", tot_cred= " + tot_cred + "]";
	}
}
