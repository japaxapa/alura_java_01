import java.util.Scanner;

public class Desafio {
    public static void main() {
        String nome = "Mario Kawakita";
        String tipoDeConta = "Corrente";
        double saldoDaConta = 2500;

        String welcomeMessage = String.format("""
                ************************************************************
                Dados iniciais do cliente:
                
                Nome:           %s
                Tipo conta:     %s
                Saldo inicial:  R$ %.2f
                ************************************************************
                """, nome, tipoDeConta, saldoDaConta);

        System.out.println(welcomeMessage);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        String menu = """
                
                Operações
                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada:
                """;


        while (opcao != 4) {
            System.out.println(menu);
            opcao = scanner.nextInt();
            double valor = 0;

            switch (opcao) {
                case 1:
                    System.out.printf("O saldo atual é R$ %.2f%n", saldoDaConta);
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Informe o valor a receber: ");
                    valor = scanner.nextDouble();
                    saldoDaConta += valor;

                    System.out.printf("Saldo atualizado R$ %.2f %n", saldoDaConta);
                    break;

                case 3:
                    System.out.println("Informe o valor que deseja transferir: ");
                    valor = scanner.nextDouble();

                    if (valor <= saldoDaConta) {
                        saldoDaConta -= valor;
                        System.out.printf("Saldo atualizado R$ %.2f %n", saldoDaConta);
                    } else {
                        System.out.println("Não há saldo suficiente para fazer essa transferência.");
                    }
                    break;
                case 4:
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }


    }
}
