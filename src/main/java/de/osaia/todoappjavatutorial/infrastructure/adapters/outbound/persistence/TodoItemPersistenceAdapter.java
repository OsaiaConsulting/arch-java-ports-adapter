package de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence;

import de.osaia.todoappjavatutorial.application.ports.outbound.TodoListOutputPort;
import de.osaia.todoappjavatutorial.domain.models.TodoItem;
import de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence.entities.TodoItemEntity;
import de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence.mapper.TodoItemPersistenceMapper;
import de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Repository
public class TodoItemPersistenceAdapter implements TodoListOutputPort {
    private final TodoItemPersistenceMapper mapper;
    private final TodoListRepository repository;

    @Autowired
    public TodoItemPersistenceAdapter(TodoItemPersistenceMapper mapper, TodoListRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TodoItem saveTodoItem(TodoItem item) {
        TodoItemEntity entity = this.repository.save(this.mapper.fromTodoItem(item));
        return this.mapper.toTodoItem(entity);
    }

    @Override
    public Optional<TodoItem> getTodoItemById(Integer id) {
        Optional<TodoItemEntity> entity = this.repository.findById(id);
        return entity.map(this.mapper::toTodoItem);
    }

    @Override
    public List<TodoItem> getTodoList() {
        Iterable<TodoItemEntity> entities = this.repository.findAll();
        Stream<TodoItemEntity> stream = StreamSupport.stream(entities.spliterator(), false);
        return stream.map(this.mapper::toTodoItem).collect(Collectors.toList());
    }
}
