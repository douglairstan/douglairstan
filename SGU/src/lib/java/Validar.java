/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.java;

import java.sql.Date;

/**
 *
 * @author DIOGO
 * 19-04-2008
 */
public class Validar {

    public Validar(){
        
    }
    
    Mensagem mensagem = new Mensagem();
    
    public boolean Data(String _data){
        
        Date data;
        
        boolean testeTamanho = false;
        boolean testeConteudo = false;
        boolean testeMes = false;
        boolean testeDia = false;
        boolean testeAnoBissexto = false;
        boolean dataOk = false;
        
        
        String dia, mes, ano, barra1, barra2;
        int janeiro, fevereiro, marco, abril, maio, junho, julho, agosto, setembro,
                outubro, novembro, dezembro, diaInt, mesInt, anoInt;
        
        janeiro = 31;
        fevereiro = 28;
        marco = 31;
        abril = 30;
        maio = 31;
        junho = 30;
        julho = 31;
        agosto = 31;
        setembro = 30;
        outubro = 31;
        novembro = 30;
        dezembro = 31;
        
        diaInt = 100;
        mesInt = 100;
        anoInt = 0;
        
        int tamanho = _data.length();
        
        dia = _data.substring(0,2);
        mes = _data.substring(3,5);
        ano = _data.substring(6,10);
       // barra1 = _data.substring(2,2);
       // barra2 = _data.substring(5,5);
        
       /* 
        mensagem.Livre(mes);
        mensagem.Livre(ano);*/
       // mensagem.Livre(barra1);
       // mensagem.Livre(barra2);
        
        if(tamanho == 10){
            //mensagem.Livre(String.valueOf(tamanho));
            testeTamanho = true;
            //if(barra1 == "/"){
                //if(barra2 == "/"){
                    if(this.Inteiro(dia)){
                        //mensagem.Livre(String.valueOf(diaInt));
                        if(this.Inteiro(mes)){
                            if(this.Inteiro(ano)){
                                
                                diaInt = Integer.parseInt(dia);
                                mesInt = Integer.parseInt(mes);
                                anoInt = Integer.parseInt(ano);
                                if(mesInt < 13){
                                    testeMes = true;
                                    
                                    if((anoInt % 4) == 0){
                                        testeAnoBissexto = true;
                                      
                                    }
                                }
                                
                            }
                        }
                    }
            testeConteudo = true;
        }
        
        
       if((mesInt == 1)&&(diaInt <= janeiro)){
           
           dataOk = true;
       }else{
            //mensagem.Livre("if janeiro");
            if((mesInt == 2)&&(diaInt<=fevereiro)){
                dataOk = true;
            }else{                
                if((mesInt == 2) && (diaInt <= 29) && (testeAnoBissexto)){
                  dataOk = true;  
                }else{
                    if ((mesInt == 3) && (diaInt <= marco)){
                        dataOk = true;
                    }else{
                        if((mesInt == 4) && (diaInt <= abril)){
                            dataOk = true;
                        }else{
                            if((mesInt == 5) && (diaInt <= maio)){
                                dataOk = true;
                            }else{
                                if((mesInt == 6) && (diaInt <= junho)){
                                    dataOk = true;
                                }else{
                                   if((mesInt ==7) && (diaInt <= julho)){
                                       dataOk = true;
                                   }else{
                                       if((mesInt == 8) && (diaInt <= agosto)){
                                           dataOk = true;
                                       }else{
                                           if((mesInt == 9) && (diaInt <= setembro)){
                                               dataOk = true;
                                           }else{
                                               if((mesInt == 10) && (diaInt <= outubro)){
                                                   dataOk = true;
                                               }else{
                                                   if((mesInt == 11) && (diaInt <= novembro)){
                                                       dataOk = true;
                                                   }else{
                                                       if((mesInt == 12) && (diaInt <= dezembro)){
                                                           dataOk = true;
                                                       }
                                                   }
                                               }
                                           }
                                       }
                                   }  
                                }
                            }
                        }
                    }
                }
            }
       }
          return dataOk;       
        /*
        try{
            
            data = Date.valueOf(_data);
            return dataOk;
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
            return false;
            
        }*/
    }
    
    public boolean Inteiro(String _inteiro){
        
        int inteiro;
        try{
            
            inteiro = Integer.parseInt(_inteiro);
            return true;
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
            return false;
            
        }
    }
    
    public boolean Float_(String _float_){
        
        Float _float;
        try{
            
            _float = Float.parseFloat(_float_);
            return true;
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
            return false;
            
        }
    }
    
    public boolean Double_(String _double_){
        
        Double _double;
        
        try{
            
            _double = Double.parseDouble(_double_);
            return true;
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
            return false;
            
        }
    }
    
}
