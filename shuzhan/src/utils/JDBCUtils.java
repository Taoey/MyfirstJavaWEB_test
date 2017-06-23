package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	
	/**
	 * 获得数据库连接
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql:///test","root","12345678");
	}
	
	/**
	 * 关闭数据库连接
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void close(ResultSet resultSet,Statement statement ,Connection connection){
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				resultSet=null;
			}
		}
		
		if(statement!=null){
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				statement=null;
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				connection=null;
			}
		}
		
	}
	
	
	
	
	
	
	
	
}


