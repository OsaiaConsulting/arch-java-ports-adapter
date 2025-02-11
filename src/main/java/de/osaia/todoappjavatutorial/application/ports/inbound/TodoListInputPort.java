package de.osaia.todoappjavatutorial.application.ports.inbound;

import de.osaia.todoappjavatutorial.domain.models.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoListInputPort {
    TodoItem createTodoItemUseCase(TodoItem todoItem);
    Optional<TodoItem> getTodoItemById(final Integer id);
    List<TodoItem> getTodoList();
}
