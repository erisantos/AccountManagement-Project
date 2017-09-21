import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Main {
	Scanner scan = new Scanner(System.in);
	HashMap contas = new HashMap();
	
	
	public Main(){
		menu();
	}
	
	private void menu(){
		int opcao=0;
		
		while(true){
			System.out.println("1...Criar conta ordem");
			System.out.println("2...Criar conta prazo");
			System.out.println("3...Criar conta poupança");
			System.out.println("4...Calcular juros");
			System.out.println("5...Sair");
			opcao = scan.nextInt(); scan.nextLine();
			
			switch(opcao){
			case 1:
				criarContaOrdem();
				break;
			
			case 2:
				criarContaPrazo();
				break;
			
			case 3:
				criarContaPoupanca();
				break;
			case 4:
				calcularJuros();
				break;
			case 5:
				System.exit(0);
			}
			
		}
			
			
	}

		
	private void criarContaOrdem(){
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		System.out.println("Saldo inicial: ");
		float saldo = scan.nextFloat();	
		Conta conta = new ContaOrdem("Ordem", nome, saldo);
		contas.put(new Integer( conta.getNrConta() ), conta);
	}
	
	private void criarContaPrazo(){
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		System.out.println("Saldo inicial: ");
		float saldo = scan.nextFloat();	
		Conta conta = new ContaPrazo("Prazo", nome, saldo);
		contas.put(new Integer( conta.getNrConta() ), conta);
	}
	
	private void criarContaPoupanca(){
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		System.out.println("Saldo inicial: ");
		float saldo = scan.nextFloat();	
		Conta conta = new ContaPoupanca("Poupanca", nome, saldo);
		contas.put(new Integer( conta.getNrConta() ), conta);
	}
	
	private void calcularJuros(){
		Iterator iter = contas.entrySet().iterator();
		
		while(iter.hasNext() ){
			Map.Entry entry = (Map.Entry)iter.next();
			Conta conta = (Conta)entry.getValue();
			System.out.println(conta.getNrConta() + "  " + conta.getTipo() + " " + conta.getNome() + "  " + conta.getSaldo() + "  " + conta.juros());
		}
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
