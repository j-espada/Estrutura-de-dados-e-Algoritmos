
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author J.Espada
 */
public class GraphBuilder {

	Graph graph;

	public GraphBuilder() {

		this.graph = new SingleGraph("Guia9");
		construiGrafo();

	}

	private Graph construiGrafo() {

		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");

		graph.addEdge("AB", "A", "B").addAttribute("w", 80);
		graph.addEdge("BC", "B", "C").addAttribute("w", 40);
		graph.addEdge("CA", "C", "A").addAttribute("w", 70);

		graph.addNode("W");
		graph.addNode("E");
		graph.addNode("F");

		graph.addEdge("WE", "W", "E").addAttribute("w", 20);
		graph.addEdge("WC", "W", "C").addAttribute("w", 15);
		graph.addEdge("EF", "E", "F").addAttribute("w", 9);
		graph.addEdge("FW", "F", "W").addAttribute("w", 2);

		return graph;
	}

	public Graph getGraph() {

		return this.graph;
	}

	public void representaGrafo() {

		graph.display();
	}

	public List<Node> listaAdjacencia(Graph G, String idNode) {

		Node A = G.getNode(idNode);
		List<Node> adjList = new ArrayList<Node>();
		adjList.add(A);

		for (Edge e : G.getEachEdge()) {

			Node source = e.getSourceNode();
			if (source.equals(A)) {

				Node target = e.getTargetNode();
				adjList.add(target);
			}

		}

		return adjList;
	}

	private int[][] matrizAdj() {

		int n = graph.getNodeCount();
		int[][] adjMatriz = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (graph.getNode(i).hasEdgeBetween(j) == true) {

					adjMatriz[i][j] = 1;

				} else {

					adjMatriz[i][j] = 0;
				}

			}
		}

		return adjMatriz;
	}

	public static void imprimirMatriz(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			System.out.println("");
			for (int j = 0; j < matriz.length; j++) {

				System.out.print(matriz[i][j]);
			}
		}

	}
}
