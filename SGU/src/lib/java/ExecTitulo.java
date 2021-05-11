/**
* @author Cristian Avencurt
 * 
 *  avencurt@yahoo.com.br
 * 
 * Execu��o da classe Titulo
 */

package lib.java;

import javax.swing.JOptionPane;

public class ExecTitulo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Titulo t1 = new Titulo();
		
		String aux;
		
		aux =  JOptionPane.showInputDialog(null,"Informe a altura");
		String mostra = aux.subSequence(0,8)+"/"+aux.subSequence(8, 10)+"-"+aux.subSequence(11, 12);
		
		t1.valor = aux;
		
		if(t1.valido==1){
			JOptionPane.showMessageDialog(null,mostra+ "� um T�tulo V�lido!");
		}
		else{
			JOptionPane.showMessageDialog(null, mostra+"� um T�tulo INV�LIDO!");
		}

	}

}
