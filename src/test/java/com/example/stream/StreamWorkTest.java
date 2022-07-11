package com.example.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.junit.LimitedCloneException;
import com.example.junit.Reptiloyd;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class StreamWorkTest {

  @Test
  public void getAverageTest() {
    List<Integer> li1 = List.of(0, 0, 0, 0, 0, 0, 0, 8, 9, 10);
    List<Integer> li2 = List.of(1, 1, 1, 1, 1, 1, 1, 8, 9, 10);
    List<Integer> li3 = List.of(2, 2, 2, 2, 2, 2, 2, 8, 9, 10);
    assertEquals(5.0, StreamWork.getAverage(li1), 0.1);
    assertEquals(-4.0, StreamWork.getAverage(li2), 0.1);
    assertEquals(7.0, StreamWork.getAverage(li3), 0.1);
  }

  @Test
  public void getMapTest() {
    Set<String> set = Set.of(
      "qwertyyuity",
      "ewqrkjlsdfsdop",
      "werwerew",
      "werwerw",
      "we",
      "werwerewrw",
      "rwer",
      "Werwer",
      "SDfsdgdsg",
      "xzbbhx"
    );
    assertEquals(
      "{qwertyyuity=11, ewqrkjlsdfsdop=14}",
      StreamWork.getMap(set).toString()
    );
    assertEquals("11", StreamWork.getMap(set).get("qwertyyuity").toString());
    assertEquals(null, StreamWork.getMap(set).get("we"));
  }

  @Test
  public void getKeyDoubleEqualValueTest() {
    HashMap<String, String> map = new HashMap<>();
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", "three");
    map.put("4", "four");
    map.put("5", "five");
    assertEquals(5, StreamWork.getKeyDoubleEqualValue(map).size());
    assertTrue(StreamWork.getKeyDoubleEqualValue(map).contains("1 == one"));
    assertTrue(StreamWork.getKeyDoubleEqualValue(map).contains("5 == five"));
  }

  @Test
  public void getListKeyAndValueTest() {
    HashMap<String, String> map = new HashMap<>();
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", "three");
    map.put("4", "four");
    map.put("5", "five");
    assertEquals(10, StreamWork.getListKeyAndValue(map).size());
    assertTrue(StreamWork.getListKeyAndValue(map).contains("1"));
    assertTrue(StreamWork.getListKeyAndValue(map).contains("one"));
  }

  @Test
  public void getNumberHumansTest() {
    Reptiloyd reptiloyd = null;
    assertEquals(0, StreamWork.getNumberHumans(reptiloyd));
    reptiloyd = new Reptiloyd();
    reptiloyd.createdHuman();
    assertEquals(1, StreamWork.getNumberHumans(reptiloyd));
    try {
      reptiloyd.cloneHuman();
    } catch (LimitedCloneException e) {
      e.printStackTrace();
    }
    assertEquals(2, StreamWork.getNumberHumans(reptiloyd));
  }
}
