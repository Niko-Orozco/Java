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
public class Administrador {
    private int Id_Admin;
    private String Passwd;
    private Conexion Conn;
    private int Valido;

    public Administrador(int Id_Admin, String Passwd) {
        this.Id_Admin = Id_Admin;
        this.Passwd = Passwd;
    }

    public int getId_Admin() {
        return Id_Admin;
    }

    public void setId_Admin(int Id_Admin) {
        this.Id_Admin = Id_Admin;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }
    
    public void Agregar_Admin() throws SQLException{
        Conn = new Conexion();
        Connection Cons = Conn.GetConection();
        PreparedStatement Ps_Insert;
        try
        {
            Ps_Insert = Cons.prepareStatement("insert into Admins "+" values(?,?)");
            Ps_Insert.setInt(1, this.Id_Admin);
            Ps_Insert.setString(2, this.Passwd);
            Ps_Insert.executeUpdate();  
        }catch(Exception ex){
            System.err.println("Error al insertar los datos" + ex);
        }
        Cons.close();
        Conn.Closer();
    }
    
    public void Validar_Admin() throws SQLException{
        Conn = new Conexion();
        Connection Cons = Conn.GetConection();
        Statement Stmt = Cons.createStatement();
        ResultSet Rs = Stmt.executeQuery("SELECT * FROM Admins");
        while(Rs.next())
        {
            int Id = Integer.parseInt(Rs.getString("Id_Admin"));
            String Pass = Rs.getString("Passwd");
            if(Id == this.Id_Admin && Passwd.equals(Pass))
            {
                Valido = 1;
                System.out.println("Hiiii");
            }else{ 
                    Valido = 0; 
                 }
        }
        Rs.close();
        Stmt.close();
        Cons.close();
        Conn.Closer();      
    }

    public int getValido() {
        return Valido;
    }

    public void setValido(int Valido) {
        this.Valido = Valido;
    }
    
}
