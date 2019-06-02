package schiller.com;

import java.sql.Connection;

public class TestJDBC {
  public static void main(String[] args) {

    Dbutils db = new Dbutils();
    Connection conn = db.getConnection();

    System.out.println(conn);

    db.deleleById("mydb",2);


  }
}
