/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base.dto;

/**
 *
 * @author Douglas Estanislau Pereira
 */
public class BaseDTO {
    
    public BaseDTO(){
        
    }
    
    // Acervo
    private int id;
    private String isbn; //Código do Livro ex: 9999999999999 (10 ou 13)
    private String nome; //Nome do Livro ex: Memórias de Brás Cubas
    private String subtitulo;
    private String colecao; //Nome da Coleção do Livro ex: Cubas
    private String tipo; //Tipo do Livro ex: Livro, Dicionário, Revista
    private String paginas; //Número de Páginas do Livro ex: 80 páginas
    private String volume; //Volume do Livro ex: Volume 1 ou Volume 2...
    private String linguagem; //Linguaguem do Livro ex: português, inglês...
    private String resumo; //Resumo do Livro ex: "este livro conta que havia..."
    private String obs; //Marcar alguma Observação do Livro
    private String autor; //Autor do Livro ex: Brás Cubas
    private String editora; //Editora do Livro ex: Era
    private String tag; //referência para o Livro ex: Aventura, Animais
    private String gereno; //Gênero para o Livro ex: Romance
    private String classliter; //Classificação Literaria do Livro
    private String edicao_numero; //Edição do Livro ex: 9° Edição, São Paulo, 1999
    private String edicao_cidadeuf;
    private String edicao_ano;
    private String outros_tipo; //Outros conteúdos ex: Capa e Ilustração: Marcelo Borges
    private String outros_nome;
    private String tombo;
    private int quantidade;
    private String relatarboolean;

    // Pessoa
    private String pessoa_uf; //SP
    private String pessoa_id; //402265506
    private String pessoa_id_tipo; //RG
    private String pessoa_prenome; //Douglas Estanislau
    private String pessoa_sobrenome; //Pereira
    private String pessoa_agnome; //Neto, Filho, Júnior
    private String pessoa_nome; //Douglas Estanislau Pereira
    private String pessoa_sexo; //Masculino ou Feminino
    private String pessoa_dn; //17-10-1987
    private String pessoa_cor; //Cor/Raça: Branca, Negra
    private String pessoa_apelido; //Droga
    private String pessoa_login; //douglairstan
    private String pessoa_senha; //hash md5
    private String pessoa_nascimento_multiplo; //UNICO
    private String pessoa_estado_civil;//Casado
    
    
    private String pessoa_religiao_nome;//Congregação Cristã no Brasil
    private String pessoa_religiao_obs;
    
    private String religiao_nome;
    private String religiao_obs;
    private String certificadora;
    //private Float pessoa_codigo;
    
    
    // Pessoa Física
    
    //Médico
    private String medico_nome; //dr. luiz ramim
    private String medico_codigo; //123456
    private String medico_tipo; //crmsp
    private String medico_sexo; //F
    
    
    // Pessoa Jurídica
    
    
    // Aluno
    private String aluno_uf;//SP
    private String aluno_id;//103568965X
    private String aluno_relatorio_individual;
    private int empresa_relatos_id;
    private String empresa_relatos_tipo1;
    private String empresa_relatos_tipo2;
    private String empresa_relatos_descricao1;
    private String empresa_relatos_descricao2;
    private String empresa_relatos_descricao3;
    private String empresa_relatos_descricao4;
    private String empresa_relatos_dataf;
    
    
    
    // Professor
    
    // Raça/Cor
    private String racacor;
    
    //Sexo
    private String sexo;
    
    // Endereço
    private String endereco_pais; //Brasil
    private String endereco_uf; //Unidade Federativa SP, MG, RJ...
    private String endereco_uf_descricao;
    private String endereco_estado; //SÃO PAULO
    private String endereco_cidade; //OUROESTE OU CIDADE/DISTRITO: OUROESTE/ARABÁ
    private String endereco_cep; //15685-000
    private String endereco_zona; //URBANA
    private String endereco_bairro; //Res. Rodrigues
    private String endereco_logradouro; //Rua Osmária Corrêa de Morais Rezende
    private String endereco_numero; //1516
    private String endereco_complemento; //Prédio 
    private String endereco_referencia;
    private String endereco_obs; //
    
    // Telefone
    private int telefone_id;
    private String telefone_ddd;//17
    private String telefone_operadora;//VIVO
    private String telefone_tipo;//CELULAR
    private String telefone_numero;//997848613
    private String telefone_ramal;//
    private String telefone_obs;//
    
    // Série/Turma
    //private Integer st_ano;
    private String st_classe;// 152224747
    private Integer st_anoletivo;//2014
    private String st_ensino;//FUNDAMENTAL I
    private String st_serie;//1, 2, 3, 4 e 5
    private String st_periodo;//MATUTINO
    private String st_turma;//A
    private String st_sala;//1
    private String st_horario_inicio;//07:10
    private String st_horario_fim;//11:40
    private String st_obs;
    private String disciplina;//Matemática, Ciências...
    
