package com.library;

public class Book {

  private final long id;
  private String title;
  private String author;

  public Book(long id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "Book{id=" + id + ", title='" + title + "', author='" + author + "'}";
  }
}
/*
 Улучшения
 1) Валидация входных данных
 2) Добавить equals и hashCode пригодится при тестах.
 3) Возможность частичного обновления сеттеры или паттерн Builder
 4) больше параметров для книги, год, кол-во страниц и так далее
 5) можно использовать в целом rest
 6) тест
 7) логирование
 8) ломбок можно использовать
*/