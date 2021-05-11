/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.java;

import javax.swing.JOptionPane;

/**
 *
 * @author DIOGO
 */
public class Mensagem {
    
    public Mensagem(){
        
    }
    
    public void OK(){
        JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso.");
    }
    
    public void Erro(String complemento){
        JOptionPane.showMessageDialog(null, "Operação não efetuada. "+complemento);
    }
    
    public void Livre(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

}
