package com.example.stream;

import com.example.junit.Reptiloyd;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamWork {

  public static double getAverage(List<Integer> li) {
    return li
      .stream()
      .limit(7)
      .map(x -> (x % 2 == 0) ? x + 5 : x - 5)
      .mapToInt(e -> e)
      .average()
      .getAsDouble();
  }

  public static Map<String, Integer> getMap(Set<String> set) {
    return set
      .stream()
      .filter(x -> x.length() > 10)
      .collect(Collectors.toMap(Function.identity(), String::length));
  }

  public static List<String> getKeyDoubleEqualValue(Map<String, String> map) {
    return map
      .entrySet()
      .stream()
      .map(x -> x.getKey() + " == " + x.getValue())
      .collect(Collectors.toList());
  }

  public static List<String> getListKeyAndValue(Map<String, String> map) {
    return map
      .entrySet()
      .stream()
      .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
      .collect(Collectors.toList());
  }

  public static int getNumberHumans(Reptiloyd reptiloyd) {
    return Optional.ofNullable(reptiloyd).orElseGet(Reptiloyd::new).getNumberOfHumans();
  }
}
