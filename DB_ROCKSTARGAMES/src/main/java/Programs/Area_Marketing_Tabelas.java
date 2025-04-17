package Programs;

import Application.Marketing;

import java.sql.*;

public class Area_Marketing_Tabelas {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rockstar_db";
        String user = "root"; // Nome do usuário
        String password = "MySQL@Adm2025!"; // Senha do banco de dados
// Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão realizada com sucesso");

            String queryCampanhas = "select * from campanhas",
                    queryLocalizacao = "select * from localizacao",
                    queryPublico = "select * from publico",
                    queryInteresse = "select * from interesse",
                    queryCanais = "select * from canais_distribuicao",
                    queryProduto = "select * from produto_anuncio";
            try (Statement Campanhas =  conexao.createStatement();
                 ResultSet campanhas = Campanhas.executeQuery(queryCampanhas)){
                Marketing.exibirCampanhas(campanhas);

                ResultSet Localizacao = Campanhas.executeQuery(queryLocalizacao);
                Marketing.exibirLoc(Localizacao);

                ResultSet Publico = Campanhas.executeQuery(queryPublico);
                Marketing.exibirPublico(Publico);

                ResultSet Interesse = Campanhas.executeQuery(queryInteresse);
                Marketing.exibirInteresse(Interesse);

                ResultSet Canais = Campanhas.executeQuery(queryCanais);
                Marketing.exibirCanais(Canais);

                ResultSet Produto = Campanhas.executeQuery(queryProduto);
                Marketing.exibirProdutos(Produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}