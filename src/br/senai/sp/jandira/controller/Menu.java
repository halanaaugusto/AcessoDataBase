package br.senai.sp.jandira.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public void executarMenu() throws SQLException {

        boolean sair = false;

        Scanner scanner = new Scanner(System.in);

        FuncionarioController funcionarioController = new FuncionarioController();

        while (!sair){
            System.out.println("================= Menu ================");
            System.out.println("1- Listar Funcionários");
            System.out.println("2- Deletar Funcionários");
            System.out.println("3- Pesquisar Funcionários");
            System.out.println("4- Cadastrar Funcionários");
            System.out.println("5- Sair");

            System.out.println("Escolha uma opção acima: ");
            int opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario){
                case 1:
                    funcionarioController.listarFuncionarios();
                    break;

                case 2:
                    funcionarioController.deletarFuncionario();
                    System.out.println("Usuário deletado com sucesso!!");
                    break;

                case 3:
                    funcionarioController.cadastrarFuncionarios();
                    break;

                case 4:
                    System.out.println("Feature in development");
                    break;

                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Escolha uma opção válida");

            }

        }

    }

}
