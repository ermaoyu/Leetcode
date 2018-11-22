package leetCode动态规划和贪心每日一刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *      毛毛雨     2018/11/7
 *      假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
 *      k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列
 *
 *      简书详解: https://www.jianshu.com/p/3eee89a6417a
 * */
public class day6_18_406根据身高重建队列 {

    public int[][] reconstructQueue(int[][] people) {
       if(people == null || people.length == 0 || people[0].length == 0){
           return new int[0][0];
       }
        Arrays.sort(people, new Comparator<int[]>() {
            //把二维数组按照,h的降序和K的升序排序
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])return a[1] - b[1];
                return b[0] - a[0];
            }
        });
       int n = people.length;
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add(people[i][1]//按照K的下标插入到数组中
                    ,new int[]{people[i][0],people[i][1]});
        }
        /**
         *  ArrayList.add(int index,e elment)
         *  按下标插入,该如果下标有数值,则插入到后一位并把后面的数值后移
         * */
        //插入完成之后,tmp已经是有序的了
        int [][] ret = new int[n][2];
        for (int i = 0; i < n; i++) {
            ret[i][0] = tmp.get(i)[0];
            ret[i][1] = tmp.get(i)[1];
        }
        return ret;
    }
}
