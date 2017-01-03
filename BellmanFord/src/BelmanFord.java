
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 *
 * @author J.Espada
 */
public class BelmanFord {

	private Node NIL = null;

	public BelmanFord(Graph G, Node source) {

		run(G, source);
	}

	private boolean run(Graph G, Node source) {
		boolean res;
		inicializeSingleSource(G, source);

		for (int i = 0; i < G.getNodeCount() - 1; i++) {

			for (Edge e : G.getEachEdge()) {

				relax(e);
			}
		}

		for (Edge e : G.getEachEdge()) {
			Node u = e.getNode0();
			Node v = e.getNode1();
			int vD = v.getAttribute("d");
			int uD = u.getAttribute("d");
			int w = e.getAttribute("w");

			if (vD > uD + w) {
				res = false;
				return false;
			}
		}

		res = true;
		System.out.println(res);
		return true;
	}

	private void inicializeSingleSource(Graph G, Node source) {
		for (Node v : G) {

			v.changeAttribute("d", Integer.MAX_VALUE);
			v.changeAttribute("pi", NIL);
		}

		source.changeAttribute("d", 0);
	}

	private void relax(Edge e) {

		Node u = e.getNode0();
		Node v = e.getNode1();
		int vD = v.getAttribute("d");
		int uD = u.getAttribute("d");
		int w = e.getAttribute("w");

		if (vD > uD + w) {

			v.changeAttribute("d", uD + w);
			v.changeAttribute("pi", u);
		}

	}

}
