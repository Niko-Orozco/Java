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
public class Citas {
    private int Id_Cita;
    private int Id_Doc;
    private int Id_Date;
    private int Status;
    private Date Dia_Cita;
    private Date Dia_Salida;
    private Conexion Conn;

    public int getId_Cita() {
        return Id_Cita;
    }

    public void setId_Cita(int Id_Cita) {
        this.Id_Cita = Id_Cita;
    }

    public int getId_Doc() {
        return Id_Doc;
    }

    public void setId_Doc(int Id_Doc) {
        this.Id_Doc = Id_Doc;
    }

    public int getId_Date() {
        return Id_Date;
    }

    public void setId_Date(int Id_Date) {
        this.Id_Date = Id_Date;
    }
    
    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Date getDia_Cita() {
        return Dia_Cita;
    }

    public void setDia_Cita(Date Dia_Cita) {
        this.Dia_Cita = Dia_Cita;
    }

    public Date getDia_Salida() {
        return Dia_Salida;
    }

    public void setDia_Salida(Date Dia_Salida) {
        this.Dia_Salida = Dia_Salida;
    }
    
    public void Agregar_Cita() throws SQLException{
        Conn = new Conexion();
        PreparedStatement Ps_Insert;
        Connection Cons = Conn.GetConection();
        this.Id_Cita = (int) Math.floor(Math.random()*1000+1);
        this.Id_Date = this.Id_Cita+1;
        try
        {
            Ps_Insert = Cons.prepareStatement("insert into Appointment values(?,?,?,?)");
            Ps_Insert.setInt(1, this.Id_Cita);
            Ps_Insert.setInt(2, this.Id_Doc);
            Ps_Insert.setInt(3, this.Id_Date);
            Ps_Insert.setInt(4, this.Status);
            Ps_Insert.executeUpdate();
            
            Ps_Insert = Cons.prepareStatement("insert into Dates(Id_Date,Day_of_Entry) values(?,?)");
            Ps_Insert.setInt(1, this.Id_Date);
            Ps_Insert.setDate(2, this.Dia_Cita);
            Ps_Insert.executeUpdate();
            
        }catch(Exception ex){
            System.err.println("Error al insertar los datos" + ex);
        }
    }
    
}
