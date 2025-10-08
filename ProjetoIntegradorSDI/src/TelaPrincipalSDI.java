import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipalSDI extends JFrame {

    // Construtor
    public TelaPrincipalSDI() {
        initComponents();
    }

    private void initComponents() {
        // Definições da Janela Principal
        setTitle("Sistema de Cadastro de Carros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Barra de Menu
        JMenuBar mnuBarTelaPrincipal = new JMenuBar();

        // Menu "Arquivo"
        JMenu mnuArquivo = new JMenu("Arquivo");

        // Menu "Cadastro"
        JMenu mnuCadastro = new JMenu("Cadastro");

        // Item de Menu "Cadastro de Veículo"
        JMenuItem mnuCadastroVeiculo = new JMenuItem("Cadastro de Veículo");

        try {
            mnuCadastroVeiculo.setIcon(new ImageIcon(getClass().getResource("/home/estudante2/Documentos/GitHub/ProjetoIntegrador_WEB/ProjetoIntegradorSDI/imagens/cadastro.jpeg")));
        } catch (Exception e) {
            System.out.println("Ícone não encontrado. Verifique o caminho /home/estudante2/Documentos/GitHub/ProjetoIntegrador_WEB/ProjetoIntegradorSDI/imagenscadastro.jpeg");
        }


        // Adiciona o item de menu "Cadastro de Veículo" ao menu "Cadastro"
        mnuCadastro.add(mnuCadastroVeiculo);

        // Adiciona os menus "Arquivo" e "Cadastro" à barra de menus
        mnuBarTelaPrincipal.add(mnuArquivo);
        mnuBarTelaPrincipal.add(mnuCadastro);

        // Define a barra de menus para esta janela
        setJMenuBar(mnuBarTelaPrincipal);

        // Adiciona o evento de clique para o item de menu "Cadastro de Veículo"
        mnuCadastroVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mnuCadastroVeiculoActionPerformed(evt);
            }
        });
    }

    // Método executado ao clicar no item de menu
    private void mnuCadastroVeiculoActionPerformed(ActionEvent evt) {
        new TelaCadastroVeiculo().setVisible(true);
    }

    // Método Main para executar a aplicação
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new TelaPrincipalSDI().setVisible(true);
        });
    }
}