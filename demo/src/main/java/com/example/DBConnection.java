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

public class DBConnection 
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
	
	
	public List<dummy> getdummy() {
		List<dummy> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM dummy";
		try(Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					String des = rs.getString(1);
					int id = rs.getInt("ID");
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					dummy data = new dummy(id, name, grade);
					list.add(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void createTable() {
			
			Connection conn = null;
		    Statement stmt = null;
	 
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	 
	            conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
	 
	            System.out.println("Successfully Connected!");
	 
	            //DB와 연결된 conn 객체로부터 Statement 객체 획득.
	            stmt = conn.createStatement();
	 
	            //query 만들기
	            StringBuilder sb = new StringBuilder();
	            String sql = sb.append("create table if not exists dummy(")
	                    .append("id int,")
	                    .append("name varchar(20),")
	                    .append("grade int")
	                    .append(");").toString();
	 
	            //query문 날리기
	            stmt.execute(sql);
	        }
	 
	        catch(ClassNotFoundException e){
	            e.printStackTrace();
	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	        finally{
	            try{
	                //자원 해제
	                if(conn != null && !conn.isClosed())
	                    conn.close();
	            } catch(SQLException e){
	                e.printStackTrace();
	        }
	    }
	}
	
    public void insertDummy(int id, String name, int grade) {
    	String table = "dummy";
        StringBuilder sb = new StringBuilder();
        Statement stmt = null;
        Connection conn = null;
        
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        //DB와 연결된 conn 객체로부터 Statement 객체 획득.
        try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        String sql = sb.append("insert into " + table + " values(")
                .append(id + ",")
                .append("'" + name + "',")
                .append(grade)
                .append(");")
                .toString();
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void deleteDummy(int id, String name, int grade) {
    	String table = "dummy";
        StringBuilder sb = new StringBuilder();
        Statement stmt = null;
        Connection conn = null;
        
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        //DB와 연결된 conn 객체로부터 Statement 객체 획득.
        try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        String sql = sb.append("delete from " + table + " where id = ")
                .append(id)
                .append(";")
                .toString();
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
    	
    	DBConnection my = new DBConnection();
    	
//    	List<student> list_students = my.getstudents();
//    	for(student data: list_students) {
//    		System.out.println(data);
//    	}
    	//System.out.println(list_students.toString());
    	
    	my.createTable();
    	
    	my.insertDummy(10, "dummy_name_1", 10);
    	
    	my.deleteDummy(10, "dummy_name_1", 10);
    	List<dummy> list_dummies = my.getdummy();
    	for(dummy data: list_dummies) {
    		System.out.println(data);
    	}

    }
}
