package org.zerock.mallapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonTest {
  @Test
  public void testMain() throws Exception {
    String jsonInput = "["
            + "{\"group\": \"1\", \"value1\": \"a1\", \"value2\": \"b1\"},"
            + "{\"group\": \"1\", \"value1\": \"c1\", \"value2\": \"d1\"},"
            + "{\"group\": \"2\", \"value1\": \"a2\", \"value2\": \"b2\"},"
            + "{\"group\": \"2\", \"value1\": \"c2\", \"value2\": \"d2\"},"
            + "{\"group\": \"3\", \"value1\": \"a3\", \"value2\": \"b3\"},"
            + "{\"group\": \"3\", \"value1\": \"c3\", \"value2\": \"d3\"}"
            + "]";

    ObjectMapper objectMapper  = new ObjectMapper();
    List<Map<String, String>> dataList = objectMapper.readValue(jsonInput, new TypeReference<>() {});

    // 그룹별로 데이터 저장
    Map<String, List<Map<String, String>>> groupedData = dataList.stream()
            .collect(Collectors.groupingBy(map -> map.get("group")));

    System.out.println( groupedData );

    // 최종 변환된 리스트
    List<Map<String, String>> mergedList = new ArrayList<>();

    // 그룹별로 2개씩 데이터를 합침
    for (Map.Entry<String, List<Map<String, String>>> entry : groupedData.entrySet()) {
      List<Map<String, String>> values = entry.getValue();
      if (values.size() == 2) { // 정확히 2개의 쌍이 있는 경우만 처리
        Map<String, String> mergedMap = new LinkedHashMap<>();
        mergedMap.put("group", entry.getKey());
        mergedMap.put("value1", values.get(0).get("value1"));
        mergedMap.put("value2", values.get(0).get("value2"));
        mergedMap.put("value3", values.get(1).get("value1"));
        mergedMap.put("value4", values.get(1).get("value2"));
        mergedList.add(mergedMap);
      }
    }

    // 결과 출력
    String resultJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedList);
    System.out.println(resultJson);
  }
}
