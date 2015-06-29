package edu.jonathan.exemplo2;

/*

2015mar24: 
.read(): faz a leitura de um grafo pela entrada padrão
.print(): imprime listas de adjacencia e matriz de adjacencia

Node 'int id': indice dos vertices.
Assume v.id de 0..N-1, obedecendo a ordem de insercao dos vertices.

*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    protected LinkedList Vl; //lista temporaria para criar Adj
    protected int idV; // temporario para contabilizar indices dos vertices no grafo
    public Node[] V; // vetor de vertices indexados por 'id'
    public LinkedList[] Adj; // lista de adjacencia
    public int totV, totE; // total de vertices e arestas no grafo
    
    public Graph() {
        init();
    }
    protected void init() {
        Vl = new LinkedList();
        idV = 0;
        totE = 0;
    }

    public void addNode(Node v) {
        Vl.addLast(v);
        v.id = idV;
        idV++;
    }
    
    public void initAdj() { //chamar para finalizar insercao de vertices
        totV = Vl.size();
        Adj = new LinkedList[totV]; // 1 lista de adjacencia para cada vertice
        for (int i = 0; i < totV; i++)
            Adj[i] = new LinkedList();
        // cria vetor indexado de vertices
        V = new Node[totV];
        Iterator it = Vl.iterator();
        while (it.hasNext()) {
            Node v = (Node)it.next();
            V[v.id] = v;
        }
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj(Node u, Node v) {
        Adj[u.id].addLast(v);
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

    public void read() {
        Graph G = this;
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        for (int i = 0; i < n; i++) {
            String name = entrada.next();
            Node v = new Node(name);
            G.addNode(v);
        }
        G.initAdj();
        int m = entrada.nextInt();
        for (int i = 0; i < m; i++) {
            int idFrom = entrada.nextInt();
            int idTo = entrada.nextInt();
            G.insertAdj(G.V[idFrom], G.V[idTo]);
        }
    }

    public void print() {
        Graph G = this;
        int n = G.totV;
        int[][] madj = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                madj[i][j] = 0;
        //System.out.println("\nListas de Adjacencia:");
        for (int i = 0; i < n; i++) {
            Node u = G.V[i];
            System.out.print(u.name+": ");
            Iterator it = G.Adj[u.id].iterator();
            while (it.hasNext()) {
                Node v = (Node)it.next();
                System.out.print(v.name+", ");
                int j = v.id;
                madj[i][j] = 1;
            }
            System.out.println();
        }

        //System.out.println("\nMatriz de Adjacencia:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(madj[i][j]+" ");
            System.out.println();
        }
        
        System.out.println("Total de vertices: "+G.totV);
        System.out.println("Total de arcos: "+G.totE);
    }
}

