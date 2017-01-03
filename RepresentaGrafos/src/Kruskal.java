import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Kruskal {

	public Kruskal(Grafo G) {
		MstKruskal(G);

	}

	private void MstKruskal(Grafo G) {

		TreeSet A = new TreeSet();
		TreeSet Set = new TreeSet();
		List<Aresta> caminho = new ArrayList<>();
		for (Vertice v : G.getVertices()) {

			Set.add(v);

		}

		G.ordenarPorPeso();

		for (Aresta a : G.getArestas()) {
			if (Set.contains(a.getV1()) != Set.contains(a.getV2())) {

				A.add(a);
				Aresta union = new Aresta(a.getV1(), a.getV2());
				caminho.add(union);
			}
		}

		System.out.println(caminho.toString());
	}

}
