package newPackage;

public class Semaforo {

	boolean estado = true;
	Processo utilizador = null;

	public void down(Processo p) {
		if(this.estado == true) {
			this.utilizador = p;
			p.situacao = "E";
			this.estado = false;
		}
		
		else {
			if(p != this.utilizador) {
				p.situacao = "D";
			}
		}
	}

	public void up(Processo p) {
		estado = true;
		utilizador.situacao = "F";
		p.situacao = "L";
		down(p);
	}

}