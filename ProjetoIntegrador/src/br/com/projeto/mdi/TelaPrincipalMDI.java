package br.com.projeto.mdi;

import br.com.projeto.comum.VeiculoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;

public class TelaPrincipalMDI extends JFrame {

    private JDesktopPane desktopPane;
    // 1. Guarda uma referência da tela de listagem para podermos atualizá-la
    private TelaListaVeiculosMDI telaLista;

    public TelaPrincipalMDI() {
        VeiculoDAO.criarTabela();
        initComponents();
    }

    // 2. Método público que será chamado pela tela de cadastro após um salvamento
    public void veiculoFoiSalvo() {
        // Se a tela de lista estiver aberta, chame o método para recarregar os dados
        if (telaLista != null && !telaLista.isClosed()) {
            telaLista.carregarVeiculos();
        }
    }

    private void initComponents() {
        setTitle("Sistema de Cadastro de Carros (MDI)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu mnuArquivo = new JMenu("Arquivo");
        JMenu mnuCadastro = new JMenu("Cadastro");
        JMenu mnuExibir = new JMenu("Exibir"); // 3. Novo menu "Exibir"

        // --- Menu Cadastro ---
        JMenuItem mnuCadastroVeiculo = new JMenuItem("Cadastro de Veículo");
        mnuCadastroVeiculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        // ... (código do ícone continua o mesmo)
        mnuCadastro.add(mnuCadastroVeiculo);

        // --- Menu Exibir ---
        JMenuItem mnuListarVeiculos = new JMenuItem("Listar Veículos");
        mnuExibir.add(mnuListarVeiculos);

        // --- Menu Arquivo ---
        JMenuItem mnuSair = new JMenuItem("Sair");
        mnuArquivo.add(mnuSair);

        menuBar.add(mnuArquivo);
        menuBar.add(mnuCadastro);
        menuBar.add(mnuExibir); // Adiciona o novo menu à barra
        setJMenuBar(menuBar);

        // --- Eventos ---
        mnuCadastroVeiculo.addActionListener(e -> abrirJanelaCadastro());
        mnuListarVeiculos.addActionListener(e -> abrirJanelaListagem());
        mnuSair.addActionListener(e -> System.exit(0));
    }

    private void abrirJanelaCadastro() {
        // 4. Passa a referência da tela principal (this) para a tela de cadastro
        TelaCadastroVeiculoMDI telaCadastro = new TelaCadastroVeiculoMDI(this);
        desktopPane.add(telaCadastro);
        telaCadastro.setVisible(true);
    }

    private void abrirJanelaListagem() {
        // Se a janela de lista ainda não foi criada ou foi fechada, cria uma nova
        if (telaLista == null || telaLista.isClosed()) {
            telaLista = new TelaListaVeiculosMDI();
            desktopPane.add(telaLista);
            telaLista.setVisible(true);
        }
        // Traz a janela para frente caso ela já esteja aberta
        telaLista.toFront();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new TelaPrincipalMDI().setVisible(true));
    }
}