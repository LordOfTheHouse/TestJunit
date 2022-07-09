package com.example.stream;

import com.example.Reptiloyd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamWork {

  public static void main(String[] args) {
    // 1
    List<Integer> li = List.of(7, 2, 236, 11, 76, 67, 81, 88, 93, 128);
    double averageLi = li
      .stream()
      .limit(7)
      .map(x -> (x % 2 == 0) ? x + 5 : x - 5)
      .mapToInt(e -> e)
      .average()
      .getAsDouble();
    System.out.printf("%.2f\n", averageLi);

    // 2

    Set<String> set = Set.of(
      "qwertyyuity",
      "ewqrkjlsdfsdop",
      "werwerew",
      "werwerwerwer",
      "we",
      "werwerewrwetgdsfgs",
      "rwer",
      "Werwer",
      "SDfsdgdsg",
      "xzbbhxfhhafdg"
    );

    Map<String, Integer> mp = set
      .stream()
      .filter(x -> x.length() > 10)
      .collect(Collectors.toMap(Function.identity(), String::length));
    mp.entrySet().forEach(System.out::println);

    // 3
    HashMap<String, String> map = new HashMap<>();
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", "three");
    map.put("4", "four");
    map.put("5", "five");

    List<String> listKeyAndValue = map
      .entrySet()
      .stream()
      .map(x -> x.getKey() + " == " + x.getValue())
      .collect(Collectors.toList());
    listKeyAndValue.forEach(System.out::println);

    listKeyAndValue =
      map
        .entrySet()
        .stream()
        .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
        .collect(Collectors.toList());
    listKeyAndValue.forEach(System.out::println);
    // 4
    Reptiloyd o = null;

    o = Optional.ofNullable(o).orElseGet(Reptiloyd::new);
    System.out.println(o.getNumberOfHumans());
  }
}
