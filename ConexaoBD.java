
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    
    public Connection getConnection(){
    
        Connection conn = null;
        String className = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/agenda"; // Aqui conectamos ao schema!
        String user = "root";
        String password = "123";
        
        
        try {
            Class.forName(className);
            System.out.println("ClasseName com valor correto!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar conexao!");
        }
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar a conexao junto a URL!");
        }
        return conn;
    }
}
