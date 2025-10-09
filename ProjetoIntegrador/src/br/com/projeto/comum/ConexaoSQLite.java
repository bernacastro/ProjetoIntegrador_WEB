package br.com.projeto.comum; // <-- INFORMA QUE ESTA CLASSE PERTENCE A ESTE PACOTE

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {

    public static Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:meu_banco.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o SQLite: " + e.getMessage());
        }
        return conn;
    }
}