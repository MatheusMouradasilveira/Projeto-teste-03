
package Model;

import DAO.ContatoBancoDados;

public class ContatoModel {
    
    //Atributos
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    
    //Contrutores

    public ContatoModel() {
    }

    public ContatoModel(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public ContatoModel(Integer id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    //Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //Metodo é utilizado para passsar os dados para o DAO realizar a conexão com o banco de dados.
    public void cadastrarContatoDAO(ContatoModel novoContato){
        ContatoBancoDados novoRegistro = new ContatoBancoDados();
        novoRegistro.inserirContatoBD(novoContato);
    }
    
}
