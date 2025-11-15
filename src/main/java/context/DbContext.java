package context;
import java.sql.*;

public class DbContext {
    
    private final String serverName = "localhost";
    private final String dbName = "ShopDB";  //thay đổi tên CSDL cho dự án của bạn
    private final String portNumber = "1433";  
    private final String userID = "sa";
    private final String password = "sa"; //thay đổi mật khẩu phù hợp (nếu cần)
    
    public Connection getConnection()
    {
        Connection conn=null;
        try{ 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //b2. dinh nghia chuoi ket noi URL
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            //b3.Thiet lap ket noi
            conn = DriverManager.getConnection(url,userID,password);       
        }catch(Exception ex){
            System.out.println("Error:" + ex.toString());
        }
        return conn;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Ket Qua ket noi:" + new DbContext().getConnection());
    }
}
