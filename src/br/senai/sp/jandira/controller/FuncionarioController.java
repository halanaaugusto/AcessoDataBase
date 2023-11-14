package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FuncionarioController {

    public void listarFuncionarios() throws SQLException {
        //Instanciar conexão
        Conexao conexao = new Conexao();

        Connection connection = conexao.getConnection();

        Statement statement = connection.createStatement();

        String queryConsulta = "SELECT * FROM funcionario";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()) {
            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setMatricula(resultSet.getString("matricula"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));
            funcionario.setPermissao(resultSet.getInt("permissao"));
            funcionario.setDepartamento_FK(resultSet.getInt("departamento_FK"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getMatricula());
            System.out.println(funcionario.getNome() + " " + funcionario.getSobrenome());
            System.out.println(funcionario.getPermissao());
            System.out.println(funcionario.getDepartamento_FK());
            System.out.println("=================================================================");
        }

    }

    public boolean deletarFuncionario() throws SQLException {
        //Instanciar conexão
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o id do funcionário que deseja excluir? ");
        int deletarFuncionario = scanner.nextInt();

        //Conexão com o banco
        Conexao conexao = new Conexao();

        Connection connection = conexao.getConnection();

        Statement statement = connection.createStatement();

        //Query para deletar no banco de dados
        String queryDelete = "DELETE FROM funcionario WHERE idFuncionario = '" + deletarFuncionario + "'";

        try {
            statement.executeUpdate(queryDelete);
            return true;
        } catch (Exception erro){
            System.out.println(erro);
            return false;
        }
    }

    public boolean cadastrarFuncionarios() throws SQLException {
        //Instanciar conexão
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o id: ");
        int idFuncionario = scanner.nextInt();
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.println("Informe a matricula: ");
        String matricula = scanner.nextLine();
        System.out.println("Informe a permissão: ");
        int permissao = scanner.nextInt();
        System.out.println("Informe o id do departamento: ");
        int departamento_FK = scanner.nextInt();

        //Conexão com o banco
        Conexao conexao = new Conexao();

        Connection connection = conexao.getConnection();

        Statement statement = connection.createStatement();

        //Query para deletar no banco de dados
        String queryAddFuncionario = "INSERT INTO funcionario (idFuncionario, nome, sobrenome, matricula, permissao, departamento_FK) values (" +
                idFuncionario + "," + nome + "," + sobrenome + "," +  matricula + "," + permissao + "," + departamento_FK + ")";

        try {
            statement.executeUpdate(queryAddFuncionario);
            return true;
        } catch (Exception erro){
            System.out.println(erro);
            return false;
        }
    }


    public void pesquisarFuncionarios() {

    }

}
