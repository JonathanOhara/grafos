package edu.jonathan.ep1;

import java.util.Scanner;

public class MatrizDist {
	
	public static void main( String[] args ) {
		Graph graph = readGraph();
		
		graph.calculateDistanceMatrix();
	}
	
    public static Graph readGraph() {
    	String name;
        int idFrom, idTo, i, m, n;
    	
        Graph graph = new Graph();
        Node v;
        Scanner scanner = new Scanner( System.in );

        n = scanner.nextInt();
        for ( i = 0; i < n; i++ ) {
            name = scanner.next();
            v = new Node( name );
            graph.addNode( v );
        }
        
        graph.initAdj();
        
        m = scanner.nextInt();
        for ( i = 0; i < m; i++ ) {
            idFrom = scanner.nextInt();
            idTo = scanner.nextInt();
            graph.insertAdj( graph.vertices[ idFrom ], graph.vertices[ idTo ] );
        }
        
        scanner.close();
        
		return graph;
    }
}
