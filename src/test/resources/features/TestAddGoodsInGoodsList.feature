# language: ru

@ui
@all
@features
Функция: Добавление товаров

  Предыстория:
    * открыт стенд

  @correct
  Сценарий: Добавление экзотического фрукта
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт "Товары"
    * Пользователь нажимает на кнопку "Добавить"
    * Пользователь вводит наименование "Test"
    * Пользователь нажимает на тип и выбирает в выпадающем списке тип "Фрукт"
    * Пользователь выбирает чек-бокс Экзотический
    * Пользователь нажимает кнопку "Сохранить"
    * Проверяем, что в последней строке таблицы Товары отображаются введенные данные экзотического фрукта
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт Сброс данных


  @correct
  Сценарий: Добавление экзотического овоща
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт "Товары"
    * Пользователь нажимает на кнопку "Добавить"
    * Пользователь вводит наименование "Test2"
    * Пользователь нажимает на тип и выбирает в выпадающем списке тип "Овощ"
    * Пользователь выбирает чек-бокс Экзотический
    * Пользователь нажимает кнопку "Сохранить"
    * Проверяем, что в последней строке таблицы Товары отображаются введенные данные экзотического овоща
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт Сброс данных


  @correct
  Сценарий: Добавление не экзотического фрукта
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт "Товары"
    * Пользователь нажимает на кнопку "Добавить"
    * Пользователь вводит наименование "Test3"
    * Пользователь нажимает на тип и выбирает в выпадающем списке тип "Фрукт"
    * Пользователь нажимает кнопку "Сохранить"
    * Проверяем, что в последней строке таблицы Товары отображаются введенные данные фрукта
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт Сброс данных


  @correct
  Сценарий: Добавление экзотического овоща
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт "Товары"
    * Пользователь нажимает на кнопку "Добавить"
    * Пользователь вводит наименование "Test4"
    * Пользователь нажимает на тип и выбирает в выпадающем списке тип "Овощ"
    * Пользователь нажимает кнопку "Сохранить"
    * Проверяем, что в последней строке таблицы Товары отображаются введенные данные овоща
    * Пользователь нажимает на выпадающий список "Песочница"
    * Пользователь выбирает в выпадающем списке пункт Сброс данных


