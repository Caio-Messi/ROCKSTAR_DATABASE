package Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vendas {
public static void exibirClientes (ResultSet Clientes) throws SQLException{
    System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
    System.out.println("║                                 TABELA: CLIENTES                                                    ║");
    System.out.println("╠════════════╬══════════════════════════════════════════╬══════════════════════╬═══════════════════════╬═════════════╬═════════════════════════════╬═══════════╣");
    System.out.println("║    ID      ║ Nome                                     ║ Tipo Documento       ║ Número Documento      ║ Telefone    ║ Email                       ║ CEP       ║");
    System.out.println("╠════════════╬══════════════════════════════════════════╬══════════════════════╬═══════════════════════╬═════════════╬═════════════════════════════╬═══════════╣");

    while (Clientes.next()) {
        System.out.printf(
                "║ %-10d ║ %-40s ║ %-20s ║ %-21s ║ %-11s ║ %-27s ║ %-9s ║%n",
                Clientes.getInt("id_cliente"),
                Clientes.getString("nome"),
                Clientes.getString("tipo_documento"),
                Clientes.getString("numero_documento"),
                Clientes.getString("telefone_contato"),
                Clientes.getString("email"),
                Clientes.getString("codigo_postal")
        );
    }

    System.out.println("╚════════════╩══════════════════════════════════════════╩══════════════════════╩═══════════════════════╩═════════════╩═════════════════════════════╩═══════════╝");
}
public static void exibirPagamentos (ResultSet Pagamentos) throws SQLException{
    System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
    System.out.println("║                                 TABELA: PAGAMENTOS                                                   ║");
    System.out.println("╔════════════════════╦════════════════════╦════════════════════╦════════════════════╦═════════════════════════╦════════════════════╦════════════════════╦════════════════════╦════════════════════╗");
    System.out.println("║ ID                 ║ Jogo               ║ Unidades Compradas ║ Valor Bruto (US$)  ║ Descontos (US$)         ║ Valor Total (US$)  ║ Forma de Pagamento ║ Data Pagamento     ║ Status             ║");
    System.out.println("╠════════════════════╬════════════════════╬════════════════════╬════════════════════╬═════════════════════════╬════════════════════╬════════════════════╬════════════════════╬════════════════════╣");

    while (Pagamentos.next()) {
        System.out.printf("║ %-18d ║ %-18d ║ %-18d ║ %-18.2f ║ %-23.2f ║ %-18.2f ║ %-18s ║ %-18s ║ %-18s ║%n",
                Pagamentos.getInt("id_pagamento"),
                Pagamentos.getInt("jogos_id"),
                Pagamentos.getInt("unidades_compradas"),
                Pagamentos.getDouble("valor_pedido"),
                Pagamentos.getDouble("descontos"),
                Pagamentos.getDouble("valor"),
                Pagamentos.getString("forma_pagamento"),
                Pagamentos.getDate("data_pagamento"),
                Pagamentos.getString("status_pagamento"));
    }

    System.out.println("╚════════════════════╩════════════════════╩════════════════════╩════════════════════╩═════════════════════════╩════════════════════╩════════════════════╩════════════════════╩════════════════════╝");
}
public static void exibirVendas (ResultSet vendasDigitais) throws SQLException{
    System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
    System.out.println("║                                 TABELA: VENDAS DIGITAIS                                                   ║");
    System.out.println("╠════════════╦══════════════════╦═══════╦══════════════╦══════════╦════════════════╦════════════════════╦══════════════╦══════════════╦══════════╦══════════╣");
    System.out.printf("║ %-10s ║ %-16s ║ %-5s ║ %-12s ║ %-8s ║ %-14s ║ %-18s ║ %-12s ║ %-12s ║ %-8s ║ %-8s║%n",
            "ID", "Data Venda", "Jogo", "Plataforma", "Unidades", "Localização",
            "Valor Bruto", "Desconto", "Valor Total", "Cliente", "Pagamento");
    System.out.println("╠════════════╬══════════════════╬═══════╬══════════════╬══════════╬════════════════╬════════════════════╬══════════════╬══════════════╬══════════╬══════════╣");

    while (vendasDigitais.next()) {
        System.out.printf("║ %-10d ║ %-16s ║ %-5d ║ %-12d ║ %-8d ║ %-14d ║ %-18.2f ║ %-12.2f ║ %-12.2f ║ %-8d ║ %-8d ║%n",
                vendasDigitais.getInt("id_venda_digital"),
                vendasDigitais.getDate("data_venda"),
                vendasDigitais.getInt("jogo"),
                vendasDigitais.getInt("plataforma"),
                vendasDigitais.getInt("unidades"),
                vendasDigitais.getInt("localizacao"),
                vendasDigitais.getDouble("valor_bruto"),
                vendasDigitais.getDouble("valor_desconto"),
                vendasDigitais.getDouble("valor_total"),
                vendasDigitais.getInt("cliente"),
                vendasDigitais.getInt("pagamento"));
    }

    System.out.println("╚════════════╩══════════════════╩═══════╩══════════════╩══════════╩════════════════╩════════════════════╩══════════════╩══════════════╩══════════╩══════════╝");
}
public static void exibirMicroTransacoes (ResultSet MicroTransacoes) throws SQLException {
    System.out.println("╔════════════╦════════════╦══════════════╦════════════════════╦════════════════╦════════════════════╦════════════════════╦════════════════════╗");
    System.out.println("║    ID      ║   Jogo     ║  Pagamento   ║       Item         ║   Valor (US$)  ║  Moeda Utilizada   ║  Data Transação    ║      Status        ║");
    System.out.println("╠════════════╬════════════╬══════════════╬════════════════════╬════════════════╬════════════════════╬════════════════════╬════════════════════╣");

    while (MicroTransacoes.next()) {
        System.out.printf(
                "║ %-10d ║ %-10d ║ %-12d ║ %-18s ║ %-14.2f ║ %-18s ║%-18s ║ %18s ║%n",
                MicroTransacoes.getInt("id_historico"),
                MicroTransacoes.getInt("jogo"),
                MicroTransacoes.getInt("pagamento"),
                MicroTransacoes.getString("tipo_item"),
                MicroTransacoes.getDouble("valor"),
                MicroTransacoes.getString("moeda_utilizada"),
                MicroTransacoes.getString("data_transacao"),
                MicroTransacoes.getString("status_transacao")
        );
    }

    System.out.println("╚════════════╩════════════╩══════════════╩════════════════════╩════════════════╩════════════════════╩════════════════════╩════════════════════╝");
}
}
