package Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Area_Financeira {
    public static void exibirContas (ResultSet contas) throws SQLException{
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                      TABELA: CONTAS                                                                ║");
        System.out.println("╠════════════════════╦══════════════════════════════════════════════════╦════════════════╦════════════════════╦════════════════════╣");
        System.out.printf ("║ %-18s ║ %-42s       ║ %-14s ║%-20s║%-20s║%n",
                "ID", "Descrição", "Valor (US$)", "Data de Vencimento", "Status Pagamento");
        System.out.println("╠════════════════════╬══════════════════════════════════════════════════╬════════════════╬════════════════════╬════════════════════╣");

        while (contas.next()) {
            System.out.printf("║ %-18s ║ %-42s       ║ %-14.2f ║%-20s║%-20s║%n",
                    contas.getString("id_conta"),
                    contas.getString("tipo_conta"),
                    contas.getFloat("valor"), // Use getFloat() para obter um valor numérico
                    contas.getString("data"),
                    contas.getString("status"));
        }
        System.out.println("╚════════════════════╩══════════════════════════════════════════════════╩════════════════╩════════════════════╩════════════════════╝");
    }

    public static void exibirContasFinanceiras (ResultSet contasFinanceiras) throws SQLException{
        System.out.println("╔════════╦════════════════════════════════════╦══════════════════════╦══════════════╦════════════════════╦════════════════╗");
        System.out.println("║  ID    ║ Nome da Conta                      ║ Tipo da Conta        ║ Agência      ║ Número da Conta    ║ Saldo (US$)    ║");
        System.out.println("╠════════╬════════════════════════════════════╬══════════════════════╬══════════════╬════════════════════╬════════════════╣");

        while (contasFinanceiras.next()) {
            System.out.printf("║ %-6d║ %-36s║%-20s  ║ %-12s ║%-20s║ %14.2f ║%n",
                    contasFinanceiras.getInt("id"),
                    contasFinanceiras.getString("nome_conta"),
                    contasFinanceiras.getString("tipo_conta"),
                    contasFinanceiras.getString("agencia"),
                    contasFinanceiras.getString("numero_conta"),
                    contasFinanceiras.getDouble("saldo"));
        }

        System.out.println("╚════════╩════════════════════════════════════╩══════════════════════╩══════════════╩════════════════════╩════════════════╝");
    }
    public static void exibirTransferencias (ResultSet Transferencias) throws SQLException{
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                         TABELA: TRANSFERÊNCIAS                                                           ║");
            System.out.println("╠════════════════════╦═══════════════════════════════╦════════════════════════════════╦══════════════╦═════════════════════╣");
            System.out.printf("║%-20s║ %-30s║ %-30s ║ %-12s ║ %-20s║%n",
                    "ID", "Conta de Origem", "Conta de Destino", "Valor (US$)", "Data Movimentação");
            System.out.println("╠════════════════════╬═══════════════════════════════╬════════════════════════════════╬══════════════╬═════════════════════╣");

            while (Transferencias.next()) {
                System.out.printf("║%-20s║%-30s ║ %-30s ║ %-12.2f ║ %-20s║%n",
                        Transferencias.getString("id_transferencia"),
                        Transferencias.getString("conta_origem"),
                        Transferencias.getString("conta_destino"),
                        Transferencias.getDouble("valor"),
                        Transferencias.getString("data_movimentacao"));
            }

            System.out.println("╚════════════════════╩═══════════════════════════════╩════════════════════════════════╩══════════════╩═════════════════════╝");
    }

    public static void exibirFluxo (ResultSet Fluxo) throws SQLException {
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                       TABELA: FLUXO DE CAIXA                                                               ║");
        System.out.println("╠════════════╦══════════════════════════════╦══════════════════════════════════════════════════════════╦════════════════╦════════════════════╣");
        System.out.printf ("║ %-10s ║%-30s║ %-50s       ║ %-14s ║%-20s║%n",
                "ID", "Tipo", "Descrição", "Valor (US$)", "Data");
        System.out.println("╠════════════╬══════════════════════════════╬══════════════════════════════════════════════════════════╬════════════════╬════════════════════╣");

        while (Fluxo.next()) {
            System.out.printf("║ %-10s ║%-30s║ %-50s       ║ %14.2f ║%-20s║%n",
                    Fluxo.getString("id"),
                    Fluxo.getString("tipo_movimentacao"),
                    Fluxo.getString("descricao"),
                    Fluxo.getDouble("valor"),
                    Fluxo.getString("data_movimentacao"));
        }

        System.out.println("╚════════════╩══════════════════════════════╩══════════════════════════════════════════════════════════╩════════════════╩════════════════════╝");


    }
}
