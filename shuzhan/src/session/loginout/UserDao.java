package session.loginout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import utils.JDBCUtils;

public class UserDao {
	private static Connection connection =null;
	private static Statement statement=null;
	private static PreparedStatement ps = null;
	private static ResultSet resultSet=null;
	
	private UserDao(){		
	}	
	private static Map<String, String> map=new HashMap<String,String>();
	
	public static boolean valiNamepsw(String email,String password) throws SQLException, ClassNotFoundException{
		connection=JDBCUtils.getConnection();
		statement=connection.createStatement();		
		
		resultSet=statement.executeQuery("select * from users where _email='"+email+"'");
		if(resultSet.next()){
			String pas=resultSet.getString("_passwd");
			return pas.equals(password);
		}else {
			return false;
		}
		
		
	}
	
	public static String  getName(String email) throws SQLException,ClassNotFoundException{
		connection=JDBCUtils.getConnection();
		statement=connection.createStatement();
		String sql = String.format("select * from users where _email= '%s'",email);
		resultSet=statement.executeQuery(sql);
		if(resultSet.next()){
			return resultSet.getString("_name");
		}
		else {
			return null;
		}
		
	}
	
	public static boolean valiRegister(String email) throws ClassNotFoundException, SQLException{
		connection=JDBCUtils.getConnection();
		statement=connection.createStatement();
		String sql =String.format("select * from users where _email='%s'",email);
		resultSet=statement.executeQuery(sql);
		if(! resultSet.next()){//没有占用该邮箱可以注册
			return true;
		}
		else{
			return false;
		}	
		
	}
	
	public static boolean insertUser(String name,String passwd,String email) {
		try {
			connection=JDBCUtils.getConnection();
			ps=connection.prepareStatement("insert into users (_email,_name,_passwd)values(?,?,?)");
			
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, passwd);
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}finally{
			JDBCUtils.close(resultSet, statement, connection);
		}

		
		
	}
	
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		boolean y=insertUser("11", "22", "22");
//		System.out.println(y);
//	}
	
	
}














