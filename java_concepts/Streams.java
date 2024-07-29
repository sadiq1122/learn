package java_concepts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(10);
        list.add(5);

        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

        System.out.println(collect);

        Optional<Integer> min = list.stream().min(Comparator.comparing(Integer::valueOf));
        System.out.println(min.get());

        Map<Integer, Long> collect2 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry e : collect2.entrySet()) {
            System.out.println(e);
        }

    }

}
