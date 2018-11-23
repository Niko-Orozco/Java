/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms_ortodont;

import Model.Administrador;
import Model.Pacientes;
import java.sql.*;

/**
 *
 * @author niko
 */
public class Ms_Ortodont {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Pacientes Pati = new Pacientes(33333, "Niko", "", "Orozco", "", 30585250, 1,"pasword");
        Pati.Ingresar_Paciente();
    }
    
}
