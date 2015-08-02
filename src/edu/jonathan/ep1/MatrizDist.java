package edu.jonathan.ep1;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MatrizDist {
	
	public static void main( String[] args ) {
		Graph graph = readGraph();
		graph.calculateDistanceMatrix();
		System.out.println( graph.getDistanceMatrixForPrint() );
		//test();
	}
	
    public static Graph readGraph() {
    	String name;
        int idFrom, idTo, i, m, n;
        
        Node v;
        Scanner scanner = new Scanner( System.in );

        n = scanner.nextInt();
        
        Graph graph = new Graph( n );
        
        for ( i = 0; i < n; i++ ) {
            name = scanner.next();
            v = new Node( name );
            graph.addNode( v );
        }
        
        m = scanner.nextInt();
        
        graph.initAdj( m );
        for ( i = 0; i < m; i++ ) {
            idFrom = scanner.nextInt();
            idTo = scanner.nextInt();
            graph.insertAdj( idFrom, idTo );
        }
        
        scanner.close();
        
		return graph;
    }
    
    public static void test(){
    	Graph graph;
    	ByteArrayInputStream in;
    	
    	String in1 = "6\n1\n2\n3\n4\n5\n6\n14\n0 1\n0 4\n1 0\n1 2\n1 4\n2 1\n2 3\n3 2\n3 4\n3 5\n4 0\n4 1\n4 3\n5 3";
    	String out1 = "0 1 2 2 1 3 \n1 0 1 2 1 3 \n2 1 0 1 2 2 \n2 2 1 0 1 1 \n1 1 2 1 0 2 \n3 3 2 1 2 0 \n";
    	in = new ByteArrayInputStream(in1.getBytes());
    	System.setIn(in);
    	graph = readGraph();
		graph.calculateDistanceMatrix();
		if( !out1.equals( graph.getDistanceMatrixForPrint() ) ){
			System.out.println("ERRO In 1!");
			System.out.println( graph.getDistanceMatrixForPrint() );
			System.out.println("Expected");
			System.out.println( out1 );
		}
    	
		String in2 = "6\n1\n2\n3\n4\n5\n6\n8\n0 1\n0 3\n1 4\n2 4\n2 5\n3 1\n4 3\n5 5";
    	String out2 = "0 1 . 1 2 . \n. 0 . 2 1 . \n. 3 0 2 1 1 \n. 1 . 0 2 . \n. 2 . 1 0 . \n. . . . . 0 \n";		
    	in = new ByteArrayInputStream(in2.getBytes());
    	System.setIn(in);
    	graph = readGraph();
		graph.calculateDistanceMatrix();
		if( !out2.equals( graph.getDistanceMatrixForPrint() ) ){
			System.out.println("ERRO In 2!");
			System.out.println( graph.getDistanceMatrixForPrint() );
			System.out.println("Expected");
			System.out.println( out2 );
		}
    }
}
