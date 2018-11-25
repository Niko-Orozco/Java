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
public class Empleados {
    private int Id_Employee;
    private int Cellphone;
    private int Id_Charge;
    private int Id_Specialty;
    private double Cellphones;
    private String Name;
    private String Name2;
    private String Last_Name;
    private String Last_Name2;
    private String Specialty;
    private String Charge;
    private String Pass;  
    private Date Birthday;  
    private Cargos Cargo;
    private Conexion Conn;
    private Administrador Admin;

    public Empleados(int Id_Employee, String Name, String Name2, String Last_Name, String Last_Name2, double Cellphone, Date Birthday, String Charge, String Specialty, String Pass) {
        this.Id_Employee = Id_Employee;
        this.Name = Name;
        this.Name2 = Name2;
        this.Last_Name = Last_Name;
        this.Last_Name2 = Last_Name2;
        this.Cellphones = Cellphone;
        this.Birthday = Birthday;
        this.Charge = Charge;
        this.Pass = Pass;
        this.Specialty = Specialty;
    }


    public int getId_Employee() {
        return Id_Employee;
    }

    public void setId_Employee(int Id_Employee) {
        this.Id_Employee = Id_Employee;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String Name2) {
        this.Name2 = Name2;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getLast_Name2() {
        return Last_Name2;
    }

    public void setLast_Name2(String Last_Name2) {
        this.Last_Name2 = Last_Name2;
    }

    public double getCellphone() {
        return Cellphones;
    }

    public void setCellphone(double Cellphone) {
        this.Cellphones = Cellphone;
    }

    public String getCharge() {
        return Charge;
    }

    public void setCharge(String Charge) {
        this.Charge = Charge;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    public void GetEmpleado()throws SQLException{
        
    }
    
    public void Ingresar_Empleado() throws SQLException{
        Conn = new Conexion();
        PreparedStatement Ps_Insert;
        Connection Cons = Conn.GetConection(); 
        this.Id_Charge = (int) Math.floor(Math.random()*1000+1);
        this.Id_Specialty = this.Id_Charge + 2;
        this.Cellphone = (int) this.Cellphones;
        try
        {
            //  Hacemos la incercion de los datoos en la base de datos....
            Ps_Insert = Cons.prepareStatement("insert into Employee "+" values(?,?,?,?,?,?,?,?)");
            Ps_Insert.setInt(1, this.Id_Employee);
            Ps_Insert.setString(2, this.Name);
            Ps_Insert.setString(3, this.Name2);
            Ps_Insert.setString(4, this.Last_Name);
            Ps_Insert.setString(5, this.Last_Name2);
            Ps_Insert.setInt(6, this.Cellphone);
            Ps_Insert.setDate(7, this.Birthday);
            Ps_Insert.setInt(8, this.Id_Charge);
            Ps_Insert.executeUpdate();
            
            Admin = new Administrador(this.Id_Employee, this.Pass);
            Admin.Agregar_Admin();
            
            Cargo = new Cargos(this.Id_Charge, this.Id_Specialty, this.Charge, this.Specialty);
            Cargo.Agregar_Cargo();
            
        }catch(Exception ex){
            System.err.println("Error al insertar los datos" + ex);
        }
        Cons.close();
        Conn.Closer();
    }
    
}
