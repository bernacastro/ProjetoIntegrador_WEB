package br.com.projeto.comum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS veiculos ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " fabricante TEXT NOT NULL,"
                + " modelo TEXT NOT NULL,"
                + " cidade TEXT NOT NULL"
                + ");";

        // AQUI ESTAVA O ERRO: ConcasexoSQLite -> ConexaoSQLite
        try (Connection conn = ConexaoSQLite.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela de veículos: " + e.getMessage());
        }
    }

    public void salvar(String fabricante, String modelo, String cidade) {
        String sql = "INSERT INTO veiculos(fabricante, modelo, cidade) VALUES(?, ?, ?)";

        // AQUI ESTAVA O ERRO: ConcasexoSQLite -> ConexaoSQLite
        try (Connection conn = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, fabricante);
            pstmt.setString(2, modelo);
            pstmt.setString(3, cidade);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar o veículo: " + e.getMessage());
        }
    }

    public List<String> listarTodos() {
        List<String> veiculos = new ArrayList<>();
        String sql = "SELECT fabricante, modelo, cidade FROM veiculos";

        // AQUI ESTAVA O ERRO: ConcasexoSQLite -> ConexaoSQLite
        try (Connection conn = ConexaoSQLite.conectar();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                String linha = "Fabricante: " + rs.getString("fabricante") +
                        " | Modelo: " + rs.getString("modelo") +
                        " | Cidade: " + rs.getString("cidade");
                veiculos.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os veículos: " + e.getMessage());
        }
        return veiculos;
    }
}