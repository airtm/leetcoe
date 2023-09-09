package myTest;


/**
 * 平安集团竞赛题 算法第二题
 * 还没写
 */
public class lc1292元素和小于等于阈值的正方形的最大边长 {


    public int maxInsuredArea(int[][] warehouses, int limit) {
        int xx = warehouses.length, n = warehouses[0].length;
        int[][] yyyy = new int[xx + 1][n + 1];
        for (int i = 1; i <= xx; i++) {
            for (int j = 1; j <= n; j++) {
                yyyy[i][j] = warehouses[i - 1][j - 1] + yyyy[i - 1][j] + yyyy[i][j - 1] - yyyy[i - 1][j - 1];
            }
        }
        int result = 0;
        for (int aa = 1; aa <= Math.min(xx, n); aa++) {
            for (int i = 1; i <= xx; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i - aa < 0 || j - aa < 0) {
                        //跳出
                        continue;
                    }
                    int tmp = yyyy[i][j] - yyyy[i - aa][j] - yyyy[i][j - aa] + yyyy[i - aa][j - aa];
                    if (tmp <= limit) {
                        result = Math.max(result, aa);
                    }
                }
            }
        }
        return result;
    }


}
