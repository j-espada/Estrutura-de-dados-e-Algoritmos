
public class Aresta {

	private Vertice v1;
	private Vertice v2;
	private String direcao = "Não Orientado";
	private int peso = 0;

	public Aresta(Vertice v1, Vertice v2) {

		this.v1 = v1;
		this.v2 = v2;

	}

	public Aresta(Vertice v1, Vertice v2, int peso) {

		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;

	}

	public Aresta(Vertice v1, Vertice v2, String dir) {

		this.v1 = v1;
		this.v2 = v2;
		this.direcao = dir;

	}

	public Aresta(Vertice v1, Vertice v2, int peso, String dir) {

		this.v1 = v1;
		this.v2 = v2;
		this.direcao = dir;
		this.peso = peso;

	}

	public Vertice getV1() {
		return v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public int getPeso() {
		return peso;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {

		return "V1 -> " + this.v1.getName() + " V2 -> " + this.v2.getName() + " Peso -> " + this.peso;
	}

}
