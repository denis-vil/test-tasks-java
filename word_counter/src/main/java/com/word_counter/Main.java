package com.word_counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    System.out.println(wordCounter("hello world qwerty world", 2));
  }

  /**
   * Возвращает первое слово, встречающееся ровно n раз, или null.
   */
  static String wordCounter(String str, int n) {
    if (str == null || str.isBlank() || n <= 0) {
      return null;
    }

    Map<String, Integer> counts = new LinkedHashMap<>();
    for (String w : str.trim().split("\\s+")) {
      counts.put(w, counts.getOrDefault(w, 0) + 1);
    }

    for (Map.Entry<String, Integer> e : counts.entrySet()) {
      if (e.getValue() == n) {
        return e.getKey();
      }
    }
    return null;
  }
}
/*
Возможные улучшения и доработки:
Нормализовать регистр и убрать знаки препинания.
Тесты на пустую строку, несколько совпадений, отсутствие совпадений.
*/