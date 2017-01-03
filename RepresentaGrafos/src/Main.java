
public class Main {

	public static void main(String[] args) {

		Grafo G = new Grafo("G");
		Vertice v0 = new Vertice("A");
		Vertice v1 = new Vertice("B");
		Vertice v2 = new Vertice("C");
		Vertice v3 = new Vertice("D");
		Vertice v4 = new Vertice("E");

		v0.adicionar(v1);
		v0.adicionar(v2);
		v1.adicionar(v3);
		v1.adicionar(v3);
		v2.adicionar(v3);
		v2.adicionar(v4);

		G.adicionarVertices(v0);
		G.adicionarVertices(v1);
		G.adicionarVertices(v2);
		G.adicionarVertices(v3);
		G.adicionarVertices(v4);

		G.imprimirVertices();
		System.out.println();
		G.imprimirAdj();
		G.criarArestas();
		G.ordenarPorPeso();
		
		Kruskal k = new Kruskal(G);
	}
}
