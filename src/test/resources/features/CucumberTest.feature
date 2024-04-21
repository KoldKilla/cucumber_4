#language: en

@ui
Feature: Добавление товаров

  Background: Я нахожусь на главной странице сайта
    * Открыть сайт QualIT

  @correct
  Scenario: Добавление фрукта - экзотического
    * Нажать на меню 'Песочница'
    * Нажать на меню 'Товары'
    * Проверить столбцы 'Наименование', 'Тип', 'Экзотический' в таблице товаров
    * Нажать на кнопку 'Добавить'
    * В модальном окне ввести текст "Test" в поле 'Наименование'
    * В модальном окне нажать меню с типом товара
    * В модальном окне выбрать тип 'Фрукт'
    * В модальном окне выбрать чекбокс экзотический
    * Нажимаем на кнопку 'Сохранить'

  @correct
  Scenario: Добавление фрукта - не экзотического
    * Нажать на меню 'Песочница'
    * Нажать на меню 'Товары'
    * Проверить столбцы 'Наименование', 'Тип', 'Экзотический' в таблице товаров
    * Нажать на кнопку 'Добавить'
    * В модальном окне ввести текст "Test2" в поле 'Наименование'
    * В модальном окне нажать меню с типом товара
    * В модальном окне выбрать тип 'Фрукт'
    * Нажимаем на кнопку 'Сохранить'

  @correct
  Scenario: Добавление овоща - не экзотического
    * Нажать на меню 'Песочница'
    * Нажать на меню 'Товары'
    * Проверить столбцы 'Наименование', 'Тип', 'Экзотический' в таблице товаров
    * Нажать на кнопку 'Добавить'
    * В модальном окне ввести текст "Test3" в поле 'Наименование'
    * В модальном окне нажать меню с типом товара
    * В модальном окне выбрать тип 'Овощ'
    * Нажимаем на кнопку 'Сохранить'

  @correct
  Scenario: Добавление овоща - экзотического
    * Нажать на меню 'Песочница'
    * Нажать на меню 'Товары'
    * Проверить столбцы 'Наименование', 'Тип', 'Экзотический' в таблице товаров
    * Нажать на кнопку 'Добавить'
    * В модальном окне ввести текст "Test4" в поле 'Наименование'
    * В модальном окне нажать меню с типом товара
    * В модальном окне выбрать тип 'Овощ'
    * В модальном окне выбрать чекбокс экзотический
    * Нажимаем на кнопку 'Сохранить'