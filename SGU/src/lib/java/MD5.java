/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.java;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas Estansilau Pereira
 */
public class MD5 {
    
    public static String md5(String senha){  
        String sen = "";  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        sen = hash.toString(16);              
        return sen;   
    }
    
    
    public void Senha(){
        String senha = JOptionPane.showInputDialog("Digite uma senha:");  
        String saida = "Entrada: " + senha + "\nSenha com MD5: " + md5(senha);  
        JOptionPane.showConfirmDialog(null,saida, "Resultado", JOptionPane.CLOSED_OPTION);
    }
    
    public String hash(String senha){
        return senha = md5(senha);
        
    }
    
}
