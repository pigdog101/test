package JDBCTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;




public class Demo01 {

public static void main(String[] args) {
    try {
      	Class.forName("com.mysql.jdbc.Driver");
      	System.out.println("成功加载驱动");
      	  
      String url ="jdbc:mysql://localhost:3306/book?" + "user=root&password=111111";
      Connection conn = DriverManager.getConnection(url);
      	System.out.println("成功连接到数据库");
      Statement st = conn.createStatement();
      	System.out.println("数据发送成功");

      }
      
         catch(Exception e)
      {
   System.out.println("找不到驱动程序");     	   
      }	
}
}