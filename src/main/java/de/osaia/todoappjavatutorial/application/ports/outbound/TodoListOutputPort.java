package de.osaia.todoappjavatutorial.application.ports.outbound;

import de.osaia.todoappjavatutorial.domain.models.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoListOutputPort {
    TodoItem saveTodoItem(final TodoItem item);
    Optional<TodoItem> getTodoItemById(final Integer id);
    List<TodoItem> getTodoList();
}
