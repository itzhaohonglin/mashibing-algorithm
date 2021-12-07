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
        int N = isConnected.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.sets;
    }

    public static class UnionFind {
        //记录parent值.parent[i] =k  ==> i的父亲是k
        private int[] parent;
        //size[i]=k    ==> 如果i是代表节点,size[i]才有意义,否则无意义
        //i所在的集合大小是多少
        private int[] size;
        //辅助数组
        private int[] help;
        //一共有多少个集合
        private int sets;

        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            help = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                //默认parent[i] 是自己
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int i, int j) {
            int topI = findTop(i);
            int topJ = findTop(j);
            if (topI != topJ) {
                int sizeI = size[i];
                int sizeJ = size[j];
                if (sizeI > sizeJ) {
                    size[i] += size[j];
                    parent[j] = i;
                } else {
                    size[j] += size[i];
                    parent[i] = j;
                }
                sets--;
            }
        }

        /**
         * 查询顶级节点,并且路径压缩
         *
         * @param i
         * @return
         */
        // 从i开始一直往上，往上到不能再往上，代表节点，返回
        private int findTop(int i) {
            int hi = 0;
            while (i != parent[i]) {
                help[hi++] = i;
                i = parent[i];
            }
            for (; hi >= 0; hi--) {
                parent[help[hi]] = i;
            }
            return i;
        }

        public int sets() {
            return sets;
        }
    }
}
