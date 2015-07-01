package edu.jonathan.ep1;

/*

2015mar24: 
.read(): faz a leitura de um grafo pela entrada padrão
.print(): imprime listas de adjacencia e matriz de adjacencia

Node 'int id': indice dos vertices.
Assume v.id de 0..N-1, obedecendo a ordem de insercao dos vertices.

*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    protected List<Node> Vl; //lista temporaria para criar Adj
    protected int idV; // temporario para contabilizar indices dos vertices no grafo
    public Node[] vertices; // vetor de vertices indexados por 'id'
    public LinkedList[] Adj; // lista de adjacencia
    public int totV, totE; // total de vertices e arestas no grafo
    
    private int[][] distanceMatrix;
    
    public Graph() {
        init();
    }
    protected void init() {
        Vl = new LinkedList<Node>();
        idV = 0;
        totE = 0;
    }

    public void addNode( Node v ) {
        Vl.add( v );
        v.setId( idV );
        idV++;
    }
    
    public void initAdj() { //chamar para finalizar insercao de vertices
        totV = Vl.size();
        Adj = new LinkedList[ totV ]; // 1 lista de adjacencia para cada vertice
        for (int i = 0; i < totV; i++)
            Adj[i] = new LinkedList();
        // cria vetor indexado de vertices
        vertices = new Node[ totV ];
        Iterator it = Vl.iterator();
        while (it.hasNext()) {
            Node v = (Node)it.next();
            vertices[ v.getId() ] = v;
        }
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj( Node u, Node v ) {
        Adj[ u.getId() ].addLast(v);
        totE++;
    }
    
    /*
    //devolve um vetor com os vizinhos de u
    public Node[] getAdj(Node u) {
        int tote = Adj[u.id].size();
        Node[] vAdj = new Node[tote];
        Iterator it = Adj[u.id].iterator();
        int pos = 0;
        while (it.hasNext()) {
            Node v = (Node)it.next();
            vAdj[pos] = v;
            pos++;
        }
    }
    */

    public void print() {
        Graph G = this;
        int n = G.totV;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }
        //System.out.println("\nListas de Adjacencia:");
        for (int i = 0; i < n; i++) {
            Node u = G.vertices[ i ];
            System.out.print( u.getName() + ": " );
            Iterator<Node> it = G.Adj[ u.getId() ].iterator();
            while (it.hasNext()) {
                Node v = it.next();
                System.out.print( v.getName() + ", " );
                int j = v.getId();
                madj[i][j] = 1;
            }
            System.out.println();
        }

        //System.out.println("\nMatriz de Adjacencia:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                System.out.print( madj[ i ][ j ] + " " );
            }
            System.out.println();
        }
        
        System.out.println( "Total de vertices: " + G.totV );
        System.out.println( "Total de arcos: " + G.totE );
    }
	
    public void calculateDistanceMatrix() {
    	
	}
    
    private void breadthFirstSearch( Node node ){
    	
    }
}

