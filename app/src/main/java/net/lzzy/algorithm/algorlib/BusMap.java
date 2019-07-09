package net.lzzy.algorithm.algorlib;

import android.net.wifi.aware.PublishConfig;
import android.provider.Telephony;
import android.util.SparseArray;

import java.lang.annotation.Target;
import java.security.PrivateKey;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

/**
 * Created by lzzy_gxy on 2019/7/9.
 * Description:
 */
public class BusMap extends SimpleMap {
    public static  final int KEY_DEPTH_FIRST=0;
    public static  final int KEY_FYOYD=1;
    public static  final int KTY_DIJKSTRA=2;
    private SparseArray<String> vertexes;
    private double minDistance;
    private int statr,target;

    public BusMap(int v) {
        super(v);
        vertexes = new SparseArray<>();
        for (int i = 0; i < v; i++) {
            vertexes.append(i, String.valueOf(i));
        }
    }

    public void setStart(int start) {
        this.statr = statr;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void rename(int i, String name) {
        vertexes.setValueAt(i, name);
    }

    private void tryWay(int curVertex, double distance) {
        if (minDistance > 0 && distance > minDistance) {
            return;
        }
        if (curVertex == target) {
            if (minDistance == 0 || minDistance > distance) {
                minDistance = distance;
            }
            return;
        }
        List<Edge> vEdges = getConnectdEdge(curVertex);
        for (Edge edge : vEdges) {
            if (visited.contains(edge.getTarget())) {
                continue;
            }
            visited.add(edge.getTarget());
            tryWay(edge.getTarget(), distance + edge.getDistance());
            visited.remove(edge.getTarget());
        }
    }

    private double[][] floyd() {
        double[][] distances = new double[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                distances[i][j] = 999999;
            }
        }
        for (Edge edge : edges) {
            distances[edge.getSource()][edge.getTarget()] = edge.getDistance();
        }
        for (int k = 0; k < vertexCount; k++) {
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        return distances;
    }
        private double[] dikstra(int source) {
            double[] distance = new double[vertexCount];
            for (int i = 0; i < vertexCount; i++) {
                distance[i] = 999999;
            }
            distance[source] = 0;
            List<Edge> vEdges = getConnectdEdge(source);
            for (Edge edge : vEdges) {
                distance[edge.getTarget()] = edge.getDistance();
            }
            visited.add(source);
            int shorVertex = source;
            for (int i = 1; i < vertexCount; i++) {
                double shortDistance = 999999;
                for (int j = 0; j < vertexCount; j++) {
                    if (visited.contains(j) || distance[j] >= shortDistance) {
                        continue;
                    }
                    shortDistance = distance[j];
                    shorVertex = j;
                }
                visited.add(shorVertex);
                List<Edge> shortVertexEdges = getConnectdEdge(shorVertex);
                for (Edge edge : shortVertexEdges) {
                    if (distance[edge.getTarget()] > distance[shorVertex] + edge.getDistance()) {
                        distance[edge.getTarget()] = distance[shorVertex] + edge.getDistance();

                    }
                }
            }
            return distance;
        }
public String getMinDistance(int key){
            visited = new ArrayList<>();
            switch (key) {
                case 0:
                    tryWay(statr, 0);
                    break;
                case 1:
                    minDistance = floyd()[statr][target];
                    break;
                case 2:
                    minDistance = dikstra(statr)[target];
                    break;
                default:
                    minDistance = 0;
                    break;
            }
            return "从" + statr+ "到" + target + "的最短距离为" + minDistance;
        }
}
