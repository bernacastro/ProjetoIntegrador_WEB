package br.com.projeto.sdi; // <-- INFORMA QUE ESTA CLASSE PERTENCE A ESTE PACOTE

import br.com.projeto.comum.VeiculoDAO; // <-- IMPORTA A CLASSE DE OUTRO PACOTE

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

public class TelaPrincipalSDI extends JFrame {

    private JTextArea areaDeTextoCarros;

    public TelaPrincipalSDI() {
        VeiculoDAO.criarTabela();
        initComponents();
    }

    public void adicionarCarro(String fabricante, String modelo, String cidade) {
        String carroInfo = "Fabricante: " + fabricante + " | Modelo: " + modelo + " | Cidade: " + cidade + "\n";
        areaDeTextoCarros.append(carroInfo);
    }

    private void initComponents() {
        setTitle("Sistema de Cadastro de Carros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JMenuBar mnuBarTelaPrincipal = new JMenuBar();
        JMenu mnuArquivo = new JMenu("Arquivo");
        JMenu mnuCadastro = new JMenu("Cadastro");

        JMenuItem mnuCadastroVeiculo = new JMenuItem("Cadastro de Veículo");
        mnuCadastroVeiculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));

        try {
            URL resource = getClass().getResource("/imagens/cadastro_icon.png");
            ImageIcon iconeOriginal = new ImageIcon(resource);
            Image imagemOriginal = iconeOriginal.getImage();
            Image imagemRedimensionada = imagemOriginal.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            ImageIcon iconeRedimensionado = new ImageIcon(imagemRedimensionada);
            mnuCadastroVeiculo.setIcon(iconeRedimensionado);
        } catch (Exception e) {
            System.out.println("Erro ao carregar ou redimensionar o ícone: " + e.getMessage());
        }

        mnuCadastro.add(mnuCadastroVeiculo);

        JMenuItem mnuSair = new JMenuItem("Sair");
        mnuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuArquivo.add(mnuSair);

        mnuBarTelaPrincipal.add(mnuArquivo);
        mnuBarTelaPrincipal.add(mnuCadastro);
        setJMenuBar(mnuBarTelaPrincipal);

        areaDeTextoCarros = new JTextArea();
        areaDeTextoCarros.setEditable(false);
        areaDeTextoCarros.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaDeTextoCarros.setMargin(new java.awt.Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(areaDeTextoCarros);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        mnuCadastroVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mnuCadastroVeiculoActionPerformed(evt);
            }
        });
    }

    private void mnuCadastroVeiculoActionPerformed(ActionEvent evt) {
        new TelaCadastroVeiculo(this).setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new TelaPrincipalSDI().setVisible(true);
        });
    }
}