package edu.jonathan.ep4;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import edu.jonathan.ep4.Graph;
import edu.jonathan.ep4.Node;

public class MatrizDist2 {
	public static void main( String[] args ) {
		Graph graph = readGraph();
		graph.calculateDistanceMatrixByDikstra();
		System.out.println( graph.getDistanceMatrix() );
//		test();
	}
	
    public static Graph readGraph() {
    	String name;
        int idFrom, idTo, i, m, n, weight;
        
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
    	String inString, outString;
    	
    	inString = "6\n1\n2\n3\n4\n5\n6\n7\n0 1 2\n0 3 4\n1 4 1\n2 4 14\n2 5 3\n3 1 9\n4 3 6";
    	outString = "0 2 . 4 3 . \n. 0 . 7 1 . \n. 29 0 20 14 3 \n. 9 . 0 10 . \n. 15 . 6 0 . \n. . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 1!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
    	
		
    	inString = "5\ns\nt\nx\ny\nz\n10\n0 1 2\n0 3 5\n1 2 4\n1 3 8\n2 4 2\n3 1 2\n3 2 3\n3 4 1\n4 0 7\n4 2 8";
    	outString = "0 2 6 5 6 \n13 0 4 8 6 \n9 11 0 14 2 \n8 2 3 0 1 \n7 9 8 12 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 2!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
	
		
		inString = "6\nu\nv\nw\nx\ny\nz\n7\n0 1 1\n0 3 2\n1 4 2\n2 4 7\n2 5 9\n3 1 2\n4 3 1";
		outString = "0 1 . 2 3 . \n. 0 . 3 2 . \n. 10 0 8 7 9 \n. 2 . 0 4 . \n. 3 . 1 0 . \n. . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 3!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "6\n0\n1\n2\n3\n4\n5\n13\n0 1 7\n0 2 4\n0 3 6\n0 4 4\n0 5 4\n1 3 9\n1 4 8\n2 1 1\n3 4 4\n3 5 5\n4 5 3\n5 1 1\n5 2 3";
		outString = "0 5 4 6 4 4 \n. 0 14 9 8 11 \n. 1 0 10 9 12 \n. 6 8 0 4 5 \n. 4 6 13 0 3 \n. 1 3 10 9 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 4!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "8\ns\nt\nu\nv\nw\nx\ny\nz\n13\n0 4 4\n0 7 3\n1 2 7\n1 3 10\n2 1 1\n2 3 6\n3 0 9\n3 4 3\n4 5 2\n5 7 14\n6 5 5\n7 4 7\n7 6 4";
		outString = "0 . . . 4 6 7 3 \n19 0 7 10 13 15 26 22 \n15 1 0 6 9 11 22 18 \n9 . . 0 3 5 16 12 \n. . . . 0 2 20 16 \n. . . . 21 0 18 14 \n. . . . 26 5 0 19 \n. . . . 7 9 4 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 5!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n12\n0 1 18\n0 4 7\n1 6 10\n2 1 9\n2 4 4\n2 6 20\n3 0 4\n3 2 14\n4 1 5\n4 3 4\n5 0 16\n5 3 13";
		outString = "0 12 25 11 7 . 22 \n. 0 . . . . 10 \n12 9 0 8 4 . 19 \n4 16 14 0 11 . 26 \n8 5 18 4 0 . 15 \n16 28 27 13 23 0 38 \n. . . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 6!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n11\n0 1 16\n0 4 4\n1 4 10\n1 6 5\n2 6 14\n3 2 18\n4 2 7\n4 3 9\n4 6 13\n5 0 20\n5 3 10";
		outString = "0 16 11 13 4 . 17 \n. 0 17 19 10 . 5 \n. . 0 . . . 14 \n. . 18 0 . . 32 \n. . 7 9 0 . 13 \n20 36 28 10 24 0 37 \n. . . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 7!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "9\na\nb\nc\nd\ne\nf\ng\ns\nt\n14\n0 1 13\n0 5 7\n1 2 8\n1 3 7\n2 8 16\n3 2 4\n3 8 18\n4 3 10\n5 4 8\n5 6 9\n6 1 5\n6 4 4\n7 0 20\n7 5 14";
		outString = "0 13 21 20 15 7 16 . 37 \n. 0 8 7 . . . . 24 \n. . 0 . . . . . 16 \n. . 4 0 . . . . 18 \n. . 14 10 0 . . . 28 \n. 14 22 18 8 0 9 . 36 \n. 5 13 12 4 . 0 . 29 \n20 28 36 32 22 14 23 0 50 \n. . . . . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 8!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "10\na\nb\nc\nd\ne\nf\ng\nh\ns\nt\n16\n0 1 14\n0 2 7\n1 3 5\n1 9 13\n2 3 7\n2 5 4\n3 9 16\n4 2 7\n4 5 5\n5 9 9\n6 4 8\n6 7 10\n7 5 7\n8 0 4\n8 2 18\n8 6 20";
		outString = "0 14 7 14 . 11 . . . 20 \n. 0 . 5 . . . . . 13 \n. . 0 7 . 4 . . . 13 \n. . . 0 . . . . . 16 \n. . 7 14 0 5 . . . 14 \n. . . . . 0 . . . 9 \n. . 15 22 8 13 0 10 . 22 \n. . . . . 7 . 0 . 16 \n4 18 11 18 28 15 20 30 0 24 \n. . . . . . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 9!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n12\n0 1 7\n0 3 7\n1 2 8\n1 6 20\n2 4 5\n2 6 18\n3 1 10\n3 2 7\n4 0 13\n5 0 14\n5 3 16\n5 4 9";
		outString = "0 7 14 7 19 . 27 \n26 0 8 33 13 . 20 \n18 25 0 25 5 . 18 \n25 10 7 0 12 . 25 \n13 20 27 20 0 . 40 \n14 21 23 16 9 0 41 \n. . . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 10!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n13\n0 1 10\n1 2 7\n1 6 20\n2 4 4\n2 6 16\n3 1 4\n3 2 9\n4 0 7\n4 1 8\n4 3 7\n5 0 18\n5 3 14\n5 4 13";
		outString = "0 10 17 28 21 . 30 \n18 0 7 18 11 . 20 \n11 12 0 11 4 . 16 \n20 4 9 0 13 . 24 \n7 8 15 7 0 . 28 \n18 18 23 14 13 0 38 \n. . . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 11!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "8\na\nb\nc\nd\ne\nf\ns\nt\n13\n0 1 13\n0 3 9\n0 4 7\n1 3 7\n1 7 18\n2 1 8\n2 3 10\n3 7 16\n4 7 5\n5 2 4\n6 0 20\n6 2 14\n6 5 4";
		outString = "0 13 . 9 7 . . 12 \n. 0 . 7 . . . 18 \n. 8 0 10 . . . 26 \n. . . 0 . . . 16 \n. . . . 0 . . 5 \n. 12 4 14 . 0 . 30 \n20 16 8 18 27 4 0 32 \n. . . . . . . 0 \n";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDistanceMatrixByDikstra(  );
		if( !outString.equals( graph.getDistanceMatrix() ) ){
			System.out.println("ERRO In 12!");
			System.out.println( graph.getDistanceMatrix() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
    }
}