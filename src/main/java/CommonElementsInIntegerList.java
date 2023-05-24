import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        // return realization(a, b);
        // return realization1(a, b);
        // return realization2(a, b);
        return realization3(a, b);
    }

    private static Set<Integer> realization3(List<Integer> a, List<Integer> b) {
        HashSet<Integer> tempSet = new HashSet<>(a);

        Set<Integer> set = new HashSet<>();

        for (Integer integer : b) {
            if (tempSet.contains(integer)) {
                set.add(integer);
            }
        }
        return set;
    }

    private static Set<Integer> realization2(List<Integer> a, List<Integer> b) {
        Collection<Integer> intersection = CollectionUtils.intersection(a, b);
        return new HashSet<>(intersection);
    }

    private static Set<Integer> realization1(List<Integer> a, List<Integer> b) {
        return a.stream().filter(b::contains).collect(Collectors.toSet());
    }

    private static Set<Integer> realization(List<Integer> a, List<Integer> b) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : a) {
            if (b.contains(integer)) {
                set.add(integer);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        String[] arrayA = new String[]{"1", "2", "3", "4"};
        String[] arrayB = new String[]{"3", "4", "5", "6"};
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);

//        //1、交集
//        List<String> jiaoList = new ArrayList<>(listA);
//        jiaoList.retainAll(listB);
//        System.out.println(jiaoList);
        Collection intersection = CollectionUtils.intersection(listA, listB);

        System.out.println(intersection);
    }
}
