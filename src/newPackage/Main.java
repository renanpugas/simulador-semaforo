package newPackage;

import java.util.Scanner;

public class Main {
	
	public static boolean verificaTempo(Processo[] processos) {
		for(int i = 0; i < processos.length; i++) {
			if(processos[i].tempo > 0) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static void exibeProcessos(Semaforo semaforo, Processo[] processos) {
		System.out.println("Semaforo: " + semaforo.estado);
		for(int i = 0; i < processos.length; i++) {
			System.out.println("\nNome do Processo: " + processos[i].nome  
							   + "| Tempo Restante: " + processos[i].tempo
							   + "| Situação: " + processos[i].situacao);
		}
		System.out.println("-------------------------------\n");
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Processo[] processos = new Processo[5];
		Scanner s1 = new Scanner(System.in);
		Semaforo semaforo = new Semaforo();
		int numProcessoExecucao = 0;
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Digite o nome do processo " + i);
			String nome = s1.next();
			System.out.println("Digita o tempo restante");
			int tempo = s1.nextInt();
			processos[i] = new Processo(nome, tempo);

		}
		
		semaforo.down(processos[0]);
		
		while (verificaTempo(processos)) {
			for (int i = 0; i < processos.length; i++) {
					if(semaforo.utilizador.tempo > 0) {
						if(processos[i].tempo > 0) {
							semaforo.down(processos[i]);
						}
											
						semaforo.utilizador.decrementaTempo();
									
						if(processos[i].tempo > 0) {
							if(semaforo.utilizador.tempo == 0) {
								semaforo.up(processos[i]);
							}
						}
						
						else {
							if(!verificaTempo(processos)) {
								semaforo.utilizador.situacao = "F";
								semaforo.estado = true;
							}
						}
						
						exibeProcessos(semaforo, processos);
						Thread.sleep(2000);
						
					}
					
					else {
						if(processos[i].tempo > 0) {
							semaforo.up(processos[i]);
						}
					}
					
				}
				

			}
			exibeProcessos(semaforo, processos);
	}	

	
}
