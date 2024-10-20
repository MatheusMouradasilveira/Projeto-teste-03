package Controller;

import Model.ContatoModel;
import javax.swing.JOptionPane;

public class ContatoController {

    public void cadastrarContatoController(String nome, String telefone, String email) {

        //Verificar se as informações foram enviadas da maneira correta!
        if ((nome != null && nome.length() > 0)
                && (telefone != null && telefone.length() > 0)
                && (email != null && email.length() > 0)) {

            // Intanciar o objeto de acordo com o nosso modelo (Classe Contato)
            ContatoModel novoContato = new ContatoModel(nome, telefone, email);
                       
            //Chamar o método disponivel na classe de contatos que realiza a inserção do
            // registro no banco de dados.
            novoContato.cadastrarContatoDAO(novoContato);
            
        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");
        }

    }

}
