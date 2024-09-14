import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, E, cnt;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
//            dfs(i);
            bfs(i);
            cnt++;
        }

        bw.write(cnt + " ");
    }

    private static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while (!que.isEmpty()) {
            x = que.poll();

            for (int y : adj[x]) {
                if (visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }

    private static void dfs(int x) throws IOException {
        visit[x] = true;

        for (int y : adj[x]) {

            if (visit[y]) continue;
            dfs(y);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
