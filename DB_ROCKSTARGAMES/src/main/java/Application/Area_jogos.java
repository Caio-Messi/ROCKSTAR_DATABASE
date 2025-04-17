package Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Area_jogos {

        public static void exibirTabelaJogos(ResultSet rs) throws SQLException {
            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                      TABELA: JOGOS                                                 ║");
            System.out.println("╠════════════╦════════════════════════════════════╦════════════════════╦══════════════╦══════════╦══════════════╗");
            System.out.printf("║ %-10s ║ %-34s ║%-20s║ %-12s ║ %-8s ║ %-12s ║%n",
                    "ID", "Nome", "Gênero", "Lançamento", "Preço", "Plataforma");
            System.out.println("╠════════════╬════════════════════════════════════╬════════════════════╬══════════════╬══════════╬══════════════╣");

            while (rs.next()) {
                System.out.printf("║ %-10s ║ %-34s ║ %-18s ║ %-12s ║ %-8.2f ║ %-12s ║%n",
                        rs.getString("id_jogo"),
                        rs.getString("nome_jogo"),
                        rs.getString("genero"),
                        rs.getString("data_lancamento"),
                        rs.getDouble("preço_base"),
                        rs.getString("Plataforma_id"));
            }
            System.out.println("╚════════════╩════════════════════════════════════╩════════════════════╩══════════════╩══════════╩══════════════╝");
        }

        public static void exibirTabelaPlataformas(ResultSet Plataformas) throws SQLException {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║            TABELA: PLATAFORMAS         ║");
            System.out.println("╠════════════════╦═══════════════════════╣");
            System.out.printf("║ %-14s ║ %-21s ║%n", "ID", "Nome da Plataforma");
            System.out.println("╠════════════════╬═══════════════════════╣");

            while (Plataformas.next()) {
                System.out.printf("║ %-14s ║ %-21s ║%n",
                        Plataformas.getString("id_plataforma"),
                        Plataformas.getString("nome_plataforma"));
            }
            System.out.println("╚════════════════╩═══════════════════════╝");
        }

        public static void exibirTabelaExpansoes(ResultSet rs) throws SQLException {
                System.out.println("╔════════════════╦════════════════════════════════════════════════╦══════════════════════════════════════════════════════════════════════════════════════╦════════════════╦════════════════════╗");
                System.out.println("║      ID        ║               Nome da Expansão                 ║                         Descrição                                                    ║   Lançamento   ║      ID Jogo       ║");
                System.out.println("╠════════════════╬════════════════════════════════════════════════╬══════════════════════════════════════════════════════════════════════════════════════╬════════════════╬════════════════════╣");

                while (rs.next()) {
                    System.out.printf("║ %-14s ║ %-47s║ %-82s   ║ %-14s ║ %-18s ║%n",
                            rs.getString("id_expansoes"),
                            rs.getString("nome_expansoes"),
                            rs.getString("descricao"),
                            rs.getString("data_lancamento"),
                            rs.getString("id_jogo"));
                }

                System.out.println("╚════════════════╩════════════════════════════════════════════════╩══════════════════════════════════════════════════════════════════════════════════════╩════════════════╩════════════════════╝");
            }
        }
