package com.library;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Library lib = new Library();
    Scanner sc = new Scanner(System.in);
    System.out.println(
        "Команды: add Указать название книги;Указать автора книги | list | get <После get через пробел указать ID> | del <после del через пробел указать ID> | exit");

    while (true) {
      System.out.print("> ");
      String line = sc.nextLine().trim();
      if (line.equalsIgnoreCase("exit")) {
        break;
      }
      if (line.startsWith("add ")) {
        String payload = line.substring(4);
        String[] parts = payload.split(";", 2);
        if (parts.length < 2) {
          System.out.println("Формат: add Название;Автор");
          continue;
        }
        var b = lib.add(parts[0].trim(), parts[1].trim());
        System.out.println("Добавлено: " + b);
      } else if (line.equals("list")) {
        lib.all().forEach(System.out::println);
      } else if (line.startsWith("get ")) {
        try {
          long id = Long.parseLong(line.substring(4).trim());
          var b = lib.byId(id);
          System.out.println(b != null ? b : "Не найдено");
        } catch (NumberFormatException e) {
          System.out.println("Некорректный id");
        }
      } else if (line.startsWith("del ")) {
        try {
          long id = Long.parseLong(line.substring(4).trim());
          System.out.println(lib.delete(id) ? "Удалено" : "Не найдено");
        } catch (NumberFormatException e) {
          System.out.println("Некорректный id");
        }
      } else {
        System.out.println("Неизвестная команда");
      }
    }
    System.out.println("Всего доброго!");
  }
}
/*
 Улучшения:
 1) Разделить ввод/вывод и бизнес-логику (вынести парсинг команд в отдельный класс CommandHandler).
 2) Добавить справку, историю команд, более дружелюбные сообщения об ошибках.
 3) Тесты
 4) Логирование вместо System.out (java.util.logging/SLF4J) для реального приложения.
 5) Если потребуется API перейти на Spring Boot + REST контроллеры GET/POST/DELETE,дто и маппер
 6) дублирование убрать
*/