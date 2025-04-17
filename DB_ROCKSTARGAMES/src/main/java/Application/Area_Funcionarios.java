package Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Area_Funcionarios {
    public static void exibirFuncionarios (ResultSet Funcionarios) throws SQLException{
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                       TABELA: FUNCIONÁRIOS                                                         ║");
        System.out.println("╠════════════╦══════════════════════╦════════════════╦════════════════╦════════════════════════╦════════════════╦════════════════════╦════════════════════╣");
        System.out.printf("║ %-10s ║ %-20s ║ %-14s ║ %-14s ║ %-22s ║ %-14s ║ %-18s ║ %-18s ║%n",
                "ID", "Nome", "Nascimento", "Telefone", "Email", "Admissão", "Cargo", "Departamento");
        System.out.println("╠════════════╬══════════════════════╬════════════════╬════════════════╬════════════════════════╬════════════════╬════════════════════╬════════════════════╣");

        while (Funcionarios.next()) {
            System.out.printf("║ %-10s ║ %-20s ║ %-14s ║ %-14s ║ %-22s ║ %-14s ║ %-18s ║ %-18s ║%n",
                    Funcionarios.getString("id_funcionario"),
                    Funcionarios.getString("nome_funcionario"),
                    Funcionarios.getString("Data_nascimento"),
                    Funcionarios.getString("Telefone"),
                    Funcionarios.getString("Email"),
                    Funcionarios.getString("Admissao"),
                    Funcionarios.getString("Cargo"),
                    Funcionarios.getString("Departamento")
            );
        }

        System.out.println("╚════════════╩══════════════════════╩════════════════╩════════════════╩════════════════════════╩════════════════╩════════════════════╩════════════════════╝");
    }
    public static void exibirSalarios (ResultSet Salarios) throws SQLException{
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                           TABELA: SALÁRIOS                                                                           ║");
        System.out.println("╠════════════════╦════════════════════════╦════════════════════════════╦════════════════════╦════════════════╦════════════════════╦════════════════════╣");
        System.out.println("║ ID Salário     ║ Funcionário            ║ Cargo                      ║ Salário (US$)      ║ Bônus (US$)    ║ Início             ║ Fim                ║");
        System.out.println("╠════════════════╬════════════════════════╬════════════════════════════╬════════════════════╬════════════════╬════════════════════╬════════════════════╣");

        while (Salarios.next()) {
            System.out.printf("║ %-14s ║ %-24s║ %-26s║ %18.2f║ %14.2f║ %-20s║ %-20s║%n",
                    Salarios.getString("id_salario"),
                    Salarios.getString("Funcionario"),
                    Salarios.getString("Cargo"),
                    Salarios.getDouble("salario"),
                    Salarios.getDouble("bonus"),
                    Salarios.getString("incio"),
                    Salarios.getString("fim") == null ? " - " : Salarios.getString("fim"));
        }

        System.out.println("╚════════════════╩════════════════════════╩════════════════════════════╩════════════════════╩════════════════╩════════════════════╩════════════════════╝");


    }
    public static void exibirCargos (ResultSet Cargos) throws SQLException{
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║             TABELA: CARGOS                      ║");
        System.out.println("╠════════════════╦════════════════════════════════╣");
        System.out.printf ("║ %-14s ║ %-30s ║%n", "ID", "Nome do Cargo");
        System.out.println("╠════════════════╬════════════════════════════════╣");

        while (Cargos.next()) {
            System.out.printf("║ %-14s ║ %-30s ║%n",
                    Cargos.getString("ID_Cargo"),
                    Cargos.getString("nome_cargo"));
        }

        System.out.println("╚════════════════╩════════════════════════════════╝");

    }
    public static void exibirDepartamentos (ResultSet Departamentos) throws SQLException{
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                  TABELA: DEPARTAMENTOS                   ║");
        System.out.println("╠════════════════════╦═════════════════════════════════════╣");
        System.out.printf("║ %-18s ║ %-33s   ║ %n", "ID Departamento", "Nome Departamento");
        System.out.println("╠════════════════════╬═════════════════════════════════════╣");

        while (Departamentos.next()) {
            System.out.printf("║ %-18s ║ %-33s   ║%n",
                    Departamentos.getString("ID_departamento"),
                    Departamentos.getString("Nome_departamento"));
        }

        System.out.println("╚════════════════════╩═════════════════════════════════════╝");
    }
}
