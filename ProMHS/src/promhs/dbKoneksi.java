package promhs;

/**
 *
 * @author Anjeli Oktalia_20103298
 */

import java.sql.DriverManager;
import java.sql.Connection;

public class dbKoneksi {
    String DB_URL = "jdbc:mysql://localhost/dbmhs";
    String USER = "root";
    String PASS = "";
    
    private static Connection koneksi;
    
    public Connection koneksi(){
        if(this.koneksi == null){
            try{
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                this.koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            }catch(Exception e){
                System.out.println("Error saat membuat koneksi ke DBMS");
            }
        }
        return this.koneksi;
    }
}
