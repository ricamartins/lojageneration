package lojageneration;
import java.util.Scanner;
public class LojaGeneration {
	
	public static void entradaPrograma() {
		System.out.println("Bem-Vinde a loja Ungidos por Christian!");
		for(int x = 0;x < 16;x++) {
			if(x == 4 || x == 5) {
				System.out.println("\t************************");
			}
			else {
				System.out.println("\t\t  ****          ");
			}
		}
	}
	
	public static void limpaTela() {
		for(int x = 0;x < 50;x++) {
		System.out.println();
		}
	}
	
	public static void catalogo(String nomeUsuario, String produtos[], double valorProdutos[], int estoque[], int codigoProdutos[]) {
		
		Scanner leia = new Scanner(System.in);
		
		//carrinho
		final int QUANTIDADE_PRODUTOS = 14;
		int carrinhoQuantidade[] = new int [QUANTIDADE_PRODUTOS];
		int carrinhoCodigo[] = new int [QUANTIDADE_PRODUTOS];
		char opcaoCatalogo;
		int codigoProduto;
		int quantidadeProduto;
		int contadorNovoProduto = 0;
		double somaCarrinho = 0;
		int indiceProduto = -1;
		char cancelar;
		//finaliza��o
		double valorIcms = 0, valorTotal = 500, valorParcela = 0;
		int  opcaoPagamento, continua;
		
		do 
		{
			
			System.out.println("\n\nLISTA DE PRODUTOS\n");
			
			for (int x = 0; x < QUANTIDADE_PRODUTOS; x++ )	
			{
				
				System.out.printf("C�digo: %d\t Em estoque: %d\t Valor: R$ %.2f\t %s\n", codigoProdutos[x], estoque[x], valorProdutos[x], produtos[x]);
				
			}
			
			System.out.println("\nSTATUS DO CARRINHO");
			
			if (contadorNovoProduto ==0) 
			{
				System.out.println("Seu carrinho est� vazio");
			}
			
			else 
			{
				somaCarrinho =0;
				
				for (int x = 0; x < contadorNovoProduto; x++) 
				{
					System.out.printf("\nCodigo: %d\t Quantidade: %d\t Valor R$%.2f\t %s\n", carrinhoCodigo[x],carrinhoQuantidade[x], valorProdutos[carrinhoCodigo[x]-1], produtos[carrinhoCodigo[x]-1]);
					
					somaCarrinho = somaCarrinho +(carrinhoQuantidade[x]*valorProdutos[carrinhoCodigo[x]-1]);
					
				}
					System.out.printf("\nValor atual da compra: R$ %.2f\n",somaCarrinho);
			}
				
			System.out.println("\nMENU\n");
			
			System.out.println("Adicionar ao carrinho - Op��o 1");
			
			System.out.println("Remover item do carrinho - Op��o 2");
			
			System.out.println("Editar compra - Op��o 3");
			
			System.out.println("Finalizar compra - Op��o 4");
			
			System.out.println("Cancelar compra - Op��o 5");
			
			
			
			opcaoCatalogo = leia.next().charAt(0);
			
			if (opcaoCatalogo == '1') 
			{
				System.out.print("\nDigite o c�digo do item que voc� deseja: ");
				
				codigoProduto = leia.nextInt();
				
				if (estoque [codigoProduto -1]== 0)
				{
					System.out.println("O produto est� em falta" );
				}
				
				else 
				{
					System.out.print("\nDigite a quantidade desejada: ");
					
					quantidadeProduto= leia.nextInt();
					
					if (quantidadeProduto > estoque [codigoProduto-1]) 
					{
						System.out.println("Quantidade indispon�vel! Tente novamente: ");
					}
					
					else 
					{
						System.out.println("Adicionando ao carrinho...");
						
						carrinhoCodigo[contadorNovoProduto]= codigoProduto;
						carrinhoQuantidade[contadorNovoProduto]=quantidadeProduto;
						
						contadorNovoProduto++;
					}
				}
			
			}
			
			else if (opcaoCatalogo == '2') 
			{	
				
				System.out.print("\nDigite o c�digo do item que voc� deseja remover: ");
				
				codigoProduto = leia.nextInt();
				
				System.out.println("Removendo item...");
				
				indiceProduto = -1;
				for (int x = 0; x < contadorNovoProduto; x++) 
				{
					if (carrinhoCodigo[x] == codigoProduto) 
					{
						indiceProduto = x;
						break;
					}
				}
				
				if (indiceProduto == -1) 
				{
					System.out.println("Este produto n�o consta no seu carrinho");
				}
				
				else 
				{
					for (int x = indiceProduto; x < contadorNovoProduto-1;x++) 
					{
						carrinhoCodigo[x]= carrinhoCodigo[x +1];
						carrinhoQuantidade[x]= carrinhoQuantidade[x +1];	
					}
					
					contadorNovoProduto--;
				}
			}
			
			
			else if (opcaoCatalogo=='3') 
			{
				System.out.print("\nDigite o c�digo do item que voc� deseja alterar: ");
				
				codigoProduto = leia.nextInt();
				
				indiceProduto = -1;
				for (int x = 0; x < contadorNovoProduto; x++) 
				{
					if (carrinhoCodigo[x] == codigoProduto) 
					{
						indiceProduto = x;
						break;
					}
				}
				
				if (indiceProduto == -1)
				{
					System.out.println("O produto n�o est� no seu carrinho");
				}
				
				else 
				{
					System.out.printf("Em estoque: %d\t no carrinho: %d\n",estoque[carrinhoCodigo[indiceProduto]-1],carrinhoQuantidade[indiceProduto]);
					
					System.out.print("\nDigite a quantidade desejada: ");
					
					quantidadeProduto= leia.nextInt();
					
					if (quantidadeProduto > estoque [codigoProduto -1]) 
					{
						System.out.println("Quantidade indispon�vel! Tente novamente: ");
					}
					
					else 
					{
						System.out.println("Alterando compra...");
						carrinhoQuantidade[indiceProduto] = quantidadeProduto;
					}
				}
			
			}
				
			
			else if (opcaoCatalogo == '4') 
			{
				
				do {
					System.out.println("\nEscolha a op��o de pagamento: ");
					System.out.println("1 - Dinheiro ou D�bito com 10% de desconto");
					System.out.println("2 - Cr�dito � vista sem juros");
					System.out.println("3 - Cr�dito em 2 vezes sem juros");
					System.out.println("4 - Cr�dito em 3 vezes sem juros");
					System.out.print("Op��o: ");
					opcaoPagamento = leia.nextInt();
					if (opcaoPagamento < 1 || opcaoPagamento > 4) 
					{
						System.out.println("\nVoc� digitou uma op��o inv�lida! Tente novamente!\n");
					}
				} while (opcaoPagamento < 1 || opcaoPagamento > 4);
				
				if (opcaoPagamento == 1)
				{
					somaCarrinho = (somaCarrinho * 0.9);
					System.out.printf("\nO valor total da compra � R$ %.2f", somaCarrinho);
				}
				else if (opcaoPagamento == 2)
				{
					System.out.printf("\nO valor total da compra � R$ %.2f", somaCarrinho);
				}
				else if (opcaoPagamento == 3)
				{
					valorParcela = (somaCarrinho/2);
					System.out.printf("\nO valor total da compra � R$ %.2f. E o valor de cada parcela � R$ %.2f",somaCarrinho, valorParcela);
				}
				else
				{
					valorParcela = (somaCarrinho/3);
					System.out.printf("\nO valor total da compra � R$ %.2f. E o valor de cada parcela � R$ %.2f",somaCarrinho, valorParcela);
				}
				
				do {
				System.out.println("\n\nEscolha uma op��o para continuar: ");
				System.out.println("1 - Finalizar a compra");
				System.out.println("2 - Alterar carrinho");
				System.out.println("3 - Desistir da compra");
				System.out.println("Op��o: ");
				continua = leia.nextInt();
				
				if (continua < 1 || continua > 3)
				{
					System.out.println("Voc� digitou uma op��o inv�lida! Tente novamente!\n");
				}
				} while (continua < 1 || continua > 3);
				
				if (continua == 1)
				{
					System.out.println("\n***** Essa � a nota fiscal da sua compra: *****\n" + "Nome: " + nomeUsuario );
					for(int i = 0; i < contadorNovoProduto; i++) {
						System.out.printf("Produtos: %s -  R$ %.2f\n", produtos[carrinhoCodigo[i]-1], valorProdutos[carrinhoCodigo[i]-1]);
					}
					valorIcms = somaCarrinho*0.09;
					System.out.printf("O valor total da sua compra �: R$%.2f \nO valor do ICSM nessa compra �: R$%.2f \nObrigade pela sua compra!", somaCarrinho, valorIcms);

						for(int i = 0; i < contadorNovoProduto; i++)
					{
						estoque[carrinhoCodigo[i]-1] = estoque[carrinhoCodigo[i]-1] - carrinhoQuantidade[i];
					}
				}
				else if(continua == 2)
				{
					System.out.println("Voltando pro carrinho...");
				}
				else
				{
					System.out.println("Agradecemos a sua visita! Aguardamos ansioses pelo seu retorno!");
				}
				
				break; 
			}
		
 
			else if (opcaoCatalogo == '5') 
			{
				System.out.println("Deseja mesmo cancelar? S - Sim ou N - N�o : ");
				cancelar = leia.next().toUpperCase().charAt(0);
				
				if(cancelar == 'S') 
				{
					System.out.println("\nVoc� cancelou a compra ");
					contadorNovoProduto = 0;
					break;
				}
				
				
			}
			
			else 
			{
				System.out.println("Op��o inv�lida! ");
			}
		
		} while (true);
		
	}
	
	
	public static void main(String[] args)throws InterruptedException {
		
		Scanner leia = new Scanner(System.in);
		
		//catalogo
		String produtos[] = {"Sayajins", "Camiseta Ungidos por Christian", "Camiseta S� Christian salva", "Camisa de manga cumprida feminina", "Camisa social masculina", "Cal�a social", "Gravata", "Vestido", "Blazer", "Meia Deus aben�oe o rol�", "Sapato social masculino", "Sapatilha", "Salto alto", "Camiseta f�"};
		int codigoProdutos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		double valorProdutos[] = {81, 50, 75, 60, 40, 175, 35, 200, 150, 15, 100, 30, 80, 10};
		int estoque[] = {40, 10, 15, 25, 35, 30, 10, 20, 10, 50, 30, 50, 30, 80};
		
		//cadastro e login
		final int LIMITE = 100;
		String nomeUsuarios[] = new String[LIMITE];
		String igrejaUsuarios[] = new String[LIMITE];
		String senhaUsuarios[] = new String[LIMITE];
		String nomeUsuario = " ", senhaUsuario;
		char sexoUsuarios[] = new char[LIMITE];
		char opcaoEntrar,opcaoCadastro = ' ',opcaoRetorno = ' ';
		int contadorNovoUsuario = 0,numeroTentativa = 3,x = 0;
		
		do {		
		/*
		 * Cadastro e Login de usuario
		 */
		entradaPrograma();
		Thread.sleep(5000);
		limpaTela();
		
		System.out.print("Voc� deseja fazer L - Login ou C - Cadastro? ");
		opcaoEntrar = leia.next().toUpperCase().charAt(0);

		switch (opcaoEntrar) {
		case 'C': {
			System.out.print("\nA op��o escolhida foi: " + opcaoEntrar + " - Cadastro!");
			Thread.sleep(3500);
			limpaTela();
			
			do {
				System.out.printf("Digite o seu nome de usu�rio: ");
				nomeUsuarios[contadorNovoUsuario] = leia.next();
				
				System.out.printf("Digite a sua senha do usu�rio: ");
				senhaUsuarios[contadorNovoUsuario] = leia.next();
				
				System.out.printf("Digite o seu sexo \nM - Masculino \nF - Feminino \nQualquer letra(Escolha o que voc� se sinta � vontade!): ");
				sexoUsuarios[contadorNovoUsuario] = leia.next().toUpperCase().charAt(0);
				
				System.out.printf("Digite a sua Igreja: ");
				igrejaUsuarios[contadorNovoUsuario] = leia.next();
				
				limpaTela();
				
				System.out.println("\nDados Cadastrados: ");
				
				System.out.printf("\nO Nome de usu�rio �: %s",nomeUsuarios[contadorNovoUsuario]);
				
				System.out.printf("\nA senha cadastrada foi: %s",senhaUsuarios[contadorNovoUsuario]);
				
				System.out.printf("\nO sexo do usu�rio %s �: %s",nomeUsuarios[contadorNovoUsuario],sexoUsuarios[contadorNovoUsuario]);
				
				System.out.printf("\nA igreja do usu�rio %s �: %s",nomeUsuarios[contadorNovoUsuario],igrejaUsuarios[contadorNovoUsuario]);
				
				System.out.print("\n\nDeseja cadastrar outra pessoa?\nOp��es (Sim/N�o)");
				opcaoCadastro = leia.next().toUpperCase().charAt(0);
				if(opcaoCadastro != 'S' && opcaoCadastro != 'N') {
					do {
						System.out.print("Op��o inv�lida. \nDigite S para Cadastrar outra pessoa ou N para ir para o Login: ");
						opcaoCadastro = leia.next().toUpperCase().charAt(0);
					}while(opcaoCadastro != 'S' && opcaoEntrar != 'N');
				}
				contadorNovoUsuario++;
			}while(opcaoCadastro != 'N');
			
		}
		case 'L':{
			System.out.print("\nVoc� ser� direcionado para o Login da aplica��o");
			Thread.sleep(3500);
			limpaTela();
			
		
			System.out.print("Digite seu nome de usu�rio: ");
			nomeUsuario = leia.next();
			for(x = 0;x < nomeUsuarios.length;x++) {

				if(nomeUsuario.equals(nomeUsuarios[x])) {
					break;
				}
			
				
			}
			if(nomeUsuario.equals(nomeUsuarios[x])) {
				do
				{
					System.out.print("\nVoc� tem " + numeroTentativa + " tentativas!\n");
					System.out.print("\nDigite a senha do usu�rio: " + nomeUsuario);
					System.out.print("\nDigite a sua senha: ");
					senhaUsuario = leia.next();
					if(senhaUsuario.equals(senhaUsuarios[x])){
						numeroTentativa = 0;
					}else{
						numeroTentativa = numeroTentativa - 1;
					}
					
				} while(numeroTentativa > 0);
				if(senhaUsuario.equals(senhaUsuarios[x])){
					System.out.print("\nSeja Bem-Vinde "+nomeUsuario+"!");
					catalogo(nomeUsuario,produtos,valorProdutos,estoque,codigoProdutos);
					
				}else if(numeroTentativa == 0){
					System.out.print("Limite de tentativas alcan�ado. Tente novamente depois! ");
				}else {
					System.out.println("Usu�rio n�o cadastrado. Tente novamente! ");
				}
			
			}
			
			break;
		
		}
		default:
			do {
				System.out.print("Op��o inv�lida. Digite L para Login ou C para Cadastro: ");
				opcaoEntrar = leia.next().toUpperCase().charAt(0);
			}while(opcaoEntrar != 'L' && opcaoEntrar != 'C');
			break;
		}
		
		System.out.println("Deseja continuar? S - Sim / N - N�o ");
		opcaoRetorno = leia.next().toUpperCase().charAt(0);
		
		}while(opcaoRetorno != 'N');		
	}
}