import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //classe padrão para entrada de dados
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o limite do cartão de crédito: ");
        double limite = leitura.nextDouble();

        //instaciar a classe CartaoDeCredito
        CartaDeCredito cartao = new CartaDeCredito(limite);

        int sair = 1;
        ArrayList<Compra> listaDeCompras = new ArrayList<>();

        while (sair != 0) {
            System.out.println("Digite a descrição da compra: ");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);


            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitura.nextInt();

                listaDeCompras.add(compra);
            } else {
                System.out.println("Saldo insulficiente !");
                sair = 0;
            }
        }



        //ordenação pelo valor
        listaDeCompras.sort(Comparator.comparing(Compra::getValor));

        System.out.println("********************");
        System.out.println("COMPRAS REALIZADAS");

        for(int i = 0; i < listaDeCompras.size(); i++){
            System.out.println(listaDeCompras.get(i).getDescricao() + " - " + listaDeCompras.get(i).getValor());
        }

        System.out.println("********************");

        System.out.println("\nSaldo do cartão R$ " + cartao.getSaldo());
    }
}
