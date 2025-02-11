package de.osaia.todoappjavatutorial.infrastructure.adapters.inbound.rest.dtos.response;

import jakarta.validation.constraints.NotNull;

public class TodoItemResponse {
    @NotNull
    private Integer id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private boolean completed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
