import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] parent;
    private static PriorityQueue<Edge> queue;
    
    static class Edge implements Comparable<Edge> {
        int s, e, v;
        
        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        parent = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queue.add(new Edge(s, e, v));
        }
        int useEdge = 0;
        int result = 0;
        
        while (useEdge < n - 1) {
            Edge current = queue.poll();
            if (find(current.s) != find(current.e)) {
                union(current.s, current.e);
                result = result + current.v;
                useEdge++;
            }
        }
        System.out.println(result);
    }
    
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    
}