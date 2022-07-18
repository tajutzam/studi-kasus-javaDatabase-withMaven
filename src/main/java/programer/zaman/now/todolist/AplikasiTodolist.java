package programer.zaman.now.todolist;

import Repository.TodolistRepository;
import Repository.TodolistRepositoryImpl;
import Service.TodolistServiceImpl;
import Service.TodolistServise;
import View.TodolistView;

public class AplikasiTodolist {


    public static void main(String[] args) {

        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServise todolistServise = new TodolistServiceImpl();
        TodolistView todolistView = new TodolistView();
        todolistView.showTodolist();

    }
}
