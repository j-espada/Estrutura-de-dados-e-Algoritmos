
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 *
 * @author J.Espada
 */
public class Dijkstra {
	Node NIL = null;

	public Dijkstra(Graph G, Node s) {
		run(G, s);

	}

	private void run(Graph G, Node s) {
		inicializeSingleSource(G, s);
		List S = new LinkedList<>();
		Queue<Node> Q = this.getNodes(G);

		while (Q.isEmpty() != true) {

			Node u = extractMin(Q);
			S.add(u);
			for (Node v : this.adjList(G, u.getId())) {

				relax(G, u, v);
			}
		}
	}

	private Queue<Node> getNodes(Graph G) {

		Queue<Node> Q = new LinkedList<>();
		for (Node n : G) {
			Q.add(n);
		}

		return Q;
	}

	private Node extractMin(Queue<Node> q) {
		Node res = null;
		int max = Integer.MAX_VALUE;
		for (Node n : q) {

			int temp = n.getAttribute("d");
			if (max > temp) {
				max = temp;
				res = n;

			}

		}
		q.remove(res);
		return res;
	}

	private List<Node> adjList(Graph G, String idNode) {

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

		System.out.println("Node : " + idNode + "-> " + adjList.toString());
		return adjList;
	}

	private void inicializeSingleSource(Graph G, Node source) {
		for (Node v : G) {

			v.changeAttribute("d", Integer.MAX_VALUE);
			v.changeAttribute("pi", NIL);
		}

		source.changeAttribute("d", 0);
	}

	private void relax(Graph G, Node u, Node v) {

		int vD = v.getAttribute("d");
		int uD = u.getAttribute("d");
		int w = getWeigth(G, u, v);

		if (vD > uD + w) {

			v.changeAttribute("d", uD + w);
			v.changeAttribute("pi", u);
		}

	}

	private int getWeigth(Graph G, Node u, Node v) {
		int res = 0;
		for (Edge edge : G.getEachEdge()) {

			if (edge.getNode0().equals(u) && edge.getNode1().equals(v)) {

				res = edge.getAttribute("w");
			} else if (edge.getNode0().equals(v) && edge.getNode1().equals(u)) {
				res = edge.getAttribute("w");
			}

		}
		return res;
	}
}
