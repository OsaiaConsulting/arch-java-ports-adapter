package de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.mapper;

import de.osaia.todoappjavatutorial.domain.models.TodoItem;
import de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.dtos.request.CreateTodoItemRequest;
import de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.dtos.response.TodoItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface TodoItemRestMapper {
    @Mapping(target = "id", ignore = true)
    TodoItem createTodoItemRequestToTodoItem(CreateTodoItemRequest dto);

    TodoItemResponse todoItemToTodoItemResponse(TodoItem item);
}
