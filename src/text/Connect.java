package text;
import java.sql.*;

 

public class Connect {

 public static void main(String [] args)

 {

  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=bank";

  String userName="wanghaijin";

  String userPwd="6917";

  try

  {

   Class.forName(driverName);

   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);

    System.out.println("�������ݿ�ɹ�");

  }

  catch(Exception e)

  {

   e.printStackTrace();

   System.out.print("����ʧ��");

  }    

 }

}
