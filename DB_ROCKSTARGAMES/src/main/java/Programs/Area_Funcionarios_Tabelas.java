package Programs;

import Application.Area_Financeira;
import Application.Area_Funcionarios;

import java.sql.*;

public class Area_Funcionarios_Tabelas {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rockstar_db";
        String user = "root"; // Nome do usuário
        String password = "MySQL@Adm2025!"; // Senha do banco de dados
// Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão realizada com sucesso");

            String queryFuncionarios = " select * from funcionarios",
                    querySalarios = "select * from salarios",
                    queryCargos = "select * from cargos",
                    queryDepartamentos = "select * from departamentos";
            try (Statement funcionarios = conexao.createStatement();
                 ResultSet Funcionarios = funcionarios.executeQuery(queryFuncionarios)){
                Area_Funcionarios.exibirFuncionarios(Funcionarios);

                ResultSet Salarios = funcionarios.executeQuery(querySalarios);
                Area_Funcionarios.exibirSalarios(Salarios);

                ResultSet Cargos = funcionarios.executeQuery(queryCargos);
                Area_Funcionarios.exibirCargos(Cargos);

                ResultSet Departamentos = funcionarios.executeQuery(queryDepartamentos);
                Area_Funcionarios.exibirDepartamentos(Departamentos);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
