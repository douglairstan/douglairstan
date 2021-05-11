/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Douglas Estanislau Pereira
 */
public class ConexaoRelatorio {
    
    public ConexaoRelatorio(){
        
    }
    
    public static Connection getControlaConexao() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://35.199.71.32/sgu", "postgres", "MyIhz06rA1OBPthL");
    }
    
}
