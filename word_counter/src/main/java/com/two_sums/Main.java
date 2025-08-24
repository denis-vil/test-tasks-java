package com.two_sums;


public class Main {

  public static void main(String[] args) {
    findTwoSum(new int[]{1, 2, 5, 6, 7, 8}, 11);
  }

  /**
   * Ищет в массиве два числа, сумма которых равна {@code targetAmount}. Результат сразу печатается
   * в консоль.
   *
   * @param nums         входной массив чисел
   * @param targetAmount целевая сумма
   */
  private static void findTwoSum(int[] nums, int targetAmount) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == targetAmount) {
          result[0] = nums[i];
          result[1] = nums[j];
          break;
        }
      }
    }
    if (result != null) {
      System.out.println(result[0] + "+" + result[1] + " = " + targetAmount);
    } else {
      System.out.println("Пара не найдена");
    }
  }
}
/*
Возможные улучшения и доработки:

1.  Тут массив подается отсортированный, можно рассмотреть другую реализацию,
 чтобы по памяти было лучше, но этл оставим для рефакторинга.
 Логирование тоже можно прикрутить
Тестами покрыть код
Вывод в отдельный метод вынести
*/