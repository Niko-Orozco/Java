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
public class Cargos {
    private int Id_Cargo;
    private int Id_Especialidad;
    private String Cargo;
    private String Specialty;
    private Conexion Conn;

    public Cargos(int Id_Cargo, int Id_Especialidad, String Cargo, String Specialty) {
        this.Id_Cargo = Id_Cargo;
        this.Id_Especialidad = Id_Especialidad;
        this.Cargo = Cargo;
        this.Specialty = Specialty;
    }

    public int getId_Cargo() {
        return Id_Cargo;
    }

    public void setId_Cargo(int Id_Cargo) {
        this.Id_Cargo = Id_Cargo;
    }

    public int getId_Especialidad() {
        return Id_Especialidad;
    }

    public void setId_Especialidad(int Id_Especialidad) {
        this.Id_Especialidad = Id_Especialidad;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    public void GetCargos()throws SQLException{
        Conn = new Conexion();
        Connection Cons = Conn.GetConection();
        Statement Stmt = Cons.createStatement();
    }
    
    public void Agregar_Cargo() throws SQLException{
        Conn = new Conexion();
        PreparedStatement Ps_Insert;
        Connection Cons = Conn.GetConection(); 
        try
        {
            Ps_Insert = Cons.prepareStatement("insert into Charges values(?,?,?)");
            Ps_Insert.setInt(1, this.Id_Cargo);
            Ps_Insert.setInt(2, this.Id_Especialidad);
            Ps_Insert.setString(3, this.Cargo);
            Ps_Insert.executeUpdate();
            
            Ps_Insert = Cons.prepareStatement("insert into Specialties values(?,?)");
            Ps_Insert.setInt(1, this.Id_Especialidad);
            Ps_Insert.setString(2, this.Specialty);
            Ps_Insert.executeUpdate();
            
        }catch(Exception ex){
            System.err.println("Error al insertar los datos" + ex);
        }
        Cons.close();
        Conn.Closer();
    }
    
    
}
