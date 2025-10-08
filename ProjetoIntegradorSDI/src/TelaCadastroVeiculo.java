import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane; // Importa a classe para a caixa de diálogo
import java.awt.EventQueue;
import java.awt.event.ActionEvent;     // Importa a classe de evento
import java.awt.event.ActionListener;  // Importa a classe de "ouvinte" do evento

public class TelaCadastroVeiculo extends JFrame {

    // 1. Declare os componentes como variáveis da classe
    private JTextField txtFabricante;
    private JTextField txtModelo;
    private JTextField txtCidade;
    private JButton btnSalvar;

    public TelaCadastroVeiculo() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Veículos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel pnlCadastroVeiculos = new JPanel(null);

        JLabel lblTituloTela = new JLabel("Cadastro de Veículos");
        lblTituloTela.setBounds(130, 10, 150, 25);
        pnlCadastroVeiculos.add(lblTituloTela);

        JLabel lblFabricante = new JLabel("Fabricante");
        lblFabricante.setBounds(30, 60, 80, 25);
        pnlCadastroVeiculos.add(lblFabricante);

        txtFabricante = new JTextField(20); // Inicializa a variável da classe
        txtFabricante.setBounds(110, 60, 200, 25);
        pnlCadastroVeiculos.add(txtFabricante);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(30, 100, 80, 25);
        pnlCadastroVeiculos.add(lblModelo);

        txtModelo = new JTextField(20); // Inicializa a variável da classe
        txtModelo.setBounds(110, 100, 200, 25);
        pnlCadastroVeiculos.add(txtModelo);

        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setBounds(30, 140, 80, 25);
        pnlCadastroVeiculos.add(lblCidade);

        txtCidade = new JTextField(20); // Inicializa a variável da classe
        txtCidade.setBounds(110, 140, 200, 25);
        pnlCadastroVeiculos.add(txtCidade);

        btnSalvar = new JButton("Salvar"); // Inicializa a variável da classe
        btnSalvar.setBounds(150, 200, 100, 30);
        pnlCadastroVeiculos.add(btnSalvar);

        add(pnlCadastroVeiculos);

        // 2. Adiciona o ActionListener ao botão
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 3. Define o que acontece ao clicar
                btnSalvarActionPerformed(e);
            }
        });
    }

    // Método que será chamado pelo clique do botão
    private void btnSalvarActionPerformed(ActionEvent e) {
        // Pega o texto de cada campo
        String fabricante = txtFabricante.getText();
        String modelo = txtModelo.getText();
        String cidade = txtCidade.getText();

        // Monta a mensagem
        String mensagem = "Veículo Salvo com Sucesso!\n\n"
                + "Fabricante: " + fabricante + "\n"
                + "Modelo: " + modelo + "\n"
                + "Cidade: " + cidade;

        // Exibe a mensagem de confirmação
        JOptionPane.showMessageDialog(this, mensagem, "Confirmação", JOptionPane.INFORMATION_MESSAGE);

        // Opcional: Limpa os campos após salvar
        txtFabricante.setText("");
        txtModelo.setText("");
        txtCidade.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new TelaCadastroVeiculo().setVisible(true);
        });
    }
}