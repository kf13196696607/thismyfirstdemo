package com.kongfa.et;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.sql.*;

public class JdbcUtil {

        /**
         * Statement 和 PreparedStatement之间的关系和区别.
         * 关系：PreparedStatement继承自Statement,都是接口
         * 区别：PreparedStatement可以使用占位符，是预编译的，批处理比Statement效率高
         */
        public static void conn(String sql) {
            String URL = "jdbc:mysql://localhost:3306/kf?characterEncoding=utf-8&serverTimezone=GMT";
            String USER = "root";
            String PASSWORD = "";
            // 1.加载驱动程序
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 2.获得数据库链接
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
               // String name = "9991";
                //预编译
                //String sql="select * from student where name=?";
                PreparedStatement statement = conn.prepareStatement(sql);
               // statement.setString(1, name);
                ResultSet rs = statement.executeQuery();
//			String sql="select * from userinfo where UserName='"+name+"'";
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
                // 4.处理数据库的返回结果(使用ResultSet类)
                while (rs.next()) {
                    System.out.println(rs.getString("id") + " " + rs.getString("name"));
                }

                // 关闭资源【多谢指正】
                rs.close();
                statement.close();
                conn.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public static void main(String[] args) {
            String name="9991";
        conn("select * from student where name="+name+"");
    }

    }

