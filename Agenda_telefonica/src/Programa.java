import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Programa {

	private static Scanner ler;
	private static Scanner ler2;
	private static Scanner ler3;

	//Metodo que faz importacao
	public static void importar(ArrayList<String> agenda) { 
	    try {
	      // instancia o arquivo texto
	      FileReader arq = new FileReader("agenda.txt"); 
	      BufferedReader lerArq = new BufferedReader(arq);
	      String linha = lerArq.readLine();
	      while (linha != null) {
	        agenda.add(linha); // adiciona a linha na agenda
	        linha = lerArq.readLine();
	      }
	      // encerra o arquivo
	      arq.close(); 
	    } catch (IOException e) {
	        System.out.printf("Erro na abertura do arquivo: %s.",
	          e.getMessage());
	    }
	  }
	
	// metodo que realiza exportacao
	 public static void exportar(ArrayList<String> agenda)
			    throws IOException {
			    FileWriter arq = new FileWriter("agenda.txt");
			    PrintWriter gravarArq = new PrintWriter(arq);
			    int i, n = agenda.size();
			    for (i=0; i<n; i++) {
			      gravarArq.printf("%s%n", agenda.get(i));
			    }
			    gravarArq.close();
			  }
	//metodo que inclui um nome e telefone na agenda
	 public static void incluir(ArrayList<String> agenda) { 
		    ler = new Scanner(System.in);
		    String nome, telefone;

		    System.out.printf("\nInforme o nome do contato:\n");
		    nome = ler.nextLine();

		    System.out.printf("\nInforme o telefone do contato:\n");
		    telefone = ler.nextLine();

		    agenda.add(nome + ";" + telefone);
		  }
	// metodo que exclui um nome e um telefone da agenda
	 public static void excluir(ArrayList<String> agenda) {
		    ler2 = new Scanner(System.in);
		    int i;

		    listar(agenda);

		    System.out.printf("\nInforme a posição a ser excluída:\n");
		    i = ler2.nextInt();

		    try {
		      agenda.remove(i);
		    } catch (IndexOutOfBoundsException e) {
		        System.out.printf("\nErro: posição inválida (%s).\n\n",
		          e.getMessage());   
		    }
		  }
	//lista o conteudo da agenda
	  public static void listar(ArrayList<String> agenda) { 
		    System.out.printf("\nListadando os itens da Agenda:\n");
		    int i, n = agenda.size();
		    for (i=0; i<n; i++) {
		      System.out.printf("Posição %d- %s\n", i, agenda.get(i));
		    }
		    System.out.printf("---------------------------------------");
		  }
	//Realiza a pesquisa na agenda
	  public static void pesquisar(ArrayList<String> agenda) {
		    ler3 = new Scanner(System.in);
		    String s;
		    
		    System.out.printf("\nInforme o nome do contato:\n");
		    s = ler3.nextLine();
		    
		    int i, n = agenda.size();
		    //Transforma em maiuscula para realizar a comparação
		    s = s.toUpperCase();
		    String dados[];
		    for (i=0; i<n; i++) {
		      if (agenda.get(i).toUpperCase().indexOf(s) != -1) {
		         dados = agenda.get(i).split(";");
		         System.out.printf("\nNome....: %s", dados[0]);
		         System.out.printf("\nTelefone: %s\n", dados[1]);
		      }
		   }
	  }
}
