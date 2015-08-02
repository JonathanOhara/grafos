

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class FluxoMax {
	public static void main( String[] args ) {
		Graph5 graph = readGraph();
		graph.calculateMaximumFlow();
		System.out.println( graph.getMaximumFlow() );
//		test();
	}
	
    public static Graph5 readGraph() {
    	String name;
        int idFrom, idTo, i, m, n, weight;
        
        Node5 v;
        Scanner scanner = new Scanner( System.in );

        n = scanner.nextInt();
        
        Graph5 graph = new Graph5( n );
        
        for ( i = 0; i < n; i++ ) {
            name = scanner.next();
            v = new Node5( name );
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
    	Graph5 graph;
    	ByteArrayInputStream in;
    	String inString, outString;

    	inString = "7\na\nb\nc\nd\ne\ns\nt\n12\n0 1 18\n0 4 7\n1 6 10\n2 1 9\n2 4 4\n2 6 20\n3 0 4\n3 2 14\n4 1 5\n4 3 4\n5 0 16\n5 3 13";
    	outString = "24";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMaximumFlow(  );
		if( !outString.equals( graph.getMaximumFlow() ) ){
			System.out.println("ERRO In 1!");
			System.out.println( graph.getMaximumFlow() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
    	
		
    	inString = "7\na\nb\nc\nd\ne\ns\nt\n11\n0 1 16\n0 4 4\n1 4 10\n1 6 5\n2 6 14\n3 2 18\n4 2 7\n4 3 9\n4 6 13\n5 0 20\n5 3 10";
    	outString = "29";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMaximumFlow(  );
		if( !outString.equals( graph.getMaximumFlow()) ){
			System.out.println("ERRO In 2!");
			System.out.println( graph.getMaximumFlow() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
	
		
		inString = "9\na\nb\nc\nd\ne\nf\ng\ns\nt\n14\n0 1 13\n0 5 7\n1 2 8\n1 3 7\n2 8 16\n3 2 4\n3 8 18\n4 3 10\n5 4 8\n5 6 9\n6 1 5\n6 4 4\n7 0 20\n7 5 14";
		outString = "25";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMaximumFlow(  );
		if( !outString.equals( graph.getMaximumFlow() ) ){
			System.out.println("ERRO In 3!");
			System.out.println( graph.getMaximumFlow() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "10\na\nb\nc\nd\ne\nf\ng\nh\ns\nt\n16\n0 1 14\n0 2 7\n1 3 5\n1 9 13\n2 3 7\n2 5 4\n3 9 16\n4 2 7\n4 5 5\n5 9 9\n6 4 8\n6 7 10\n7 5 7\n8 0 4\n8 2 18\n8 6 20";
		outString = "20";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMaximumFlow(  );
		if( !outString.equals( graph.getMaximumFlow() ) ){
			System.out.println("ERRO In 4!");
			System.out.println( graph.getMaximumFlow() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n12\n0 1 7\n0 3 7\n1 2 8\n1 6 20\n2 4 5\n2 6 18\n3 1 10\n3 2 7\n4 0 13\n5 0 14\n5 3 16\n5 4 9";
		outString = "24";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMaximumFlow(  );
		if( !outString.equals( graph.getMaximumFlow() ) ){
			System.out.println("ERRO In 5!");
			System.out.println( graph.getMaximumFlow() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
		
		
		inString = "7\na\nb\nc\nd\ne\ns\nt\n13\n0 1 10\n1 2 7\n1 6 20\n2 4 4\n2 6 16\n3 1 4\n3 2 9\n4 0 7\n4 1 8\n4 3 7\n5 0 18\n5 3 14\n5 4 13";
		outString = "31";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMaximumFlow(  );
		if( !outString.equals( graph.getMaximumFlow() ) ){
			System.out.println("ERRO In 6!");
			System.out.println( graph.getMaximumFlow() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();

		
		inString = "8\na\nb\nc\nd\ne\nf\ns\nt\n13\n0 1 13\n0 3 9\n0 4 7\n1 3 7\n1 7 18\n2 1 8\n2 3 10\n3 7 16\n4 7 5\n5 2 4\n6 0 20\n6 2 14\n6 5 4";
		outString = "38";
    	in = new ByteArrayInputStream(inString.getBytes());
    	System.setIn(in);
    	graph = readGraph();
    	graph.calculateMaximumFlow(  );
		if( !outString.equals( graph.getMaximumFlow() ) ){
			System.out.println("ERRO In 7!");
			System.out.println( graph.getMaximumFlow() );
			System.out.println("Expected");
			System.out.println( outString );
		}
		System.out.println();
    }
}
