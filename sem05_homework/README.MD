# Домашнее задание

## Базовое задание:
Условие:
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:

- Добавление задачи. Подсказка метод в контроллере: 
```java
@PostMapping 
public Task addTask(@RequestBody Task task) {}
```

- Просмотр всех задач. Подсказка метод в контроллере: 
```java
@GetMapping 
public List<Task> getAllTasks() {}
```

- Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере: 
```java
@GetMapping("/status/{status}") 
public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {}
```
- Изменение статуса задачи. Подсказка метод в контроллере: 
```java
@PutMapping("/{id}") 
public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {}
```
- Удаление задачи.
Подсказка метод в контроллере:
```java
@DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id) {}
```

Репозитроий подсказка: 
```java
public interface TaskRepository extends JpaRepository<Task, Long> {}
```

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

Подсказка понадобится энумератор:
```java
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;
}
```


## Задание со звездочкой:
Cоздать серверное приложение, которое может получать файлы, загружаемые по протоколу HTTP из нескольких частей.

Для основы проекта взять пример: https://spring.io/guides/gs/uploading-files