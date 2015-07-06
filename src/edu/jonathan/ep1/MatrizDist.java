package edu.jonathan.ep1;

import java.util.Scanner;

/*
6
1
2
3
4
5
6
14
0 1
0 4
1 0
1 2
1 4
2 1
2 3
3 2
3 4
3 5
4 0
4 1
4 3
5 3
*/

/*
6
1
2
3
4
5
6
8
0 1
0 3
1 4
2 4
2 5
3 1
4 3
5 5
 */

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
