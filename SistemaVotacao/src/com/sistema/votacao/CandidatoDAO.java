package com.sistema.votacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class CandidatoDAO {
    public static void listarCandidatos() {
        String query = "SELECT * FROM candidatos";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Partido: " + rs.getString("partido"));
                System.out.println("Número: " + rs.getInt("numero_candidato"));
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar candidatos.");
            e.printStackTrace();
        }
    }
}

