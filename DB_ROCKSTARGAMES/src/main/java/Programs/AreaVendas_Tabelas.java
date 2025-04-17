package Programs;

import Application.Vendas;

import java.sql.*;

public class AreaVendas_Tabelas {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rockstar_db";
        String user = "root"; // Nome do usuário
        String password = "MySQL@Adm2025!"; // Senha do banco de dados
// Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão realizada com sucesso");

            String queryClientes = "select * from clientes",
                    queryPagamento = "select * from pagamento",
                    queryVendas = "select * from vendas_digitais",
                    querymicroTransacoes = "select * from historico_microtransacoes";

            try(Statement AreaVendas = conexao.createStatement();
                ResultSet Clientes = AreaVendas.executeQuery(queryClientes)){
                Vendas.exibirClientes(Clientes);

                ResultSet Pagamentos = AreaVendas.executeQuery(queryPagamento);
                Vendas.exibirPagamentos(Pagamentos);

                ResultSet vendasDigitais = AreaVendas.executeQuery(queryVendas);
                Vendas.exibirVendas(vendasDigitais);

                ResultSet MicroTransacoes = AreaVendas.executeQuery(querymicroTransacoes);
                Vendas.exibirMicroTransacoes(MicroTransacoes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}