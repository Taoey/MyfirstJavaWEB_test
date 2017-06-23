package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import javaBean.User;


import utils.JDBCUtils;


public class UserJDBC {
    static Map<Integer, User> userMap=new LinkedHashMap<Integer, User>();
	
    private static int id;
	private static String name;
	private static String passwd;
	private static String email;
	
	private static Connection connection=null;
	private static Statement statement=null;
	private static ResultSet resultSet=null;
	
	/**
	 * 获取数据库游标
	 * @return resultSet
	 */		
	public static Map<Integer, User> getAllUsers() throws SQLException{
		
		try {
			connection=JDBCUtils.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from users");	
			
			while(resultSet.next()){
				id=resultSet.getInt("_id");
				name=resultSet.getString("_name");
				passwd=resultSet.getString("_passwd");
				email=resultSet.getString( "_email");
				userMap.put(id,new User(name,passwd,email));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(resultSet, statement, connection);
		}		
		return userMap;
		
	
	}
	public static User getUser(int id) throws SQLException, ClassNotFoundException{
		
		User tempUser =null;
		try {
			connection=JDBCUtils.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from users where _id="+id);
			if (resultSet.next()){//有游标必定有next(),可以认为一开始游标在-1的位置上.							
				id=resultSet.getInt("_id");
				name=resultSet.getString("_name");
				passwd=resultSet.getString("_passwd");
				email=resultSet.getString("_email");
				tempUser= new User(name,passwd,email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(resultSet, statement, connection);
		}
		return tempUser;
		
	}

	
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Map<Integer, User> Users=new LinkedHashMap<Integer, User>();
//		Users=getAllUsers();		
//		System.out.println(Users.size());
//		User tempBook=getUser(1);
//		System.out.println(tempBook.getName());
//	}
	 
	
	
	
	
	
	
	
}
