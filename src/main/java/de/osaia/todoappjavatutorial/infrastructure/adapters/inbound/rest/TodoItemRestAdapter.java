package de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest;

import de.osaia.todoappjavatutorial.application.ports.inbound.TodoListInputPort;
import de.osaia.todoappjavatutorial.domain.models.TodoItem;
import de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.dtos.request.CreateTodoItemRequest;
import de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.dtos.response.TodoItemResponse;
import de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.mapper.TodoItemRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoItemRestAdapter {
    private final TodoListInputPort inputPort;
    private final TodoItemRestMapper mapper;

    @Autowired
    public TodoItemRestAdapter(TodoListInputPort inputPort, TodoItemRestMapper mapper) {
        this.inputPort = inputPort;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    TodoItemResponse createTodoItem(@RequestBody CreateTodoItemRequest payload) {
        TodoItem item = this.inputPort.createTodoItemUseCase(this.mapper.createTodoItemRequestToTodoItem(payload));
        return this.mapper.todoItemToTodoItemResponse(item);
    }

    @GetMapping("/{id}")
    ResponseEntity<TodoItemResponse> getTodoItemById(@PathVariable Integer id) {
        return this.inputPort.getTodoItemById(id)
                .map(this.mapper::todoItemToTodoItemResponse)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("list")
    List<TodoItemResponse> getTodoItemList() {
        return this.inputPort.getTodoList().stream().map(this.mapper::todoItemToTodoItemResponse).toList();
    }
}
