package de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.dtos.request;

import jakarta.validation.constraints.NotNull;

public class CreateTodoItemRequest {
    @NotNull(message = "Name may not be empty")
    private String title;
    @NotNull(message = "Name may not be empty")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
