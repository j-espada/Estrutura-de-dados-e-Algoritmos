
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.graphstream.graph.*;

/**
 *
 * @author J.Espada
 */
public class Main {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		GraphBuilder gb = new GraphBuilder();
		Graph G = gb.getGraph();
		Node source = G.getNode("C");
		Dijkstra dj = new Dijkstra(gb.getGraph(), source);

	}

}
