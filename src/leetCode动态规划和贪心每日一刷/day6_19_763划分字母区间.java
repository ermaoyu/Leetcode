package leetCode动态规划和贪心每日一刷;

import java.util.ArrayList;
import java.util.List;

public class day6_19_763划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] chs = new int[26];
        for (int i = 0; i < S.length(); i++) {//数组中记录出现过的字符最后出现的位置
          chs[S.charAt(i) - 'a'] = i;
        }
        int index = -1;
        int max = 0;
        for (int i = 0; i < S.length() ; i++) {
            if (chs[S.charAt(i)-'a'] > max)max = chs[S.charAt(i)-'a'];//左侧的数出现的最后位置,字符串中每个字符最后出现位置的整体最大值
            if (max == i){//贪心
                res.add(max - index);
                index = max;
                max = max + 1;
            }
        }
        return res;



    }
}
