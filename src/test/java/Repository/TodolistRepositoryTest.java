package Repository;

import Entity.Todolist;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodolistRepositoryTest {
    TodolistRepository todolistRepository = new TodolistRepositoryImpl();

    @Test
    void testAddTodo() {
        todolistRepository.addTodoList(new Todolist("zam"));
    }
    @Test
    void testRemoveTodo() {
        todolistRepository.removeTodolist(2);
    }
    @Test
    void testIsExist() {
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        System.out.println(repository.isExist(2));
    }
    @Test
    void testGetAllList() {
        List<Todolist> list = todolistRepository.getAll();
        todolistRepository.addTodoList(new Todolist("belajar java"));
        todolistRepository.addTodoList(new Todolist("belajar cpp"));
        for(var value : list){
            System.out.println(value.getId() +":"+value.getTodolist());
        }
    }
    @Test
    void testUpdateTodolist() {
        todolistRepository.editTodolist(new Todolist("zam baru") , 100);
    }

}
