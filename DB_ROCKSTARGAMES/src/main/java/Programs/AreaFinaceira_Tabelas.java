package Programs;

import Application.Area_Financeira;

import java.sql.*;

public class AreaFinaceira_Tabelas {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rockstar_db";
        String user = "root"; // Nome do usuário
        String password = "MySQL@Adm2025!"; // Senha do banco de dados
// Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão realizada com sucesso");

            String queryContas = "select * from  contas",
                    queryContasFinanceiras = "select * from contas_finaceiras",
                    queryTransferencias = "select * from transferencias",
                    fluxo = "select * from fluxo_caixa";
            try (Statement Financas = conexao.createStatement();
                 ResultSet contas = Financas.executeQuery(queryContas)){
                Area_Financeira.exibirContas(contas);

                ResultSet contasFinaneiras = Financas.executeQuery(queryContasFinanceiras);
                Area_Financeira.exibirContasFinanceiras(contasFinaneiras);

                ResultSet Transferencias = Financas.executeQuery(queryTransferencias);
                Area_Financeira.exibirTransferencias(Transferencias);

                ResultSet Fluxo = Financas.executeQuery(fluxo);
                Area_Financeira.exibirFluxo(Fluxo);
            }

        } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}