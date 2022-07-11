package com.example.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.example.junit.LimitedCloneException;
import com.example.junit.Reptiloyd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Map<String, Integer> resultGetMap = StreamWork.getMap(set);
    assertEquals(
      "{qwertyyuity=11, ewqrkjlsdfsdop=14}",
      resultGetMap.toString()
    );
    assertEquals("11", resultGetMap.get("qwertyyuity").toString());
    assertNull(resultGetMap.get("we"));
  }

  @Test
  public void getKeyDoubleEqualValueTest() {
    HashMap<String, String> map = new HashMap<>();
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", "three");
    map.put("4", "four");
    map.put("5", "five");
    List<String> resultGetKeyDoubleEqualValue = StreamWork.getKeyDoubleEqualValue(map);
    assertEquals(5, resultGetKeyDoubleEqualValue.size());
    assertTrue(resultGetKeyDoubleEqualValue.contains("1 == one"));
    assertTrue(resultGetKeyDoubleEqualValue.contains("5 == five"));
  }

  @Test
  public void getListKeyAndValueTest() {
    HashMap<String, String> map = new HashMap<>();
    map.put("one", "1");
    map.put("two", "2");
    map.put("three", "3");
    map.put("four", "4");
    map.put("five", "5");
    List<String> resultGetListKeyAndValue = StreamWork.getListKeyAndValue(map);
    assertEquals(10, resultGetListKeyAndValue.size());
    assertTrue(resultGetListKeyAndValue.contains("1"));
    assertTrue(resultGetListKeyAndValue.contains("one"));
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
