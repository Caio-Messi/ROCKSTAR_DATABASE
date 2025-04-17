package Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Marketing {
    public static void exibirCampanhas (ResultSet campanhas) throws SQLException{
        System.out.println("╔════════════╦══════════════════════════════════════════════╦════════════════════════════════════════════════════════════════════════════════════════════════════════════════╦════════════════╦════════════════╦════════════════╦════════════════════╗");
        System.out.println("║   ID       ║ Nome da Campanha                             ║ Descrição                                                                                                      ║ Início         ║ Término        ║ Valor (US$)    ║ Lance Máximo (US$) ║");
        System.out.println("╠════════════╬══════════════════════════════════════════════╬════════════════════════════════════════════════════════════════════════════════════════════════════════════════╬════════════════╬════════════════╬════════════════╬════════════════════╣");

        while (campanhas.next()) {
            System.out.printf("║ %-10s ║%-45s ║ %-85s                          ║ %-14s ║ %-14s ║ %14.2f ║ %18.2f ║%n",
                    campanhas.getString("id_campanha"),
                    campanhas.getString("nome_campanha"),
                    campanhas.getString("descricao_campanha"),
                    campanhas.getString("data_inicio"),
                    campanhas.getString("data_termino"),
                    campanhas.getDouble("valor_investido"),
                    campanhas.getDouble("maximo_lance"));
        }

        System.out.println("╚════════════╩══════════════════════════════════════════════╩════════════════════════════════════════════════════════════════════════════════════════════════════════════════╩════════════════╩════════════════╩════════════════╩════════════════════╝");

    }
    public static void exibirLoc (ResultSet Localizacao) throws SQLException{
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                   TABELA: LOCALIZAÇÃO                  ║");
        System.out.println("╠════════════════════╦════════════════════════╦══════════╣");
        System.out.printf ("║ %-18s ║%-24s║%-8s  ║%n", "ID", "Cidade", "País");
        System.out.println("╠════════════════════╬════════════════════════╬══════════╣");

        while (Localizacao.next()) {
            System.out.printf("║ %-18s ║%-24s║%-8s  ║%n",
                    Localizacao.getString("id_localizacao"),
                    Localizacao.getString("cidade"),
                    Localizacao.getString("pais"));
        }
        System.out.println("╚════════════════════╩════════════════════════╩══════════╝");
    }
    public static void exibirPublico (ResultSet Publico) throws SQLException{
        System.out.println("╔════════════════╦════════════════════╦════════════════╦════════════════════╦════════════════════════════╗");
        System.out.println("║ ID             ║ Faixa Etária       ║ Gênero         ║ Renda Média        ║ Consumo                    ║");
        System.out.println("╠════════════════╬════════════════════╬════════════════╬════════════════════╬════════════════════════════╣");

        while (Publico.next()) {
            int id = Publico.getInt("id_publico");
            String faixaEtaria = Publico.getString("faixa_etaria");
            String genero = Publico.getString("genero");
            double rendaMedia = Publico.getDouble("renda_media");
            String consumo = Publico.getString("consumo");

            System.out.printf("║ %-14d ║ %-18s ║ %-14s ║ %18.2f ║ %-26s ║%n",
                    id, faixaEtaria, genero, rendaMedia, consumo);
        }

        System.out.println("╚════════════════╩════════════════════╩════════════════╩════════════════════╩════════════════════════════╝");
    }
    public static void exibirInteresse (ResultSet Interesse) throws SQLException{
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  TABELA: INTERESSE                             ║");
        System.out.println("╠════════════════╦═══════════════════════════════════════════════╣");
        System.out.printf ("║ %-14s ║ %-43s   ║%n", "PUBLICO ALVO", "INTERESSE");
        System.out.println("╠════════════════╬═══════════════════════════════════════════════╣");

        while (Interesse.next()) {
            System.out.printf("║ %-14d ║ %-43s   ║%n",
                    Interesse.getInt("id_interesse"),
                    Interesse.getString("descricao"));
        }

        System.out.println("╚════════════════╩═══════════════════════════════════════════════╝");
    }
    public static void exibirCanais (ResultSet Canais) throws SQLException{
        System.out.println("╔════════════╦════════════╦════════════════╦════════════════╦════════════════════════════╦════════════════════════════════════════════════════════════════════════════════════╦══════════════╗");
        System.out.println("║ ID Canal   ║ Campanha   ║ Público        ║ Localização    ║ Nome do Canal              ║ Descrição                                                                          ║ Tipo Canal   ║");
        System.out.println("╠════════════╬════════════╬════════════════╬════════════════╬════════════════════════════╬════════════════════════════════════════════════════════════════════════════════════╬══════════════╣");

        while (Canais.next()) {
            System.out.printf("║ %-10d ║ %-10d ║ %-14d ║ %-14d ║ %-26s ║ %-80s   ║ %-12d ║%n",
                    Canais.getInt("id_canais"),
                    Canais.getInt("campanha"),
                    Canais.getInt("publico"),
                    Canais.getInt("localizacao"),
                    Canais.getString("Nome_canal"),
                    Canais.getString("descricao"),
                    Canais.getInt("tipo_canal"));
        }

        System.out.println("╚════════════╩════════════╩════════════════╩════════════════╩════════════════════════════╩════════════════════════════════════════════════════════════════════════════════════╩══════════════╝");
    }
    public static void exibirProdutos (ResultSet Produto) throws SQLException{
        System.out.println("╔════════════╦══════════════════════════════════════════════════════════════════════════════════════════════════════════════╦════════════════════╦══════════════════════════╗");
        System.out.println("║ ID Produto ║ Descrição                                                                                                    ║ Marca              ║ Quantidade Anunciada     ║");
        System.out.println("╠════════════╬══════════════════════════════════════════════════════════════════════════════════════════════════════════════╬════════════════════╬══════════════════════════╣");

        while (Produto.next()) {
            int id = Produto.getInt("ID");
            String descricao = Produto.getString("descricao");
            String marca = Produto.getString("marca");
            int quantidade = Produto.getInt("quantidade_anunciada");

            // Limitar a descrição para caber na largura da tabela
            if (descricao.length() > 94) {
                descricao = descricao.substring(0, 91) + "...";
            }

            System.out.printf("║ %-10d ║ %-94s               ║ %-18s ║ %-24d ║%n", id, descricao, marca, quantidade);
        }

        System.out.println("╚════════════╩══════════════════════════════════════════════════════════════════════════════════════════════════════════════╩════════════════════╩══════════════════════════╝");
    }
    }

