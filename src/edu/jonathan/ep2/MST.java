package edu.jonathan.ep2;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import edu.jonathan.ep2.Graph;
import edu.jonathan.ep2.Node;

public class MST {

	public static void main( String[] args ) {
		Graph graph = readGraph();
		
		graph.calculateMstPrim( graph.vertices.get(0) );
		System.out.println( graph.getGraphWeight() );
//		test();
	}
	
    public static Graph readGraph() {
    	String name;
        int idFrom, idTo, weight, i, m, n;
        
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
            weight = scanner.nextInt();
            graph.insertAdj( idFrom, idTo, weight );
        }
        
        scanner.close();
        
		return graph;
    }
	
   public static void test(){
    	Graph graph;
    	ByteArrayInputStream in;
    	
    	String in1 = "6\n1\n2\n3\n4\n5\n6\n14\n0 1 2\n0 3 4\n1 4 1\n1 0 2\n1 3 9\n2 4 14\n2 5 3\n3 1 9\n3 0 4\n3 4 6\n4 3 6\n4 1 1\n4 2 14\n5 2 3";
    	String out1 = "24";
    	in = new ByteArrayInputStream(in1.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMstPrim( graph.vertices.get(0) );
		if( !out1.equals( String.valueOf( graph.getGraphWeight() ) ) ){
			System.out.println("ERRO In 1!");
			System.out.println( graph.getGraphWeight() );
			System.out.println("Expected");
			System.out.println( out1 );
		}
		System.out.println();
    	
		String in2 = "5\ns\nt\nx\ny\nz\n16\n0 1 2\n0 3 5\n0 4 7\n1 2 4\n1 3 8\n1 0 2\n2 4 8\n2 1 4\n2 3 3\n3 1 8\n3 2 3\n3 4 1\n3 0 5\n4 0 7\n4 2 8\n4 3 1";
    	String out2 = "10";		
    	in = new ByteArrayInputStream(in2.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMstPrim( graph.vertices.get(0) );
		if( !out2.equals( String.valueOf( graph.getGraphWeight() ) ) ){
			System.out.println("ERRO In 2!");
			System.out.println( graph.getGraphWeight() );
			System.out.println("Expected");
			System.out.println( out2 );
		}
    }
}
