/**
* @author Douglas Estanislau Pereira
 * 
 * douglairstan@gmail.com
 * 
 * Execucao da classe CPF
 */

package lib.java;

import javax.swing.JOptionPane;

public class ExecCPF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CPF c1 = new CPF();
		String aux;
		aux = JOptionPane.showInputDialog(null,"Informe o CPF");
		c1.setCPF(aux);
		if (c1.retorno == 1){
			JOptionPane.showMessageDialog(null,"CPF "+c1.valor.subSequence(0, 3)+"."+c1.valor.subSequence(3, 6)+"."+ c1.valor.subSequence(6, 9)+"/"+c1.valor.subSequence(9, 11)+ " está Correto!");
                        System.out.println(""+c1.retorno);
		}
		else{
			JOptionPane.showMessageDialog(null,"CPF "+c1.valor.subSequence(0, 3)+"."+c1.valor.subSequence(3, 6)+"."+ c1.valor.subSequence(6, 9)+"/"+c1.valor.subSequence(9, 11)+ " É INVÁLIDO!!");
		}

	}

}
