package cn.jeas.test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;

public class JdbcTest {
	@Test
	public void testJDBC(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/mybatis";
		String user = "root";
		String password = "513219";
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			Class.forName(driver);
			connection = (Connection) DriverManager.getConnection(url, user, password);
			String sql = "select * from tb_user where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, 1L);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getLong("id"));
				System.out.println("username: " + resultSet.getString("user_name"));
				System.out.println("password: " + resultSet.getString("password"));
				System.out.println("age: " + resultSet.getInt("age"));

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (resultSet!= null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
