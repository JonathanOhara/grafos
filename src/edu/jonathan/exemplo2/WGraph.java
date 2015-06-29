package edu.jonathan.exemplo2;

/*

2013out10: grafo ponderado

*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class WGraph extends Graph {
    public DistNode[] V; // vetor de vertices indexados por 'id'
    int INF = 999999;
    public WEdge[][] medge;
    
    public WGraph() {
        init();
    }

    public void addNode(DistNode v) {
        Vl.addLast(v);
        v.id = idV;
        idV++;
    }

    //insert weighted edge (u,v) in Adj[u]
    public void insertAdj(DistNode u, DistNode v, int weight) {
        WEdge e = new WEdge(u,v,weight);
        Adj[u.id].addLast(e);
        totE++;
    }

    public void buildEdgeMatrix() {
        WGraph G = this;
        int n = G.totV;
        this.medge = new WEdge[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                medge[i][j] = null;
        for (int i = 0; i < n; i++) {
            Node u = G.V[i];
            Iterator it = G.Adj[u.id].iterator();
            while (it.hasNext()) {
                WEdge e = (WEdge)it.next();
                Node v = e.to;
                int j = v.id;
                medge[i][j] = e;
            }
        }
    }

    public void initAdj() { //chamar para finalizar insercao de vertices
        totV = Vl.size();
        Adj = new LinkedList[totV]; // 1 lista de adjacencia para cada vertice
        for (int i = 0; i < totV; i++)
            Adj[i] = new LinkedList();
        // cria vetor indexado de vertices
        V = new DistNode[totV];
        Iterator it = Vl.iterator();
        while (it.hasNext()) {
            DistNode v = (DistNode)it.next();
            V[v.id] = v;
        }
    }

    public void read() {
        WGraph G = this;
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        for (int i = 0; i < n; i++) {
            String name = entrada.next();
            DistNode v = new DistNode(name, 0); // para usar fila de prioridade
            G.addNode(v);
        }
        G.initAdj();
        int m = entrada.nextInt();
        for (int i = 0; i < m; i++) {
            int idFrom = entrada.nextInt();
            int idTo = entrada.nextInt();
            int w = entrada.nextInt();
            G.insertAdj(G.V[idFrom], G.V[idTo], w);
        }
        G.buildEdgeMatrix();
    }

    public void print() {
        WGraph G = this;
        int n = G.totV;
        //System.out.println("\nListas de Adjacencia:");
        for (int i = 0; i < n; i++) {
            Node u = G.V[i];
            System.out.print(u.name+": ");
            Iterator it = G.Adj[u.id].iterator();
            while (it.hasNext()) {
                WEdge e = (WEdge)it.next();
                Node v = e.to;
                System.out.print(v.name+"("+e.w+") ");
            }
            System.out.println();
        }

        //System.out.println("\nMatriz de Adjacencia:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (medge[i][j] != null)
                  System.out.print(medge[i][j].w+" ");
                else
                  System.out.print(". ");
            System.out.println();
        }
        
        System.out.println("Total de vertices: "+G.totV);
        System.out.println("Total de arcos: "+G.totE);
    }
    
    public WGraph copy() {
        WGraph G = this;
        int n = G.totV;
        WGraph Gcopy = new WGraph();
        for (int i = 0; i < n; i++) {
            Node v = G.V[i];
            Node vcopy = new Node(v.name);
            Gcopy.addNode(vcopy);
        }
        Gcopy.initAdj();
        for (int i = 0; i < n; i++) {
            Node u = G.V[i];
            Iterator it = G.Adj[u.id].iterator();
            while (it.hasNext()) {
                WEdge e = (WEdge)it.next();
                Node v = e.to;
                Gcopy.insertAdj(G.V[u.id], G.V[v.id], e.w);
            }
        }
        return Gcopy;
    }
    
    /*
    // OBS: se existir arcos de ida e volta com pesos diferentes, atualiza com o maior peso.
    public void undirected() {
        WGraph G = this;
        int n = G.totV;
        for (int i = 0; i < n; i++) 
          for (int j = i+1; j < n; j++)
              if (medge[i][j] != null || medge[j][i] != null) {
                  WEdge e1 = medge[i][j];
                  WEdge e2 = medge[j][i];
                  if (e1 != null && e2 != null) {
                      int max = e1.w;
                      if (max < e2.w)
                          max = e2.w;
                      e1.setW(max);
                      e2.setW(max);
                  }
                  else {
                      Node u, v;
                      int w;
                      if (e1 == null) {
                          u = G.V[i];
                          v = G.V[j];
                          w = medge[j][i].w;
                      }
                      else {
                          u = G.V[j];
                          v = G.V[i];
                          w = medge[i][j].w;
                      }
                      this.insertAdj(u, v, w);
                  }
              }
        this.buildEdgeMatrix();
    }
*/
}

