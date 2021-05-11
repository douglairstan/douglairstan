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

public class CNPJ {

	protected int retorno = -1;
	protected String valor;

	/**
	 * construtor vazio
	 */
	public CNPJ() {
		this.valor = "";
		this.retorno = -1;
	}

	/**
	 * construtor com par�metro
	 * 
	 * @param x
	 */
	public CNPJ(String x) {
		this.valor = x;
		getCNPJ();
	}

	/**
	 * seta o CNPJ
	 * 
	 * @param x
	 */
	public void setCNPJ(String x) {
		this.valor = x;
		getCNPJ();
	}

	/**
	 * retorna 1 para CNPJ v�lido e -1 para inv�lido
	 * 
	 * @return this.retorno
	 */
	public int getCNPJ() {

		if (this.valor.length() != 14) {
			this.retorno = -1;
			return this.retorno;
		}

		int soma = 0, dv = 0, dv2 = 0;
		int vetor2[] = { 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int i = 0; i < 12; i++) {
			soma = soma + (vetor2[i + 1] * (this.valor.charAt(i) - 48));
		}
		dv = soma % 11;
		soma = 0;

		for (int i = 0; i < 12; i++) {
			soma = soma + (vetor2[i] * (this.valor.charAt(i) - 48));
		}
		soma = soma + (dv * vetor2[12]);
		dv2 = soma % 11;

		if ((dv2 == Integer.parseInt(this.valor.substring(13, 14)))
				&& (dv == Integer.parseInt(this.valor.substring(12, 13)))) {
			this.retorno = 1;
		} else {
			this.retorno = -1;
		}

		return this.retorno;
	}

}
