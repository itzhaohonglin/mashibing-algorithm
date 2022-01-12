package com.howliked.mashibing.algorithm.class13.unionfind;

/**
 * 省份数量  或者叫 friend-circle
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * <p>
 * 示例1:
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * <p>
 * 示例2:
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 */
public class Code02_NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int N = isConnected[0].length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.sets();
    }

    public static class UnionFind {
        private int[] parent;
        private int[] size;
        private int[] help;
        private int sets;

        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            sets = 0;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean isSameSet(int a, int b) {
            return findParent(a) == findParent(b);
        }

        private int findParent(int val) {
            int hi = 0;
            while (val != parent[val]) {
                help[hi++] = val;
                val = parent[val];
            }
            for (; hi > 0; hi--) {
                parent[help[hi]] = val;
            }
            return val;
        }

        public void union(int a, int b) {
            int fa = findParent(a);
            int fb = findParent(b);
            if (fa != fb) {
                if (size[a] >= size[b]) {
                    size[fa] += size[fb];
                    parent[fb] = fa;
                } else {
                    parent[fa] = fb;
                    size[fb] += size[fa];
                }
                sets--;
            }
        }

        public int sets() {
            return sets;
        }
    }
}
