/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base.dao;

import connect.Conexao;
import java.sql.Statement;
import base.dto.BaseDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import lib.java.info;

/**
 *
 * @author Douglas Estanislau Pereira
 */
public class BaseDAO {
    
    
    ResultSet rs;
    info info = new info();
    
    
    public BaseDAO(){
        
    }
    
    // Autor
    
    public boolean InserirAutor(BaseDTO inserirAutor){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into autor values (nextval('sid_autor'),(select current_date), (select current_time), true,'"+inserirAutor.getAutor()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"',''INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            Conexao.CloseDB();
            return true;
	}
	catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            return false;
	}
    }
    
    public boolean RemoverAutorAcervo(BaseDTO removerAutorAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_autor set acervo_autor_status = false where acervo_autor_id = "+removerAutorAcervo.getId()+" and acervo_isbn = '"+removerAutorAcervo.getIsbn()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarAutor(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select autor_id, autor_nome from autor where autor_status = true and autor_nome like ('%"+consultar.getAutor()+"%') order by autor_nome;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarAutorAcervo(BaseDTO consultarAutorAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_autor_id, autor_nome from acervo_autor where acervo_isbn = '"+consultarAutorAcervo.getIsbn()+"' and acervo_autor_status = true order by acervo_autor_id";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirAutorAcervo(BaseDTO inserirAutorAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_autor values (nextval('sid_acervo_autor'),(select current_date), (select current_time), true,'"+inserirAutorAcervo.getIsbn()+"','"+inserirAutorAcervo.getAutor()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Editora
    
    public boolean InserirEditora(BaseDTO inserirEditora){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_editora values (nextval('sid_acervo_editora'),(select current_date), (select current_time), true,'"+inserirEditora.getEditora()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarEditora(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_editora_id, acervo_editora_nome from acervo_editora where acervo_editora_status = true and acervo_editora_nome like ('%"+consultar.getEditora()+"%') order by acervo_editora_nome;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Tipo Acervo
    
    public boolean InserirTipoAcervo(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_tipo values (nextval('sid_acervo_tipo'),(select current_date), (select current_time),true,'"+inserir.getTipo()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarTipoAcervo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(acervo_tipo_nome) from acervo_tipo where acervo_tipo_status = true order by acervo_tipo_nome;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
   
    // Classificação Literaria
    
    public boolean InserirClassLiteraria(BaseDTO inserirClassLiteraria){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into classificacao_literaria values (nextval('sid_classificacao_literaria'),(select current_date), (select current_time), true,'"+inserirClassLiteraria.getClassliter()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
        
    public ResultSet ConsultarClassLiteraria(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(classificacao_literaria_nome) from classificacao_literaria where classificacao_literaria_status = true order by classificacao_literaria_nome;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirClassLiterariaAcervo(BaseDTO inserirClassLiterariaAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_class_liter values (nextval('sid_acervo_class_liter'),(select current_date), (select current_time), true,'"+inserirClassLiterariaAcervo.getIsbn()+"','"+inserirClassLiterariaAcervo.getClassliter()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarClassLiterAcervo(BaseDTO consultarClassLiterAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_class_liter_id, classificacao_literaria_nome from acervo_class_liter where acervo_isbn = '"+consultarClassLiterAcervo.getIsbn()+"' and acervo_class_liter_status = true order by acervo_class_liter_id";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean RemoverClassLiterAcervo(BaseDTO removerClassLiterAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_class_liter set acervo_class_liter_status = false where acervo_class_liter_id = "+removerClassLiterAcervo.getId()+" and acervo_isbn = '"+removerClassLiterAcervo.getIsbn()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Coleção
   
    public boolean InserirColecao(BaseDTO inserirColecao){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_colecao values (nextval('sid_acervo_colecao'),(select current_date), (select current_time), true,'"+inserirColecao.getColecao()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarColecao(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_colecao_id, acervo_colecao_nome from acervo_colecao where acervo_colecao_status = true and acervo_colecao_nome like('%"+consultar.getColecao()+"%') order by acervo_colecao_nome;";
            //select distinct(acervo_colecao_nome) from acervo_colecao where acervo_colecao_status = true order by acervo_colecao_nome;
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
     
    // Tag
    
    public boolean InserirTag(BaseDTO inserirTag){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'"+inserirTag.getTag()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean RemoverTagAcervo(BaseDTO removerTagAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_tag set acervo_tag_status = false where acervo_tag_id = "+removerTagAcervo.getId()+" and acervo_isbn = '"+removerTagAcervo.getIsbn()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarTag(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select tag_id, tag_nome from tag where tag_status = true and tag_nome like ('%"+consultar.getTag()+"%') order by tag_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarTagAcervo(BaseDTO consultarTagAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_tag_id, tag_nome from acervo_tag where acervo_isbn = '"+consultarTagAcervo.getIsbn()+"' and acervo_tag_status = true order by acervo_tag_id";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    } 
    
    public boolean InserirTagAcervo(BaseDTO inserirTagAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_tag values (nextval('sid_acervo_tag'),(select current_date), (select current_time), true,'"+inserirTagAcervo.getIsbn()+"','"+inserirTagAcervo.getTag()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Gênero
    
    public boolean InserirGenero(BaseDTO inserirGenero){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into genero values (nextval('sid_genero'),(select current_date), (select current_time), true,'"+inserirGenero.getGereno()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean RemoverGeneroAcervo(BaseDTO removerGeneroAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_genero set acervo_genero_status = false where acervo_genero_id = "+removerGeneroAcervo.getId()+" and acervo_isbn = '"+removerGeneroAcervo.getIsbn()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }  
    
    public ResultSet ConsultarGenero(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(genero_nome) from genero where genero_status = true order by genero_nome;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarGeneroAcervo(BaseDTO consultarGeneroAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_genero_id, genero_nome from acervo_genero where acervo_isbn = '"+consultarGeneroAcervo.getIsbn()+"' and acervo_genero_status = true order by acervo_genero_id";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }  
    
    public boolean InserirGeneroAcervo(BaseDTO inserirGeneroAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_genero values (nextval('sid_acervo_genero'),(select current_date), (select current_time), true,'"+inserirGeneroAcervo.getIsbn()+"','"+inserirGeneroAcervo.getGereno()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
  
     // Edição

    public boolean RemoverEdicaoAcervo(BaseDTO removerEdicaoAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_edicao set acervo_edicao_status = false where acervo_edicao_id = "+removerEdicaoAcervo.getId()+" and acervo_isbn = '"+removerEdicaoAcervo.getIsbn()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarEdicaoAcervo(BaseDTO consultarEdicaoAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_edicao_id, acervo_edicao_numero, acervo_edicao_cidade, acervo_edicao_ano from acervo_edicao where acervo_isbn = '"+consultarEdicaoAcervo.getIsbn()+"' and acervo_edicao_status = true order by acervo_edicao_id";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirEdicaoAcervo(BaseDTO inserirEdicaoAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_edicao values (nextval('sid_acervo_edicao'),(select current_date), (select current_time), true,'"+inserirEdicaoAcervo.getIsbn()+"','"+inserirEdicaoAcervo.getEdicao_numero()+"','"+inserirEdicaoAcervo.getEdicao_cidadeuf()+"','"+inserirEdicaoAcervo.getEdicao_ano()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Outros
    
    public boolean InserirOutros(BaseDTO inserirOutros){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into outros values (nextval('sid_outros'),(select current_date), (select current_time), true,'"+inserirOutros.getTipo()+"','"+inserirOutros.getOutros_tipo()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean RemoverOutrosAcervo(BaseDTO removerOutrosAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_outros set acervo_outros_status = false where acervo_outros_id = "+removerOutrosAcervo.getId()+" and acervo_isbn = '"+removerOutrosAcervo.getIsbn()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarOutros(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct (outros_nome) from outros where outros_tipo = '"+consultar.getTipo()+"' and outros_status = true order by outros_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarOutrosAcervo(BaseDTO consultarOutrosAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_outros_id, outros_nome, acervo_outros_nome2 from acervo_outros where acervo_isbn = '"+consultarOutrosAcervo.getIsbn()+"' and acervo_outros_status = true order by acervo_outros_id";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirOutrosAcervo(BaseDTO inserirOutrosAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_outros values (nextval('sid_acervo_outros'),(select current_date), (select current_time), true,'"+inserirOutrosAcervo.getIsbn()+"','"+inserirOutrosAcervo.getOutros_tipo()+"','"+inserirOutrosAcervo.getOutros_nome()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Acervo
    
    public boolean InserirAcervo(BaseDTO inserirAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo values (nextval('sid_acervo'),(select current_date), (select current_time), true,'"+inserirAcervo.getIsbn()+"','"+inserirAcervo.getNome()+"','"+inserirAcervo.getSubtitulo()+"','"+inserirAcervo.getColecao()+"','"+inserirAcervo.getEditora()+"','"+inserirAcervo.getTipo()+"','"+inserirAcervo.getPaginas()+"','"+inserirAcervo.getVolume()+"','"+inserirAcervo.getLinguagem()+"','"+inserirAcervo.getResumo()+"','"+inserirAcervo.getObs()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean AlterarAcervo(BaseDTO alterarAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo set acervo_nome = '"+alterarAcervo.getNome()+"', acervo_subtitulo = '"+alterarAcervo.getSubtitulo()+"',acervo_colecao = '"+alterarAcervo.getColecao()+"', acervo_editora = '"+alterarAcervo.getEditora()+"', acervo_tipo = '"+alterarAcervo.getTipo()+"', acervo_paginas = '"+alterarAcervo.getPaginas()+"', acervo_volume = '"+alterarAcervo.getVolume()+"', acervo_linguagem = '"+alterarAcervo.getLinguagem()+"', acervo_resumo = '"+alterarAcervo.getResumo()+"', acervo_obs = '"+alterarAcervo.getObs()+"' where acervo_isbn = '"+alterarAcervo.getIsbn()+"';";
            System.out.println(comando);
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarAcervoVerificador(BaseDTO consultarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(acervo_isbn) as verificador from acervo where acervo_isbn = '"+consultarAcervo.getIsbn()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarAcervo(BaseDTO consultarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_nome, acervo_subtitulo, acervo_colecao, acervo_editora, acervo_tipo, acervo_paginas, acervo_volume, acervo_linguagem, acervo_resumo, acervo_obs from acervo where acervo_isbn = '"+consultarAcervo.getIsbn()+"' and acervo_status = true";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Acervo Consulta
    
    public ResultSet ConsultarAcervoBibliotecaTitulo(BaseDTO consultarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select a.acervo_isbn, ate.acervo_tombo_empresa_numero, a.acervo_nome, a.acervo_subtitulo, atr.acervo_outros_nome2, a.acervo_colecao, a.acervo_editora, a.acervo_tipo, a.acervo_paginas, acervo_volume, acervo_linguagem from acervo a left outer join acervo_outros atr on (a.acervo_isbn = atr.acervo_isbn), acervo_tombo_empresa ate where atr.outros_nome = 'AUTOR(A)' and a.acervo_isbn = ate.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and a.acervo_status = true and atr.acervo_outros_status = true and ate.acervo_tombo_empresa_status = true and a.acervo_nome like('%"+consultarAcervo.getNome()+"%') order by a.acervo_nome, ate.acervo_tombo_empresa_numero";
                          //select a.acervo_isbn, ate.acervo_tombo_empresa_numero, a.acervo_nome, a.acervo_subtitulo, atr.autor_nome, a.acervo_colecao, a.acervo_editora, a.acervo_tipo, a.acervo_paginas, acervo_volume, acervo_linguagem from acervo a left outer join acervo_autor atr on (a.acervo_isbn = atr.acervo_isbn), acervo_tombo_empresa ate where a.acervo_isbn = ate.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and a.acervo_status = true and ate.acervo_tombo_empresa_status = true and a.acervo_nome like('%"+consultarAcervo.getNome()+"%') order by a.acervo_nome, ate.acervo_tombo_empresa_numero
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarAcervoBibliotecaTombo(BaseDTO consultarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select a.acervo_isbn, ate.acervo_tombo_empresa_numero, a.acervo_nome, a.acervo_subtitulo, atr.acervo_outros_nome2, a.acervo_colecao, a.acervo_editora, a.acervo_tipo, a.acervo_paginas, acervo_volume, acervo_linguagem from acervo a left outer join acervo_outros atr on (a.acervo_isbn = atr.acervo_isbn), acervo_tombo_empresa ate where atr.outros_nome = 'AUTOR(A)' and a.acervo_isbn = ate.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and a.acervo_status = true and atr.acervo_outros_status = true and ate.acervo_tombo_empresa_status = true and ate.acervo_tombo_empresa_numero like('%"+consultarAcervo.getTombo()+"%') order by a.acervo_nome, ate.acervo_tombo_empresa_numero";
                          //select a.acervo_isbn, ate.acervo_tombo_empresa_numero, a.acervo_nome, a.acervo_subtitulo, atr.autor_nome, a.acervo_colecao, a.acervo_editora, a.acervo_tipo, a.acervo_paginas, acervo_volume, acervo_linguagem from acervo a left outer join acervo_autor atr on (a.acervo_isbn = atr.acervo_isbn), acervo_tombo_empresa ate where a.acervo_isbn = ate.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and a.acervo_status = true and ate.acervo_tombo_empresa_status = true and ate.acervo_tombo_empresa_numero like('%"+consultarAcervo.getTombo()+"%') order by a.acervo_nome, ate.acervo_tombo_empresa_numero
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarAcervoBibliotecaTombo2(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select ate.acervo_tombo_empresa_id, a.acervo_isbn, ate.acervo_tombo_empresa_numero, a.acervo_nome  from acervo_tombo_empresa ate, acervo a where ate.acervo_isbn = a.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and ate.acervo_tombo_empresa_status = true and a.acervo_status = true order by ate.acervo_tombo_empresa_numero desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Pessoa Aluno Consulta
    
    public ResultSet ConsultarPessoaAniversario(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select p.pessoa_id, p.pessoa_nome, p.pessoa_dn, p.pessoa_sexo, rpe.cargo_nome, (extract(year from current_date) - extract(year from p.pessoa_dn)) as idade from pessoa p, registro_pessoa_empresa rpe WHERE (EXTRACT(MONTH FROM p.pessoa_dn) = "+consultar.getAniversario()+") and p.pessoa_status = true and (p.pessoa_ci_uf, p.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and rpe.rpe_status = true and rpe.empresa_cnpj = '"+info.getCnpj()+"' order by p.pessoa_dn, p.pessoa_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarPessoaNM(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select p.pessoa_id, p.pessoa_nome, p.pessoa_dn, p.pessoa_sexo, rpe.cargo_nome from pessoa p, registro_pessoa_empresa rpe WHERE p.pessoa_nascimento_multiplo = '"+consultar.getPessoa_nascimento_multiplo()+"' and (p.pessoa_ci_uf, p.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and rpe.rpe_status = true and rpe.empresa_cnpj = '"+info.getCnpj()+"' order by p.pessoa_dn, p.pessoa_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    
    
    public ResultSet ConsultarAlunoNome(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select rpe.rpe_registro, rpe.pessoa_ci_uf, rpe.pessoa_ci_numero, ps.pessoa_nome, ps.pessoa_dn, ps.pessoa_sexo  from registro_pessoa_empresa rpe, pessoa ps where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and empresa_cnpj = '"+info.getCnpj()+"' and rpe_status = true and ps.pessoa_nome like ('%"+consultar.getPessoa_nome()+"%') and ps.pessoa_status = true order by ps.pessoa_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarAlunoRA(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select ps.pessoa_ci_uf, ps. pessoa_ci_numero, ps.pessoa_nome  from registro_pessoa_empresa rpe, pessoa ps where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and empresa_cnpj = '"+info.getCnpj()+"' and rpe_status = true and ps.pessoa_status = true and ps.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and ps.pessoa_ci_numero = '"+consultar.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Tombo
    
    public boolean RemoverTomboAcervo(BaseDTO removerTomboAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_tombo_empresa set acervo_tombo_empresa_status = false where acervo_tombo_empresa_id = "+removerTomboAcervo.getId()+" and acervo_isbn = '"+removerTomboAcervo.getIsbn()+"' and empresa_cnpj = '"+info.getCnpj()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean AlterarTomboAcervo(BaseDTO alterarTomboAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_tombo_empresa set acervo_tombo_empresa_status = true where acervo_tombo_empresa_numero = '"+alterarTomboAcervo.getTombo()+"' and acervo_isbn = '"+alterarTomboAcervo.getIsbn()+"' and empresa_cnpj = '"+info.getCnpj()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarTomboAcervo(BaseDTO consultarTomboAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_tombo_empresa_id, acervo_tombo_empresa_numero from acervo_tombo_empresa where acervo_isbn = '"+consultarTomboAcervo.getIsbn()+"' and acervo_tombo_empresa_status = true and empresa_cnpj = '"+info.getCnpj()+"' order by acervo_tombo_empresa_numero";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirTomboAcervo(BaseDTO inserirTomboAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_tombo_empresa values (nextval('sid_acervo_tombo_empresa'),(select current_date), (select current_time), true,'"+inserirTomboAcervo.getIsbn()+"','"+info.getCnpj()+"','"+inserirTomboAcervo.getTombo()+"',1,'');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet VerificarTomboAcervo(BaseDTO consultarTomboAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(acervo_tombo_empresa_numero) as verificador from acervo_tombo_empresa where acervo_tombo_empresa_numero = '"+consultarTomboAcervo.getTombo()+"' and acervo_isbn = '"+consultarTomboAcervo.getIsbn()+"' and empresa_cnpj = '"+info.getCnpj()+"';";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Relatar Entrada/Saída Acervo
    
    public ResultSet ConsultarRelatoEntradaSaida(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(acervo_tombo_empresa_numero) as verificador from acervo_relatar where acervo_relatar_status = true and empresa_cnpj = '"+info.getCnpj()+"' and acervo_tombo_empresa_numero = '"+consultar.getTombo()+"';";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarRelatarAcervoPessoa(BaseDTO consultarRelatarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select ar.acervo_relatar_id, ar.acervo_relatar_data, ar.acervo_relatar_data_saida, ar.acervo_relatar_data_saida - ar.acervo_relatar_data as dias, ar.acervo_tombo_empresa_numero, a.acervo_nome, ar.pessoa_ci_uf, ar.pessoa_ci_numero, ps.pessoa_nome from acervo_relatar ar, pessoa ps, acervo_tombo_empresa ate, acervo a where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.pessoa_ci_uf, ar.pessoa_ci_numero) and ate.acervo_tombo_empresa_numero = ar.acervo_tombo_empresa_numero and ate.acervo_isbn = a.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and ate.acervo_tombo_empresa_status = true and ar.acervo_relatar_status = "+consultarRelatarAcervo.getRelatarboolean()+" and ps.pessoa_nome like('%"+consultarRelatarAcervo.getPessoa_nome()+"%') and (acervo_relatar_data) >= (select current_date-360) order by ar.acervo_relatar_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarRelatarAcervoTombo(BaseDTO consultarRelatarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select ar.acervo_relatar_id, ar.acervo_relatar_data, ar.acervo_relatar_data_saida, ar.acervo_relatar_data_saida - ar.acervo_relatar_data as dias, ar.acervo_tombo_empresa_numero, a.acervo_nome, ar.pessoa_ci_uf, ar.pessoa_ci_numero, ps.pessoa_nome from acervo_relatar ar, pessoa ps, acervo_tombo_empresa ate, acervo a where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.pessoa_ci_uf, ar.pessoa_ci_numero) and ate.acervo_tombo_empresa_numero = ar.acervo_tombo_empresa_numero and ate.acervo_isbn = a.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and ate.acervo_tombo_empresa_status = true and ar.acervo_relatar_status = "+consultarRelatarAcervo.getRelatarboolean()+" and a.acervo_nome like('%"+consultarRelatarAcervo.getNome()+"%') and (acervo_relatar_data) >= (select current_date-360) order by ar.acervo_relatar_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarRelatarPessoaNome(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select ps.pessoa_nome from pessoa ps, registro_pessoa_empresa rpe where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and ps.pessoa_status = true and rpe.rpe_status = true and rpe.empresa_cnpj = '"+info.getCnpj()+"' and ps.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and ps.pessoa_ci_numero = '"+consultar.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consulta o Tombo para entrega do acervo
    
    public ResultSet ConsultarRelatarTombo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select ar.acervo_relatar_id, ar.pessoa_ci_uf, ar.pessoa_ci_numero, ps.pessoa_nome, ar.acervo_tombo_empresa_numero, ac.acervo_nome from acervo ac, pessoa ps, acervo_relatar ar, acervo_tombo_empresa ate where ac.acervo_isbn = ate.acervo_isbn and ar.pessoa_ci_uf = ps.pessoa_ci_uf and ar.pessoa_ci_numero = ps.pessoa_ci_numero and ate.acervo_tombo_empresa_numero = ar.acervo_tombo_empresa_numero and ate.empresa_cnpj = ar.empresa_cnpj and ar.acervo_relatar_status = true and ar.empresa_cnpj = '"+info.getCnpj()+"' and ar.acervo_tombo_empresa_numero = '"+consultar.getTombo()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet VerificadorRelatarPessoa(BaseDTO consultarRelatarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(ps.pessoa_nome) as verificador from pessoa ps, registro_pessoa_empresa rpe where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and rpe.empresa_cnpj = '"+info.getCnpj()+"' and ps.pessoa_ci_uf = '"+consultarRelatarAcervo.getPessoa_uf()+"' and ps.pessoa_ci_numero = '"+consultarRelatarAcervo.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet VerificadorRelatarPessoaDocente(BaseDTO consultarRelatarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(ps.pessoa_nome) as verificador from pessoa ps, registro_pessoa_empresa rpe where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and rpe.cargo_nome <> '"+info.getAluno()+"' and ps.pessoa_status = true and rpe.rpe_status = true and rpe.empresa_cnpj = '"+info.getCnpj()+"' and ps.pessoa_ci_uf = '"+consultarRelatarAcervo.getPessoa_uf()+"' and ps.pessoa_ci_numero = '"+consultarRelatarAcervo.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet VerificadorRelatarPessoaAluno(BaseDTO consultarRelatarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(ps.pessoa_nome) as verificador from pessoa ps, registro_pessoa_empresa rpe where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) and rpe.cargo_nome = '"+info.getAluno()+"' and ps.pessoa_status = true and rpe.rpe_status = true and rpe.empresa_cnpj = '"+info.getCnpj()+"' and ps.pessoa_ci_uf = '"+consultarRelatarAcervo.getPessoa_uf()+"' and ps.pessoa_ci_numero = '"+consultarRelatarAcervo.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet VerificadorRelatarTombo(BaseDTO consultarRelatarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(acervo_nome) as verificador from acervo_tombo_empresa ate, acervo a where ate.acervo_isbn = a.acervo_isbn and ate.acervo_tombo_empresa_status = true and ate.empresa_cnpj = '"+info.getCnpj()+"' and ate.acervo_tombo_empresa_numero = '"+consultarRelatarAcervo.getTombo()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarRelatarTomboTitulo(BaseDTO consultarRelatarAcervo){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select acervo_nome from acervo_tombo_empresa ate, acervo a where ate.acervo_isbn = a.acervo_isbn and ate.empresa_cnpj = '"+info.getCnpj()+"' and ate.acervo_tombo_empresa_status = true and ate.acervo_tombo_empresa_numero = '"+consultarRelatarAcervo.getTombo()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirRelatarAcervo(BaseDTO inserirRelatarAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into acervo_relatar values (nextval('sid_acervo_relatar'),(select current_date), (select current_time), true,'"+info.getCnpj()+"','"+inserirRelatarAcervo.getTombo()+"','"+inserirRelatarAcervo.getPessoa_uf()+"','"+inserirRelatarAcervo.getPessoa_id()+"',null);";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean RemoverRelatarAcervo(BaseDTO removerRelatarAcervo){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="update acervo_relatar set acervo_relatar_status = false, acervo_relatar_data_saida = (select current_date) where acervo_relatar_status = true and acervo_relatar_id = "+removerRelatarAcervo.getId()+" and empresa_cnpj = '"+info.getCnpj()+"';";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Outros
    
    
    // Consultar EmpresaCargo
    public ResultSet ConsultarEmpresaCargo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(empresa_cargo_nome) from empresa_cargo where empresa_cargo_status = true and empresa_cnpj = '"+info.getCnpj()+"' order by empresa_cargo_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir EmpresaCargo
    public boolean InserirEmpresaCargo(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','"+inserir.getEmpresa_pessoa_cargo()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Raça/Cor
    public ResultSet ConsultarRacaCor(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(cor_racas_nome) from cor_racas where cor_racas_status = true order by cor_racas_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Raça/Cor
    public ResultSet ConsultarAgnome(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(agnome_nome) from agnome where agnome_status = true order by agnome_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Raça/Cor
    public boolean InserirRacaCor(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'"+inserir.getRacacor()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Inserir Agnome
    public boolean InserirAgnome(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'"+inserir.getPessoa_agnome()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Sexo
    public ResultSet ConsultarSexo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(sexo_tipo) from sexo where sexo_status = true order by sexo_tipo";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Nascimento Múltiplo
    public ResultSet ConsultarNascimentoMultiplo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select nascimento_multiplo_tipo from nascimento_multiplo where nascimento_multiplo_status = true order by nascimento_multiplo_codigo";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Sexo
    public boolean InserirSexo(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into sexo values (nextval('sid_sexo'),(select current_date), (select current_time), true,'"+inserir.getSexo()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Estado Civil
    public ResultSet ConsultarEstadoCivil(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(estado_civil_nome) from estado_civil where estado_civil_status = true order by estado_civil_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Estado Civil
    public boolean InserirEstadoCivil(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into estado_civil values (nextval('sid_estado_civil'),(select current_date), (select current_time), true,'"+inserir.getPessoa_estado_civil()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Pais
    public ResultSet ConsultarPais(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(pais_nome) from pais where pais_status = true order by pais_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Pais
    public boolean InserirPais(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into pais values (nextval('sid_pais'),(select current_date), (select current_time), true,'','"+inserir.getEndereco_pais()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar UF
    public ResultSet ConsultarUF(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(uf_nome) from uf where uf_status = true order by uf_nome desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar UF2
    public ResultSet ConsultarUF2(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(uf_nome) from uf where uf_status = true and pais_nome = '"+consultar.getEndereco_pais()+"' order by uf_nome desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir UF
    public boolean InserirUF(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into uf values (nextval('sid_uf'),(select current_date), (select current_time), true,'"+inserir.getEndereco_pais()+"','"+inserir.getEndereco_uf()+"','"+inserir.getEndereco_uf_descricao()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    //Inserir Religião
    public boolean InserirReligiao(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'"+inserir.getReligiao_nome()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Religião
    public ResultSet ConsultarReligiao(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(religiao_nome) from religiao where religiao_status = true order by religiao_nome ";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
     //Inserir Certificadora
    public boolean InserirCertificadora(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into certificadora values (nextval('sid_certificadora'),(select current_date), (select current_time), true,'"+inserir.getCertificadora()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Certificadora
    public ResultSet ConsultarCertificadora(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(certificadora_nome) from certificadora where certificadora_status = true order by certificadora_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Cidade
    public ResultSet ConsultarCidade(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(cidade_nome) from cidade where cidade_status = true and pais_nome = '"+consultar.getEndereco_pais()+"' and uf_nome = '"+consultar.getEndereco_uf()+"' order by cidade_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Cidade
    public boolean InserirCidade(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into cidade values (nextval('sid_cidade'),(select current_date), (select current_time), true,'"+inserir.getEndereco_pais()+"','"+inserir.getEndereco_uf()+"','"+inserir.getEndereco_cidade()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar CEP
    public ResultSet ConsultarCEP(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct (cep_numero) from cep where cep_status = true and pais_nome = '"+consultar.getEndereco_pais()+"' and uf_nome = '"+consultar.getEndereco_uf()+"' and cidade_nome = '"+consultar.getEndereco_cidade()+"' order by cep_numero";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir CEP
    public boolean InserirCEP(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into cep values (nextval('sid_cep'),(select current_date), (select current_time), true,'"+inserir.getEndereco_pais()+"','"+inserir.getEndereco_uf()+"','"+inserir.getEndereco_cidade()+"','"+inserir.getEndereco_cep()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Bairro
    public ResultSet ConsultarBairro(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(bairro_nome) from bairro where bairro_status = true and pais_nome = '"+consultar.getEndereco_pais()+"' and uf_nome = '"+consultar.getEndereco_uf()+"' and cidade_nome = '"+consultar.getEndereco_cidade()+"' and cep_numero = '"+consultar.getEndereco_cep()+"' and zona_nome = '"+consultar.getEndereco_zona()+"' order by bairro_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Bairro
    public boolean InserirBairro(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'"+inserir.getEndereco_pais()+"','"+inserir.getEndereco_uf()+"','"+inserir.getEndereco_cidade()+"','"+inserir.getEndereco_cep()+"','"+inserir.getEndereco_zona()+"','"+inserir.getEndereco_bairro()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Logradouro
    public ResultSet ConsultarLogradouro(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(logradouro_nome) from logradouro where logradouro_status = true and pais_nome = '"+consultar.getEndereco_pais()+"' and uf_nome = '"+consultar.getEndereco_uf()+"' and cidade_nome = '"+consultar.getEndereco_cidade()+"' and cep_numero = '"+consultar.getEndereco_cep()+"' and zona_nome = '"+consultar.getEndereco_zona()+"' and bairro_nome = '"+consultar.getEndereco_bairro()+"' order by logradouro_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Logradouro
    public boolean InserirLogradouro(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando = "insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'"+inserir.getEndereco_pais()+"','"+inserir.getEndereco_uf()+"','"+inserir.getEndereco_cidade()+"','"+inserir.getEndereco_cep()+"','"+inserir.getEndereco_zona()+"','"+inserir.getEndereco_bairro()+"','"+inserir.getEndereco_logradouro()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    
    // Cadastrar Pessoa Empresa
    
    
    // Consultar Pessoa Empresa
    public ResultSet ConsultarPessoaEmpresa(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select rpe.rpe_registro, rpe.rpe_data, e.empresa_nome from registro_pessoa_empresa rpe, empresa e where rpe.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and rpe.pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and rpe.rpe_status = true and rpe.empresa_cnpj = e.empresa_cnpj";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet VerificarPessoaEmpresa(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select rpe_status from registro_pessoa_empresa where pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirPessoaEmpresa(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando1 = "insert into registro_pessoa_empresa values (nextval('sid_registro_pessoa_empresa'),(select current_date), (select current_time),true,(select count(rpe_registro)+1 as maior from registro_pessoa_empresa where empresa_cnpj = '"+info.getCnpj()+"' and cargo_nome = '"+info.getAluno()+"'),'"+info.getCnpj()+"','"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+info.getAluno()+"','');";
            String comando2 = comando1.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando1);
            System.out.println(comando3);
            stmt.execute(comando1);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean AlterarPessoaEmpresa(BaseDTO alterar){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando1 = "update registro_pessoa_empresa set rpe_status = "+alterar.getEmpresa_pessoa_status()+" where pessoa_ci_uf = '"+alterar.getPessoa_uf()+"' and pessoa_ci_numero = '"+alterar.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"';";
            String comando2 = comando1.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando1);
            System.out.println(comando3);
            stmt.execute(comando1);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Cadastrar Pessoa
    
    
    // Inserir Pessoa
    public boolean InserirPessoaAluno(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando1 = "insert into pessoa values (nextval('sid_pessoa'),(select current_date), (select current_time), true,'"+inserir.getPessoa_id_tipo()+"','"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+inserir.getPessoa_prenome()+"','"+inserir.getPessoa_sobrenome()+"','"+inserir.getPessoa_agnome()+"','"+inserir.getPessoa_nome()+"','"+inserir.getPessoa_dn()+"','"+inserir.getPessoa_sexo()+"','"+inserir.getPessoa_cor()+"','"+inserir.getPessoa_estado_civil()+"','"+inserir.getPessoa_nascimento_multiplo()+"')";
            String comando2 = comando1.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            String comando4 = "insert into registro_pessoa_empresa values (nextval('sid_registro_pessoa_empresa'),(select current_date), (select current_time),true,(select count(rpe_registro)+1 as maior from registro_pessoa_empresa where empresa_cnpj = '"+info.getCnpj()+"' and cargo_nome = '"+inserir.getEmpresa_pessoa_cargo()+"'),'"+info.getCnpj()+"','"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+inserir.getEmpresa_pessoa_cargo()+"','');";
            String comando5 = comando4.replace("'", "´");
            String comando6 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando5+"');";
            System.out.println(comando1);
            System.out.println(comando3);
            System.out.println(comando4);
            System.out.println(comando6);
            stmt.execute(comando1);
            stmt.execute(comando3);
            stmt.execute(comando4);
            stmt.execute(comando6);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Alterar Pessoa
    public boolean AlterarPessoaAluno(BaseDTO alterar){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando1 = "update pessoa set pessoa_ci_tipo = '"+alterar.getPessoa_id_tipo()+"',pessoa_prenome = '"+alterar.getPessoa_prenome()+"', pessoa_sobrenome = '"+alterar.getPessoa_sobrenome()+"', pessoa_agnome = '"+alterar.getPessoa_agnome()+"', pessoa_nome = '"+alterar.getPessoa_nome()+"', pessoa_dn = '"+alterar.getPessoa_dn()+"', pessoa_sexo = '"+alterar.getPessoa_sexo()+"', pessoa_cor = '"+alterar.getPessoa_cor()+"', pessoa_estado_civil = '"+alterar.getPessoa_estado_civil()+"', pessoa_nascimento_multiplo = '"+alterar.getPessoa_nascimento_multiplo()+"' where pessoa_ci_uf = '"+alterar.getPessoa_uf()+"' and pessoa_ci_numero = '"+alterar.getPessoa_id()+"';";
            String comando2 = comando1.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            String comando4 = "update registro_pessoa_empresa set cargo_nome = '"+alterar.getEmpresa_pessoa_cargo()+"' where pessoa_ci_uf = '"+alterar.getPessoa_uf()+"' and pessoa_ci_numero = '"+alterar.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"'";
            String comando5 = comando4.replace("'", "´");
            String comando6 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando5+"');";
            System.out.println(comando1);
            System.out.println(comando3);
            System.out.println(comando4);
            System.out.println(comando6);
            stmt.execute(comando1);
            stmt.execute(comando3);
            stmt.execute(comando4);
            stmt.execute(comando6);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Consultar Verificar Pessoa Cadastrada
    public ResultSet VerificadorPessoa(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(*) as verificador from pessoa where pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and pessoa_status = true";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet VerificadorPessoaStatus(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(pessoa_id) as verificador from pessoa where pessoa_status = true and pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet VerificadorPessoaSenha(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select count(*) as verificador from pessoa_senha where pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"' and pessoa_senha = '"+consultar.getPessoa_senha()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean InserirPessoaSenha(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando1 = "insert into pessoa_senha values (nextval('sid_pessoa_senha'),(select current_date), (select current_time),true,'"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+info.getCnpj()+"','"+inserir.getPessoa_login()+"','"+inserir.getPessoa_senha()+"');";
            String comando2 = comando1.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando1);
            System.out.println(comando3);
            stmt.execute(comando1);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarPessoaAluno(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select * from pessoa where pessoa_status = true and pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarPessoaBiblioteca(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select ar.acervo_relatar_id, ar.acervo_relatar_data, ar.acervo_tombo_empresa_numero, ac.acervo_nome, ep.empresa_nome from acervo_tombo_empresa ate, acervo_relatar ar, empresa ep, pessoa ps, acervo ac where ps.pessoa_status = true and ate.empresa_cnpj = ep.empresa_cnpj and ate.acervo_isbn = ac.acervo_isbn and ate.acervo_tombo_empresa_status = true and ar.empresa_cnpj = ep.empresa_cnpj and ar.pessoa_ci_uf = ps.pessoa_ci_uf and ar.pessoa_ci_numero = ps.pessoa_ci_numero and ar.acervo_tombo_empresa_numero = ate.acervo_tombo_empresa_numero and ps.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and ps.pessoa_ci_numero = '"+consultar.getPessoa_id()+"' order by 1 desc;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    //select max(rpe_registro)+1 as maior from registro_pessoa_empresa where empresa_cnpj = '01611213000112' and cargo_nome = 'ALUNO(A)'
    
    // Consultar Médico
    public ResultSet ConsultarMedico(BaseDTO consultar){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(medico_nome) from medico where medico_status = true order by medico_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	} 
    }
    
    // Telefone
    
    
    // Inserir Telefone Tipo
    public boolean InserirTelefoneTipo(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando = "insert into telefone_tipo values (nextval('sid_telefone_tipo'),(select current_date), (select current_time), true,'"+inserir.getTelefone_tipo()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public boolean RemoverTelefonePessoa(BaseDTO remover){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "update pessoa_telefone set tel_status = false where tel_status = true and tel_id = "+remover.getTelefone_id()+";";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
     //Verifica Telefone Pessoa
    public ResultSet VerificarTelefonePessoa(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select count(*) as verificador from pessoa_telefone where tel_status = false and pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero  = '"+consultar.getPessoa_id()+"' and tel_ddd_numero = '"+consultar.getTelefone_ddd()+"' and tel_numero = '"+consultar.getTelefone_numero()+"' and tel_ramal = '"+consultar.getTelefone_ramal()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public boolean RecuperarTelefonePessoa(BaseDTO recuperar){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "update pessoa_telefone set tel_status = true where tel_id = (select tel_id from pessoa_telefone where tel_status = false and pessoa_ci_uf = '"+recuperar.getPessoa_uf()+"' and pessoa_ci_numero  = '"+recuperar.getPessoa_id()+"' and tel_ddd_numero = '"+recuperar.getTelefone_ddd()+"' and tel_numero = '"+recuperar.getTelefone_numero()+"' and tel_ramal = '"+recuperar.getTelefone_ramal()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
     //Consultar Telefone Tipo
    public ResultSet ConsultarTelefoneTipo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(tel_tipo) from telefone_tipo where tel_tipo_status = true order by tel_tipo";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
     //Consultar Telefone por Nome da Pessoa
    public ResultSet ConsultarListaTelefonicaNome(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select tel_id, tel_data, tel_tipo, tel_operadora, tel_ddd_numero, tel_numero, tel_ramal, pessoa_nome, tel_obs from pessoa_telefone pt, pessoa ps, registro_pessoa_empresa rpe where (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and (pt.pessoa_ci_uf, pt.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and pt. tel_status = true and ps.pessoa_status = true and rpe.rpe_status = true and rpe.rpe_status = true and rpe.empresa_cnpj = '"+info.getCnpj()+"' and ps.pessoa_nome like('%"+consultar.getPessoa_nome()+"%') order by ps.pessoa_nome, tel_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    
    //Consultar Telefone por Número
    public ResultSet ConsultarListaTelefonicaNumero(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select tel_id, tel_data, tel_tipo, tel_operadora, tel_ddd_numero, tel_numero, tel_ramal, pessoa_nome, tel_obs from pessoa_telefone pt, pessoa ps, registro_pessoa_empresa rpe where (rpe.pessoa_ci_uf, rpe.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and (pt.pessoa_ci_uf, pt.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and pt. tel_status = true and ps.pessoa_status = true and rpe.rpe_status = true and rpe.empresa_cnpj = '"+info.getCnpj()+"' and tel_numero like('%"+consultar.getTelefone_numero()+"%') order by ps.pessoa_nome, tel_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Telefone Operadora
    public boolean InserirTelefoneOperadora(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into telefone_operadora values (nextval('sid_telefone_operadora'),(select current_date), (select current_time), true,'"+inserir.getTelefone_operadora()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    //Consultar Telefone Operadora
    public ResultSet ConsultarTelefoneOperadora(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(tel_operadora) from telefone_operadora where tel_operadora_status = true order by tel_operadora";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Telefone DDD
    public boolean InserirTelefoneDDD(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into telefone_ddd values (nextval('sid_telefone_ddd'),(select current_date), (select current_time), true,'"+inserir.getTelefone_ddd()+"','','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    //Consultar Telefone DDD
    public ResultSet ConsultarTelefoneDDD(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(tel_ddd_numero) from telefone_ddd where tel_ddd_status = true order by tel_ddd_numero";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    
    // Inserir Telefone Pessoa
    public boolean InserirTelefonePessoa(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into pessoa_telefone values (nextval('sid_pessoa_telefone'),(select current_date), (select current_time), true,'"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+inserir.getTelefone_tipo()+"','"+inserir.getTelefone_operadora()+"','"+inserir.getTelefone_ddd()+"','"+inserir.getTelefone_numero()+"','"+inserir.getTelefone_ramal()+"','"+inserir.getTelefone_obs()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    
    //Consultar Telefone Pessoa
    public ResultSet ConsultarTelefonePessoa(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select tel_id, tel_data, tel_tipo, tel_operadora, tel_ddd_numero, tel_numero, tel_ramal, tel_obs from pessoa_telefone pt, pessoa ps where pt.tel_status = true and ps.pessoa_status = true and (pt.pessoa_ci_uf, pt.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and pt.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pt.pessoa_ci_numero = '"+consultar.getPessoa_id()+"' order by tel_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    //##########################################################################
    
    // Inserir Pessoa Religião
    public boolean InserirPessoaReligiao(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into pessoa_religiao values (nextval('sid_pessoa_religiao'),(select current_date), (select current_time),true,'"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+inserir.getPessoa_religiao_nome()+"','"+inserir.getPessoa_religiao_obs()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    //##########################################################################
    
    
    // Inserir Pessoa Endereço
    public boolean InserirPessoaEndereco(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into pessoa_endereco values (nextval('sid_pessoa_endereco'),(select current_date), (select current_time),true,'"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+inserir.getEndereco_pais()+"','"+inserir.getEndereco_uf()+"','"+inserir.getEndereco_cidade()+"','"+inserir.getEndereco_cep()+"','"+inserir.getEndereco_zona()+"','"+inserir.getEndereco_bairro()+"','"+inserir.getEndereco_logradouro()+"','"+inserir.getEndereco_numero()+"','"+inserir.getEndereco_complemento()+"','"+inserir.getEndereco_referencia()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    //Consultar Pessoa Endereço
    public ResultSet ConsultarEnderecoPessoa(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select pe.pessoa_end_data, pe.pais_nome, pe.uf_nome, pe.cidade_nome, pe.cep_numero, pe.zona_nome, pe.bairro_nome, pe.logradouro_nome, pe.pessoa_end_numero, pe.pessoa_end_complemento, pe.pessoa_end_referencia from pessoa_endereco pe, pessoa ps where pessoa_end_status = true and ps.pessoa_status = true and (pe.pessoa_ci_uf, pe.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and pe.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pe.pessoa_ci_numero = '"+consultar.getPessoa_id()+"' order by pessoa_end_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    //Consultar Religião Pessoa
    public ResultSet ConsultarReligiaoPessoa(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select pr.pessoa_religiao_id, pr.pessoa_religiao_data, pr.pessoa_religiao_nome, pr.pessoa_religiao_obs from pessoa pe, pessoa_religiao pr where pr.pessoa_religiao_status = true and pe.pessoa_status = true and (pe.pessoa_ci_uf, pe.pessoa_ci_numero) = (pr.pessoa_ci_uf, pr.pessoa_ci_numero) and pe.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pe.pessoa_ci_numero = '"+consultar.getPessoa_id()+"' order by pessoa_religiao_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    
    //##########################################################################
    
    // Planejamento da Rotina Semanal
    
    // Mostra o Código usando um nextval no BD
    public ResultSet PlanejamentoRotinaSemanalCodigo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select nextval('sid_planejamento_rotina_semanal') as codigo;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
     // Mostrar Dados Planejamento Rotina Semanal
    public ResultSet MostrarDadosPRS(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select prs_id, prs_data, prs_data_semanal, prs_caderno, prs.periodo_nome, disciplina_nome, prs.classe_numero, cs.ensino_serie, cs.turma_nome from planejamento_rotina_semanal prs, classe cs where cs.classe_status = true and prs_status = true and pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and prs.empresa_cnpj = '"+info.getCnpj()+"' and prs.classe_numero = cs.classe_numero and cs.ano_letivo_ano = (select max(ano_letivo_ano) from ano_letivo) order by prs_data_semanal desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Verificar o Planejamento
    public ResultSet VerificarPlanejamento(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select count(*) as verificador from planejamento_rotina_semanal where prs_status = true and prs_id = "+consultar.getPrs_codigo()+" and pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Planejamento da Rotina Semanal
    public boolean InserirPlanejamentoRotinaSemanal(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into planejamento_rotina_semanal values ("+inserir.getPrs_codigo()+",(select current_date),(select current_time),true,'"+inserir.getPrs_data()+"','"+inserir.getPrs_caderno()+"','"+inserir.getSt_periodo()+"','"+inserir.getDisciplina()+"','"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+inserir.getSt_classe()+"','"+info.getCnpj()+"','"+inserir.getPrs_descricao()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
     // Alterar Planejamento da Rotina Semanal
    public boolean AlterarPlanejamentoRotinaSemanal(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "update planejamento_rotina_semanal set prs_data_semanal = '"+inserir.getPrs_data()+"', prs_caderno = '"+inserir.getPrs_caderno()+"', periodo_nome = '"+inserir.getSt_periodo()+"', disciplina_nome = '"+inserir.getDisciplina()+"', classe_numero = '"+inserir.getSt_classe()+"', prs_descricao = '"+inserir.getPrs_descricao()+"' where prs_id = "+inserir.getPrs_codigo()+" and pessoa_ci_uf = '"+inserir.getPessoa_uf()+"' and pessoa_ci_numero = '"+inserir.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"'";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
     // Remover Planejamento da Rotina Semanal
    public boolean RemoverPlanejamentoRotinaSemanal(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "update planejamento_rotina_semanal set prs_status = false where prs_id = "+inserir.getPrs_codigo()+" and pessoa_ci_uf = '"+inserir.getPessoa_uf()+"' and pessoa_ci_numero = '"+inserir.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"'";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    //Consultar Planejamento da Rotina Semanal
    public ResultSet ConsultarPlanejamentoRotinaSemanal(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select prs_descricao from planejamento_rotina_semanal where prs_status = true and prs_id = "+consultar.getPrs_codigo()+" and pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    //##########################################################################
    
    // Relatório do Aluno
    
    // Mostra o Código usando um nextval no BD
    public ResultSet EmpresaRelatosCodigo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select nextval('sid_empresa_relatos') as codigo;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Relatório Individual do Aluno
    public boolean InserirRelatorioIndividualAluno(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into empresa_relatos values ("+inserir.getEmpresa_relatos_id()+",(select current_date), (select current_time),true,'"+info.getCnpj()+"','RELATÓRIO','"+info.getAluno()+"','"+inserir.getEmpresa_relatos_descricao1()+"','','','','"+inserir.getEmpresa_relatos_dataf()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    
    public boolean InserirEmpresaRelatosPessoa(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando ="insert into empresa_relatos_pessoas values (nextval('sid_empresa_relatos_pessoas'),(select current_date), (select current_time),true,'"+info.getCnpj()+"',"+inserir.getEmpresa_relatos_id()+",'"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"',(select cargo_nome from registro_pessoa_empresa where empresa_cnpj = '"+info.getCnpj()+"' and rpe_status = true and pessoa_ci_uf = '"+inserir.getPessoa_uf()+"' and pessoa_ci_numero = '"+inserir.getPessoa_id()+"'));";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
  
    
    public ResultSet ConsultarRelatoriosAluno(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select erp.empresa_relatos_id, empresa_relatos_pessoas_data, ps.pessoa_ci_uf, ps.pessoa_ci_numero, pessoa_nome, empresa_nome, empresa_relatos_tipo1, empresa_relatos_tipo2 from empresa_relatos_pessoas erp, empresa ep, pessoa ps, empresa_relatos er where er.empresa_relatos_id = erp.empresa_relatos_id and erp.empresa_cnpj = ep.empresa_cnpj and empresa_relatos_tipo1 = 'RELATÓRIO' and erp.empresa_relatos_id in (select empresa_relatos_id from empresa_relatos_pessoas where pessoa_ci_uf = '"+consultar.getAluno_uf()+"' and pessoa_ci_numero = '"+consultar.getAluno_id()+"') and pessoa_tipo <> '"+info.getAluno()+"' and (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (erp.pessoa_ci_uf, erp.pessoa_ci_numero) and erp.empresa_relatos_pessoas_status = true order by empresa_relatos_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarRelatoriosAluno2(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select erp.empresa_relatos_id, empresa_relatos_pessoas_data, ps.pessoa_ci_uf, ps.pessoa_ci_numero, pessoa_nome, empresa_nome, empresa_relatos_tipo1, empresa_relatos_tipo2 from empresa_relatos_pessoas erp, empresa ep, pessoa ps, empresa_relatos er where er.empresa_relatos_id = erp.empresa_relatos_id and erp.empresa_cnpj = ep.empresa_cnpj and erp.empresa_relatos_id in (select empresa_relatos_id from empresa_relatos_pessoas where pessoa_ci_uf = '"+consultar.getAluno_uf()+"' and pessoa_ci_numero = '"+consultar.getAluno_id()+"') and pessoa_tipo <> '"+info.getAluno()+"' and (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (erp.pessoa_ci_uf, erp.pessoa_ci_numero) and erp.empresa_relatos_pessoas_status = true order by empresa_relatos_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    
    public ResultSet ConsultarRelatoriosDocente(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select erp.empresa_relatos_id, empresa_relatos_pessoas_data, ps.pessoa_ci_uf, ps.pessoa_ci_numero, pessoa_nome, empresa_nome, empresa_relatos_tipo1, empresa_relatos_tipo2 from empresa_relatos_pessoas erp, empresa ep, pessoa ps, empresa_relatos er where er.empresa_relatos_id = erp.empresa_relatos_id and erp.empresa_cnpj = ep.empresa_cnpj and empresa_relatos_tipo1 = 'RELATÓRIO' and erp.empresa_relatos_id in (select empresa_relatos_id from empresa_relatos_pessoas where pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and pessoa_ci_numero = '"+consultar.getPessoa_id()+"') and pessoa_tipo = '"+info.getAluno()+"' and (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (erp.pessoa_ci_uf, erp.pessoa_ci_numero) and erp.empresa_relatos_pessoas_status = true order by empresa_relatos_id desc";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarRelatosAluno(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select erp.empresa_relatos_id, erp.empresa_relatos_pessoas_data, erp.pessoa_ci_uf, erp.pessoa_ci_numero, ps.pessoa_nome, erp.pessoa_tipo from empresa_relatos_pessoas erp, pessoa ps where erp.empresa_cnpj = '"+info.getCnpj()+"' and erp.empresa_relatos_pessoas_status = true and (erp.pessoa_ci_uf, erp.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and erp.pessoa_tipo = '"+info.getAluno()+"' and erp.empresa_relatos_id = "+consultar.getEmpresa_relatos_id()+"";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
       
    }
    
    public ResultSet ConsultarRelatosDocente(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select erp.empresa_relatos_id, erp.empresa_relatos_pessoas_data, erp.pessoa_ci_uf, erp.pessoa_ci_numero, ps.pessoa_nome, erp.pessoa_tipo from empresa_relatos_pessoas erp, pessoa ps where erp.empresa_cnpj = '"+info.getCnpj()+"' and erp.empresa_relatos_pessoas_status = true and (erp.pessoa_ci_uf, erp.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and erp.pessoa_tipo <> '"+info.getAluno()+"' and erp.empresa_relatos_id = "+consultar.getEmpresa_relatos_id()+"";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    public ResultSet ConsultarRelatos(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select * from empresa_relatos where empresa_cnpj = '"+info.getCnpj()+"' and empresa_relatos_status = true and empresa_relatos_id = "+consultar.getEmpresa_relatos_id()+"";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
     public ResultSet VerificaConsultaRelatos(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select count(*) as verificador from empresa_relatos_pessoas erp, empresa_relatos er where er.empresa_relatos_id = "+consultar.getEmpresa_relatos_id()+" and er.empresa_relatos_id = erp.empresa_relatos_id and er.empresa_relatos_status = true and erp.empresa_relatos_pessoas_status = true and er.empresa_cnpj = '"+info.getCnpj()+"' and erp.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and erp.pessoa_ci_numero = '"+consultar.getPessoa_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
     public boolean InserirVisualizacaoDocente(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into docente_visualizacao values (nextval('sid_docente_visualizacao'),(select current_date), (select current_time),true,"+inserir.getEmpresa_relatos_id()+",'"+inserir.getPessoa_uf()+"','"+inserir.getPessoa_id()+"','"+info.getCnpj()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
     
     public ResultSet AlunosVistosDocente(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select erp.empresa_relatos_id as id, dv.docente_visualizacao_data as data, erp.pessoa_ci_uf, erp.pessoa_ci_numero, ps.pessoa_nome from empresa_relatos_pessoas erp, empresa_relatos er, pessoa ps, docente_visualizacao dv where erp.empresa_relatos_id = er.empresa_relatos_id and (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (erp.pessoa_ci_uf, erp.pessoa_ci_numero) and er.empresa_relatos_status = true and dv.empresa_relatos_id = erp.empresa_relatos_id and dv.docente_visualizacao_status = true and pessoa_tipo = '"+info.getAluno()+"' and dv.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and dv.pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and dv.empresa_cnpj = '"+info.getCnpj()+"' order by dv.docente_visualizacao_data desc, dv.empresa_relatos_id desc;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
     
     public ResultSet AlunosNaoVistosDocente(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select ar.empresa_relatos_id as id, ar.empresa_relatos_data as data, ps.pessoa_ci_uf, ps.pessoa_ci_numero, ps.pessoa_nome FROM  empresa_relatos ar, pessoa ps, empresa ep, empresa_relatos_pessoas erp WHERE (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (erp.pessoa_ci_uf, erp.pessoa_ci_numero) and ar.empresa_relatos_status = true and erp.pessoa_tipo = '"+info.getAluno()+"' and erp.empresa_relatos_id = ar.empresa_relatos_id and ep.empresa_cnpj = ar.empresa_cnpj and NOT EXISTS (SELECT * FROM docente_visualizacao dv WHERE dv.empresa_relatos_id = ar.empresa_relatos_id and dv.pessoa_ci_uf = '"+consultar.getPessoa_uf()+"' and dv.pessoa_ci_numero = '"+consultar.getPessoa_id()+"' and empresa_cnpj = '"+info.getCnpj()+"') order by ar.empresa_relatos_data desc, ar.empresa_relatos_id desc;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
     
    //##########################################################################
    
    // Classe
    
    //Ano Letivo
    public boolean InserirAnoLetivo(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into ano_letivo values (nextval('sid_ano_letivo'),(select current_date), (select current_time),true,"+inserir.getSt_anoletivo()+");";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarAnoLetivo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(ano_letivo_ano) from ano_letivo where ano_letivo_status = true order by ano_letivo_ano desc;";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    //Ensino
    public boolean InserirEnsino(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into ensino values (nextval('sid_ensino'),(select current_date), (select current_time),true,'"+inserir.getSt_ensino()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarEnsino(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(ensino_nome) from ensino where ensino_status = true order by ensino_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Série
    public boolean InserirSerie(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into ensino_serie values (nextval('sid_ensino_serie'),(select current_date), (select current_time),true,'"+inserir.getSt_ensino()+"','"+inserir.getSt_serie()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarSerie(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(ensino_serie_nome) from ensino_serie where ensino_serie_status = true and ensino_nome = '"+consultar.getSt_ensino()+"' order by ensino_serie_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Período
    public boolean InserirPeriodo(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into periodo values (nextval('sid_periodo'),(select current_date), (select current_time),true,'"+inserir.getSt_periodo()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarPeriodo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(periodo_nome) from periodo where periodo_status = true order by periodo_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Turma
    public boolean InserirTurma(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into turma values (nextval('sid_turma'),(select current_date), (select current_time),true,'"+info.getCnpj()+"',"+inserir.getSt_anoletivo()+",'"+inserir.getSt_periodo()+"','"+inserir.getSt_ensino()+"','"+inserir.getSt_serie()+"','"+inserir.getSt_turma()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarTurma(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct(turma_nome) from turma where turma_status = true and empresa_cnpj = '"+info.getCnpj()+"' and ano_letivo_ano = "+consultar.getSt_anoletivo()+" and periodo_nome = '"+consultar.getSt_periodo()+"' and ensino_nome = '"+consultar.getSt_ensino()+"' and ensino_serie_nome = '"+consultar.getSt_serie()+"' order by turma_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Sala
    public boolean InserirEmpresaSala(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into empresa_sala values (nextval('sid_empresa_sala'),(select current_date), (select current_time), true,'"+info.getCnpj()+"','"+inserir.getEmpresa_sala_numero()+"','',0,0,0,'');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarEmpresaSala(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando ="select distinct (empresa_sala_numero) from empresa_sala where empresa_sala_status = true and empresa_cnpj = '"+info.getCnpj()+"' order by empresa_sala_numero";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Disciplina
    public boolean InserirDisciplina(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into disciplina values (nextval('sid_disciplina'),(select current_date), (select current_time),true,'"+inserir.getDisciplina()+"','');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    public ResultSet ConsultarDisciplina(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select distinct (disciplina_nome) from disciplina where disciplina_status = true order by disciplina_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Verificar Classe
    public ResultSet VerificarClasse(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select count(classe_numero) as verificador from classe where classe_status = true and classe_numero = '"+consultar.getSt_classe()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Classe
    public boolean InserirClasse(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into classe values (nextval('sid_classe'),(select current_date), (select current_time),true,'"+inserir.getSt_classe()+"','"+info.getCnpj()+"','"+inserir.getSt_ensino()+"','"+inserir.getSt_serie()+"','"+inserir.getSt_turma()+"','"+inserir.getSt_periodo()+"',"+inserir.getSt_anoletivo()+",'"+inserir.getSt_sala()+"','"+inserir.getSt_horario_inicio()+"','"+inserir.getSt_horario_fim()+"','"+inserir.getSt_obs()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Alterar Classe
    public boolean AlterarClasse(BaseDTO alterar){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "update classe set ensino_nome = '"+alterar.getSt_ensino()+"', ensino_serie = '"+alterar.getSt_serie()+"', turma_nome = '"+alterar.getSt_turma()+"', periodo_nome = '"+alterar.getSt_periodo()+"', ano_letivo_ano = "+alterar.getSt_anoletivo()+", empresa_sala_numero = '"+alterar.getSt_sala()+"', classe_hinicial = '"+alterar.getSt_horario_inicio()+"', classe_hfinal = '"+alterar.getSt_horario_fim()+"', classe_obs = '"+alterar.getObs()+"' where empresa_cnpj = '"+info.getCnpj()+"' and classe_status = true and classe_numero = '"+alterar.getSt_classe()+"'";
            System.out.println(comando);
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Mostrar Dados Classe
    public ResultSet MostrarDadosClasse(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select classe_numero, ensino_nome, ensino_serie, turma_nome, periodo_nome, ano_letivo_ano, empresa_sala_numero, classe_hinicial, classe_hfinal from classe where empresa_cnpj = '"+info.getCnpj()+"' and classe_status = true and ano_letivo_ano = "+consultar.getSt_anoletivo()+" order by ensino_nome, ensino_serie, turma_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Mostrar Alunos Classe
    public ResultSet MostrarAlunosClasse(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select ac.aluno_classe_nchamada, p.pessoa_ci_uf, p.pessoa_ci_numero, p.pessoa_nome, p.pessoa_dn, p.pessoa_sexo, ac.aluno_classe_tranf, ac.aluno_classe_rem, ac.aluno_classe_obs from aluno_classe ac, pessoa p where (p.pessoa_ci_uf, p.pessoa_ci_numero) = (ac.pessoa_ci_uf, ac.pessoa_ci_numero) and ac.empresa_cnpj = '"+info.getCnpj()+"' and ac.classe_numero = '"+consultar.getSt_classe()+"' and ac.aluno_classe_status = true and p.pessoa_status = true order by ac.aluno_classe_nchamada";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Inserir Aluno Classe
    public boolean InserirAlunoClasse(BaseDTO inserir){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "insert into aluno_classe values (nextval('sid_aluno_classe'),(select current_date), (select current_time),true,'"+inserir.getSt_classe()+"','"+info.getCnpj()+"','"+inserir.getAluno_uf()+"','"+inserir.getAluno_id()+"',"+inserir.getAluno_classe_nchamada()+",'"+inserir.getAluno_classe_transf()+"','"+inserir.getAluno_classe_rem()+"','"+inserir.getAluno_classe_sit()+"','"+inserir.getAluno_classe_def()+"','"+inserir.getAluno_classe_obs()+"');";
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.commit();
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Alterar Aluno Classe
    public boolean AlterarAlunoClasse(BaseDTO alterar){
        try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "";
            System.out.println(comando);
            String comando2 = comando.replace("'", "´");
            String comando3 = "insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'"+info.getCnpj()+"','INSERT','"+comando2+"');";
            System.out.println(comando);
            System.out.println(comando3);
            stmt.execute(comando);
            stmt.execute(comando3);
            Conexao.con.close();
            return true;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	}
    }
    
    // Verificar Aluno Classe
    public ResultSet VerificarAlunoClasse(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select count(classe_numero) as verificador from aluno_classe where aluno_classe_status = true and classe_numero = '"+consultar.getSt_classe()+"' and empresa_cnpj = '"+info.getCnpj()+"' and pessoa_ci_uf = '"+consultar.getAluno_uf()+"' and pessoa_ci_numero = '"+consultar.getAluno_id()+"'";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Mostrar Dados Classe
    public ResultSet MostrarDadosAlunoClasse(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt = Conexao.con.createStatement();
            String comando = "select * from aluno_classe where aluno_classe_status = true and empresa_cnpj = '"+info.getCnpj()+"' and classe_numero = '"+consultar.getSt_classe()+"' order by aluno_classe_nchamada";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Auto Marca
    public ResultSet ConsultarAutoMarca(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(auto_tipo_marca_nome) from auto_tipo_marca where auto_tipo_marca_status = true and auto_tipo_nome = '"+consultar.getAuto_tipo()+"' order by auto_tipo_marca_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Auto Tipo
    public ResultSet ConsultarAutoTipo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(auto_tipo_nome) from auto_tipo where auto_tipo_status = true order by auto_tipo_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
   
    // Consultar Auto Combustível
    public ResultSet ConsultarAutoCombustivel(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(auto_combustivel_nome) from auto_combustivel where auto_combustivel_status = true order by auto_combustivel_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Auto Cor
    public ResultSet ConsultarAutoCor(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(auto_cor_nome) from auto_cor where auto_cor_status = true order by auto_cor_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Auto Modelo
    public ResultSet ConsultarAutoModelo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(auto_marca_modelo_nome) from auto_marca_modelo where auto_marca_modelo_status = true and auto_marca_nome = '"+consultar.getAuto_modelo()+"' order by auto_marca_modelo_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
    
    // Consultar Auto Stilo
    public ResultSet ConsultarAutoStilo(BaseDTO consultar){
       try{
            Conexao.ConectDB();
            Statement stmt= Conexao.con.createStatement();
            String comando="select distinct(auto_marca_modelo_stilo_nome) from auto_marca_modelo_stilo where auto_marca_modelo_stilo_status = true and auto_marca_nome = '"+consultar.getAuto_marca()+"' and auto_marca_modelo_nome = '"+consultar.getAuto_modelo()+"' order by auto_marca_modelo_stilo_nome";
            System.out.println(comando);
            rs= stmt.executeQuery(comando);
            Conexao.con.commit();
            Conexao.con.close();
            return rs;
	}
	catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
	}    
    }
}
