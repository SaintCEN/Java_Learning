package Collection;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);

        list = (ArrayList<Integer>) list
                .stream()
                .distinct()   //去重
                .sorted((a, b) -> b - a)    //倒序排列
                .map(e -> e+1)    //每个元素都要执行+1操作
                .limit(2)    //只放行前两个元素
                .collect(Collectors.toList());
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        int sum = list2
                .stream()
                .reduce(Integer::sum)   //计算规则为：a是上一次计算的值，b是当前要计算的参数，这里是求和
                .get();    //我们发现得到的是一个Optional类实例，通过get方法返回得到的值
        System.out.println(sum);
    }
}
