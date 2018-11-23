/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;

/**
 *
 * @author niko
 */
public class Conexion {
    private Connection Cnt =  null;
    private String Url = "jdbc:mysql://localhost/MS_Ortodont";
    private String Pass = "Niko_orozco99";
    
    public Conexion() throws SQLException
    {
        if(Cnt == null)
        {
            try
            {
               Class.forName("com.mysql.jdbc.Driver");
               Cnt = DriverManager.getConnection(Url, "root", Pass);
            }
            catch (ClassNotFoundException ex) 
            {
               System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
        }
    }
    
    public Connection GetConection()
    {
        return Cnt;
    }
    
    public void Closer() throws SQLException
    {
        if(Cnt != null)
        {
            Cnt.close();
        }
    }
    
}
