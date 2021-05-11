/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.java;

import java.sql.Date;

/**
 *
 * @author DIOGO
 */
public class Formatar {
    
    public Formatar(){
        
    }
    
    public Date Data_Postgres(String _data){
        Mensagem mensagem = new Mensagem();
        Date dataFormatada = Date.valueOf("1982-12-21");
        
        String dataValidada;
        
        
        Validar validar = new Validar();
        if(validar.Data(_data)){
            String dia, mes, ano;
            dia = _data.substring(0,2);
            mes = _data.substring(3,5);
            ano = _data.substring(6,10);
            
            dataValidada = ano+"-"+mes+"-"+dia;
            dataFormatada = Date.valueOf(dataValidada);
            
            
        }else{
           mensagem.Livre("Informe a data corretamente."); 
        }
        
        return dataFormatada;
        
    }
    
    public String Data_Internacional(Date _data){
        //Mensagem mensagem = new Mensagem();
        String dataFormatada = String.valueOf(_data);
        String dataFormatoInternacional;
        //mensagem.Livre(dataFormatada);
        
        String dia, mes, ano;
            ano = dataFormatada.substring(0,4);
            mes = dataFormatada.substring(5,7);
            dia = dataFormatada.substring(8,10);
            
            dataFormatoInternacional = ano+"-"+mes+"-"+dia;
            //mensagem.Livre(dataFormatoBrasil);
                            
        return dataFormatoInternacional;
        
    }
    
    public String Data_Brasil(Date _data){
        //Mensagem mensagem = new Mensagem();
        String dataFormatada = String.valueOf(_data);
        String dataFormatoBrasil;
        //mensagem.Livre(dataFormatada);
        
        String dia, mes, ano;
            ano = dataFormatada.substring(0,4);
            mes = dataFormatada.substring(5,7);
            dia = dataFormatada.substring(8,10);
            
            dataFormatoBrasil = dia+"/"+mes+"/"+ano;
            //mensagem.Livre(dataFormatoBrasil);
                            
        return dataFormatoBrasil;
        
    }
    

}
