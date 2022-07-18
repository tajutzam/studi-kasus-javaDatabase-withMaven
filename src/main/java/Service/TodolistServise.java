package Service;

import Entity.Todolist;

public interface TodolistServise {

    public void showAll();
    public void add(Todolist todo);
    public void remove();
    public void showMenuAwal();
    public void updateTodo();
}
