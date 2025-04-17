package Programs;

import Application.Area_jogos;

import java.sql.*;

public class AreaJogos_Tabelas {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rockstar_db";
        String user = "root"; // Nome do usuário
        String password = "MySQL@Adm2025!"; // Senha do banco de dados
// Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão realizada com sucesso");

            String queryJogos = "Select * from jogos",
                    queryPlataformas = "select * from plataformas",
                    queryExpansoes = "select * from expansoes";
            try (Statement stmt = conexao.createStatement();
                 ResultSet rsJogos = stmt.executeQuery(queryJogos)) {
                Area_jogos.exibirTabelaJogos(rsJogos);

                ResultSet plataformas = stmt.executeQuery(queryPlataformas);
                Area_jogos.exibirTabelaPlataformas(plataformas);

                ResultSet expansoes = stmt.executeQuery(queryExpansoes);
                Area_jogos.exibirTabelaExpansoes(expansoes);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
