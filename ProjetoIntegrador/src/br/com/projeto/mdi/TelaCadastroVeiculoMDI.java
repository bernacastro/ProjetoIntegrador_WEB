package br.com.projeto.mdi;

import br.com.projeto.comum.VeiculoDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaCadastroVeiculoMDI extends JInternalFrame {

    private JTextField txtFabricante;
    private JTextField txtModelo;
    private JTextField txtCidade;

    // 1. Variável para guardar a referência da tela principal
    private TelaPrincipalMDI telaPrincipal;

    // 2. Construtor agora recebe a tela principal
    public TelaCadastroVeiculoMDI(TelaPrincipalMDI telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
    }

    private void initComponents() {
        // ... (código dos componentes visuais continua o mesmo)
        setTitle("Novo Cadastro de Veículo");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setSize(450, 300);
        JPanel pnlCadastroVeiculos = new JPanel(null);
        JLabel lblTituloTela = new JLabel("Cadastro de Veículos (MDI)");
        lblTituloTela.setBounds(130, 10, 200, 25);
        pnlCadastroVeiculos.add(lblTituloTela);
        JLabel lblFabricante = new JLabel("Fabricante");
        lblFabricante.setBounds(30, 60, 80, 25);
        pnlCadastroVeiculos.add(lblFabricante);
        txtFabricante = new JTextField(20);
        txtFabricante.setBounds(110, 60, 250, 25);
        pnlCadastroVeiculos.add(txtFabricante);
        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(30, 100, 80, 25);
        pnlCadastroVeiculos.add(lblModelo);
        txtModelo = new JTextField(20);
        txtModelo.setBounds(110, 100, 250, 25);
        pnlCadastroVeiculos.add(txtModelo);
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setBounds(30, 140, 80, 25);
        pnlCadastroVeiculos.add(lblCidade);
        txtCidade = new JTextField(20);
        txtCidade.setBounds(110, 140, 250, 25);
        pnlCadastroVeiculos.add(txtCidade);
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(170, 200, 100, 30);
        pnlCadastroVeiculos.add(btnSalvar);
        add(pnlCadastroVeiculos);
        btnSalvar.addActionListener(e -> btnSalvarActionPerformed(e));
    }

    private void btnSalvarActionPerformed(ActionEvent e) {
        String fabricante = txtFabricante.getText();
        String modelo = txtModelo.getText();
        String cidade = txtCidade.getText();

        if (fabricante.trim().isEmpty() || modelo.trim().isEmpty() || cidade.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.salvar(fabricante, modelo, cidade);

        JOptionPane.showMessageDialog(this, "Veículo salvo no banco de dados com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);

        // 3. Avisa a tela principal que um novo veículo foi salvo!
        telaPrincipal.veiculoFoiSalvo();

        dispose();
    }
}