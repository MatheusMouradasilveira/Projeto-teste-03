package DAO;

import Model.ContatoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ContatoBancoDados {

    // Manipulação da tabela do BD - Contatos
    // CRUD - Criar, excluir, listar, modificação
    //Recebe o objeto (tipo ContatoModel) e realiza a conexão com o banco de daods
    // Insere as infromações na tabela do banco de dados
    public void inserirContatoBD(ContatoModel novoContato) {

        String sql = "INSERT INTO contatos (nome, telefone, email) values (?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoContato.getNome());
            stmt.setString(2, novoContato.getTelefone());
            stmt.setString(3, novoContato.getEmail());
            stmt.execute();
            System.out.println("Registro realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
    }

    
    public ArrayList<ContatoModel> listarTodosContatos(){
    
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        ContatoModel contato = null;
        ArrayList<ContatoModel> listaContatos = null;
        
        String sql = "SELECT * FROM ROOT.CONTATOS";
        
        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaContatos = new ArrayList<>();
                while (rs.next()) {
                    contato = new ContatoModel();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setTelefone(rs.getString("telefone"));
                    contato.setEmail(rs.getString("email"));
                    listaContatos.add(contato);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        return listaContatos;
    }
}


        
    
    
    
    

