package br.com.projeto.sdi; // <-- INFORMA QUE ESTA CLASSE PERTENCE A ESTE PACOTE

import br.com.projeto.comum.VeiculoDAO; // <-- IMPORTA A CLASSE DE OUTRO PACOTE

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;


public class TelaCadastroVeiculo extends JFrame {

    private JTextField txtFabricante;
    private JTextField txtModelo;
    private JTextField txtCidade;
    private JButton btnSalvar;
    private TelaPrincipalSDI telaPrincipal;

    public TelaCadastroVeiculo(TelaPrincipalSDI telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
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

        txtFabricante = new JTextField(20);
        txtFabricante.setBounds(110, 60, 200, 25);
        pnlCadastroVeiculos.add(txtFabricante);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(30, 100, 80, 25);
        pnlCadastroVeiculos.add(lblModelo);

        txtModelo = new JTextField(20);
        txtModelo.setBounds(110, 100, 200, 25);
        pnlCadastroVeiculos.add(txtModelo);

        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setBounds(30, 140, 80, 25);
        pnlCadastroVeiculos.add(lblCidade);

        txtCidade = new JTextField(20);
        txtCidade.setBounds(110, 140, 200, 25);
        pnlCadastroVeiculos.add(txtCidade);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 200, 100, 30);
        pnlCadastroVeiculos.add(btnSalvar);

        add(pnlCadastroVeiculos);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalvarActionPerformed(e);
            }
        });
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

        telaPrincipal.adicionarCarro(fabricante, modelo, cidade);

        JOptionPane.showMessageDialog(this, "Veículo salvo no banco de dados com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();
    }
}