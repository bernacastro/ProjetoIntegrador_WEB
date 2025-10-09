package br.com.projeto.mdi;

import br.com.projeto.comum.VeiculoDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaListaVeiculosMDI extends JInternalFrame {

    private JTextArea areaDeTexto;
    private VeiculoDAO veiculoDAO;

    public TelaListaVeiculosMDI() {
        this.veiculoDAO = new VeiculoDAO();
        initComponents();
        carregarVeiculos(); // Carrega os veículos assim que a janela é criada
    }

    private void initComponents() {
        setTitle("Lista de Veículos Cadastrados");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setSize(600, 400);

        areaDeTexto = new JTextArea();
        areaDeTexto.setEditable(false);
        areaDeTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaDeTexto.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(areaDeTexto);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * NOVO MÉTODO: Busca os dados no DAO e atualiza a área de texto.
     * Deixamos como 'public' para que a tela principal possa chamar este método.
     */
    public void carregarVeiculos() {
        // Limpa a lista atual
        areaDeTexto.setText("");

        // Busca a nova lista do banco de dados
        List<String> veiculos = veiculoDAO.listarTodos();

        // Adiciona cada veículo na área de texto
        for (String veiculo : veiculos) {
            areaDeTexto.append(veiculo + "\n");
        }
    }
}