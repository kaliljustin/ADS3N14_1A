import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
	


	private static Scanner ler;

	public static void main(String[] args) throws IOException {
		// Este try realiza o teste para verificar se o usuário digitou algum valor válido
		try{
		ArrayList<String> agenda = new ArrayList<String>();
		 ler = new Scanner(System.in);
		 int opcao;
		 
		// Realiza a importacao dos dados para o programa
		 Programa.importar(agenda); 
		
		  do {
		      System.out.printf("**** Menu Principal *****\n");
		      System.out.printf("[ 1 ] Listar Contato\n");
		      System.out.printf("[ 2 ] Inserir Contato\n");
		      System.out.printf("[ 3 ] Excluir Contatos\n");
		      System.out.printf("[ 4 ] Pesquisar Contato\n");
		      System.out.printf("[ 0 ] Encerrar o Programa\n");
		      System.out.printf("\nOpção Desejada: ");

		      opcao = ler.nextInt();
		      if (opcao > 4) {
		    	  System.out.println("Você digitou uma opção inválida\n");
		      }
		        switch (opcao) {
		        case 1: Programa.listar(agenda); break;
		        case 2: Programa.incluir(agenda); break;
		        case 3: Programa.excluir(agenda); break;
		        case 4: Programa.pesquisar(agenda);
		        System.out.printf("\n\n");
		      }
		      } while (opcao != 0);
		//Realiza a exportacao dos dados para o txt
		   Programa.exportar(agenda); 
		   {
			   
		   }
		} catch (Exception ioException){
		System.out.printf("Você digitou uma opção inválida");
		}
	}
}

// Nao consegui fazer o trabalho exatamente como o senhor pediu, mas aqui esta o que eu consegui com o auxilio de alguns
//amigos e da internet.
