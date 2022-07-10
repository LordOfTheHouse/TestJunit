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

  public static double getAverage(List<Integer> li) {
    double averageLi = li
      .stream()
      .limit(7)
      .map(x -> (x % 2 == 0) ? x + 5 : x - 5)
      .mapToInt(e -> e)
      .average()
      .getAsDouble();
    return averageLi;
  }

  public static Map<String, Integer> getMap(Set<String> set) {
    Map<String, Integer> mp = set
      .stream()
      .filter(x -> x.length() > 10)
      .collect(Collectors.toMap(Function.identity(), String::length));
    return mp;
  }

  public static List<String> getKeyDoubleEqualValue(
    HashMap<String, String> map
  ) {
    List<String> listKeyAndValue = map
      .entrySet()
      .stream()
      .map(x -> x.getKey() + " == " + x.getValue())
      .collect(Collectors.toList());
    return listKeyAndValue;
  }

  public static List<String> getListKeyAndValue(HashMap<String, String> map) {
    List<String> listKeyAndValue = map
      .entrySet()
      .stream()
      .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
      .collect(Collectors.toList());
    return listKeyAndValue;
  }

  public static int getNumberHumans(Reptiloyd reptiloyd) {
    reptiloyd = Optional.ofNullable(reptiloyd).orElseGet(Reptiloyd::new);
    return reptiloyd.getNumberOfHumans();
  }
}
