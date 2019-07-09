package net.lzzy.algorithm.algorlib;

import android.preference.PreferenceActivity;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lzzy_gxy on 2019/6/28.
 * Description:
 */
public class SimpleMap {
    int vertexCount;
    List<Edge> edges = new ArrayList<>();
    List<Integer> visited;

    public SimpleMap(int v) {
        vertexCount = v;
    }

    public void addEdg(int source, int target, int distance) {
        edges.add(new Edge(source, target, distance));
    }

    public void addTwoWayEdge(int v1, int v2, double distance) {
        addEdg(v1, v2, distance);
        addEdg(v1, v2, distance);
    }

    List<Edge> getConnectdEdge(int source) {
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            if (e.getSource() == source) {
                result.add(e);
            }
        }
        return result;
    }

    private void iterateDepth(int v) {
        if (!visited.contains(v)) {
            visited.add(v);
        }
        if (visited.size() == vertexCount) {
            return;
        }
        List<Edge> vEdges = getConnectdEdge(v);
        for (Edge edge : vEdges) {
            if (visited.contains(edge.getTarget())) {
                continue;
            }
            iterateDepth(edge.getTarget());
        }
    }

    public String iterateDaptFirst() {

        visited = new ArrayList<>();
        iterateDepth(0);
        StringBuilder result = new StringBuilder();
        for (int v : visited) {
            result.append(v).append(",");
        }
        return result.toString();
//        return "015234";
    }

    public String iterateRangeFirst() {
        StringBuilder result=new StringBuilder();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        int head=0,tail=1;
        while (head<tail){
            Integer cursor=queue.poll();
            if (cursor==null){
                break;
            }
            result.append(cursor).append(",");
            List<Edge> vEdges=getConnectdEdge(cursor);
            for (Edge edge:vEdges){
                if (!queue.contains(edge.getTarget())){
                    queue.offer(edge.getTarget());
                    tail++;
                }
                if (tail>vertexCount){
                    break;
                }
            }
            head++;
        }
        while (queue.size()>0){
            result.append(queue.poll()).append(",");
        }

        return result.toString();
    }
}

class Edge {
    public int getSource;
    private int source;

    private int target;

    private double distance;

    Edge(int source, int tagrt, double distance) {
        this.source = source;
        this.target = tagrt;
        this.distance = distance;
    }
    public double getDistance(){
        return 0;
    }

    public Integer getTarget() {
        return null;
    }

    public int getSource() {
        return 0;
    }
}