package com.library;

import java.util.*;

public class Library {

  private final Map<Long, Book> store = new LinkedHashMap<>();
  private long seq = 1L;

  /**
   * Добавляет книгу в хранилище.
   *
   * @param title  название книги
   * @param author автор книги
   * @return созданная книга с присвоенным id
   */
  public Book add(String title, String author) {
    Book b = new Book(seq++, title, author);
    store.put(b.getId(), b);
    return b;
  }

  /**
   * Возвращает коллекцию всех книг.
   *
   * @return все книги в порядке добавления
   */
  public Collection<Book> all() {
    return store.values();
  }

  /**
   * Находит книгу по идентификатору.
   *
   * @param id идентификатор книги
   * @return книгу или {@code null}, если не найдена
   */
  public Book byId(long id) {
    return store.get(id);
  }

  /**
   * Удаляет книгу по идентификатору.
   *
   * @param id идентификатор книги
   * @return {@code true}, если книга существовала и была удалена
   */
  public boolean delete(long id) {
    return store.remove(id) != null;
  }
}
/*
 Улучшения
 1) ConcurrentHashMap и AtomicLong,
    если предполагается многопоточное использование.
 2) Валидация входных данных
 4) Слои: разделить доменную логику service/repository
 6) Уникальность если нужно по автору или что-то еще
 7) Пагинация/поиск/фильтрация
 8) Переезд на Spring Boot + REST контроллеры, DTO, обработка ошибок при необходимости веб-API.
 9) логирование
 10) тесты написать
 11) import java.util.*; не импортировать все, а только нужное
*/