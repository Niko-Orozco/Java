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
public class Tratamientos {
    private int Id_Trat;
    private int Id_Uss = 0;
    private String Datos;
    private String Descripcion;
    private String Detalles;
    private Conexion Conn;

    public Tratamientos() {
    }
    
    public Tratamientos(int Id_Trat, String Descripcion, String Detalles) {
        this.Id_Trat = Id_Trat;
        this.Descripcion = Descripcion;
        this.Detalles = Detalles;
    }

    public int getId_Trat() {
        return Id_Trat;
    }

    public int getId_Uss() {
        return Id_Uss;
    }

    public void setId_Uss(int Id_Uss) {
        this.Id_Uss = Id_Uss;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDetalles() {
        return Detalles;
    }

    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }

    public String getDatos() {
        return Datos;
    }
    
    
    public void GetTratamiento()throws SQLException{
        Conn = new Conexion();
        Connection Cons = Conn.GetConection();
        Statement Stmt = Cons.createStatement();
        try
        {
            if(this.Id_Uss == 0)
            {
                ResultSet Rs = Stmt.executeQuery("select * from Treatments");
                while(Rs.next())
                {
                    this.Datos = "Id Tratamiento: " + Rs.getInt(1) + "\n"
                                +"Detalles: "       + Rs.getString(3) + "\n"
                                +"Descripcion: "    + Rs.getString(4);
                }
            }else{
                ResultSet Rs = Stmt.executeQuery("select * from Treatments where Id_Pati = "+this.Id_Uss);
                this.Id_Trat = Rs.getInt(1);
                this.Detalles = Rs.getString(3);
                this.Descripcion = Rs.getString(4);
            }
        }catch(Exception ex){
            System.err.println("Error al insertar los datos" + ex);
        }
    }
    
    public void Agregar_Trat() throws SQLException{
        Conn = new Conexion();
        PreparedStatement Ps_Insert;
        Connection Cons = Conn.GetConection();
        this.Id_Trat = (int) Math.floor(Math.random()*1000+1);
        try
        {
            Ps_Insert = Cons.prepareStatement("");
            Ps_Insert.setInt(1, this.Id_Trat);
            Ps_Insert.setString(2, this.Detalles);
            Ps_Insert.setString(3, this.Descripcion);
            Ps_Insert.executeUpdate();
        }catch(Exception ex){
            System.err.println("Error al insertar los datos" + ex);
        }
        
    }
}
