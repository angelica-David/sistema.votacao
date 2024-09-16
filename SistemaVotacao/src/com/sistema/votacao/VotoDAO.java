package com.sistema.votacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VotoDAO {
    public static void registrarVoto(int idUsuario, int idCandidato) {
        String query = "INSERT INTO votos (id_usuario, id_candidato) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idCandidato);
            pstmt.executeUpdate();
            System.out.println("Voto registrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao registrar voto.");
            e.printStackTrace();
        }
    }
}
