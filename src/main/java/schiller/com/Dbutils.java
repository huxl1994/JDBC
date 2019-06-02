package schiller.com;

import java.sql.*;

public class Dbutils {
  private String driver = "com.mysql.cj.jdbc.Driver";
  private String user = "root";
  private String password = "0000";
  private String url =
      "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";

  private static Connection conn = null;

  // 获取数据库连接
  public Connection getConnection() {
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(this.url, this.user, this.password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  // 查询某条记录
  public void selectById(String table, int id) {
    try {
      PreparedStatement pst =
          conn.prepareStatement(String.format("select * from %s where id = %d", table, id));
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        String name = rs.getString(1);
        int idd = rs.getInt(2);
        String sex = rs.getString(3);
        System.out.println(idd + " " + name + " " + sex);
      }
      rs.close();
      pst.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 查询全部记录
  public void selectAll(String table) {
    try {
      PreparedStatement pst = conn.prepareStatement(String.format("select * from %s", table));
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        String name = rs.getString(1);
        int idd = rs.getInt(2);
        String sex = rs.getString(3);
        System.out.println(idd + " " + name + " " + sex);
      }
      rs.close();
      pst.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 插入一条记录
  public void insert(String table, String name, String sex) {
    try {
      PreparedStatement pst =
          conn.prepareStatement(
              String.format("insert into %s (name,sex) values ('%s', '%s')", table, name, sex));
      int num = pst.executeUpdate();
      if (num > 0) {
        System.out.println("成功添加一条记录");
      } else {
        System.out.println("错误");
      }
      pst.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 删除一条记录
  public void deleleById(String table, int id) {
    try {
      PreparedStatement pst =
          conn.prepareStatement(String.format("delete from %s where id = %d", table, id));
      int num = pst.executeUpdate();
      if (num > 0) {
        System.out.println("成功删除一条记录");
      } else {
        System.out.println("错误");
      }
      pst.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 更新某条记录
  public void update(String table, String name, int id, String sex) {
    try {
      PreparedStatement pst =
          conn.prepareStatement(
              String.format("update %s set name='%s',sex='%s' where id=%d", table, name, sex, id));
      int num = pst.executeUpdate();
      if (num > 0) {
        System.out.println("成功更新一条记录");
      } else {
        System.out.println("错误");
      }
      pst.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
