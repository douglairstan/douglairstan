/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.java;

/**
 *
 * @author Douglas Estnaislau Pereira
 */
public class info {
    
    public info(){
        
    }
    
    // CNPJ da Empresa
    private String cnpj = "01611213000112";//EMEF OUROESTE
    //private String cnpj = "11111111111111";//TESTE
    
    
    //Aluno(a)
    private String aluno = "ALUNO(A)";
    private String relatorio_individual = "INDIVIDUAL";
    
    private double Tela = 0.8;


    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the aluno
     */
    public String getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the relatorio_individual
     */
    public String getRelatorio_individual() {
        return relatorio_individual;
    }

    /**
     * @param relatorio_individual the relatorio_individual to set
     */
    public void setRelatorio_individual(String relatorio_individual) {
        this.relatorio_individual = relatorio_individual;
    }

    /**
     * @return the Tela
     */
    public double getTela() {
        return Tela;
    }

    /**
     * @param Tela the Tela to set
     */
    public void setTela(double Tela) {
        this.Tela = Tela;
    }

}
