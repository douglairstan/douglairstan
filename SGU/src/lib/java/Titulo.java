/**
 * 
 * @author CRISTIAN Avencurt
 * 
 * avencurt@yahoo.com.br
 * 
 * valida o T�tulo de Eleitor
 *
 */

package lib.java;


public class Titulo {
	
	protected String valor ="";
	protected int valido = -1;
	
	/**
	 * construtor vazio
	 */
	public Titulo(){
	}
	
	/**
	 * construtor com par�metro
	 * @param x
	 */
	public Titulo (String x){
		if (x.length()==12){
			this.valor = x;
		}
		processa();
	}
	
	/**
	 * seta o T�tulo
	 * @param x
	 */
	public void setValor(String x){
		if (x.length()==12){
			this.valor = x;
		}
		processa();
	}
	
	/**
	 * @return 1 para t�tulo v�lido e -1 para t�tulo suspeito
	 */
	private void processa(){
		int soma=0, dv=0, dv2=0;
		int vetor2[] = { 4, 5, 6, 7, 8, 9};
		
		//calcula o primeiro DV mod 11
		for(int i=0; i<6;i++){
			soma = soma + (vetor2[i]* (this.valor.charAt(i+2)-48 )  );
		}
		
		dv = soma%11;
		if (dv==10){//o d�gito deve ocupar apenas uma posi��o
			dv = 0;
		}

		//	calcula o segundo DV mod 11
		soma = 0;
		soma = ((this.valor.charAt(8)-48)* 7 );
		soma = soma +((this.valor.charAt(9)-48)* 8);
		soma = soma+(dv * 9);
		
		dv2 = soma%11;

		//duas vari�veis usadas para facilitar a leitura do c�digo
		int valida = 0;
		valida = ((this.valor.charAt(8)-48 )* 10)+(this.valor.charAt(9)-48); 

		//testa se o DV mod 11 digitado confere com o DV mod 11 calculado
		if ((valida<1) || (valida>28)){//valida o c�digo da UF
			this.valido = -1;
		}
		else{
			if (((this.valor.charAt(10)-48) != dv) || ( (this.valor.charAt(11)-48)!=dv2  )){//valida os d�gitos verificadores
				this.valido = -1;
			}
			else{
				this.valido =1;
			}
		}
	}
}
