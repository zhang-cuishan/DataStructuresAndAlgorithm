package com.springchang.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：图的数据结构以及算法
 * 日期：2021/06/08
 * 作者：张翠山
 */
public class Graph {

    List<String> vertextList; //保存数据节点的列表

    int[][] edges; //保存边数的二维数组

    int numOfEdges; //边数记录数

    boolean[] visitedList; //记录数组已经访问的数组

    /**
     * 有参构造函数
     * @param n 默认的节点数
     */
    Graph(int n) {
        vertextList = new ArrayList<>(n);//给数组开辟初始值
        edges = new int[n][n];
        numOfEdges = 0;//边数默认为0
        visitedList = new boolean[n];
    }

    public void addVertex(String vertex) {
        vertextList.add(vertex);
    }

    public void addEdge(int v1, int v2) {
        edges[v1][v2] = 1;
        edges[v2][v1] = 1;
        numOfEdges++;
    }

    public int getSize() {
        return vertextList.size();
    }

    //输出矩阵
    public void printEdgesMatrix() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //dfs深度优先遍历
    public void dfs() {
        for (int i = 0; i < getSize(); i++) {
            if(!visitedList[i]) {
                dfs(visitedList, i);
            }
        }
    }

    //深度优先遍历
    public void dfs(boolean[] visitedList, int w) {
        //访问当前节点
        System.out.print(vertextList.get(w)+"->");
        //已经被访问过了，所以标记为已经访问
        visitedList[w] = true;

        //获取当前节点的第一个邻居节点
        int nextIndex = getFirstNeibor(w);
        while(nextIndex != -1) {
            //当前节点有进一个邻接点
            if(!visitedList[nextIndex]) {
                //且下一个节点没被访问过，则递归遍历下一个节点
                dfs(visitedList, nextIndex);
            }

            nextIndex = getNextNeibor(w, nextIndex);
        }
    }

    /**
     * 获取当前节点的第一个邻居节点
     * @param index
     * @return
     */
    public int getFirstNeibor(int index) {
        for (int i = 0; i < getSize(); i++) {
            if(edges[index][i] >= 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取当前节点的下一个灵界节点
     * @param index
     * @param index
     * @return
     */
    public int getNextNeibor(int index, int w) {
        for (int i = w+1; i < getSize(); i++) {
            if(edges[index][i] >= 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] cityNames = new String[]{"北京", "上海", "天津", "重庆", "贵阳", "成都"};

        Graph graph = new Graph(cityNames.length);
        for (String cityName : cityNames) {
            //向图中添加顶点
            graph.addVertex(cityName);
        }
        System.out.println("节点个数 = " + graph.getSize());

        //向图中添加边
        graph.addEdge(0, 1); //连通北京到上海
        graph.addEdge(0, 2); //连通北京到天津
        graph.addEdge(1, 2); //连通上海到天津
        graph.addEdge(1, 4); //连通上海到贵阳
        graph.addEdge(1, 3); //连通上海到重庆
        graph.addEdge(3, 5);

        //输出矩阵
        graph.printEdgesMatrix();

        System.out.println("DFS输出结果:");
        graph.dfs();
    }
}
