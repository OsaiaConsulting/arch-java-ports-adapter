package de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence.mapper;

import de.osaia.todoappjavatutorial.domain.models.TodoItem;
import de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence.entities.TodoItemEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoItemPersistenceMapper {
    public TodoItem toTodoItem(TodoItemEntity entity) {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(entity.getId());
        todoItem.setTitle(entity.getTitle());
        todoItem.setDescription(entity.getDescription());
        todoItem.setCompleted(entity.isCompleted());

        return todoItem;
    }

    public TodoItemEntity fromTodoItem(TodoItem todoItem) {
        TodoItemEntity entity = new TodoItemEntity();
        entity.setId(todoItem.getId());
        entity.setTitle(todoItem.getTitle());
        entity.setDescription(todoItem.getDescription());
        entity.setCompleted(todoItem.isCompleted());

        return entity;
    }
}
