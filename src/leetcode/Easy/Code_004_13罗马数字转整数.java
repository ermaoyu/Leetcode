package leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * maomaoyu    2019/7/23_21:14
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，
 * 即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Code_004_13罗马数字转整数 {
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int rs = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1< s.length() && map.containsKey(s.substring(i,i+2))){
                rs += map.get(s.substring(i,i+2));
                i += 2;
            }else {
                rs += map.get(s.substring(i,i+1));
                i ++;
            }
        }
        return rs;
    }

    public int romanToInt_2(String s) {
        int value = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]){
                case 'I':
                    value += 1;
                    break;
                case 'V':
                    if (i > 0 && arr[i - 1] == 'I'){
                        value -= 2;
                    }
                    value +=5;
                    break;
                case 'X':
                    if (i > 0 && arr[i - 1] == 'I'){
                        value -= 2;
                    }
                    value += 10;
                    break;
                case 'L':
                    if (i > 0 && arr[i - 1] == 'X'){
                        value -= 20;
                    }
                    value += 50;
                    break;
                case 'C':
                    if (i > 0 && arr[i - 1] == 'X'){
                    value -= 20;
                     }
                    value += 100;
                    break;
                case 'D':
                    if (i > 0 && arr[i - 1] == 'C'){
                        value -= 200;
                    }
                    value += 500;
                    break;
                case 'M':
                    if (i > 0 && arr[i - 1] == 'C'){
                        value -= 200;
                    }
                    value += 1000;
                    break;
            }
        }
        return value;
    }
}
