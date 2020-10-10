package lojageneration;
import java.util.Scanner;
public class LojaGeneration {
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		//catalogo
		String produtos[] = {"Sayajins", "Camiseta Ungidos por Christian", "Camiseta Só Christian salva", "Camisa de manga cumprida feminina", "Camisa social masculina", "Calça social", "Gravata", "Vestido", "Blazer", "Meia Deus abençoe o rolê", "Sapato social masculino", "Sapatilha", "Salto alto", "Camiseta fé"};
		int codigoProdutos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		double valorProdutos[] = {81, 50, 75, 60, 40, 175, 35, 200, 150, 15, 100, 30, 80, 10};
		int estoque[] = {40, 10, 15, 25, 35, 30, 10, 20, 10, 50, 30, 50, 30, 80};
		
		//cadastro e login
		final int LIMITE = 1000;
		String nomeUsuarios[] = new String[LIMITE];
		char sexoUsuarios[] = new char[LIMITE];
		String igrejaUsuarios[] = new String[LIMITE];
		String senhaUsuarios[] = new String[LIMITE];
		int contadorNovoUsuario = 0;
		char opcaoEntrar;
		String nomeUsuario = "0", senhaUsuario;
		
		//carrinho
		final int QUANTIDADE_PRODUTOS = 14;
		int carrinhoQuantidade[] = new int [QUANTIDADE_PRODUTOS];
		int carrinhoCodigo[] = new int [QUANTIDADE_PRODUTOS];
		int carrinhoProdutos[] = new int [QUANTIDADE_PRODUTOS];
		char opcaoCatalogo;
		int codigoProduto;
		double carrinhoValorUnitario[] = new double [QUANTIDADE_PRODUTOS];
		
		//finalização
		double valorCompra = 0, valorIcms = 0, valorTotal = 500, valorParcela = 0;
		int quantidadeParcelas = 0, opcaoPagamento, continua;
		int x = 0;
		
		
		
		/*
		 * Opções de pagamento
		 * Cálculo da compra
		 * Desistir da compra
		 * gerar nota fiscal
		 * Atualizar estoque
		 *
		 */
		
		do {
			System.out.println("Escolha a opção de pagamento: ");
			System.out.println("1 - Dinheiro ou débito com 10% de desconto.");
			System.out.println("2 - Crédito à vista sem juros.");
			System.out.println("3 - Crédito em 2 vezes sem juros.");
			System.out.println("4 - Crédito em 3 vezes sem juros.");
			System.out.print("Opção: ");
			opcaoPagamento = leia.nextInt();
			if (opcaoPagamento < 1 || opcaoPagamento > 4)
			{
				System.out.println("Você digitou uma opção inválida! Tente novamente!\n");
			}
		} while (opcaoPagamento < 1 || opcaoPagamento > 4);
		
		if (opcaoPagamento == 1)
		{
			valorTotal = (valorTotal * 0.9);
			System.out.printf("O valor total da compra é R$ %.2f", valorTotal);
		}
		else if (opcaoPagamento == 2)
		{
			System.out.printf("O valor total da compra é R$ %.2f", valorTotal);
		}
		else if (opcaoPagamento == 3)
		{
			valorParcela = (valorTotal/2);
			System.out.printf("O valor total da compra é R$ %.2f. E o valor de cada parcela é R$ %.2f",valorTotal, valorParcela);
		}
		else
		{
			valorParcela = (valorTotal/3);
			System.out.printf("O valor total da compra é R$ %.2f. E o valor de cada parcela é R$ %.2f",valorTotal, valorParcela);
		}
		
		do {
		System.out.println("\nEscolha uma opção para continuar: ");
		System.out.println("1 - Finalizar a compra.");
		System.out.println("2 - Alterar carrinho.");
		System.out.println("3 - Desistir da compra.");
		System.out.println("Opção: ");
		continua = leia.nextInt();
		
		if (continua < 1 || continua > 3)
		{
			System.out.println("Você digitou uma opção inválida! Tente novamente!\n");
		}
		} while (continua < 1 || continua > 3);
		
		if (continua == 1)
		{
			carrinhoCodigo[x] = codigoProdutos[x];
			carrinhoValorUnitario[x] = valorProdutos[x];
			valorIcms = valorTotal*0.09;
			System.out.println("***** Essa é a nota fiscal da sua compra: *****\n" + "Nome: " + nomeUsuario + "\nProdutos da compra: " + carrinhoCodigo[x] + " | O valor unitário dos produtos é: " + carrinhoValorUnitario[x] + "\nO valor total da sua compra é: R$ " + valorTotal + "\nO valor do ICMS nesta compra foi " + valorIcms + "\nObrigadx pela sua compra!");
			
		}
		else if(continua == 2)
		{
			
		}
		else
		{
			System.out.println("Agradecemos sua visita! Aguardamos ansiosos pelo seu retorno!");
		}
		
	
		
		leia.close();	
	}
}