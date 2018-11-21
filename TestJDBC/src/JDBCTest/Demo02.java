package JDBCTest;

import java.sql.*;

public class Demo02 {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载驱动");
			String url = "jdbc:mysql://localhost:3306/book?user=root&password=111111";
			conn = DriverManager.getConnection(url);
			System.out.println("成功连接到数据库");
			st = conn.createStatement();
			System.out.println("数据发送成功");
			rs = st.executeQuery("select * from message");
			System.out.println("1");
			while (rs.next()) {
				System.out.println(rs.getString("book_name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (st != null) {
					st.close();
					st = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
