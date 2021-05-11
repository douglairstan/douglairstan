/**
 * 
 * @author Cristian Avencurt
 * avencurt@yahoo.com.br
 *
 */
package lib.java;

import javax.swing.*;
public class ExecCNPJ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CNPJ c1 = new CNPJ();
		
		String aux;
		aux = JOptionPane.showInputDialog(null,"Informe o CPF");
		
		c1.setCNPJ(aux);
		
		if (c1.retorno==1){
			JOptionPane.showMessageDialog(null,"CNPJ "+c1.valor.subSequence(0,2)+"."+c1.valor.subSequence(2, 5)+"."+ c1.valor.subSequence(5, 8)+"/"+c1.valor.subSequence(8, 12)+"-" +c1.valor.subSequence(12, 14)+" est� Correto!");
		}
		else{
			JOptionPane.showMessageDialog(null,"CNPJ "+c1.valor.subSequence(0,2)+"."+c1.valor.subSequence(2, 5)+"."+ c1.valor.subSequence(5, 8)+"/"+c1.valor.subSequence(8, 12)+"-" +c1.valor.subSequence(12, 14)+" � INV�LIDO!");
		}

	}

}
