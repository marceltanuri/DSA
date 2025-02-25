class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i][j];
                int enemies = 0;

                if (isEmpty(cell)) {

                    int dir = i - 1;

                    //move up
                    while (dir >= 0 && !hasWall(grid[dir][j])) {
                        enemies += isEnemy(grid[dir][j]) ? 1 : 0;
                        dir--;
                    }

                    //move down
                    dir = i + 1;
                    while (dir < m && !hasWall(grid[dir][j])) {
                        enemies += isEnemy(grid[dir][j]) ? 1 : 0;
                        dir++;
                    }


                    //move right
                    dir = j + 1;
                    while (dir < n && !hasWall(grid[i][dir])) {
                        enemies += isEnemy(grid[i][dir]) ? 1 : 0;
                        dir++;
                    }

                    //move left
                    dir = j - 1;
                    while (dir >= 0 && !hasWall(grid[i][dir])) {
                        enemies += isEnemy(grid[i][dir]) ? 1 : 0;
                        dir--;
                    }

                }

                max = Math.max(max, enemies);

            }
        }

        return max;

    }

    private boolean isEnemy(char c) {
        return c == 'E';
    }

    private boolean hasWall(char c) {
        return c == 'W';
    }

    private boolean isEmpty(char c) {
        return c == '0';
    }

}