    // Aluno Classe
    private Integer aluno_classe_nchamada;
    private String aluno_classe_transf;
    private String aluno_classe_rem;
    private String aluno_classe_sit;
    private String aluno_classe_def;
    private String aluno_classe_obs;
    
    //Planejamento da Rotina Semanal
    private int prs_codigo;
    private String prs_data;
    private String prs_caderno;
    private String prs_descricao;
    
    // Empresa
    private String empresa_cnpj;
    private String empresa_nome;
    private String empresa_inep;
    private String empresa_sala_numero;
    private String empresa_pessoa_status;
    private String empresa_pessoa_cargo;
    private String empresa_pessoa_funcao;
    
    
    //Carro Moto Caminhão
    private String auto_placa; //DSC-0000
    private String auto_tipo; //Carro ou Moto
    private String auto_marca; //Ford
    private String auto_modelo; //Fiesta
    private String auto_stilo; //Hatch ou Sedan
    private String auto_cor; //Prata
    private String auto_motor; //1 8V ou 1.4 8V ou 1.5 8V ou 1.6  8V ou 2.0 16V
    
    
    private int aniversario;
    
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the coleca
     */
    public String getColecao() {
        return colecao;
    }

    /**
     * @param colecao the coleca to set
     */
    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the paginas
     */
    public String getPaginas() {
        return paginas;
    }

    /**
     * @param paginas the paginas to set
     */
    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the linguagem
     */
    public String getLinguagem() {
        return linguagem;
    }

    /**
     * @param linguagem the linguagem to set
     */
    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the classliter
     */
    public String getClassliter() {
        return classliter;
    }

