package com.yj.chart;

public class ListNDG {
    Vertex[] vertexLists;
    int size;

    public ListNDG(char[] vertexs, char[][] edges) {
        size = vertexs.length;
        this.vertexLists = new Vertex[size];

        for (int i = 0; i < size; i++) {
            this.vertexLists[i] = new Vertex(vertexs[i]);
        }

        for (char[] edge : edges) {
            int p1 = getPosition(edge[0]);
            vertexLists[p1].add(edge[1]);
            int p2 = getPosition(edge[1]);
            vertexLists[p2].add(edge[0]);
        }
    }

    private int getPosition(char c) {
        for (int i = 0; i < size; i++) {
            if (vertexLists[i].c == c) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        char[][] edge = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'D', 'G'},
                {'I', 'J'},
                {'J', 'K'},
                {'E', 'H'},
                {'H', 'K'}
        };
        ListNDG listNDG = new ListNDG(vexs, edge);
        for (Vertex vertexList : listNDG.vertexLists) {
            while (vertexList != null) {
                System.out.print(vertexList.c + "   ");
                vertexList = vertexList.next;
            }
            System.out.println();
        }
    }


}

class Vertex {
    char c;
    Vertex next;

    Vertex(char c) {
        this.c = c;
    }

    void add(char c) {
        Vertex node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Vertex(c);
    }
}
