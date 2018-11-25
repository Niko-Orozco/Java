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
public class Pacientes {
    private int Id_Uss;   
    private int Status;
    private int Cellphone;
    private double Cellphones;
    private String Name;
    private String Name2;
    private String Last_Name;
    private String Last_Name2;
    private String Pass;
    private Conexion Conn;
    private Administrador Admin;

    public Pacientes(int Id_Uss, String Name, String Name2, String Last_Name, String Last_Name2, double Cellphone, int Status, String Pass) {
        this.Id_Uss = Id_Uss;
        this.Name = Name;
        this.Name2 = Name2;
        this.Last_Name = Last_Name;
        this.Last_Name2 = Last_Name2;
        this.Cellphones = Cellphone;
        this.Status = Status;
        this.Pass = Pass;
    }
    

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public int getId_Uss() {
        return Id_Uss;
    }

    public void setId_Uss(int Id_Uss) {
        this.Id_Uss = Id_Uss;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String Name2) {
        this.Name2 = Name2;
    }

    public String getLast_Name2() {
        return Last_Name2;
    }

    public void setLast_Name2(String Last_Name2) {
        this.Last_Name2 = Last_Name2;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public double getCellphone() {
        return Cellphones;
    }

    public void setCellphone(double Cellphone) {
        this.Cellphones = Cellphone;
    }
    
    public void Ingresar_Paciente() throws SQLException{
        Conn = new Conexion();
        PreparedStatement Ps_Insert;
        Connection Cons = Conn.GetConection();
        this.Cellphone = (int) this.Cellphones;
        try
        {
            //  Hacemos la incercion de los datoos en la base de datos....
            Ps_Insert = Cons.prepareStatement("insert into Patient "+" values(?,?,?,?,?,?,?)");
            Ps_Insert.setInt(1, this.Id_Uss);
            Ps_Insert.setString(2, this.Name);
            Ps_Insert.setString(3, this.Name2);
            Ps_Insert.setString(4, this.Last_Name);
            Ps_Insert.setString(5, this.Last_Name2);
            Ps_Insert.setInt(6, this.Cellphone);
            Ps_Insert.setInt(7, this.Status);
            Ps_Insert.executeUpdate();
            
            Admin = new Administrador(this.Id_Uss, this.Pass);
            Admin.Agregar_Admin();
            
        }catch(Exception ex)
        {
            System.err.println("Error al insertar los datos" + ex);
        }
        Cons.close();
        Conn.Closer();
    }
}
