package edu.jonathan.ep3;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class CompsFortes {

	public static void main( String[] args ) {
		Graph graph = readGraph();
		graph.calculateDFS();
		System.out.println( graph.getDFSExpression() );
//		test();
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
    	String inString, outString;
    	
    	inString = "6\n1\n2\n3\n4\n5\n6\n14\n0 1\n0 4\n1 0\n1 2\n1 4\n2 1\n2 3\n3 2\n3 4\n3 5\n4 0\n4 1\n4 3\n5 3";
    	outString = "(1 (2 (3 (4 (5 5) (6 6) 4) 3) 2) 1)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 1!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
    	
    	inString = "6\n1\n2\n3\n4\n5\n6\n8\n0 1\n0 3\n1 4\n2 4\n2 5\n3 1\n4 3\n5 5";
    	outString = "(3 3) (6 6) (1 1) (2 (4 (5 5) 4) 2)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 2!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
	
		inString = "5\n\ns\nt\nx\ny\nz\n10\n0 1\n0 3\n1 2\n1 3\n2 4\n3 1\n3 2\n3 4\n4 0\n4 2";
    	outString = "(s (z (x (t (y y) t) x) z) s)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 3!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "6\nu\nv\nw\nx\ny\nz\n8\n0 1\n0 3\n1 4\n2 4\n2 5\n3 1\n4 3\n5 5";
    	outString = "(w w) (z z) (u u) (v (x (y y) x) v)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 4!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "6\n0\n1\n2\n3\n4\n5\n13\n0 1\n0 2\n0 3\n0 4\n0 5\n1 3\n1 4\n2 1\n3 4\n3 5\n4 5\n5 1\n5 2";
    	outString = "(0 0) (1 (2 (5 (3 3) (4 4) 5) 2) 1)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 5!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "8\ns\nt\nu\nv\nw\nx\ny\nz\n13\n0 4\n0 7\n1 2\n1 3\n2 1\n2 3\n3 0\n3 4\n4 5\n5 7\n6 5\n7 4\n7 6";
    	outString = "(t (u u) t) (v v) (s s) (w (z (x (y y) x) z) w)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 6!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n12\n0 1\n0 4\n1 6\n2 1\n2 4\n2 6\n3 0\n3 2\n4 1\n4 3\n5 0\n5 3";
    	outString = "(s s) (a (d (e (c c) e) d) a) (b b) (t t)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 7!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n11\n0 1\n0 4\n1 4\n1 6\n2 6\n3 2\n4 2\n4 3\n4 6\n5 0\n5 3";
    	outString = "(s s) (a a) (b b) (e e) (d d) (c c) (t t)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 8!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "9\na\nb\nc\nd\ne\nf\ng\ns\nt\n14\n0 1\n0 5\n1 2\n1 3\n2 8\n3 2\n3 8\n4 3\n5 4\n5 6\n6 1\n6 4\n7 0\n7 5";
    	outString = "(s s) (a a) (f f) (g g) (e e) (b b) (d d) (c c) (t t)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 9!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "10\na\nb\nc\nd\ne\nf\ng\nh\ns\nt\n16\n0 1\n0 2\n1 3\n1 9\n2 3\n2 5\n3 9\n4 2\n4 5\n5 9\n6 4\n6 7\n7 5\n8 0\n8 2\n8 6";
    	outString = "(s s) (g g) (h h) (e e) (a a) (c c) (f f) (b b) (d d) (t t)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 10!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n12\n0 1\n0 3\n1 2\n1 6\n2 4\n2 6\n3 1\n3 2\n4 0\n5 0\n5 3\n5 4";
    	outString = "(s s) (a (e (c (b (d d) b) c) e) a) (t t)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 11!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n13\n0 1\n1 2\n1 6\n2 4\n2 6\n3 1\n3 2\n4 0\n4 1\n4 3\n5 0\n5 3\n5 4";
    	outString = "(s s) (a (e (c (b (d d) b) c) e) a) (t t)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 12!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		inString = "8\na\nb\nc\nd\ne\nf\ns\nt\n13\n0 1\n0 3\n0 4\n1 3\n1 7\n2 1\n2 3\n3 7\n4 7\n5 2\n6 0\n6 2\n6 5";
    	outString = "(s s) (f f) (c c) (a a) (e e) (b b) (d d) (t t)";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateDFS(  );
		if( !outString.equals( graph.getDFSExpression() ) ){
			System.out.println("ERRO In 13!");
			System.out.println( graph.getDFSExpression() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
    }
}
