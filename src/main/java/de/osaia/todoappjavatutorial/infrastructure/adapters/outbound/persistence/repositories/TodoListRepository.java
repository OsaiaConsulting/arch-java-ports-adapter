package de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence.repositories;

import de.osaia.todoappjavatutorial.infrastructure.adapters.outbound.persistence.entities.TodoItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoItemEntity, Integer> {
}
