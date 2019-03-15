package demo.react.todolist.controller;

import demo.react.todolist.dto.TodoDto;
import demo.react.todolist.entity.Todo;
import demo.react.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoListController {
    @Autowired
    private TodoService service;

    @GetMapping
    public List<TodoDto> getAllTodo(){
        List<Todo> todos = service.getAllTodo();
        return TodoDto.transform(todos);
    }

    @PostMapping
    public Todo createTodo(@RequestBody TodoDto dto){
        Todo todo = dto.convert();
        boolean result = service.saveTodo(todo);
        if (result){
            return todo;
        }
        return null;
    }
}
