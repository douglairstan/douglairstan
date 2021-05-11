/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base.ctr;

import base.dao.BaseDAO;
import base.dto.BaseDTO;
import java.sql.ResultSet;

/**
 *
 * @author Douglas Estanislau Pereira
 */
public class BaseCTR {
    
    public BaseCTR(){
        
    }
    
    
    // Autor
    
    
    public boolean InserirAutor(String autor){
        BaseDTO inserirAutorDTO = new BaseDTO();
        BaseDAO inserirAutorDAO = new BaseDAO();
        
        inserirAutorDTO.setAutor(autor);
        
        return inserirAutorDAO.InserirAutor(inserirAutorDTO);
    }
    
    public ResultSet ConsultarAutor(String autor){
       BaseDTO consultarAutorDTO = new BaseDTO();
       BaseDAO consultarAutorDAO = new BaseDAO();
     
       consultarAutorDTO.setAutor(autor);
       
       ResultSet rs;
       rs= consultarAutorDAO.ConsultarAutor(consultarAutorDTO);
       return rs;
    }
    
    public ResultSet ConsultarAutorAcervo(String isbn){
       BaseDTO consultarAutorAcervoDTO = new BaseDTO();
       BaseDAO consultarAutorAcervoDAO = new BaseDAO();
     
       consultarAutorAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarAutorAcervoDAO.ConsultarAutorAcervo(consultarAutorAcervoDTO);
       return rs;
    }
    
    public boolean InserirAutorAcervo(String isbn, String autor){
        BaseDTO inserirAutorAcervoDTO = new BaseDTO();
        BaseDAO inserirAutorAcervoDAO = new BaseDAO();
        
        inserirAutorAcervoDTO.setIsbn(isbn);
        inserirAutorAcervoDTO.setAutor(autor);
        
        return inserirAutorAcervoDAO.InserirAutorAcervo(inserirAutorAcervoDTO);
    }
    
