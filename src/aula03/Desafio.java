package aula03;

import java.util.*;

public class Desafio {
    private static class Item implements Comparable<Item> {
        String nome;
        double valor;

        public Item(String nome, double valor) {
            this.nome = nome;
            this.valor = valor;
        }

        @Override
        public int compareTo(Item i) {
            return Double.compare(this.valor, i.valor);
        }
    }

    private static class Carrinho {
        double limite = 0;
        double total = 0;
        List<Item> lista = new ArrayList<Item>();

        public void setLimite(double limite) {
            this.limite = limite;
        }

        public void listarItens() {
            Collections.sort(this.lista);
            System.out.println("\nCOMPRAS REALIZADAS!");
            this.lista.forEach(item -> System.out.println(item.nome + " - " + item.valor));
            System.out.println("Saldo do cartão: " + (this.limite - this.total));
        }

        public void adicionarItem(String nome, double valor) {
            lista.add(new Item(nome, valor));
            this.total += valor;
        }

    }

    static void main() {
        System.out.println("Digite o limite do cartão: ");
        Scanner scanner = new Scanner(System.in);

        Carrinho carrinho = new Carrinho();
        carrinho.limite = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Limite definido: " + carrinho.limite + "\n");

        int opcao = 1;

        while (opcao == 1) {
            System.out.println("Digite a descrição da compra: ");
            String nome;
            nome = scanner.nextLine();

            System.out.println("Digite o valor da compra: ");
            double valor;
            valor = scanner.nextDouble();
            scanner.nextLine();

            if (carrinho.total + valor > carrinho.limite) {
                System.out.println("\nSaldo insuficiente!");
                break;
            } else {
                carrinho.adicionarItem(nome, valor);
                System.out.println("Compra realizada!\n");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                opcao = scanner.nextInt();
                scanner.nextLine();
            }

        }

        carrinho.listarItens();

        scanner.close();
    }
}
