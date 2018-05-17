package newPackage;

public class Processo {

	String nome;
	int tempo;
	String situacao;

	public Processo(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		this.situacao = "L";

	}
	
	public void decrementaTempo() {
		this.tempo = tempo - 1;
	}
		

}