    public boolean RemoverAutorAcervo(int id, String isbn){
        BaseDTO removerAutorAcervoDTO = new BaseDTO();
        BaseDAO removerAutorAcervoDAO = new BaseDAO();
        
        removerAutorAcervoDTO.setId(id);
        removerAutorAcervoDTO.setIsbn(isbn);
        
        if (removerAutorAcervoDAO.RemoverAutorAcervo(removerAutorAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    
    // Editora
    
    
    public boolean InserirEditora(String editora){
        BaseDTO inserirEditoraDTO = new BaseDTO();
        BaseDAO inserirEditoraDAO = new BaseDAO();
        
        inserirEditoraDTO.setEditora(editora);
        
        if (inserirEditoraDAO.InserirEditora(inserirEditoraDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarEditora(String editora){
       BaseDTO consultarEditoraDTO = new BaseDTO();
       BaseDAO consultarEditoraDAO = new BaseDAO();
     
       consultarEditoraDTO.setEditora(editora);
       
       ResultSet rs;
       rs= consultarEditoraDAO.ConsultarEditora(consultarEditoraDTO);
       return rs;
    }
    
    
    // Tipo Acervo
    
   
    public boolean InserirTipoAcervo(String acervo){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setTipo(acervo);
        
        if (inserirDAO.InserirTipoAcervo(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarTipoAcervo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setTipo(tipo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarTipoAcervo(consultarDTO);
       return rs;
    }
    
    // Classificação Literaria
    
    
    public boolean InserirClassLiteraria(String classliteraria){
        BaseDTO inserirClassLiterariaDTO = new BaseDTO();
        BaseDAO inserirClassLiterariaDAO = new BaseDAO();
        
        inserirClassLiterariaDTO.setClassliter(classliteraria);
        
        if (inserirClassLiterariaDAO.InserirClassLiteraria(inserirClassLiterariaDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarClassLiteraria(){
       BaseDTO consultarClassLiterariaDTO = new BaseDTO();
       BaseDAO consultarClassLiterariaDAO = new BaseDAO();
     
       //consultarClassLiterariaDTO.setClassliter(classliteraria);
       
       ResultSet rs;
       rs= consultarClassLiterariaDAO.ConsultarClassLiteraria(consultarClassLiterariaDTO);
       return rs;
    }
    
    public boolean InserirClassLiterariaAcervo(String isbn, String nome){
        BaseDTO inserirClassLiterariaAcervoDTO = new BaseDTO();
        BaseDAO inserirClassLiterariaAcervoDAO = new BaseDAO();
        
        inserirClassLiterariaAcervoDTO.setIsbn(isbn);
        inserirClassLiterariaAcervoDTO.setClassliter(nome);
        
        if (inserirClassLiterariaAcervoDAO.InserirClassLiterariaAcervo(inserirClassLiterariaAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarClassLiterAcervo(String isbn){
       BaseDTO consultarClassLiterAcervoDTO = new BaseDTO();
       BaseDAO consultarClassLiterAcervoDAO = new BaseDAO();
     
       consultarClassLiterAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarClassLiterAcervoDAO.ConsultarClassLiterAcervo(consultarClassLiterAcervoDTO);
       return rs;
    }
    
    public boolean RemoverClassLiterAcervo(int id, String isbn){
        BaseDTO removerClassLiterAcervoDTO = new BaseDTO();
        BaseDAO removerClassLiterAcervoDAO = new BaseDAO();
        
        removerClassLiterAcervoDTO.setId(id);
        removerClassLiterAcervoDTO.setIsbn(isbn);
        
        if (removerClassLiterAcervoDAO.RemoverClassLiterAcervo(removerClassLiterAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    
    // Coleção
    
    
    public boolean InserirColecao(String colecao){
        BaseDTO inserirColecaoDTO = new BaseDTO();
        BaseDAO inserirColecaoDAO = new BaseDAO();
        
        inserirColecaoDTO.setColecao(colecao);
        
        if (inserirColecaoDAO.InserirColecao(inserirColecaoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarColecao(String nome){
       BaseDTO consultarColecaoDTO = new BaseDTO();
       BaseDAO consultarColecaoDAO = new BaseDAO();
     
       consultarColecaoDTO.setColecao(nome);
       
       ResultSet rs;
       rs= consultarColecaoDAO.ConsultarColecao(consultarColecaoDTO);
       return rs;
    }
    
    
    // Tag
    
    
    public boolean InserirTag(String tag){
        BaseDTO inserirTagDTO = new BaseDTO();
        BaseDAO inserirTagDAO = new BaseDAO();
        
        inserirTagDTO.setTag(tag);
        
        if (inserirTagDAO.InserirTag(inserirTagDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarTag(String tag){
       BaseDTO consultarTagDTO = new BaseDTO();
       BaseDAO consultarTagDAO = new BaseDAO();
     
       consultarTagDTO.setTag(tag);
       
       ResultSet rs;
       rs= consultarTagDAO.ConsultarTag(consultarTagDTO);
       return rs;
    }
    
    public ResultSet ConsultarTagAcervo(String isbn){
       BaseDTO consultarTagAcervoDTO = new BaseDTO();
       BaseDAO consultarTagAcervoDAO = new BaseDAO();
     
       consultarTagAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarTagAcervoDAO.ConsultarTagAcervo(consultarTagAcervoDTO);
       return rs;
    }
    
    public boolean InserirTagAcervo(String isbn, String tag){
        BaseDTO inserirTagAcervoDTO = new BaseDTO();
        BaseDAO inserirTagAcervoDAO = new BaseDAO();
        
        inserirTagAcervoDTO.setIsbn(isbn);
        inserirTagAcervoDTO.setTag(tag);
        
        if (inserirTagAcervoDAO.InserirTagAcervo(inserirTagAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean RemoverTagAcervo(int id, String isbn){
        BaseDTO removerTagAcervoDTO = new BaseDTO();
        BaseDAO removerTagAcervoDAO = new BaseDAO();
        
        removerTagAcervoDTO.setId(id);
        removerTagAcervoDTO.setIsbn(isbn);
        
        if (removerTagAcervoDAO.RemoverTagAcervo(removerTagAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    // Gênero
    
    
    public boolean InserirGenero(String genero){
        BaseDTO inserirGeneroDTO = new BaseDTO();
        BaseDAO inserirGeneroDAO = new BaseDAO();
        
        inserirGeneroDTO.setGereno(genero);
        
        if (inserirGeneroDAO.InserirGenero(inserirGeneroDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarGenero(){
       BaseDTO consultarGeneroDTO = new BaseDTO();
       BaseDAO consultarGeneroDAO = new BaseDAO();
     
       //consultarGeneroDTO.setGereno(genero);
       
       ResultSet rs;
       rs= consultarGeneroDAO.ConsultarGenero(consultarGeneroDTO);
       return rs;
    }
    
    public ResultSet ConsultarGeneroAcervo(String isbn){
       BaseDTO consultarGeneroAcervoDTO = new BaseDTO();
       BaseDAO consultarGeneroAcervoDAO = new BaseDAO();
     
       consultarGeneroAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarGeneroAcervoDAO.ConsultarGeneroAcervo(consultarGeneroAcervoDTO);
       return rs;
    }
    
    public boolean InserirGeneroAcervo(String isbn, String genero){
        BaseDTO inserirGeneroAcervoDTO = new BaseDTO();
        BaseDAO inserirGeneroAcervoDAO = new BaseDAO();
        
        inserirGeneroAcervoDTO.setIsbn(isbn);
        inserirGeneroAcervoDTO.setGereno(genero);
        
        if (inserirGeneroAcervoDAO.InserirGeneroAcervo(inserirGeneroAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean RemoverGeneroAcervo(int id, String isbn){
        BaseDTO removerGeneroAcervoDTO = new BaseDTO();
        BaseDAO removerGeneroAcervoDAO = new BaseDAO();
        
        removerGeneroAcervoDTO.setId(id);
        removerGeneroAcervoDTO.setIsbn(isbn);
        
        if (removerGeneroAcervoDAO.RemoverGeneroAcervo(removerGeneroAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    // Edição
    
    
    
    public ResultSet ConsultarEdicaoAcervo(String isbn){
       BaseDTO consultarEdicaoAcervoDTO = new BaseDTO();
       BaseDAO consultarEdicaoAcervoDAO = new BaseDAO();
     
       consultarEdicaoAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarEdicaoAcervoDAO.ConsultarEdicaoAcervo(consultarEdicaoAcervoDTO);
       return rs;
    }
    
    public boolean InserirEdicaoAcervo(String isbn, String edicao_numero, String edicao_cidadeuf, String edicao_ano){
        BaseDTO inserirEdicaoAcervoDTO = new BaseDTO();
        BaseDAO inserirEdicaoAcervoDAO = new BaseDAO();
        
        inserirEdicaoAcervoDTO.setIsbn(isbn);
        inserirEdicaoAcervoDTO.setEdicao_numero(edicao_numero);
        inserirEdicaoAcervoDTO.setEdicao_cidadeuf(edicao_cidadeuf);
        inserirEdicaoAcervoDTO.setEdicao_ano(edicao_ano);
        
        if (inserirEdicaoAcervoDAO.InserirEdicaoAcervo(inserirEdicaoAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean RemoverEdicaoAcervo(int id, String isbn){
        BaseDTO removerEdicaoAcervoDTO = new BaseDTO();
        BaseDAO removerEdicaoAcervoDAO = new BaseDAO();
        
        removerEdicaoAcervoDTO.setId(id);
        removerEdicaoAcervoDTO.setIsbn(isbn);
        
        if (removerEdicaoAcervoDAO.RemoverEdicaoAcervo(removerEdicaoAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    
    // Outros
    
    
    public boolean InserirOutros(String tipo, String outro_tipo){
        BaseDTO inserirOutrosDTO = new BaseDTO();
        BaseDAO inserirOutrosDAO = new BaseDAO();
        
        inserirOutrosDTO.setTipo(tipo);
        inserirOutrosDTO.setOutros_tipo(outro_tipo);
        
        if (inserirOutrosDAO.InserirOutros(inserirOutrosDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarOutros(String tipo){
       BaseDTO consultarOutrosDTO = new BaseDTO();
       BaseDAO consultarOutrosDAO = new BaseDAO();
     
       consultarOutrosDTO.setTipo(tipo);
       
       ResultSet rs;
       rs= consultarOutrosDAO.ConsultarOutros(consultarOutrosDTO);
       return rs;
    }
    
    public ResultSet ConsultarOutrosAcervo(String isbn){
       BaseDTO consultarOutrosAcervoDTO = new BaseDTO();
       BaseDAO consultarOutrosAcervoDAO = new BaseDAO();
     
       consultarOutrosAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarOutrosAcervoDAO.ConsultarOutrosAcervo(consultarOutrosAcervoDTO);
       return rs;
    }
    
    public boolean InserirOutrosAcervo(String isbn, String outros_tipo, String outros_nome){
        BaseDTO inserirOutrosAcervoDTO = new BaseDTO();
        BaseDAO inserirOutrosAcervoDAO = new BaseDAO();
        
        inserirOutrosAcervoDTO.setIsbn(isbn);
        inserirOutrosAcervoDTO.setOutros_tipo(outros_tipo);
        inserirOutrosAcervoDTO.setOutros_nome(outros_nome);
        
        if (inserirOutrosAcervoDAO.InserirOutrosAcervo(inserirOutrosAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean RemoverOutrosAcervo(int id, String isbn){
        BaseDTO removerOutrosAcervoDTO = new BaseDTO();
        BaseDAO removerOutrosAcervoDAO = new BaseDAO();
        
        removerOutrosAcervoDTO.setId(id);
        removerOutrosAcervoDTO.setIsbn(isbn);
        
        if (removerOutrosAcervoDAO.RemoverOutrosAcervo(removerOutrosAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    // Acervo
    
    public boolean InserirAcervo(String isbn, String nome, String subtitulo, String tipo, String editora, String colecao, String paginas, String volume, String linguagem, String resumo){
        BaseDTO inserirAcervoDTO = new BaseDTO();
        BaseDAO inserirAcervoDAO = new BaseDAO();
        
        inserirAcervoDTO.setIsbn(isbn);
        inserirAcervoDTO.setNome(nome);
        inserirAcervoDTO.setSubtitulo(subtitulo);
        inserirAcervoDTO.setTipo(tipo);
        inserirAcervoDTO.setEditora(editora);
        inserirAcervoDTO.setColecao(colecao);
        inserirAcervoDTO.setPaginas(paginas);
        inserirAcervoDTO.setVolume(volume);
        inserirAcervoDTO.setLinguagem(linguagem);
        inserirAcervoDTO.setResumo(resumo);
        //inserirAcervoDTO.setObs(obs);
        
        
        if (inserirAcervoDAO.InserirAcervo(inserirAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean AlterarAcervo(String isbn, String nome, String subtitulo, String tipo, String editora, String colecao, String paginas, String volume, String linguagem, String resumo){
        BaseDTO alterarAcervoDTO = new BaseDTO();
        BaseDAO alterarAcervoDAO = new BaseDAO();
        
        alterarAcervoDTO.setIsbn(isbn);
        alterarAcervoDTO.setNome(nome);
        alterarAcervoDTO.setSubtitulo(subtitulo);
        alterarAcervoDTO.setTipo(tipo);
        alterarAcervoDTO.setEditora(editora);
        alterarAcervoDTO.setColecao(colecao);
        alterarAcervoDTO.setPaginas(paginas);
        alterarAcervoDTO.setVolume(volume);
        alterarAcervoDTO.setLinguagem(linguagem);
        alterarAcervoDTO.setResumo(resumo);
        //alterarAcervoDTO.setObs(obs);
        
        
        if (alterarAcervoDAO.AlterarAcervo(alterarAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarAcervoVerificador(String isbn){
       BaseDTO consultarAcervoDTO = new BaseDTO();
       BaseDAO consultarAcervoDAO = new BaseDAO();
     
       consultarAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarAcervoDAO.ConsultarAcervoVerificador(consultarAcervoDTO);
       return rs;
    }
    
    public ResultSet ConsultarAcervo(String isbn){
       BaseDTO consultarAcervoDTO = new BaseDTO();
       BaseDAO consultarAcervoDAO = new BaseDAO();
     
       consultarAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarAcervoDAO.ConsultarAcervo(consultarAcervoDTO);
       return rs;
    }
    
    // Acervo Consulta
    
    public ResultSet ConsultarAcervoBibliotecaTitulo(String nome){
       BaseDTO consultarAcervoDTO = new BaseDTO();
       BaseDAO consultarAcervoDAO = new BaseDAO();
     
       consultarAcervoDTO.setNome(nome);
       
       ResultSet rs;
       rs= consultarAcervoDAO.ConsultarAcervoBibliotecaTitulo(consultarAcervoDTO);
       return rs;
    }
    
    public ResultSet ConsultarAcervoBibliotecaTombo(String tombo){
       BaseDTO consultarAcervoDTO = new BaseDTO();
       BaseDAO consultarAcervoDAO = new BaseDAO();
     
       consultarAcervoDTO.setTombo(tombo);
       
       ResultSet rs;
       rs= consultarAcervoDAO.ConsultarAcervoBibliotecaTombo(consultarAcervoDTO);
       return rs;
    }
    
    public ResultSet ConsultarAcervoBibliotecaTombo2(){
       BaseDTO consultarAcervoDTO = new BaseDTO();
       BaseDAO consultarAcervoDAO = new BaseDAO();
     
       //consultarAcervoDTO.setTombo(tombo);
       
       ResultSet rs;
       rs= consultarAcervoDAO.ConsultarAcervoBibliotecaTombo2(consultarAcervoDTO);
       return rs;
    }
    
    
    // Aluno Consulta
    
    public ResultSet ConsultarAlunoNome(String nome){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_nome(nome);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAlunoNome(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarPessoaAniversario(int mes){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setAniversario(mes);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPessoaAniversario(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarPessoaNM(String nm){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_nascimento_multiplo(nm);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPessoaNM(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarAlunoRA(String uf, String ra){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(ra);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAlunoRA(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarPessoaBiblioteca(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPessoaBiblioteca(consultarDTO);
       return rs;
    }
    
    // Tombo
    
    
    public ResultSet ConsultarTomboAcervo(String isbn){
       BaseDTO consultarTomboAcervoDTO = new BaseDTO();
       BaseDAO consultarTomboAcervoDAO = new BaseDAO();
     
       consultarTomboAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= consultarTomboAcervoDAO.ConsultarTomboAcervo(consultarTomboAcervoDTO);
       return rs;
    }
    
    public ResultSet VerificarTomboAcervo(String tombo, String isbn){
       BaseDTO verificarTomboAcervoDTO = new BaseDTO();
       BaseDAO verificarTomboAcervoDAO = new BaseDAO();
     
       verificarTomboAcervoDTO.setTombo(tombo);
       verificarTomboAcervoDTO.setIsbn(isbn);
       
       ResultSet rs;
       rs= verificarTomboAcervoDAO.VerificarTomboAcervo(verificarTomboAcervoDTO);
       return rs;
    }
    
    public boolean InserirTomboAcervo(String isbn, String tombo){
        BaseDTO inserirTomboAcervoDTO = new BaseDTO();
        BaseDAO inserirTomboAcervoDAO = new BaseDAO();
        
        inserirTomboAcervoDTO.setIsbn(isbn);
        inserirTomboAcervoDTO.setTombo(tombo);
        //inserirTomboAcervoDTO.setQuantidade(qtd);
        
        if (inserirTomboAcervoDAO.InserirTomboAcervo(inserirTomboAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean RemoverTomboAcervo(int id, String isbn){
        BaseDTO removerTomboAcervoDTO = new BaseDTO();
        BaseDAO removerTomboAcervoDAO = new BaseDAO();
        
        removerTomboAcervoDTO.setId(id);
        removerTomboAcervoDTO.setIsbn(isbn);
        
        if (removerTomboAcervoDAO.RemoverTomboAcervo(removerTomboAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean AlterarTomboAcervo(String tombo, String isbn){
        BaseDTO alterarTomboAcervoDTO = new BaseDTO();
        BaseDAO alterarTomboAcervoDAO = new BaseDAO();
        
        alterarTomboAcervoDTO.setTombo(tombo);
        alterarTomboAcervoDTO.setIsbn(isbn);
        
        if (alterarTomboAcervoDAO.AlterarTomboAcervo(alterarTomboAcervoDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    
    // Relatar Entrada/Saída do Acervo
    
    
    public boolean InserirRelatarAcervo(String tombo, String pessoa_uf, String pessoa_id){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setTombo(tombo);
        inserirDTO.setPessoa_uf(pessoa_uf);
        inserirDTO.setPessoa_id(pessoa_id);
        
        if (inserirDAO.InserirRelatarAcervo(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean RemoverRelatarAcervo(int id){
        BaseDTO removerDTO = new BaseDTO();
        BaseDAO removerDAO = new BaseDAO();
        
        removerDTO.setId(id);
        
        if (removerDAO.RemoverRelatarAcervo(removerDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet ConsultarRelatarTombo(String tombo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setTombo(tombo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatarTombo(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarRelatarAcervoTombo(String relatarboolean, String nome){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setRelatarboolean(relatarboolean);
       consultarDTO.setNome(nome);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatarAcervoTombo(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarRelatarAcervoPessoa(String relatarboolena, String pessoa_nome){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setRelatarboolean(relatarboolena);
       consultarDTO.setPessoa_nome(pessoa_nome);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatarAcervoPessoa(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarRelatarPessoaNome(String pessoa_uf, String pessoa_id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(pessoa_uf);
       consultarDTO.setPessoa_id(pessoa_id);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatarPessoaNome(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificadorRelatarPessoa(String pessoa_uf, String pessoa_id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(pessoa_uf);
       consultarDTO.setPessoa_id(pessoa_id);
       
       ResultSet rs;
       rs= consultarDAO.VerificadorRelatarPessoa(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificadorRelatarPessoaDocente(String pessoa_uf, String pessoa_id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(pessoa_uf);
       consultarDTO.setPessoa_id(pessoa_id);
       
       ResultSet rs;
       rs= consultarDAO.VerificadorRelatarPessoaDocente(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificadorRelatarPessoaAluno(String pessoa_uf, String pessoa_id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(pessoa_uf);
       consultarDTO.setPessoa_id(pessoa_id);
       
       ResultSet rs;
       rs= consultarDAO.VerificadorRelatarPessoaAluno(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificadorRelatarTombo(String tombo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setTombo(tombo);
       
       ResultSet rs;
       rs= consultarDAO.VerificadorRelatarTombo(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarRelatarTomboTitulo(String tombo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setTombo(tombo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatarTomboTitulo(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarRelatoEntradaSaida(String tombo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setTombo(tombo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatoEntradaSaida(consultarDTO);
       return rs;
    }
    
    
    // Cadastrar Pessoa Empresa
    
    
    // Consultar Pessoa Empresa
    public ResultSet ConsultarPessoaEmpresa(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPessoaEmpresa(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificarPessoaEmpresa(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.VerificarPessoaEmpresa(consultarDTO);
       return rs;
    }
    
    public boolean AlterarPessoaEmpresa(String status, String uf, String id){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
        alterarDTO.setEmpresa_pessoa_status(status);
        alterarDTO.setPessoa_uf(uf);
        alterarDTO.setPessoa_id(id);
        
        if (alterarDAO.AlterarPessoaEmpresa(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean InserirPessoaEmpresa(String uf, String id){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
        //alterarDTO.setEmpresa_pessoa_status(status);
        alterarDTO.setPessoa_uf(uf);
        alterarDTO.setPessoa_id(id);
        
        if (alterarDAO.InserirPessoaEmpresa(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    // Pessoa
    
    
     // Inserir Pessoa
   public boolean InserirPessoaAluno(String uf, String id, String tipo, String prenome, String sobrenome, String agnome, String nome, String dn, String sexo, String cor, String estadocivil, String nascimentomultiplo, String cargo){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(id);
        inserirDTO.setPessoa_id_tipo(tipo);
        inserirDTO.setPessoa_prenome(prenome);
        inserirDTO.setPessoa_sobrenome(sobrenome);
        inserirDTO.setPessoa_agnome(agnome);
        inserirDTO.setPessoa_nome(nome);
        inserirDTO.setPessoa_dn(dn);
        inserirDTO.setPessoa_sexo(sexo);
        inserirDTO.setPessoa_cor(cor);
        inserirDTO.setPessoa_estado_civil(estadocivil);
        inserirDTO.setPessoa_nascimento_multiplo(nascimentomultiplo);
        inserirDTO.setEmpresa_pessoa_cargo(cargo);
        
        if (inserirDAO.InserirPessoaAluno(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public boolean AlterarPessoaAluno(String uf, String id, String tipo, String prenome, String sobrenome, String agnome, String nome, String dn, String sexo, String cor, String estadocivil, String nascimentomultiplo, String  cargo){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
        alterarDTO.setPessoa_uf(uf);
        alterarDTO.setPessoa_id(id);
        alterarDTO.setPessoa_id_tipo(tipo);
        alterarDTO.setPessoa_prenome(prenome);
        alterarDTO.setPessoa_sobrenome(sobrenome);
        alterarDTO.setPessoa_agnome(agnome);
        alterarDTO.setPessoa_nome(nome);
        alterarDTO.setPessoa_dn(dn);
        alterarDTO.setPessoa_sexo(sexo);
        alterarDTO.setPessoa_cor(cor);
        alterarDTO.setPessoa_estado_civil(estadocivil);
        alterarDTO.setPessoa_nascimento_multiplo(nascimentomultiplo);
        alterarDTO.setEmpresa_pessoa_cargo(cargo);
        
        if (alterarDAO.AlterarPessoaAluno(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Pessoa Senha
   public boolean InserirPessoaSenha(String uf, String id, String nome, String login, String senha){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(id);
        inserirDTO.setPessoa_nome(nome);
        inserirDTO.setPessoa_login(login);
        inserirDTO.setPessoa_senha(senha);
     
        
        if (inserirDAO.InserirPessoaSenha(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   // Verificar Pessoa Cadastrada
    public ResultSet VerificadorPessoa(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.VerificadorPessoa(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificadorPessoaStatus(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.VerificadorPessoaStatus(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificadorPessoaSenha(String uf, String id, String senha){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       consultarDTO.setPessoa_senha(senha);
       
       ResultSet rs;
       rs= consultarDAO.VerificadorPessoaSenha(consultarDTO);
       return rs;
    }
    
    public ResultSet ConsultarPessoaAluno(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPessoaAluno(consultarDTO);
       return rs;
    }
    
    
   //Religião
   // Inserir Religiao
   public boolean InserirReligiao(String religiao){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setReligiao_nome(religiao);
        
        if (inserirDAO.InserirReligiao(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Religiao
    public ResultSet ConsultarReligiao(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarReligiao(consultarDTO);
       return rs;
    }
    
    //Certificadora
   // Inserir Certificadora
   public boolean InserirCertificadora(String certificadora){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setCertificadora(certificadora);
        
        if (inserirDAO.InserirCertificadora(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Religiao
    public ResultSet ConsultarCertificadora(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarCertificadora(consultarDTO);
       return rs;
    }
    
    // Outros
    
    
    // Inserir Pais
   public boolean InserirPais(String pais){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEndereco_pais(pais);
        
        if (inserirDAO.InserirPais(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Pais
    public ResultSet ConsultarPais(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPais(consultarDTO);
       return rs;
    }
    
   // Inserir UF
   public boolean InserirUF(String pais, String uf, String descricao){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEndereco_pais(pais);
        inserirDTO.setEndereco_uf(uf);
        inserirDTO.setEndereco_uf_descricao(descricao);
        
        if (inserirDAO.InserirUF(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar UF
    public ResultSet ConsultarUF(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarUF(consultarDTO);
       return rs;
    }
    
    // Consultar UF2
    public ResultSet ConsultarUF2(String pais){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setEndereco_pais(pais);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarUF(consultarDTO);
       return rs;
    }
    
    // Inserir Cidade
   public boolean InserirCidade(String pais, String uf, String cidade){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEndereco_pais(pais);
        inserirDTO.setEndereco_uf(uf);
        inserirDTO.setEndereco_cidade(cidade);
        
        if (inserirDAO.InserirCidade(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Cidade
    public ResultSet ConsultarCidade(String pais, String uf){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
    
       consultarDTO.setEndereco_pais(pais);
       consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarCidade(consultarDTO);
       return rs;
    }
    
    // Inserir CEP
   public boolean InserirCEP(String pais, String uf, String cidade, String cep){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEndereco_pais(pais);
        inserirDTO.setEndereco_uf(uf);
        inserirDTO.setEndereco_cidade(cidade);
        inserirDTO.setEndereco_cep(cep);
        
        if (inserirDAO.InserirCEP(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar CEP
    public ResultSet ConsultarCEP(String pais, String uf, String cidade){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
    
       consultarDTO.setEndereco_pais(pais);
       consultarDTO.setEndereco_uf(uf);
       consultarDTO.setEndereco_cidade(cidade);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarCEP(consultarDTO);
       return rs;
    }
    
    // Inserir Bairro
   public boolean InserirBairro(String pais, String uf, String cidade, String cep, String zona, String bairro){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEndereco_pais(pais);
        inserirDTO.setEndereco_uf(uf);
        inserirDTO.setEndereco_cidade(cidade);
        inserirDTO.setEndereco_cep(cep);
        inserirDTO.setEndereco_zona(zona);
        inserirDTO.setEndereco_bairro(bairro);
        
        if (inserirDAO.InserirBairro(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Bairro
    public ResultSet ConsultarBairro(String pais, String uf, String cidade, String cep, String zona){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
    
       consultarDTO.setEndereco_pais(pais);
       consultarDTO.setEndereco_uf(uf);
       consultarDTO.setEndereco_cidade(cidade);
       consultarDTO.setEndereco_cep(cep);
       consultarDTO.setEndereco_zona(zona);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarBairro(consultarDTO);
       return rs;
    }
    
    // Inserir Logradouro
   public boolean InserirLogradouro(String pais, String uf, String cidade, String cep, String zona, String bairro, String logradouro){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEndereco_pais(pais);
        inserirDTO.setEndereco_uf(uf);
        inserirDTO.setEndereco_cidade(cidade);
        inserirDTO.setEndereco_cep(cep);
        inserirDTO.setEndereco_zona(zona);
        inserirDTO.setEndereco_bairro(bairro);
        inserirDTO.setEndereco_logradouro(logradouro);
        
        if (inserirDAO.InserirLogradouro(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Logradouro
    public ResultSet ConsultarLogradouro(String pais, String uf, String cidade, String cep, String zona, String bairro){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
    
       consultarDTO.setEndereco_pais(pais);
       consultarDTO.setEndereco_uf(uf);
       consultarDTO.setEndereco_cidade(cidade);
       consultarDTO.setEndereco_cep(cep);
       consultarDTO.setEndereco_zona(zona);
       consultarDTO.setEndereco_bairro(bairro);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarLogradouro(consultarDTO);
       return rs;
    }
    
    // Inserir Sexo
   public boolean InserirSexo(String sexo){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setSexo(sexo);
        
        if (inserirDAO.InserirSexo(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Sexo
    public ResultSet ConsultarSexo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       
       ResultSet rs;
       rs= consultarDAO.ConsultarSexo(consultarDTO);
       return rs;
    }
    
    // Consultar Nascimento Múltiplo
    public ResultSet ConsultarNascimentoMultiplo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarNascimentoMultiplo(consultarDTO);
       return rs;
    }
    
    // Consultar Médico
    public ResultSet ConsultarMedico(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarMedico(consultarDTO);
       return rs;
    }
    
    // Inserir Estado Civil
   public boolean InserirEstadoCivil(String ec){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPessoa_estado_civil(ec);
        
        if (inserirDAO.InserirEstadoCivil(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Estado Civil
    public ResultSet ConsultarEstadoCivil(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       
       ResultSet rs;
       rs= consultarDAO.ConsultarEstadoCivil(consultarDTO);
       return rs;
    }
    
    // Inserir Raça/Cor
   public boolean InserirRacaCor(String rc){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setRacacor(rc);
        
        if (inserirDAO.InserirRacaCor(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Raça/Cor
    public ResultSet ConsultarRacaCor(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setRacacor(rc);
       
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRacaCor(consultarDTO);
       return rs;
    }
    
    // Consultar Agnome
    public ResultSet ConsultarAgnome(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setRacacor(rc);
       
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAgnome(consultarDTO);
       return rs;
    }
    
    // Inserir Agnome
   public boolean InserirAgnome(String ag){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPessoa_agnome(ag);
        
        if (inserirDAO.InserirAgnome(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Consultar Empresa Cargo
    public ResultSet ConsultarEmpresaCargo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setRacacor(rc);
       
       
       ResultSet rs;
       rs= consultarDAO.ConsultarEmpresaCargo(consultarDTO);
       return rs;
    }
    
    // Inserir Empresa Cargo
   public boolean InserirEmpresaCargo(String cargo){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEmpresa_pessoa_cargo(cargo);
        
        if (inserirDAO.InserirEmpresaCargo(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
    // Telefone
    
   // Inserir Telefone Tipo
   public boolean InserirTelefoneTipo(String tipo){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setTelefone_tipo(tipo);
        
        if (inserirDAO.InserirTelefoneTipo(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
    // Consultar Telefone Tipo
    public ResultSet ConsultarTelefoneTipo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setTelefone_tipo(tipo);
       
       
       ResultSet rs;
       rs= consultarDAO.ConsultarTelefoneTipo(consultarDTO);
       return rs;
    }
    
   // Inserir Telefone Operadora
   public boolean InserirTelefoneOperadora(String Operadora){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setTelefone_operadora(Operadora);
        
        if (inserirDAO.InserirTelefoneOperadora(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
    // Consultar Telefone Operadora
    public ResultSet ConsultarTelefoneOperadora(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setTelefone_operadora(Operadora);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarTelefoneOperadora(consultarDTO);
       return rs;
    }
    
    // Inserir Telefone DDD
   public boolean InserirTelefoneDDD(String DDD){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setTelefone_ddd(DDD);
        
        if (inserirDAO.InserirTelefoneDDD(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
    // Consultar Telefone DDD
    public ResultSet ConsultarTelefoneDDD(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
      // consultarDTO.setTelefone_ddd(DDD);
       
       
       ResultSet rs;
       rs= consultarDAO.ConsultarTelefoneDDD(consultarDTO);
       return rs;
    }
    
    
    // Inserir Telefone Pessoa
   public boolean InserirTelefonePessoa(String uf, String id, String tipo, String operadora, String ddd, String numero, String ramal, String obs){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(id);
        inserirDTO.setTelefone_tipo(tipo);
        inserirDTO.setTelefone_operadora(operadora);
        inserirDTO.setTelefone_ddd(ddd);
        inserirDTO.setTelefone_numero(numero);
        inserirDTO.setTelefone_ramal(ramal);
        inserirDTO.setTelefone_obs(obs);
        
        if (inserirDAO.InserirTelefonePessoa(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
    // Consultar Telefone Pessoa
    public ResultSet ConsultarTelefonePessoa(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
        consultarDTO.setPessoa_uf(uf);
        consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarTelefonePessoa(consultarDTO);
       return rs;
    }
    
    //#########################################################################
   
// Inserir Pessoa Religião
   public boolean InserirPessoaReligiao(String uf, String id, String religiao, String obs){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(id);
        inserirDTO.setPessoa_religiao_nome(religiao);
        inserirDTO.setReligiao_obs(obs);
        
        if (inserirDAO.InserirPessoaReligiao(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
    //#########################################################################
    
    
   // Inserir Pessoa Endereço
   public boolean InserirPessoaEndereco(String uf, String id, String pais, String enduf, String cidade, String cep, String zona, String bairro, String logradouro, String numero, String complemento, String referencia){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(id);
        inserirDTO.setEndereco_pais(pais);
        inserirDTO.setEndereco_uf(enduf);
        inserirDTO.setEndereco_cidade(cidade);
        inserirDTO.setEndereco_cep(cep);
        inserirDTO.setEndereco_zona(zona);
        inserirDTO.setEndereco_bairro(bairro);
        inserirDTO.setEndereco_logradouro(logradouro);
        inserirDTO.setEndereco_numero(numero);
        inserirDTO.setEndereco_complemento(complemento);
        inserirDTO.setEndereco_referencia(referencia);
        
        if (inserirDAO.InserirPessoaEndereco(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   // Consultar Endereco Pessoa
    public ResultSet ConsultarEnderecoPessoa(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
        consultarDTO.setPessoa_uf(uf);
        consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarEnderecoPessoa(consultarDTO);
       return rs;
    }
    
    // Consultar Religião
    public ResultSet ConsultarReligiaoPessoa(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
        consultarDTO.setPessoa_uf(uf);
        consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarReligiaoPessoa(consultarDTO);
       return rs;
    }
    
    //#########################################################################
    
     // Planejamento da Rotina Semanal
   
    public ResultSet PlanejamentoRotinaSemanalCodigo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.
       
       ResultSet rs;
       rs= consultarDAO.PlanejamentoRotinaSemanalCodigo(consultarDTO);
       return rs;
    }
    
    public ResultSet MostrarDadosPRS(String uf, String rg){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(rg);
       
       ResultSet rs;
       rs= consultarDAO.MostrarDadosPRS(consultarDTO);
       return rs;
    }
    
    public ResultSet VerificarPlanejamento(int cod, String uf, String rg){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPrs_codigo(cod);
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(rg);
       
       ResultSet rs;
       rs= consultarDAO.VerificarPlanejamento(consultarDTO);
       return rs;
    }
    
   // Inserir Planejamento da Rotina Semanal
   public boolean InserirPlanejamentoRotinaSemanal(int cod, String data, String caderno, String periodo, String disciplina, String uf, String rg, String classe, String descricao){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setPrs_codigo(cod);
        inserirDTO.setPrs_data(data);
        inserirDTO.setPrs_caderno(caderno);
        inserirDTO.setSt_periodo(periodo);
        inserirDTO.setDisciplina(disciplina);
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(rg);
        inserirDTO.setSt_classe(classe);
        inserirDTO.setPrs_descricao(descricao);
        
        if (inserirDAO.InserirPlanejamentoRotinaSemanal(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   // Alterar Planejamento da Rotina Semanal
   public boolean AlterarPlanejamentoRotinaSemanal(int cod, String data, String caderno, String periodo, String disciplina, String uf, String rg, String classe, String descricao){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
        alterarDTO.setPrs_codigo(cod);
        alterarDTO.setPrs_data(data);
        alterarDTO.setPrs_caderno(caderno);
        alterarDTO.setSt_periodo(periodo);
        alterarDTO.setDisciplina(disciplina);
        alterarDTO.setPessoa_uf(uf);
        alterarDTO.setPessoa_id(rg);
        alterarDTO.setSt_classe(classe);
        alterarDTO.setPrs_descricao(descricao);
        
        
        if (alterarDAO.AlterarPlanejamentoRotinaSemanal(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   // Remover Planejamento da Rotina Semanal
   public boolean RemoverPlanejamentoRotinaSemanal(int cod, String uf, String rg){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
        alterarDTO.setPrs_codigo(cod);
        alterarDTO.setPessoa_uf(uf);
        alterarDTO.setPessoa_id(rg);
        
        
        if (alterarDAO.RemoverPlanejamentoRotinaSemanal(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   // Consultar Planejamento da Rotina Semanal
   public ResultSet ConsultarPlanejamentoRotinaSemanal(int codigo, String uf, String rg){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPrs_codigo(codigo);
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(rg);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPlanejamentoRotinaSemanal(consultarDTO);
       return rs;
    }
   
    //#########################################################################
    
    // Relatório do Aluno
   
    public ResultSet EmpresaRelatosCodigo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setAluno_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.EmpresaRelatosCodigo(consultarDTO);
       return rs;
    }
    
    
   // Inserir Relatório Individual do Aluno
   public boolean InserirRelatorioIndividualAluno(int id, String des1, String data){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEmpresa_relatos_id(id);
        inserirDTO.setEmpresa_relatos_descricao1(des1);
        inserirDTO.setEmpresa_relatos_dataf(data);
        
        if (inserirDAO.InserirRelatorioIndividualAluno(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   // Inserir Código do Relatório Empresa Relatos a Pessoa
   public boolean InserirEmpresaRelatosPessoa(int id, String uf, String numero){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEmpresa_relatos_id(id);
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(numero);
        
        if (inserirDAO.InserirEmpresaRelatosPessoa(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarRelatoriosAluno(String uf, String ra){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setAluno_uf(uf);
       consultarDTO.setAluno_id(ra);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatoriosAluno(consultarDTO);
       return rs;
    }
   
   public ResultSet ConsultarRelatoriosAluno2(String uf, String ra){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setAluno_uf(uf);
       consultarDTO.setAluno_id(ra);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatoriosAluno2(consultarDTO);
       return rs;
    }
   
   public ResultSet ConsultarRelatoriosDocente(String uf, String rg){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(rg);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatoriosDocente(consultarDTO);
       return rs;
    }
   
   public ResultSet ConsultarRelatosDocente(int codigo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setEmpresa_relatos_id(codigo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatosDocente(consultarDTO);
       return rs;
    }
   
   public ResultSet ConsultarRelatosAluno(int codigo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setEmpresa_relatos_id(codigo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatosAluno(consultarDTO);
       return rs;
    }
   
   public ResultSet ConsultarRelatos(int codigo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setEmpresa_relatos_id(codigo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarRelatos(consultarDTO);
       return rs;
    }
   
   public ResultSet VerificaConsultaRelatos(int codigo, String uf, String rg){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setEmpresa_relatos_id(codigo);
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(rg);
       
       ResultSet rs;
       rs= consultarDAO.VerificaConsultaRelatos(consultarDTO);
       return rs;
    }
   
   public boolean InserirVisualizacaoDocente(int id, String uf, String numero){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEmpresa_relatos_id(id);
        inserirDTO.setPessoa_uf(uf);
        inserirDTO.setPessoa_id(numero);
        
        if (inserirDAO.InserirVisualizacaoDocente(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet AlunosVistosDocente(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.AlunosVistosDocente(consultarDTO);
       return rs;
    }
   
   public ResultSet AlunosNaoVistosDocente(String uf, String id){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       
       ResultSet rs;
       rs= consultarDAO.AlunosNaoVistosDocente(consultarDTO);
       return rs;
    }
   
   //#########################################################################
   
   // Série/Turma
   
   
   //Ano Letivo
   public boolean InserirAnoLetivo(Integer ano){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setSt_anoletivo(ano);
        
        if (inserirDAO.InserirAnoLetivo(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarAnoLetivo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setSt_anoletivo(ano);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAnoLetivo(consultarDTO);
       return rs;
    }
   
   
   // Ensino
   public boolean InserirEnsino(String ensino){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setSt_ensino(ensino);
        
        if (inserirDAO.InserirEnsino(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarEnsino(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setSt_anoletivo(ano);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarEnsino(consultarDTO);
       return rs;
    }
   
   // Série
   public boolean InserirSerie(String ensino, String serie){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setSt_ensino(ensino);
        inserirDTO.setSt_serie(serie);
        
        if (inserirDAO.InserirSerie(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarSerie(String ensino){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setSt_ensino(ensino);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarSerie(consultarDTO);
       return rs;
    }
   
   // Período
   public boolean InserirPeriodo(String periodo){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setSt_periodo(periodo);
        
        if (inserirDAO.InserirPeriodo(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarPeriodo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setSt_anoletivo(ano);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarPeriodo(consultarDTO);
       return rs;
    }
   
   // Turma
   public boolean InserirTurma(Integer ano, String periodo, String ensino, String serie, String turma){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setSt_anoletivo(ano);
        inserirDTO.setSt_periodo(periodo);
        inserirDTO.setSt_ensino(ensino);
        inserirDTO.setSt_serie(serie);
        inserirDTO.setSt_turma(turma);
        
        if (inserirDAO.InserirTurma(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarTurma(Integer ano, String periodo, String ensino, String serie){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
        consultarDTO.setSt_anoletivo(ano);
        consultarDTO.setSt_periodo(periodo);
        consultarDTO.setSt_ensino(ensino);
        consultarDTO.setSt_serie(serie);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarTurma(consultarDTO);
       return rs;
    }
   
   // Empresa Sala
   public boolean InserirEmpresaSala(String numero){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setEmpresa_sala_numero(numero);
        
        if (inserirDAO.InserirEmpresaSala(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarEmpresaSala(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEmpresa_sala_numero(numero);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarEmpresaSala(consultarDTO);
       return rs;
    }
   
   // Disciplina
   public boolean InserirDisciplina(String nome){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setDisciplina(nome);
        
        if (inserirDAO.InserirDisciplina(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet ConsultarDisciplina(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEmpresa_sala_numero(numero);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarDisciplina(consultarDTO);
       return rs;
    }
   
   public ResultSet VerificarClasse(String classe){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setSt_classe(classe);
       
       ResultSet rs;
       rs= consultarDAO.VerificarClasse(consultarDTO);
       return rs;
    }
   
   // Inserir Classe
   public boolean InserirClasse(String classe, String ensino, String serie, String turma, String periodo, int anoletivo, String sala, String horainicio, String horafim, String obs){
        BaseDTO inserirDTO = new BaseDTO();
        BaseDAO inserirDAO = new BaseDAO();
        
        inserirDTO.setSt_classe(classe);
        inserirDTO.setSt_ensino(ensino);
        inserirDTO.setSt_serie(serie);
        inserirDTO.setSt_turma(turma);
        inserirDTO.setSt_periodo(periodo);
        inserirDTO.setSt_anoletivo(anoletivo);
        inserirDTO.setSt_sala(sala);
        inserirDTO.setSt_horario_inicio(horainicio);
        inserirDTO.setSt_horario_fim(horafim);
        inserirDTO.setSt_obs(obs);
        
        if (inserirDAO.InserirClasse(inserirDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   // Alterar Classe
   public boolean AlterarClasse(String classe, String ensino, String serie, String turma, String periodo, int anoletivo, String sala, String horainicio, String horafim, String obs){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
        alterarDTO.setSt_classe(classe);
        alterarDTO.setSt_ensino(ensino);
        alterarDTO.setSt_serie(serie);
        alterarDTO.setSt_turma(turma);
        alterarDTO.setSt_periodo(periodo);
        alterarDTO.setSt_anoletivo(anoletivo);
        alterarDTO.setSt_sala(sala);
        alterarDTO.setSt_horario_inicio(horainicio);
        alterarDTO.setSt_horario_fim(horafim);
        alterarDTO.setSt_obs(obs);
        
        if (alterarDAO.AlterarClasse(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
    
   public ResultSet MostrarDadosClasse(int ano){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setSt_anoletivo(ano);
       
       ResultSet rs;
       rs= consultarDAO.MostrarDadosClasse(consultarDTO);
       return rs;
    }

   public ResultSet MostrarAlunosClasse(String classe){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setSt_classe(classe);
       
       ResultSet rs;
       rs= consultarDAO.MostrarAlunosClasse(consultarDTO);
       return rs;
    }
   
   // Inserir Aluno Classe
   public boolean InserirAlunoClasse(String classe, String uf, String id, Integer nchamada, String transf, String rem, String sit, String def, String obs){
       BaseDTO inserirDTO = new BaseDTO();
       BaseDAO inserirDAO = new BaseDAO();
       
       inserirDTO.setSt_classe(classe);
       inserirDTO.setAluno_uf(uf);
       inserirDTO.setAluno_id(id);
       inserirDTO.setAluno_classe_nchamada(nchamada);
       inserirDTO.setAluno_classe_transf(transf);
       inserirDTO.setAluno_classe_rem(rem);
       inserirDTO.setAluno_classe_sit(sit);
       inserirDTO.setAluno_classe_def(def);
       inserirDTO.setAluno_classe_obs(obs);
       
       if (inserirDAO.InserirAlunoClasse(inserirDTO)){
           return true;
       }
       else{
           return false;
       }
   }
   
   public ResultSet ConsultarListaTelefonicaNome(String nome){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_nome(nome);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarListaTelefonicaNome(consultarDTO);
       return rs;
    }
   
   public ResultSet ConsultarListaTelefonicaNumero(String numero){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setTelefone_numero(numero);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarListaTelefonicaNumero(consultarDTO);
       return rs;
    }
   
   public boolean RemoverTelefonePessoa(int codigo){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
        alterarDTO.setTelefone_id(codigo);
        
        if (alterarDAO.RemoverTelefonePessoa(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   public ResultSet VerificarTelefonePessoa(String uf, String id, String ddd, String telefone, String ramal){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setPessoa_uf(uf);
       consultarDTO.setPessoa_id(id);
       consultarDTO.setTelefone_ddd(ddd);
       consultarDTO.setTelefone_numero(telefone);
       consultarDTO.setTelefone_ramal(ramal);
       
       ResultSet rs;
       rs= consultarDAO.VerificarTelefonePessoa(consultarDTO);
       return rs;
    }
   
   public boolean RecuperarTelefonePessoa(String uf, String id, String ddd, String telefone, String ramal){
        BaseDTO alterarDTO = new BaseDTO();
        BaseDAO alterarDAO = new BaseDAO();
        
       alterarDTO.setPessoa_uf(uf);
       alterarDTO.setPessoa_id(id);
       alterarDTO.setTelefone_ddd(ddd);
       alterarDTO.setTelefone_numero(telefone);
       alterarDTO.setTelefone_ramal(ramal);
        
        if (alterarDAO.RecuperarTelefonePessoa(alterarDTO)){
            return true;
        }else{
            return false;
        }
    }
   
   // Consultar Auto Marca
    public ResultSet ConsultarAutoMarca(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAutoMarca(consultarDTO);
       return rs;
    }
   
    // Consultar Auto Tipo
    public ResultSet ConsultarAutoTipo(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAutoTipo(consultarDTO);
       return rs;
    }
   
    // Consultar Auto Combustível
    public ResultSet ConsultarAutoCombustivel(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAutoCombustivel(consultarDTO);
       return rs;
    }
    
     // Consultar Auto Cor
    public ResultSet ConsultarAutoCor(){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       //consultarDTO.setEndereco_uf(uf);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAutoCor(consultarDTO);
       return rs;
    }
    
     // Consultar Auto Modelo
    public ResultSet ConsultarAutoModelo(String modelo){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setAuto_modelo(modelo);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAutoModelo(consultarDTO);
       return rs;
    }
    
     // Consultar Auto Modelo
    public ResultSet ConsultarAutoStilo(String modelo, String marca){
       BaseDTO consultarDTO = new BaseDTO();
       BaseDAO consultarDAO = new BaseDAO();
     
       consultarDTO.setAuto_modelo(modelo);
       consultarDTO.setAuto_marca(marca);
       
       ResultSet rs;
       rs= consultarDAO.ConsultarAutoStilo(consultarDTO);
       return rs;
    }
}
