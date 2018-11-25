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
        Pacientes Pati = new Pacientes(1088037738, "Nicolas", "Andrey", "Orozco", "Giraldo", 305852516, 1,"Napsster");
        Pati.Ingresar_Paciente();
    }
    
}
