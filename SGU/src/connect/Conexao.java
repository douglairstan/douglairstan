/*
 * To change this template, choose Tools | Templates
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
public class Conexao {
    
    public Conexao(){
        
    }
    
    public static Connection con = null;
    
    public static  Connection ConectDB() throws SQLException{
        try{    
                String dsn="sgu";
		String user="postgres";
		String password="MyIhz06rA1OBPthL";
                //String local = "192.168.1.20";
                String local = "35.199.71.32";
                String porta = "5432";
                //InetAddress address = InetAddress.getByName("emefsecretaria1");
                //String local = "" + address.getCanonicalHostName();
                //System.out.println("" + address.getCanonicalHostName());
                //System.out.println("" + address.getHostAddress());
		Class.forName("org.postgresql.Driver").getInterfaces();
                String url="jdbc:postgresql://"+local+":"+porta+"/"+dsn;
                System.out.println(url);
                con = DriverManager.getConnection(url,user,password);
                System.out.println("-- Base de Dados Aberta -- ");
                return con;
        }catch (ClassNotFoundException | SQLException ex){
                //JOptionPane.showMessageDialog(null,"Problema na Abertura da Base de Dados. ","Informação de Conexão: ",JOptionPane.INFORMATION_MESSAGE);
		System.out.println("-- Problema na Abertura da Base de Dados -- "+ex.getMessage());
                //System.out.println("-- Problema na Abertura da Base de Dados -- "+zen.getCause());
                return null;
	}
        //finally{
            //con.close();
        //}
    }
    
    public static void CloseDB() throws SQLException{
        try {
            con.close();
            //
            System.out.println("-- Base de Dados Fechada -- ");
            }
	catch (SQLException zen) {
            //JOptionPane.showMessageDialog(null,"Problemas no Fechamento da Base de Dados. ","Informação de Conexão: ",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("-- Problemas no Fechamento da Base de Dados -- " + zen.getMessage());
            //System.out.println("-- Problemas no Fechamento da Base de Dados -- " + zen.getCause());
            }
        finally{
            con.close();
        }
	}
        
}

