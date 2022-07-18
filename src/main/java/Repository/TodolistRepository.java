package Repository;

import Entity.Todolist;

import java.util.List;

public interface TodolistRepository {


    public List<Todolist> getAll();
    public void addTodoList(Todolist todo);
    public boolean removeTodolist(Integer id);
    public boolean editTodolist(Todolist todo, Integer integer);
    public boolean isExist(Integer number);
}
