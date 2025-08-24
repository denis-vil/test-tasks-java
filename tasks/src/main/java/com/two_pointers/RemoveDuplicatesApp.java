package com.two_pointers;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesApp {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3})));

  }

  /**
   * Удаляет дубликаты из массива. Используется {@link LinkedHashSet}, чтобы сохранить порядок
   * элементов.
   *
   * @param nums отсортированный массив целых чисел с дубликатами
   * @return новый массив без повторяющихся значений
   */
  private static int[] removeDuplicates(int[] nums) {
    Set<Integer> set = new LinkedHashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int[] result = new int[set.size()];
    int i = 0;
    for (int val : set) {
      result[i++] = val;
    }
    return result;
  }
}
/*
Возможные улучшения и доработки:
1. Сейчас используется LinkedHashSet, что просто и удобно, но потребляет дополнительную память.
   Так как массив отсортирован, задачу можно решить более эффективно по памяти алгоритмом "двух указателей",
   работая прямо в исходном массиве (O(n) по времени, O(1) по памяти).
2. Метод removeDuplicates можно дополнить обработкой граничных случаев (например, пустой массив или null),
   чтобы сделать код более надёжным.
3. Можно вынести ввод/вывод из main, а метод оставить "чистым" (принимает массив и возвращает массив),
   что упростит тестирование и повторное использование.
4. Так же хорошая практика логирование и комментарии, но тут супер простой класс
5. с
*/