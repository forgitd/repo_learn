import java.util.*;

public class test3_up {
    static class Pos { // static 方法调用 static 类
        int x, y;
        int step;
        Pos(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public static int bfs(int[][] map, int m, int n, Pos start, Pos end) {
        boolean[][] vis = new boolean[m][n];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        // start 主动寻找 end
        Queue<Pos> q = new LinkedList<>();
        q.offer(start);
        vis[start.x][start.y] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 1; i <= size; i++) {
                Pos cur = q.poll();
                if(cur.x == end.x && cur.y == end.y) return cur.step;
                int newX = cur.x, newY = cur.y;
                while(newY+1 < n && !vis[newX][newY+1]) {
                    newY++;
                    if(map[newX][newY] != 0) { // 除 start 点之外的非 0 点是不能入队的！！！
                        if(newX == end.x && newY == end.y) return cur.step+1;
                        break;
                    }
                    q.offer(new Pos(newX, newY, cur.step+1));
                    vis[newX][newY] = true;
                }
                newY = cur.y;
                while(newX+1 < m && !vis[newX+1][newY]) {
                    newX++;
                    if(map[newX][newY] != 0) { // 除 start 点之外的非 0 点是不能入队的！！！
                        if(newX == end.x && newY == end.y) return cur.step+1;
                        break;
                    }
                    q.offer(new Pos(newX, newY, cur.step+1));
                    vis[newX][newY] = true;
                }
                newX = cur.x;
                while(newY-1 >= 0 && !vis[newX][newY-1]) {
                    newY--;
                    if(map[newX][newY] != 0) { // 除 start 点之外的非 0 点是不能入队的！！！
                        if(newX == end.x && newY == end.y) return cur.step+1;
                        break;
                    }
                    q.offer(new Pos(newX, newY, cur.step+1));
                    vis[newX][newY] = true;
                }
                newY = cur.y;
                while(newX-1 >= 0 && !vis[newX-1][newY]) {
                    newX--;
                    if(map[newX][newY] != 0) { // 除 start 点之外的非 0 点是不能入队的！！！
                        if(newX == end.x && newY == end.y) return cur.step+1;
                        break;
                    }
                    q.offer(new Pos(newX, newY, cur.step+1));
                    vis[newX][newY] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        // 初始化，不能分开
        Pos start = new Pos(x, y, 0);
        x = sc.nextInt();
        y = sc.nextInt();
        Pos end = new Pos(x, y, 0);
        int ans = bfs(map, m, n, start, end);
        System.out.println(ans);
    }
}
