class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int currentX = x;
        int currentY = y;
        StringBuilder path = new StringBuilder();
        char[] directions = {'d', 'l', 'r', 'u'};
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};

        
        int initialDistance = Math.abs(x - r) + Math.abs(y - c);
        if (initialDistance > k || (k-initialDistance) % 2 != 0) {
            return "impossible";
        }

        
        for (int step = 0; step < k; step++) {
            boolean moved = false;
            for (int d = 0; d < directions.length; d++) {
                char dir = directions[d];
                int nextX = currentX + dx[d];
                int nextY = currentY + dy[d];
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) continue;
                int distance = Math.abs(nextX - r) + Math.abs(nextY - c);
                int nextRemaining = k - (step + 1);
                
                if (distance > nextRemaining) continue;
                if ((nextRemaining - distance) % 2 != 0) continue;
                
                path.append(dir);
                currentX = nextX;
                currentY = nextY;
                moved = true;
                break;
            }
            
            if (!moved) {
                return "impossible";
            }
        }
        if (currentX == r && currentY == c) {
            return path.toString();
        }
        else {
            return "impossible";
        }
                
        
    }
}
