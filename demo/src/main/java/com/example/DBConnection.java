package com.example;

/**
 * Hello world!
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class App 
{
	private String dburl = "jdbc:mysql://localhost:3306/sys";
	private String dbuser = "test1";
	private String dbpasswd = "test1";
	String sql = "SELECT * FROM student";
	
	public List<student> getstudents() {
		List<student> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM student";
		try(Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					String des = rs.getString(1);
					int id = rs.getInt("ID");
					String name = rs.getString("name");
					String dept_name = rs.getString("dept_name");
					int tot_cred = rs.getInt("tot_cred");
					student role = new student(id, name, dept_name, tot_cred);
					list.add(role);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
    public static void main( String[] args ) 
    {

//        Class.forName("com.mysql.cj.jdbc.Driver");
        
//        Connection con = DriverManager.getConnection(dburl, dbpasswd, dbUser);
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(sql);
//       
//        rs.close();
//        st.close();
//        con.close();
    	
    	App my = new App();
    	
    	List<student> list_students = my.getstudents();
    	for(student data: list_students) {
    		System.out.println(data);
    	}
    	//System.out.println(list_students.toString());

    }
}
