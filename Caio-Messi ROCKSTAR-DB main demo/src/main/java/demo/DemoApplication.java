package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException {
// Defina as informações de conexão
        String url = "jdbc:mysql://localhost:3306/rockstar_db";
        String user = "root"; // Nome do usuário
        String password = "MySQL@Adm2025!"; // Senha do banco de dados
// Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão realizada com sucesso");
            String query = "Select * from jogos";
            try (Statement stmt = conexao.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                System.out.println(   "╔════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println(   "║                                      TABELA: JOGOS                                                 ║");
                System.out.println(   "╠════════════╦════════════════════════════════════╦════════════════════╦══════════════╦══════════╦══════════════╗");
                System.out.printf (   "║ %-10s ║ %-34s ║ %-20s ║ %-12s ║ %-8s ║ %-12s ║%n",
                                         "ID", "Nome", "Gênero", "Lançamento", "Preço", "Plataforma");
                System.out.println(   "╠════════════╬════════════════════════════════════╬════════════════════╬══════════════╬══════════╬══════════════╣");

                while (rs.next()) {
                    System.out.printf("║ %-10s ║ %-34s ║ %-20s ║ %-12s ║ %-8.2f ║ %-12s ║%n",
                            rs.getString("id_jogo"),
                            rs.getString("nome_jogo"),
                            rs.getString("genero"),
                            rs.getString("data_lancamento"),
                            rs.getDouble("preço_base"),
                            rs.getString("Plataforma_id"));
                }
                System.out.println(  "╚════════════╩════════════════════════════════════╩════════════════════╩══════════════╩══════════╩══════════════╝");

            }
           String queryPlatafomas = "select * from plataformas";
            try (Statement plataformas = conexao.createStatement();
                 ResultSet rs = plataformas.executeQuery(queryPlatafomas)) {
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║            TABELA: PLATAFORMAS         ║");
                System.out.println("╠════════════════╦═══════════════════════╣");
                System.out.printf ("║ %-14s ║ %-21s ║%n", "ID", "Nome da Plataforma");
                System.out.println("╠════════════════╬═══════════════════════╣");

                while (rs.next()) {
                    System.out.printf("║ %-14s ║ %-21s ║%n",
                            rs.getString("id_plataforma"),
                            rs.getString("nome_plataforma"));
                }
                System.out.println("╚════════════════╩═══════════════════════╝");

                String queryExpansoes = "select * from expansoes";
                try (Statement expansoes = conexao.createStatement();
                     ResultSet exe_Expansoes = expansoes.executeQuery(queryExpansoes)) {
                    System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                    System.out.println("║                                              TABELA: EXPANSOES                                                                               ║");
                    System.out.println("╠══════════════╦════════════════════════════════════════╦════════════════════════════════════════════════╦════════════════╦════════════════════╣");
                    System.out.printf ("║ %-12s ║ %-40s ║ %-40s ║ %-14s ║ %-18s ║%n",
                            "ID", "Nome da Expansão", "Descrição", "Lançamento", "ID Jogo");
                    System.out.println("╠══════════════╬════════════════════════════════════════╬════════════════════════════════════════════════╬════════════════╬════════════════════╣");

                    while (exe_Expansoes.next()) {
                        System.out.printf("║ %-12s ║ %-40s ║ %-40s ║ %-14s ║ %-18s ║%n",
                                exe_Expansoes.getString("id_expansoes"),
                                exe_Expansoes.getString("nome_expansoes"),
                                exe_Expansoes.getString("descricao"),
                                exe_Expansoes.getString("data_lancamento"),
                                exe_Expansoes.getString("id_jogo"));
                    }
                    System.out.println("╚══════════════╩════════════════════════════════════════╩════════════════════════════════════════════════╩════════════════╩════════════════════╝");

                    System.out.println("   ╚════════════╩════════════════════════════════════╩════════════════════╩══════════════╩══════════╩══════════════╝");

                    String queryContas = "select * from  contas";

                    try (Statement Contas = conexao.createStatement();
                         ResultSet contas = Contas.executeQuery(queryContas)) {
                        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║                                      TABELA: CONTAS_PAGAR                                                         ║");
                        System.out.println("╠════════════════════╦══════════════════════════════════════════════════╦════════════════╦════════════════════╦════════════════════╣");
                        System.out.printf ("║ %-18s ║ %-42s ║ %-14s ║ %-20s ║ %-20s ║%n",
                                "ID", "Descrição", "Valor (US$)", "Data de Vencimento", "Status Pagamento");
                        System.out.println("╠════════════════════╬══════════════════════════════════════════════════╬════════════════╬════════════════════╬════════════════════╣");

                        while (contas.next()) {
                            System.out.printf("║ %-18s ║ %-42s ║ %-14.2f ║ %-20s ║ %-20s ║%n",
                                    contas.getString("id_conta"),
                                    contas.getString("tipo_conta"),
                                    contas.getFloat("valor"), // Use getFloat() para obter um valor numérico
                                    contas.getString("data"),
                                    contas.getString("status"));
                        }
                        System.out.println("╚════════════════════╩══════════════════════════════════════════════════╩════════════════╩════════════════════╩════════════════════╝");

                        String queryContasReceber = "select * from contas_finaceiras";
                        try (Statement contasFinanceiras = conexao.createStatement();
                             ResultSet contas_financeiras = contasFinanceiras.executeQuery(queryContasReceber)) {

                            System.out.println("╔════════╦════════════════════════════════════╦══════════════════════╦══════════════╦════════════════════╦════════════════╗");
                            System.out.println("║  ID    ║ Nome da Conta                      ║ Tipo da Conta        ║ Agência      ║ Número da Conta     ║ Saldo (US$)    ║");
                            System.out.println("╠════════╬════════════════════════════════════╬══════════════════════╬══════════════╬════════════════════╬════════════════╣");

                            while (contas_financeiras.next()) {
                                System.out.printf("║ %-6d ║ %-36s ║ %-20s ║ %-12s ║ %-20s ║ %14.2f ║%n",
                                        contas_financeiras.getInt("id"),
                                        contas_financeiras.getString("nome_conta"),
                                        contas_financeiras.getString("tipo_conta"),
                                        contas_financeiras.getString("agencia"),
                                        contas_financeiras.getString("numero_conta"),
                                        contas_financeiras.getDouble("saldo"));
                            }

                            System.out.println("╚════════╩════════════════════════════════════╩══════════════════════╩══════════════╩════════════════════╩════════════════╝");

                            String queryTransferencias = "select * from transferencias";
                            try (Statement transferencias = conexao.createStatement();
                                 ResultSet transfers = transferencias.executeQuery(queryTransferencias)) {
                                System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                System.out.println("║                                         TABELA: TRANSFERÊNCIAS                                                           ║");
                                System.out.println("╠════════════════════╦═══════════════════════════════╦════════════════════════════════╦══════════════╦═════════════════════╣");
                                System.out.printf(" ║ %-20s ║ %-30s ║ %-30s ║ %-12s ║ %-20s ║%n",
                                        "ID", "Conta de Origem", "Conta de Destino", "Valor (US$)", "Data Movimentação");
                                System.out.println("╠════════════════════╬═══════════════════════════════╬════════════════════════════════╬══════════════╬════════════════════╣");

                                while (transfers.next()) {
                                System.out.printf(" ║ %-20s ║ %-30s ║ %-30s ║ %-12.2f ║ %-20s ║%n",
                                            transfers.getString("id_transferencia"),
                                            transfers.getString("conta_origem"),
                                            transfers.getString("conta_destino"),
                                            transfers.getDouble("valor"),
                                            transfers.getString("data_movimentacao"));
                                }

                                System.out.println("╚════════════════════╩═══════════════════════════════╩════════════════════════════════╩══════════════╩════════════════════╝");

                                String fluxo = "select * from fluxo_caixa";
                                try (Statement fluxodeCaixa = conexao.createStatement();
                                     ResultSet fluxoCaixa = fluxodeCaixa.executeQuery(fluxo)) {
                                    System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                    System.out.println("║                                      TABELA: FLUXO DE CAIXA                                                        ║");
                                    System.out.println("╠════════════╦══════════════════════════════╦════════════════════════════════════════════╦══════════════╦════════════════════╣");
                                    System.out.printf ("║ %-10s ║ %-30s ║ %-40s ║ %-12s ║ %-20s ║%n",
                                            "ID", "Tipo", "Descrição", "Valor (US$)", "Data");
                                    System.out.println("╠════════════╬══════════════════════════════╬════════════════════════════════════════════╬══════════════╬════════════════════╣");

                                    while (fluxoCaixa.next()) {
                                    System.out.printf(" ║ %-10s ║ %-30s ║ %-40s ║ %-12.2f ║ %-20s ║%n",
                                                fluxoCaixa.getString("id"),
                                                fluxoCaixa.getString("tipo_movimentacao"),
                                                fluxoCaixa.getString("descricao"),
                                                fluxoCaixa.getDouble("valor"),
                                                fluxoCaixa.getString("data_movimentacao"));
                                    }
                                    System.out.println("╚════════════╩══════════════════════════════╩════════════════════════════════════════════╩══════════════╩════════════════════╝");

                                    String queryCampanhas = "select * from campanhas";
                                    try (Statement Campanhas = conexao.createStatement();
                                         ResultSet campanha = Campanhas.executeQuery(queryCampanhas)) {
                                        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                        System.out.println("║                                                         TABELA: CAMPANHAS                                                                                          ║");
                                        System.out.println("╠════════════╦══════════════════════════════════════════╦════════════════════════════════════════════════════════╦════════════════╦════════════════╦══════════════╦══════════════════╣");
                                        System.out.printf ("║ %-10s ║ %-40s ║ %-52s ║ %-14s ║ %-14s ║ %-12s ║ %-16s ║%n",
                                                "ID", "Nome da Campanha", "Descrição", "Início", "Término", "Valor (US$)", "Lance Máximo (US$)");
                                        System.out.println("╠════════════╬══════════════════════════════════════════╬════════════════════════════════════════════════════════╬════════════════╬════════════════╬══════════════╬══════════════════╣");

                                        while (campanha.next()) {
                                        System.out.printf(" ║ %-10s ║ %-40s ║ %-52s ║ %-14s ║ %-14s ║ %-12.2f ║ %-16.2f ║%n",
                                                    campanha.getString("id_campanha"),
                                                    campanha.getString("nome_campanha"),
                                                    campanha.getString("descricao_campanha"),
                                                    campanha.getString("data_inicio"),
                                                    campanha.getString("data_termino"),
                                                    campanha.getDouble("valor_investido"),
                                                    campanha.getDouble("maximo_lance"));
                                        }
                                        System.out.println("╚════════════╩══════════════════════════════════════════╩════════════════════════════════════════════════════════╩════════════════╩════════════════╩══════════════╩══════════════════╝");

                                        String queryLocalizacao = "select * from localizacao";
                                        try (Statement Localizacao = conexao.createStatement();
                                             ResultSet localizacao = Localizacao.executeQuery(queryLocalizacao)) {
                                            System.out.println("╔════════════════════════════════════════════════════════╗");
                                            System.out.println("║                   TABELA: LOCALIZAÇÃO                  ║");
                                            System.out.println("╠════════════════════╦════════════════════════╦══════════╣");
                                            System.out.printf ("║ %-18s ║ %-24s║%-8s║%n", "ID", "Cidade", "País");
                                            System.out.println("╠════════════════════╬════════════════════════╬══════════╣");

                                            while (localizacao.next()) {
                                            System.out.printf("║ %-18s ║ %-24s ║ %-8s ║%n",
                                                        localizacao.getString("id_localizacao"),
                                                        localizacao.getString("cidade"),
                                                        localizacao.getString("pais"));
                                            }
                                            System.out.println("╚════════════════════╩════════════════════════╩══════════╝");

                                            String queryPublico = "select * from publico";
                                            try (Statement Publico = conexao.createStatement();
                                                 ResultSet publico = Publico.executeQuery(queryPublico)) {
                                                System.out.println("╔════════════════╦════════════════════╦════════════════╦════════════════════╦════════════════════════════╗");
                                                System.out.println("║ ID             ║ Faixa Etária       ║ Gênero         ║ Renda Média        ║ Consumo                    ║");
                                                System.out.println("╠════════════════╬════════════════════╬════════════════╬════════════════════╬════════════════════════════╣");

                                                while (publico.next()) {
                                                    int id = publico.getInt("id_publico");
                                                    String faixaEtaria = publico.getString("faixa_etaria");
                                                    String genero = publico.getString("genero");
                                                    double rendaMedia = publico.getDouble("renda_media");
                                                    String consumo = publico.getString("consumo");

                                                    System.out.printf("║ %-14d ║ %-18s ║ %-14s ║ %18.2f ║ %-26s ║%n",
                                                            id, faixaEtaria, genero, rendaMedia, consumo);
                                                }

                                                System.out.println("╚════════════════╩════════════════════╩════════════════╩════════════════════╩════════════════════════════╝");

                                                String queryInteresse = "select * from interesse";
                                                try (Statement Interesse = conexao.createStatement();
                                                     ResultSet interesse = Interesse.executeQuery(queryInteresse)) {
                                                    System.out.println("╔════════════════════════════════════════════════════════════════╗");
                                                    System.out.println("║                  TABELA: INTERESSE                             ║");
                                                    System.out.println("╠════════════════╦═══════════════════════════════════════════════╣");
                                                    System.out.printf ("║ %-14s ║ %-43s   ║%n", "PUBLICO ALVO", "INTERESSE");
                                                    System.out.println("╠════════════════╬═══════════════════════════════════════════════╣");

                                                    while (interesse.next()) {
                                                    System.out.printf("║ %-14d ║ %-43s   ║%n",
                                                                interesse.getInt("id_interesse"),
                                                                interesse.getString("descricao"));
                                                    }

                                                    System.out.println("╚════════════════╩═══════════════════════════════════════════════╝");

                                                    String queryCanais = "select * from canais_distribuicao";
                                                    try (Statement canais = conexao.createStatement();
                                                         ResultSet Distribuicao = canais.executeQuery(queryCanais)) {
                                                        System.out.println("╔════════════╦════════════╦════════════════╦════════════════╦════════════════════════════╦════════════════════════════════════════════════════════════════════════════════════╦══════════════╗");
                                                        System.out.println("║ ID Canal   ║ Campanha   ║ Público        ║ Localização    ║ Nome do Canal              ║ Descrição                                                                          ║ Tipo Canal   ║");
                                                        System.out.println("╠════════════╬════════════╬════════════════╬════════════════╬════════════════════════════╬════════════════════════════════════════════════════════════════════════════════════╬══════════════╣");

                                                        while (Distribuicao.next()) {
                                                            System.out.printf("║ %-10d ║ %-10d ║ %-14d ║ %-14d ║ %-26s ║ %-80s   ║ %-12d ║%n",
                                                                    Distribuicao.getInt("id_canais"),
                                                                    Distribuicao.getInt("campanha"),
                                                                    Distribuicao.getInt("publico"),
                                                                    Distribuicao.getInt("localizacao"),
                                                                    Distribuicao.getString("Nome_canal"),
                                                                    Distribuicao.getString("descricao"),
                                                                    Distribuicao.getInt("tipo_canal"));
                                                        }

                                                        System.out.println("╚════════════╩════════════╩════════════════╩════════════════╩════════════════════════════╩════════════════════════════════════════════════════════════════════════════════════╩══════════════╝");
                                                    }
                                                        String queryProduto = "select * from produto_anuncio";
                                                        try (Statement Produto = conexao.createStatement();
                                                        ResultSet produto = Produto.executeQuery(queryProduto)){
                                                            System.out.println("╔════════════╦══════════════════════════════════════════════════════════════════════════════════════════════════════════════╦════════════════════╦══════════════════════════╗");
                                                            System.out.println("║ ID Produto ║ Descrição                                                                                                    ║ Marca              ║ Quantidade Anunciada     ║");
                                                            System.out.println("╠════════════╬══════════════════════════════════════════════════════════════════════════════════════════════════════════════╬════════════════════╬══════════════════════════╣");

                                                            while (produto.next()) {
                                                                int id = produto.getInt("ID");
                                                                String descricao = produto.getString("descricao");
                                                                String marca = produto.getString("marca");
                                                                int quantidade = produto.getInt("quantidade_anunciada");

                                                                // Limitar a descrição para caber na largura da tabela
                                                                if (descricao.length() > 94) {
                                                                    descricao = descricao.substring(0, 91) + "...";
                                                                }

                                                                System.out.printf("║ %-10d ║ %-94s               ║ %-18s ║ %-24d ║%n", id, descricao, marca, quantidade);
                                                            }

                                                            System.out.println("╚════════════╩══════════════════════════════════════════════════════════════════════════════════════════════════════════════╩════════════════════╩══════════════════════════╝");
                                                        }

                                                        String queryClientes = "select * from clientes";
                                                        try (Statement Clientes = conexao.createStatement();
                                                             ResultSet clientes = Clientes.executeQuery(queryClientes)) {
                                                            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                                            System.out.println("║                                 TABELA: CLIENTES                                                    ║");
                                                            System.out.println("╠════════════╬══════════════════════════════════════════╬══════════════════════╬═══════════════════════╬═════════════╬═════════════════════════════╬══════════╣");
                                                            System.out.println("║    ID      ║ Nome                                     ║ Tipo Documento       ║ Número Documento      ║ Telefone    ║ Email                       ║ CEP      ║");
                                                            System.out.println("╠════════════╬══════════════════════════════════════════╬══════════════════════╬═══════════════════════╬═════════════╬═════════════════════════════╬══════════╣");

                                                            while (clientes.next()) {
                                                                System.out.printf(
                                                                        "║ %-10d ║ %-40s ║ %-20s ║ %-21s ║ %-11s ║ %-27s ║ %-8s ║%n",
                                                                        clientes.getInt("id_cliente"),
                                                                        clientes.getString("nome"),
                                                                        clientes.getString("tipo_documento"),
                                                                        clientes.getString("numero_documento"),
                                                                        clientes.getString("telefone_contato"),
                                                                        clientes.getString("email"),
                                                                        clientes.getString("codigo_postal")
                                                                );
                                                            }

                                                            System.out.println("╚════════════╩══════════════════════════════════════════╩══════════════════════╩═══════════════════════╩═════════════╩═════════════════════════════╩══════════╝");

                                                            String queryPagamento = "select * from pagamento";
                                                            try (Statement Pagamento = conexao.createStatement();
                                                                 ResultSet pagamentos = Pagamento.executeQuery(queryPagamento)) {
                                                                System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                                                System.out.println("║                                 TABELA: PAGAMENTOS                                                   ║");
                                                                System.out.println("╔════════════════════╦════════════════════╦════════════════════╦════════════════════╦═════════════════════════╦════════════════════╦════════════════════╦════════════════════╦════════════════════╦═════════════════╗");
                                                                System.out.println("║ ID                ║ Jogo               ║ Unidades Compradas ║ Valor Bruto (US$)  ║ Descontos (US$)        ║ Valor Total (US$)  ║ Forma de Pagamento ║ Data Pagamento     ║ Status            ║");
                                                                System.out.println("╠════════════════════╬════════════════════╬════════════════════╬════════════════════╬═════════════════════════╬════════════════════╬════════════════════╬════════════════════╬════════════════════╣");

                                                                while (pagamentos.next()) {
                                                                    System.out.printf("║ %-18d ║ %-18d ║ %-18d ║ %-18.2f ║ %-21.2f ║ %-18.2f ║ %-18s ║ %-18s ║ %-18s ║%n",
                                                                            pagamentos.getInt("id_pagamento"),
                                                                            pagamentos.getInt("jogos_id"),
                                                                            pagamentos.getInt("unidades_compradas"),
                                                                            pagamentos.getDouble("valor_pedido"),
                                                                            pagamentos.getDouble("descontos"),
                                                                            pagamentos.getDouble("valor"),
                                                                            pagamentos.getString("forma_pagamento"),
                                                                            pagamentos.getDate("data_pagamento"),
                                                                            pagamentos.getString("status_pagamento"));
                                                                }

                                                                System.out.println("╚════════════════════╩════════════════════╩════════════════════╩════════════════════╩═════════════════════════╩════════════════════╩════════════════════╩════════════════════╩════════════════════╝");

                                                                String queryVendas = "select * from vendas_digitais";
                                                                try (Statement Vendas_Digitais = conexao.createStatement();
                                                                     ResultSet vendasDigtais = Vendas_Digitais.executeQuery(queryVendas)) {
                                                                    System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                                                    System.out.println("║                                 TABELA: VENDAS DIGITAIS                                                   ║");
                                                                    System.out.println("╠════════════╦══════════════════╦═══════╦══════════════╦══════════╦════════════════╦════════════════════╦══════════════╦══════════════╦══════════╦══════════╣");
                                                                    System.out.printf("║ %-10s ║ %-16s ║ %-5s ║ %-12s ║ %-8s ║ %-14s ║ %-18s ║ %-14s ║ %-14s ║ %-8s ║ %-8s ║%n",
                                                                            "ID", "Data Venda", "Jogo", "Plataforma", "Unidades", "Localização",
                                                                            "Valor Bruto", "Desconto", "Valor Total", "Cliente", "Pagamento");
                                                                    System.out.println("╠════════════╬══════════════════╬═══════╬══════════════╬══════════╬════════════════╬════════════════════╬══════════════╬══════════════╬══════════╬══════════╣");

                                                                    while (vendasDigtais.next()) {
                                                                        System.out.printf("║ %-10d ║ %-16s ║ %-5d ║ %-12d ║ %-8d ║ %-14d ║ %-18.2f ║ %-14.2f ║ %-14.2f ║ %-8d ║ %-8d ║%n",
                                                                                vendasDigtais.getInt("id_venda_digital"),
                                                                                vendasDigtais.getDate("data_venda"),
                                                                                vendasDigtais.getInt("jogo"),
                                                                                vendasDigtais.getInt("plataforma"),
                                                                                vendasDigtais.getInt("unidades"),
                                                                                vendasDigtais.getInt("localizacao"),
                                                                                vendasDigtais.getDouble("valor_bruto"),
                                                                                vendasDigtais.getDouble("valor_desconto"),
                                                                                vendasDigtais.getDouble("valor_total"),
                                                                                vendasDigtais.getInt("cliente"),
                                                                                vendasDigtais.getInt("pagamento"));
                                                                    }

                                                                    System.out.println("╚════════════╩══════════════════╩═══════╩══════════════╩══════════╩════════════════╩════════════════════╩══════════════╩══════════════╩══════════╩══════════╝");

                                                                    String microTransacoes = "select * from historico_microtransacoes";
                                                                    try (Statement HistoricoMicroTransacoes = conexao.createStatement();
                                                                         ResultSet historicoMicroTransacoes = HistoricoMicroTransacoes.executeQuery(microTransacoes)) {
                                                                        System.out.println("╔════════════╦════════════╦══════════════╦════════════════════╦════════════════╦════════════════╦══════════════════╗");
                                                                        System.out.println("║    ID      ║ Jogo       ║ Pagamento    ║ Item              ║ Valor (US$)   ║ Data Transação ║ Status          ║");
                                                                        System.out.println("╠════════════╬════════════╬══════════════╬════════════════════╬════════════════╬════════════════╬══════════════════╣");

                                                                        while (historicoMicroTransacoes.next()) {
                                                                            System.out.printf(
                                                                                    "║ %-10d ║ %-10d ║ %-12d ║ %-20s ║ %-14.2f ║ %-14s ║ %-16s ║%n",
                                                                                    historicoMicroTransacoes.getInt("id_historico"),
                                                                                    historicoMicroTransacoes.getInt("jogo"),
                                                                                    historicoMicroTransacoes.getInt("pagamento"),
                                                                                    historicoMicroTransacoes.getString("tipo_item"),
                                                                                    historicoMicroTransacoes.getDouble("valor"),
                                                                                    historicoMicroTransacoes.getDate("data_transacao"),
                                                                                    historicoMicroTransacoes.getString("status_transacao")
                                                                            );
                                                                        }

                                                                        System.out.println("╚════════════╩════════════╩══════════════╩════════════════════╩════════════════╩════════════════╩══════════════════╝");

                                                                        String queryFuncionarios = " select * from funcionarios";
                                                                        try (Statement funcionarios = conexao.createStatement();
                                                                             ResultSet Funcionarios = funcionarios.executeQuery(queryFuncionarios)) {
                                                                            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                                                            System.out.println("║                                       TABELA: FUNCIONÁRIOS                                                         ║");
                                                                            System.out.println("╠════════════╦══════════════════════╦════════════════╦════════════════╦════════════════════════╦════════════════╦════════════════════╦════════════════════╣");
                                                                            System.out.printf(" ║ %-10s ║ %-20s ║ %-14s ║ %-14s ║ %-22s ║ %-14s ║ %-18s ║ %-18s ║%n",
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


                                                                            String querySalarios = "select * from salarios";
                                                                            try (Statement salarios = conexao.createStatement();
                                                                                 ResultSet Salarios = salarios.executeQuery(querySalarios)) {
                                                                                System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                                                                System.out.println("║                                       TABELA: SALÁRIOS                                                             ║");
                                                                                System.out.println("╔════════════════╦══════════════════════╦════════════════╦════════════════════╦════════════════╦══════════════════╦════════════════════╦════════════════╗");
                                                                                System.out.println("║ ID Salário     ║ Funcionário          ║ Cargo          ║ Salário (US$)      ║ Bônus (US$)    ║ Início           ║ Fim                ║");
                                                                                System.out.println("╠════════════════╬══════════════════════╬════════════════╬════════════════════╬════════════════╬══════════════════╬════════════════════╬════════════════╣");

                                                                                while (Salarios.next()) {
                                                                                    System.out.printf("║ %-14s ║ %-20s ║ %-16s║ %-18.2f ║%-15.2f ║ %-16s ║ %-16s ║%n",
                                                                                            Salarios.getString("id_salario"),
                                                                                            Salarios.getString("Funcionario"),
                                                                                            Salarios.getString("Cargo"),
                                                                                            Salarios.getDouble("Salario"),
                                                                                            Salarios.getDouble("bonus"),
                                                                                            Salarios.getString("incio"),
                                                                                            Salarios.getString("Fim"));
                                                                                }

                                                                                System.out.println("╚════════════════╩══════════════════════╩════════════════╩════════════════════╩════════════════╩══════════════════╩════════════════════╩════════════════╝");


                                                                                String queryCargos = "select * from cargos";
                                                                                try (Statement Cargos = conexao.createStatement();
                                                                                     ResultSet cargos = Cargos.executeQuery(queryCargos)) {
                                                                                    System.out.println("╔════════════════════════════════════════════╗");
                                                                                    System.out.println("║             TABELA: CARGOS                 ║");
                                                                                    System.out.println("╠════════════════╦═══════════════════════════╣");
                                                                                    System.out.printf ("║ %-14s ║ %-21s  ║%n", "ID","Nome do Cargo");
                                                                                    System.out.println("╠════════════════╬═══════════════════════════╣");

                                                                                    while (cargos.next()) {
                                                                                        System.out.printf("║ %-14s ║ %-21s ║%n",
                                                                                                cargos.getString("ID_Cargo"),
                                                                                                cargos.getString("nome_cargo"));
                                                                                    }

                                                                                    System.out.println("╚════════════════╩═══════════════════════════╝");


                                                                                    String queryDepartamentos = "select * from departamentos";
                                                                                    try (Statement departamentos = conexao.createStatement();
                                                                                         ResultSet Departamentos = departamentos.executeQuery(queryDepartamentos)) {
                                                                                        System.out.println("╔══════════════════════════════════════════════════════════╗");
                                                                                        System.out.println("║                  TABELA: DEPARTAMENTOS                   ║");
                                                                                        System.out.println("╠════════════════════╦═════════════════════════════════════╣");
                                                                                        System.out.printf("║ %-18s ║ %-33s   ║ %n", "ID Departamento",  "Nome Departamento");
                                                                                        System.out.println("╠════════════════════╬═════════════════════════════════════╣");

                                                                                        while (Departamentos.next()) {
                                                                                            System.out.printf("║ %-18s ║ %-33s   ║%n",
                                                                                                    Departamentos.getString("ID_departamento"),
                                                                                                    Departamentos.getString("Nome_departamento"));
                                                                                        }

                                                                                        System.out.println("╚════════════════════╩═════════════════════════════════════╝");


                                                                                        }
                                                                                        {
                                                                                        }
                                                                                    }
                                                                                }

                                                                            }
                                                                        }

                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
