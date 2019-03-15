package demo.react.todolist.service;

import demo.react.todolist.entity.Todo;
import demo.react.todolist.repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@NoArgsConstructor
@AllArgsConstructor
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> getAllTodo(){
        return this.repository.findAll();
    }

    public boolean saveTodo(Todo todo) {
        Todo saved = this.repository.save(todo);
        return true;
    }
}
