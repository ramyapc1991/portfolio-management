package com.turvo.portfolio.management.resources.java.com.turvo.portfolio.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(Integer.valueOf(1));
        arr.add(Integer.valueOf(2));
        arr.add(Integer.valueOf(3));
        arr.add(Integer.valueOf(4));
        System.out.println(maximumSum(arr));

        System.out.println(minMoves(6,5,1,0,5));
    }

    public static long maximumSum(List<Integer> arr) {
        // Write your code here
        Integer[] a = arr.stream().toArray(Integer[]::new);
        long max = 0;
        for (int i = 0; i < a.length; i++) {
            long sum = a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum = sum + a[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;

    }

    static class cell {
        int x, y;
        int dis;

        public cell(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static int minMoves(int N, int startRow, int startCol, int endRow, int endCol) {
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        // queue for storing states of knight in board
        Vector<cell> q = new Vector<>();

        // push starting position of knight with 0 distance
        q.add(new cell(startRow, startCol, 0));

        cell t;
        int x, y;
        boolean visit[][] = new boolean[N][N];

        // make all cell unvisited
        for (int i = 1; i < N; i++)
            for (int j = 1; j < N; j++)
                visit[i][j] = false;

        // visit starting state
        visit[startRow][startCol] = true;

        // loop untill we have one element in queue
        while (!q.isEmpty()) {
            t = q.firstElement();
            q.remove(0);

            // if current cell is equal to target cell,
            // return its distance
            if (t.x == endRow && t.y == endCol)
                return t.dis;

            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean isInside(int x, int y, int N)
    {
        if (x >= 1 && x < N && y >= 1 && y < N)
            return true;
        return false;
    }


    public static int minMoveRecur(int kx, int ky, int tx, int ty, int[][] table) {
        if (kx == tx && ky == ty)
            return table[0][0];

        else {
            // if value in the table has been calculated already
            if (table[Math.abs(kx - tx)][Math.abs(ky - ty)] != 0)
                return table[Math.abs(kx - tx)][Math.abs(ky - ty)];

                // Linear Positions
                /* Knight can move to -->2 different squares<-- that goes towards the Target */

                // Non-Linear Positions
            /* Knight can move to 4 different squares that
            goes towards the Target of which -->2 are equivalent<-- */

                // For every position of Knight & Target
                // there are 2 different positions i.e. (x1,y1) & (x2,y2), the Knight can move to.
            else {

                int x1, y1, x2, y2;

                // the values of (x1,y1) & (x2,y2) depend upon relative positions of Knight & Target
                // (x1,y1) & (x2,y2) are midway between (kx,ky) & (tx,ty)
                // Their calculations are made accordingly
                if (kx <= tx) {
                    if (ky <= ty) {
                        x1 = kx + 2;
                        y1 = ky + 1;
                        x2 = kx + 1;
                        y2 = ky + 2;
                    } else {
                        x1 = kx + 2;
                        y1 = ky - 1;
                        x2 = kx + 1;
                        y2 = ky - 2;
                    }
                } else {
                    if (ky <= ty) {
                        x1 = kx - 2;
                        y1 = ky + 1;
                        x2 = kx - 1;
                        y2 = ky + 2;
                    } else {
                        x1 = kx - 2;
                        y1 = ky - 1;
                        x2 = kx - 1;
                        y2 = ky - 2;
                    }
                }

                // The minimum steps from (kx,ky) to (tx,ty) = 1 + minimum of steps from (x1, y1) to (x2, y2).
                table[Math.abs(kx - tx)][Math.abs(ky - ty)] = Math.min(minMoveRecur(x1, y1, tx, ty, table), minMoveRecur(x2, y2, tx, ty, table));

                // exchanging the coordinates x with y of both knight and target will result in same min moves.
                table[Math.abs(ky - ty)][Math.abs(kx - tx)] = table[Math.abs(kx - tx)][Math.abs(ky - ty)];

                return table[Math.abs(kx - tx)][Math.abs(ky - ty)];
            }
        }

    }
}

