package de.osaia.todoappjavatutorial.application.services;

import de.osaia.todoappjavatutorial.application.ports.inbound.TodoListInputPort;
import de.osaia.todoappjavatutorial.application.ports.outbound.TodoListOutputPort;
import de.osaia.todoappjavatutorial.domain.models.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService implements TodoListInputPort {
    private final TodoListOutputPort todoListOutputPort;

    @Autowired
    public TodoListService(TodoListOutputPort todoListOutputPort) {
        this.todoListOutputPort = todoListOutputPort;
    }

    @Override
    public TodoItem createTodoItemUseCase(TodoItem item) {
        return this.todoListOutputPort.saveTodoItem(item);
    }

    @Override
    public Optional<TodoItem> getTodoItemById(Integer id) {
        return this.todoListOutputPort.getTodoItemById(id);
    }

    @Override
    public List<TodoItem> getTodoList() {
        return this.todoListOutputPort.getTodoList();
    }
}
