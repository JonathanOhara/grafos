package edu.jonathan.exemplo2;

/*

2012fev04: weighted edges

*/

public class WEdge {
    DistNode from, to;
    int w; // edge weight

    public WEdge(DistNode from, DistNode to, int weight) {
        this.from = from;
        this.to = to;
        this.w = weight;
    }
    
    public void setW(int w) {
        this.w = w;
    }
    
}
