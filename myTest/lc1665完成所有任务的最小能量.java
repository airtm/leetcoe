package myTest;

import java.util.Arrays;

/**
 * 平安集团竞赛题 算法第1题
 */
public class lc1665完成所有任务的最小能量 {

    public static void main(String[] args) {
//		int[][] aa = {{1,2},{2,4},{4,8}};
        int[][] aa = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        int test = test(aa);
        System.out.println(test);
    }

    // [[1,2],[2,4],[4,8]]
    // [[1,3],[2,4],[10,11],[10,12],[8,9]]
    public static int test(int[][] tasks) {
        // 先把门槛高与实际消耗差别大的先做了，这样才能保证最小花费 完成所有
        Arrays.sort(tasks, (o1, o2) -> {
            // 相差大的 排前面  降序
            return(o2[1]-o2[0]) - (o1[1]-o1[0]);
        });

        int result = Math.max(tasks[0][0], tasks[0][1]);
        int 总耗费 = 0;
        for (int i = 0; i < tasks.length; i++) {
            // 最后一关跳出
            if(i >= tasks.length-1){
                return result;
            }
            总耗费 += tasks[i][0];
            int 剩余体力 = result - 总耗费;
            // 剩余体力 与完成下一关的体力 取最大值
            int max = Math.max(剩余体力, Math.max(tasks[i + 1][0], tasks[i + 1][1]));
            result = 总耗费 + max;
        }
        return result;
    }
}
