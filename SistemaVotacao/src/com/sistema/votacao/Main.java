package com.sistema.votacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Votação");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Listar Candidatos");
        System.out.println("3. Votar");
        

        int opcao = sc.nextInt();
        sc.nextLine(); 

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do usuário:");
                String nome = sc.nextLine();
                System.out.println("Digite o email do usuário:");
                String email = sc.nextLine();
                System.out.println("Digite o login do usuário:");
                String login = sc.nextLine();
                System.out.println("Digite a senha do usuário:");
                String senha = sc.nextLine();
                UsuarioDAO.cadastrarUsuario(nome, email, login, senha);
                break;
            case 2:
                CandidatoDAO.listarCandidatos();
                break;
            case 3:
                System.out.println("Digite seu ID de usuário:");
                int idUsuario = sc.nextInt();
                System.out.println("Digite o ID do candidato:");
                int idCandidato = sc.nextInt();
                VotoDAO.registrarVoto(idUsuario, idCandidato);
                break;
            default:
                System.out.println("Opção inválida!");
        }

        sc.close();
    }
}
