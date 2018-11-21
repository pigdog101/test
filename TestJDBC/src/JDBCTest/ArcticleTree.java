package JDBCTest;
import java.sql.*;
public class ArcticleTree {
	   int level  = 0;
	  StringBuilder sb = new StringBuilder("");
	public static void main(String[] args) {
     new ArcticleTree().start();

	}
	
    public void start() {
		Statement st= null;
		ResultSet rs = null;
		Connection conn = null;
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:3306/book?user=root&password=111111";
    	conn = DriverManager.getConnection(url);
    	tree(conn,2,1);
    	}catch(ClassNotFoundException e) {
    	e.printStackTrace();	
    	} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
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
	private void tree(Connection conn,int id,int level)
	{
		
		Statement st= null;
		ResultSet rs = null;
		sb.append("    ");
		String sql = "select * from arcticle where id = " +id ;
		id++;
		try {
			level++;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next())
			{
			System.out.println(rs.getString("name"));
		    tree(conn,id,1);
			}
	
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
