package schiller.com;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {
  public static void main(String[] args) {

    Dbutils db = new Dbutils();
    Connection conn = db.getConnection();

    System.out.println(conn);

    db.deleleById("mydb",2);

    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