    /**
     * @param classliter the classliter to set
     */
    public void setClassliter(String classliter) {
        this.classliter = classliter;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the gereno
     */
    public String getGereno() {
        return gereno;
    }

    /**
     * @param gereno the gereno to set
     */
    public void setGereno(String gereno) {
        this.gereno = gereno;
    }

    /**
     * @return the edicao_numero
     */
    public String getEdicao_numero() {
        return edicao_numero;
    }

    /**
     * @param edicao_numero the edicao_numero to set
     */
    public void setEdicao_numero(String edicao_numero) {
        this.edicao_numero = edicao_numero;
    }

    /**
     * @return the edicao_cidadeuf
     */
    public String getEdicao_cidadeuf() {
        return edicao_cidadeuf;
    }

    /**
     * @param edicao_cidadeuf the edicao_cidadeuf to set
     */
    public void setEdicao_cidadeuf(String edicao_cidadeuf) {
        this.edicao_cidadeuf = edicao_cidadeuf;
    }

    /**
     * @return the edicao_ano
     */
    public String getEdicao_ano() {
        return edicao_ano;
    }

    /**
     * @param edicao_ano the edicao_ano to set
     */
    public void setEdicao_ano(String edicao_ano) {
        this.edicao_ano = edicao_ano;
    }

    /**
     * @return the outros_tipo
     */
    public String getOutros_tipo() {
        return outros_tipo;
    }

    /**
     * @param outros_tipo the outros_tipo to set
     */
    public void setOutros_tipo(String outros_tipo) {
        this.outros_tipo = outros_tipo;
    }

    /**
     * @return the outros_nome
     */
    public String getOutros_nome() {
        return outros_nome;
    }

    /**
     * @param outros_nome the outros_nome to set
     */
    public void setOutros_nome(String outros_nome) {
        this.outros_nome = outros_nome;
    }

    /**
     * @return the tombo
     */
    public String getTombo() {
        return tombo;
    }

    /**
     * @param tombo the tombo to set
     */
    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the subtitulo
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * @param subtitulo the subtitulo to set
     */
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    /**
     * @return the relatarboolean
     */
    public String getRelatarboolean() {
        return relatarboolean;
    }

    /**
     * @param relatarboolean the relatarboolean to set
     */
    public void setRelatarboolean(String relatarboolean) {
        this.relatarboolean = relatarboolean;
    }

    /**
     * @return the pessoa_uf
     */
    public String getPessoa_uf() {
        return pessoa_uf;
    }

    /**
     * @param pessoa_uf the pessoa_uf to set
     */
    public void setPessoa_uf(String pessoa_uf) {
        this.pessoa_uf = pessoa_uf;
    }


    /**
     * @return the pessoa_prenome
     */
    public String getPessoa_prenome() {
        return pessoa_prenome;
    }

    /**
     * @param pessoa_prenome the pessoa_prenome to set
     */
    public void setPessoa_prenome(String pessoa_prenome) {
        this.pessoa_prenome = pessoa_prenome;
    }

    /**
     * @return the pessoa_sobrenome
     */
    public String getPessoa_sobrenome() {
        return pessoa_sobrenome;
    }

    /**
     * @param pessoa_sobrenome the pessoa_sobrenome to set
     */
    public void setPessoa_sobrenome(String pessoa_sobrenome) {
        this.pessoa_sobrenome = pessoa_sobrenome;
    }

    /**
     * @return the pessoa_agnome
     */
    public String getPessoa_agnome() {
        return pessoa_agnome;
    }

    /**
     * @param pessoa_agnome the pessoa_agnome to set
     */
    public void setPessoa_agnome(String pessoa_agnome) {
        this.pessoa_agnome = pessoa_agnome;
    }

    /**
     * @return the pessoa_nome
     */
    public String getPessoa_nome() {
        return pessoa_nome;
    }

    /**
     * @param pessoa_nome the pessoa_nome to set
     */
    public void setPessoa_nome(String pessoa_nome) {
        this.pessoa_nome = pessoa_nome;
    }

    /**
     * @return the racacor
     */
    public String getRacacor() {
        return racacor;
    }

    /**
     * @param racacor the racacor to set
     */
    public void setRacacor(String racacor) {
        this.racacor = racacor;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the pessoa_sexo
     */
    public String getPessoa_sexo() {
        return pessoa_sexo;
    }

    /**
     * @param pessoa_sexo the pessoa_sexo to set
     */
    public void setPessoa_sexo(String pessoa_sexo) {
        this.pessoa_sexo = pessoa_sexo;
    }

    /**
     * @return the pessoa_dn
     */
    public String getPessoa_dn() {
        return pessoa_dn;
    }

    /**
     * @param pessoa_dn the pessoa_dn to set
     */
    public void setPessoa_dn(String pessoa_dn) {
        this.pessoa_dn = pessoa_dn;
    }

    /**
     * @return the pessoa_cor
     */
    public String getPessoa_cor() {
        return pessoa_cor;
    }

    /**
     * @param pessoa_cor the pessoa_cor to set
     */
    public void setPessoa_cor(String pessoa_cor) {
        this.pessoa_cor = pessoa_cor;
    }

    /**
     * @return the pessoa_apelido
     */
    public String getPessoa_apelido() {
        return pessoa_apelido;
    }

    /**
     * @param pessoa_apelido the pessoa_apelido to set
     */
    public void setPessoa_apelido(String pessoa_apelido) {
        this.pessoa_apelido = pessoa_apelido;
    }

    /**
     * @return the endereco_pais
     */
    public String getEndereco_pais() {
        return endereco_pais;
    }

    /**
     * @param endereco_pais the endereco_pais to set
     */
    public void setEndereco_pais(String endereco_pais) {
        this.endereco_pais = endereco_pais;
    }

    /**
     * @return the endereco_estado
     */
    public String getEndereco_estado() {
        return endereco_estado;
    }

    /**
     * @param endereco_estado the endereco_estado to set
     */
    public void setEndereco_estado(String endereco_estado) {
        this.endereco_estado = endereco_estado;
    }

    /**
     * @return the endereco_cidade
     */
    public String getEndereco_cidade() {
        return endereco_cidade;
    }

    /**
     * @param endereco_cidade the endereco_cidade to set
     */
    public void setEndereco_cidade(String endereco_cidade) {
        this.endereco_cidade = endereco_cidade;
    }

    /**
     * @return the endereco_cep
     */
    public String getEndereco_cep() {
        return endereco_cep;
    }

    /**
     * @param endereco_cep the endereco_cep to set
     */
    public void setEndereco_cep(String endereco_cep) {
        this.endereco_cep = endereco_cep;
    }

    /**
     * @return the endereco_zona
     */
    public String getEndereco_zona() {
        return endereco_zona;
    }

    /**
     * @param endereco_zona the endereco_zona to set
     */
    public void setEndereco_zona(String endereco_zona) {
        this.endereco_zona = endereco_zona;
    }

    /**
     * @return the endereco_bairro
     */
    public String getEndereco_bairro() {
        return endereco_bairro;
    }

    /**
     * @param endereco_bairro the endereco_bairro to set
     */
    public void setEndereco_bairro(String endereco_bairro) {
        this.endereco_bairro = endereco_bairro;
    }

    /**
     * @return the endereco_logradouro
     */
    public String getEndereco_logradouro() {
        return endereco_logradouro;
    }

    /**
     * @param endereco_logradouro the endereco_logradouro to set
     */
    public void setEndereco_logradouro(String endereco_logradouro) {
        this.endereco_logradouro = endereco_logradouro;
    }

    /**
     * @return the endereco_numero
     */
    public String getEndereco_numero() {
        return endereco_numero;
    }

    /**
     * @param endereco_numero the endereco_numero to set
     */
    public void setEndereco_numero(String endereco_numero) {
        this.endereco_numero = endereco_numero;
    }

    /**
     * @return the endereco_complemento
     */
    public String getEndereco_complemento() {
        return endereco_complemento;
    }

    /**
     * @param endereco_complemento the endereco_complemento to set
     */
    public void setEndereco_complemento(String endereco_complemento) {
        this.endereco_complemento = endereco_complemento;
    }

    /**
     * @return the endereco_obs
     */
    public String getEndereco_obs() {
        return endereco_obs;
    }

    /**
     * @param endereco_obs the endereco_obs to set
     */
    public void setEndereco_obs(String endereco_obs) {
        this.endereco_obs = endereco_obs;
    }

    /**
     * @return the endereco_uf
     */
    public String getEndereco_uf() {
        return endereco_uf;
    }

    /**
     * @param endereco_uf the endereco_uf to set
     */
    public void setEndereco_uf(String endereco_uf) {
        this.endereco_uf = endereco_uf;
    }

    /**
     * @return the pessoa_id
     */
    public String getPessoa_id() {
        return pessoa_id;
    }

    /**
     * @param pessoa_id the pessoa_id to set
     */
    public void setPessoa_id(String pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    /**
     * @return the pessoa_id_tipo
     */
    public String getPessoa_id_tipo() {
        return pessoa_id_tipo;
    }

    /**
     * @param pessoa_id_tipo the pessoa_id_tipo to set
     */
    public void setPessoa_id_tipo(String pessoa_id_tipo) {
        this.pessoa_id_tipo = pessoa_id_tipo;
    }

    /**
     * @return the telefone_ddd
     */
    public String getTelefone_ddd() {
        return telefone_ddd;
    }

    /**
     * @param telefone_ddd the telefone_ddd to set
     */
    public void setTelefone_ddd(String telefone_ddd) {
        this.telefone_ddd = telefone_ddd;
    }

    /**
     * @return the telefone_operadora
     */
    public String getTelefone_operadora() {
        return telefone_operadora;
    }

    /**
     * @param telefone_operadora the telefone_operadora to set
     */
    public void setTelefone_operadora(String telefone_operadora) {
        this.telefone_operadora = telefone_operadora;
    }

    /**
     * @return the telefone_tipo
     */
    public String getTelefone_tipo() {
        return telefone_tipo;
    }

    /**
     * @param telefone_tipo the telefone_tipo to set
     */
    public void setTelefone_tipo(String telefone_tipo) {
        this.telefone_tipo = telefone_tipo;
    }

    /**
     * @return the telefone_numero
     */
    public String getTelefone_numero() {
        return telefone_numero;
    }

    /**
     * @param telefone_numero the telefone_numero to set
     */
    public void setTelefone_numero(String telefone_numero) {
        this.telefone_numero = telefone_numero;
    }

    /**
     * @return the telefone_ramal
     */
    public String getTelefone_ramal() {
        return telefone_ramal;
    }

    /**
     * @param telefone_ramal the telefone_ramal to set
     */
    public void setTelefone_ramal(String telefone_ramal) {
        this.telefone_ramal = telefone_ramal;
    }

    /**
     * @return the telefone_obs
     */
    public String getTelefone_obs() {
        return telefone_obs;
    }

    /**
     * @param telefone_obs the telefone_obs to set
     */
    public void setTelefone_obs(String telefone_obs) {
        this.telefone_obs = telefone_obs;
    }

    /**
     * @return the pessoa_senha
     */
    public String getPessoa_senha() {
        return pessoa_senha;
    }

    /**
     * @param pessoa_senha the pessoa_senha to set
     */
    public void setPessoa_senha(String pessoa_senha) {
        this.pessoa_senha = pessoa_senha;
    }

    /**
     * @return the aluno_relatorio_individual
     */
    public String getAluno_relatorio_individual() {
        return aluno_relatorio_individual;
    }

    /**
     * @param aluno_relatorio_individual the aluno_relatorio_individual to set
     */
    public void setAluno_relatorio_individual(String aluno_relatorio_individual) {
        this.aluno_relatorio_individual = aluno_relatorio_individual;
    }

    /**
     * @return the aluno_uf
     */
    public String getAluno_uf() {
        return aluno_uf;
    }

    /**
     * @param aluno_uf the aluno_uf to set
     */
    public void setAluno_uf(String aluno_uf) {
        this.aluno_uf = aluno_uf;
    }

    /**
     * @return the aluno_id
     */
    public String getAluno_id() {
        return aluno_id;
    }

    /**
     * @param aluno_id the aluno_id to set
     */
    public void setAluno_id(String aluno_id) {
        this.aluno_id = aluno_id;
    }

   

    /**
     * @return the st_ensino
     */
    public String getSt_ensino() {
        return st_ensino;
    }

    /**
     * @param st_ensino the st_ensino to set
     */
    public void setSt_ensino(String st_ensino) {
        this.st_ensino = st_ensino;
    }

    /**
     * @return the st_serie
     */
    public String getSt_serie() {
        return st_serie;
    }

    /**
     * @param st_serie the st_serie to set
     */
    public void setSt_serie(String st_serie) {
        this.st_serie = st_serie;
    }

    /**
     * @return the st_periodo
     */
    public String getSt_periodo() {
        return st_periodo;
    }

    /**
     * @param st_periodo the st_periodo to set
     */
    public void setSt_periodo(String st_periodo) {
        this.st_periodo = st_periodo;
    }

    /**
     * @return the st_turma
     */
    public String getSt_turma() {
        return st_turma;
    }

    /**
     * @param st_turma the st_turma to set
     */
    public void setSt_turma(String st_turma) {
        this.st_turma = st_turma;
    }

    /**
     * @return the st_sala
     */
    public String getSt_sala() {
        return st_sala;
    }

    /**
     * @param st_sala the st_sala to set
     */
    public void setSt_sala(String st_sala) {
        this.st_sala = st_sala;
    }

    /**
     * @return the st_anoletivo
     */
    public Integer getSt_anoletivo() {
        return st_anoletivo;
    }

    /**
     * @param st_anoletivo the st_anoletivo to set
     */
    public void setSt_anoletivo(Integer st_anoletivo) {
        this.st_anoletivo = st_anoletivo;
    }

    /**
     * @return the empresa_cnpj
     */
    public String getEmpresa_cnpj() {
        return empresa_cnpj;
    }

    /**
     * @param empresa_cnpj the empresa_cnpj to set
     */
    public void setEmpresa_cnpj(String empresa_cnpj) {
        this.empresa_cnpj = empresa_cnpj;
    }

    /**
     * @return the empresa_nome
     */
    public String getEmpresa_nome() {
        return empresa_nome;
    }

    /**
     * @param empresa_nome the empresa_nome to set
     */
    public void setEmpresa_nome(String empresa_nome) {
        this.empresa_nome = empresa_nome;
    }

    /**
     * @return the empresa_inep
     */
    public String getEmpresa_inep() {
        return empresa_inep;
    }

    /**
     * @param empresa_inep the empresa_inep to set
     */
    public void setEmpresa_inep(String empresa_inep) {
        this.empresa_inep = empresa_inep;
    }

    /**
     * @return the empresa_sala_numero
     */
    public String getEmpresa_sala_numero() {
        return empresa_sala_numero;
    }

    /**
     * @param empresa_sala_numero the empresa_sala_numero to set
     */
    public void setEmpresa_sala_numero(String empresa_sala_numero) {
        this.empresa_sala_numero = empresa_sala_numero;
    }

    /**
     * @return the st_classe
     */
    public String getSt_classe() {
        return st_classe;
    }

    /**
     * @param st_classe the st_classe to set
     */
    public void setSt_classe(String st_classe) {
        this.st_classe = st_classe;
    }

    /**
     * @return the st_horario_inicio
     */
    public String getSt_horario_inicio() {
        return st_horario_inicio;
    }

    /**
     * @param st_horario_inicio the st_horario_inicio to set
     */
    public void setSt_horario_inicio(String st_horario_inicio) {
        this.st_horario_inicio = st_horario_inicio;
    }

    /**
     * @return the st_horario_fim
     */
    public String getSt_horario_fim() {
        return st_horario_fim;
    }

    /**
     * @param st_horario_fim the st_horario_fim to set
     */
    public void setSt_horario_fim(String st_horario_fim) {
        this.st_horario_fim = st_horario_fim;
    }

    /**
     * @return the st_obs
     */
    public String getSt_obs() {
        return st_obs;
    }

    /**
     * @param st_obs the st_obs to set
     */
    public void setSt_obs(String st_obs) {
        this.st_obs = st_obs;
    }

    /**
     * @return the telefone_id
     */
    public int getTelefone_id() {
        return telefone_id;
    }

    /**
     * @param telefone_id the telefone_id to set
     */
    public void setTelefone_id(int telefone_id) {
        this.telefone_id = telefone_id;
    }

    /**
     * @return the empresa_relatos_tipo1
     */
    public String getEmpresa_relatos_tipo1() {
        return empresa_relatos_tipo1;
    }

    /**
     * @param empresa_relatos_tipo1 the empresa_relatos_tipo1 to set
     */
    public void setEmpresa_relatos_tipo1(String empresa_relatos_tipo1) {
        this.empresa_relatos_tipo1 = empresa_relatos_tipo1;
    }

    /**
     * @return the empresa_relatos_tipo2
     */
    public String getEmpresa_relatos_tipo2() {
        return empresa_relatos_tipo2;
    }

    /**
     * @param empresa_relatos_tipo2 the empresa_relatos_tipo2 to set
     */
    public void setEmpresa_relatos_tipo2(String empresa_relatos_tipo2) {
        this.empresa_relatos_tipo2 = empresa_relatos_tipo2;
    }

    /**
     * @return the empresa_relatos_descricao1
     */
    public String getEmpresa_relatos_descricao1() {
        return empresa_relatos_descricao1;
    }

    /**
     * @param empresa_relatos_descricao1 the empresa_relatos_descricao1 to set
     */
    public void setEmpresa_relatos_descricao1(String empresa_relatos_descricao1) {
        this.empresa_relatos_descricao1 = empresa_relatos_descricao1;
    }

    /**
     * @return the empresa_relatos_descricao2
     */
    public String getEmpresa_relatos_descricao2() {
        return empresa_relatos_descricao2;
    }

    /**
     * @param empresa_relatos_descricao2 the empresa_relatos_descricao2 to set
     */
    public void setEmpresa_relatos_descricao2(String empresa_relatos_descricao2) {
        this.empresa_relatos_descricao2 = empresa_relatos_descricao2;
    }

    /**
     * @return the empresa_relatos_descricao3
     */
    public String getEmpresa_relatos_descricao3() {
        return empresa_relatos_descricao3;
    }

    /**
     * @param empresa_relatos_descricao3 the empresa_relatos_descricao3 to set
     */
    public void setEmpresa_relatos_descricao3(String empresa_relatos_descricao3) {
        this.empresa_relatos_descricao3 = empresa_relatos_descricao3;
    }

    /**
     * @return the empresa_relatos_descricao4
     */
    public String getEmpresa_relatos_descricao4() {
        return empresa_relatos_descricao4;
    }

    /**
     * @param empresa_relatos_descricao4 the empresa_relatos_descricao4 to set
     */
    public void setEmpresa_relatos_descricao4(String empresa_relatos_descricao4) {
        this.empresa_relatos_descricao4 = empresa_relatos_descricao4;
    }

    /**
     * @return the empresa_relatos_id
     */
    public int getEmpresa_relatos_id() {
        return empresa_relatos_id;
    }

    /**
     * @param empresa_relatos_id the empresa_relatos_id to set
     */
    public void setEmpresa_relatos_id(int empresa_relatos_id) {
        this.empresa_relatos_id = empresa_relatos_id;
    }

    /**
     * @return the endereco_referencia
     */
    public String getEndereco_referencia() {
        return endereco_referencia;
    }

    /**
     * @param endereco_referencia the endereco_referencia to set
     */
    public void setEndereco_referencia(String endereco_referencia) {
        this.endereco_referencia = endereco_referencia;
    }

    /**
     * @return the endereco_uf_descricao
     */
    public String getEndereco_uf_descricao() {
        return endereco_uf_descricao;
    }

    /**
     * @param endereco_uf_descricao the endereco_uf_descricao to set
     */
    public void setEndereco_uf_descricao(String endereco_uf_descricao) {
        this.endereco_uf_descricao = endereco_uf_descricao;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the prs_codigo
     */
    public int getPrs_codigo() {
        return prs_codigo;
    }

    /**
     * @param prs_codigo the prs_codigo to set
     */
    public void setPrs_codigo(int prs_codigo) {
        this.prs_codigo = prs_codigo;
    }

    /**
     * @return the prs_data
     */
    public String getPrs_data() {
        return prs_data;
    }

    /**
     * @param prs_data the prs_data to set
     */
    public void setPrs_data(String prs_data) {
        this.prs_data = prs_data;
    }

    /**
     * @return the prs_caderno
     */
    public String getPrs_caderno() {
        return prs_caderno;
    }

    /**
     * @param prs_caderno the prs_caderno to set
     */
    public void setPrs_caderno(String prs_caderno) {
        this.prs_caderno = prs_caderno;
    }

    /**
     * @return the prs_descricao
     */
    public String getPrs_descricao() {
        return prs_descricao;
    }

    /**
     * @param prs_descricao the prs_descricao to set
     */
    public void setPrs_descricao(String prs_descricao) {
        this.prs_descricao = prs_descricao;
    }

    /**
     * @return the pessoa_estado_civil
     */
    public String getPessoa_estado_civil() {
        return pessoa_estado_civil;
    }

    /**
     * @param pessoa_estado_civil the pessoa_estado_civil to set
     */
    public void setPessoa_estado_civil(String pessoa_estado_civil) {
        this.pessoa_estado_civil = pessoa_estado_civil;
    }

    /**
     * @return the aluno_classe_nchamada
     */
    public Integer getAluno_classe_nchamada() {
        return aluno_classe_nchamada;
    }

    /**
     * @param aluno_classe_nchamada the aluno_classe_nchamada to set
     */
    public void setAluno_classe_nchamada(Integer aluno_classe_nchamada) {
        this.aluno_classe_nchamada = aluno_classe_nchamada;
    }

    /**
     * @return the aluno_classe_sit
     */
    public String getAluno_classe_sit() {
        return aluno_classe_sit;
    }

    /**
     * @param aluno_classe_sit the aluno_classe_sit to set
     */
    public void setAluno_classe_sit(String aluno_classe_sit) {
        this.aluno_classe_sit = aluno_classe_sit;
    }

    /**
     * @return the aluno_classe_def
     */
    public String getAluno_classe_def() {
        return aluno_classe_def;
    }

    /**
     * @param aluno_classe_def the aluno_classe_def to set
     */
    public void setAluno_classe_def(String aluno_classe_def) {
        this.aluno_classe_def = aluno_classe_def;
    }

    /**
     * @return the aluno_classe_obs
     */
    public String getAluno_classe_obs() {
        return aluno_classe_obs;
    }

    /**
     * @param aluno_classe_obs the aluno_classe_obs to set
     */
    public void setAluno_classe_obs(String aluno_classe_obs) {
        this.aluno_classe_obs = aluno_classe_obs;
    }

    /**
     * @return the empresa_pessoa_status
     */
    public String getEmpresa_pessoa_status() {
        return empresa_pessoa_status;
    }

    /**
     * @param empresa_pessoa_status the empresa_pessoa_status to set
     */
    public void setEmpresa_pessoa_status(String empresa_pessoa_status) {
        this.empresa_pessoa_status = empresa_pessoa_status;
    }

    /**
     * @return the aluno_classe_transf
     */
    public String getAluno_classe_transf() {
        return aluno_classe_transf;
    }

    /**
     * @param aluno_classe_transf the aluno_classe_transf to set
     */
    public void setAluno_classe_transf(String aluno_classe_transf) {
        this.aluno_classe_transf = aluno_classe_transf;
    }

    /**
     * @return the aluno_classe_rem
     */
    public String getAluno_classe_rem() {
        return aluno_classe_rem;
    }

    /**
     * @param aluno_classe_rem the aluno_classe_rem to set
     */
    public void setAluno_classe_rem(String aluno_classe_rem) {
        this.aluno_classe_rem = aluno_classe_rem;
    }

    /**
     * @return the auto_placa
     */
    public String getAuto_placa() {
        return auto_placa;
    }

    /**
     * @param auto_placa the auto_placa to set
     */
    public void setAuto_placa(String auto_placa) {
        this.auto_placa = auto_placa;
    }

    /**
     * @return the auto_tipo
     */
    public String getAuto_tipo() {
        return auto_tipo;
    }

    /**
     * @param auto_tipo the auto_tipo to set
     */
    public void setAuto_tipo(String auto_tipo) {
        this.auto_tipo = auto_tipo;
    }

    /**
     * @return the auto_marca
     */
    public String getAuto_marca() {
        return auto_marca;
    }

    /**
     * @param auto_marca the auto_marca to set
     */
    public void setAuto_marca(String auto_marca) {
        this.auto_marca = auto_marca;
    }

    /**
     * @return the auto_modelo
     */
    public String getAuto_modelo() {
        return auto_modelo;
    }

    /**
     * @param auto_modelo the auto_modelo to set
     */
    public void setAuto_modelo(String auto_modelo) {
        this.auto_modelo = auto_modelo;
    }

    /**
     * @return the auto_cor
     */
    public String getAuto_cor() {
        return auto_cor;
    }

    /**
     * @param auto_cor the auto_cor to set
     */
    public void setAuto_cor(String auto_cor) {
        this.auto_cor = auto_cor;
    }

    /**
     * @return the auto_motor
     */
    public String getAuto_motor() {
        return auto_motor;
    }

    /**
     * @param auto_motor the auto_motor to set
     */
    public void setAuto_motor(String auto_motor) {
        this.auto_motor = auto_motor;
    }

    /**
     * @return the auto_stilo
     */
    public String getAuto_stilo() {
        return auto_stilo;
    }

    /**
     * @param auto_stilo the auto_stilo to set
     */
    public void setAuto_stilo(String auto_stilo) {
        this.auto_stilo = auto_stilo;
    }

    /**
     * @return the pessoa_login
     */
    public String getPessoa_login() {
        return pessoa_login;
    }

    /**
     * @param pessoa_login the pessoa_login to set
     */
    public void setPessoa_login(String pessoa_login) {
        this.pessoa_login = pessoa_login;
    }

    /**
     * @return the pessoa_religiao_nome
     */
    public String getPessoa_religiao_nome() {
        return pessoa_religiao_nome;
    }

    /**
     * @param pessoa_religiao_nome the pessoa_religiao_nome to set
     */
    public void setPessoa_religiao_nome(String pessoa_religiao_nome) {
        this.pessoa_religiao_nome = pessoa_religiao_nome;
    }

    /**
     * @return the religiao_nome
     */
    public String getReligiao_nome() {
        return religiao_nome;
    }

    /**
     * @param religiao_nome the religiao_nome to set
     */
    public void setReligiao_nome(String religiao_nome) {
        this.religiao_nome = religiao_nome;
    }

    /**
     * @return the certificadora
     */
    public String getCertificadora() {
        return certificadora;
    }

    /**
     * @param certificadora the certificadora to set
     */
    public void setCertificadora(String certificadora) {
        this.certificadora = certificadora;
    }

    /**
     * @return the religiao_obs
     */
    public String getReligiao_obs() {
        return religiao_obs;
    }

    /**
     * @param religiao_obs the religiao_obs to set
     */
    public void setReligiao_obs(String religiao_obs) {
        this.religiao_obs = religiao_obs;
    }

    /**
     * @return the pessoa_religiao_obs
     */
    public String getPessoa_religiao_obs() {
        return pessoa_religiao_obs;
    }

    /**
     * @param pessoa_religiao_obs the pessoa_religiao_obs to set
     */
    public void setPessoa_religiao_obs(String pessoa_religiao_obs) {
        this.pessoa_religiao_obs = pessoa_religiao_obs;
    }

    /**
     * @return the medico_nome
     */
    public String getMedico_nome() {
        return medico_nome;
    }

    /**
     * @param medico_nome the medico_nome to set
     */
    public void setMedico_nome(String medico_nome) {
        this.medico_nome = medico_nome;
    }

    /**
     * @return the medico_codigo
     */
    public String getMedico_codigo() {
        return medico_codigo;
    }

    /**
     * @param medico_codigo the medico_codigo to set
     */
    public void setMedico_codigo(String medico_codigo) {
        this.medico_codigo = medico_codigo;
    }

    /**
     * @return the medico_tipo
     */
    public String getMedico_tipo() {
        return medico_tipo;
    }

    /**
     * @param medico_tipo the medico_tipo to set
     */
    public void setMedico_tipo(String medico_tipo) {
        this.medico_tipo = medico_tipo;
    }

    /**
     * @return the empresa_pessoa_cargo
     */
    public String getEmpresa_pessoa_cargo() {
        return empresa_pessoa_cargo;
    }

    /**
     * @param empresa_pessoa_cargo the empresa_pessoa_cargo to set
     */
    public void setEmpresa_pessoa_cargo(String empresa_pessoa_cargo) {
        this.empresa_pessoa_cargo = empresa_pessoa_cargo;
    }

    /**
     * @return the empresa_relatos_dataf
     */
    public String getEmpresa_relatos_dataf() {
        return empresa_relatos_dataf;
    }

    /**
     * @param empresa_relatos_dataf the empresa_relatos_dataf to set
     */
    public void setEmpresa_relatos_dataf(String empresa_relatos_dataf) {
        this.empresa_relatos_dataf = empresa_relatos_dataf;
    }

    /**
     * @return the pessoa_nascimento_multiplo
     */
    public String getPessoa_nascimento_multiplo() {
        return pessoa_nascimento_multiplo;
    }

    /**
     * @param pessoa_nascimento_multiplo the pessoa_nascimento_multiplo to set
     */
    public void setPessoa_nascimento_multiplo(String pessoa_nascimento_multiplo) {
        this.pessoa_nascimento_multiplo = pessoa_nascimento_multiplo;
    }

    /**
     * @return the aniversario
     */
    public int getAniversario() {
        return aniversario;
    }

    /**
     * @param aniversario the aniversario to set
     */
    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }

    /**
     * @return the empresa_pessoa_funcao
     */
    public String getEmpresa_pessoa_funcao() {
        return empresa_pessoa_funcao;
    }

    /**
     * @param empresa_pessoa_funcao the empresa_pessoa_funcao to set
     */
    public void setEmpresa_pessoa_funcao(String empresa_pessoa_funcao) {
        this.empresa_pessoa_funcao = empresa_pessoa_funcao;
    }
   
}
