/**
 * @author Douglas Estanislau Pereira
 * 
 * 
 * Validar de CNPJ
 * 
 * retorna 1 para CNPJ valido
 * 
 * 
 */
package lib.java;

public class CPF {

	protected int retorno = -1;
	protected String valor;

	public CPF() {
		this.valor = "";
		this.retorno = -1;
	}

	public CPF(String x) {
		this.valor = x;
		getCPF();
	}

	public void setCPF(String x) {
		this.valor = x;
		getCPF();
	}

        
	public int getCPF() {

		if (this.valor.length() != 11) {
			this.retorno = -1;
			return this.retorno;
		}

		int soma = 0, dv = 0, dv2 = 0;
		int vetor[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// calcula o primeiro DV mod 11
		for (int i = 1; i < 10; i++) {
			soma = soma + (vetor[i] * (this.valor.charAt(i - 1) - 48));
		}
		dv = soma % 11;
		soma = 0;

		// calcula o segundo DV mod 11
		for (int i = 0; i < 10; i++) {
			soma = soma + (vetor[i] * (this.valor.charAt(i) - 48));
		}
		dv2 = soma % 11;

		// testa se o DV mod 11 digitado confere com o DV mod 11 calculado
		// faz parse para comparar int com String
		if ((dv2 == Integer.parseInt(this.valor.substring(10, 11)))
				&& (dv == Integer.parseInt(this.valor.substring(9, 10)))) {
			this.retorno = 1;

		} else {
			this.retorno = -1;
		}

		return this.retorno;
	}
        
}
