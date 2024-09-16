package com.sistema.votacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public static void cadastrarUsuario(String nome, String email, String login, String senha) {
        String query = "INSERT INTO usuarios (nome, email, login, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setString(3, login);
            pstmt.setString(4, senha);
            pstmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário.");
            e.printStackTrace();
        }
    }
}

