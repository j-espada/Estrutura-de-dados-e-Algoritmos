import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Grafo {
	Random rand = new Random();
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	private String name;

	public Grafo(String name) {
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
		this.name = name;
	}

	public void imprimirVertices() {

		for (Vertice a : this.vertices) {

			System.out.println(a);

		}
	}

	public void imprimirAdj() {

		for (Vertice a : this.vertices) {
			System.out.println(a.getName() + "-> " + a.getAdj().toString());

		}
	}

	public void adicionarVertices(Vertice v) {
		this.vertices.add(v);

	}

	public void criarArestas() {
		System.out.println("Arestas :");

		for (Vertice v : this.vertices) {

			List<Vertice> adj = v.getAdj();
			for (Vertice vertice : adj) {

				String dir = v.getName() + vertice.getName();
				int peso = rand.nextInt() % 10;
				peso = Math.abs(peso);
				Aresta a = new Aresta(v, vertice, peso, dir);
				System.out.println(
						"V1 -> " + a.getV1().getName() + " V2 -> " + a.getV2().getName() + " Direcção -> " + dir);
				arestas.add(a);
			}

		}

	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public String getName() {
		return name;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void ordenarPorPeso() {

		System.out.println(this.arestas.toString());
		QuickSort qs = new QuickSort(this.arestas);
		System.out.println(this.arestas.toString());
	}

}
