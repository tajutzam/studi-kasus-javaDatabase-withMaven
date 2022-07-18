package View;

import Service.TodolistServiceImpl;
import Service.TodolistServise;

public class TodolistView {

    TodolistServise todolistServise = new TodolistServiceImpl();


    public void showTodolist(){

        todolistServise.showMenuAwal();
    }
}
