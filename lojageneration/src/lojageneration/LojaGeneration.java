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
		String nomeUsuario, senhaUsuario;
		
		//carrinho
		final int QUANTIDADE_PRODUTOS = 14;
		int carrinhoQuantidade[] = new int [QUANTIDADE_PRODUTOS];
		int carrinhoCodigo[] = new int [QUANTIDADE_PRODUTOS];
		char opcaoCatalogo;
		int codigoProduto;
		
		//finalização
		double valorCompra, valorIcms, valorTotal, valorParcela;
		int quantidadeParcelas;
		char opcaoPagamento, continua;
		
		
		
		
		leia.close();	

	}
}