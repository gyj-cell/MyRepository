package com.yj.chart;

public class MatrixNDG {
    //图顶点个数
    int size;
    //图顶点名称
    char[] vertexs;
    //图关系矩阵
    int[][] matrix;

    public MatrixNDG(char[] vertexs, char[][] edges) {
        this.vertexs = vertexs;
        size = vertexs.length;
        matrix = new int[size][size];

        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);

            matrix[p1][p2] = 1;
            matrix[p2][p1] = 1;
        }
    }

    public void print(){
        for(int[] i : matrix){
            for (int j : i){
                System.out.print(j+"  ");
            }
            System.out.println();
        }
    }

    public int getPosition(char c){
        for (int i = 0;i < vertexs.length;i++){
            if(vertexs[i] == c){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        char[] vexs = {'A','B','C','D','E','F','G','H','I','J','K'};
        char[][] edge = new char[][]{
                {'A','C'},
                {'A','D'},
                {'A','F'},
                {'B','C'},
                {'C','D'},
                {'E','G'},
                {'D','G'},
                {'I','J'},
                {'J','K'},
                {'E','H'},
                {'H','K'}
        };
        MatrixNDG matrixNDG = new MatrixNDG(vexs, edge);
        matrixNDG.print();
    }

}
