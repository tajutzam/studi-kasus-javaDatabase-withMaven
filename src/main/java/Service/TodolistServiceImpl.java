package Service;

import Entity.Todolist;
import Repository.TodolistRepository;
import Repository.TodolistRepositoryImpl;
import util.utilInput;

import java.util.List;
import java.util.Optional;

public class TodolistServiceImpl implements TodolistServise {


    TodolistRepository todolistRepository = new TodolistRepositoryImpl();

    @Override
    public void showAll() {
       List<Todolist> list = todolistRepository.getAll();
        System.out.println("No.     | Id |      | Todolist ");
       int i=0;
       for(var value : list){
           i++;
           System.out.println(i +"       | "+value.getId()+" |      | "+value.getTodolist()+"");
       }
    }
    @Override
    public void add(Todolist todo) {
        utilInput utilInput = new utilInput();
        System.out.print("Input Todo :");
        String data = utilInput.getString();
        if(data.isEmpty()){
            data=null;
        }
       Optional.ofNullable(data).ifPresentOrElse(s -> todo.setTodolist(s) ,() -> {
           System.out.print("Data Tidak Boleh Kosong Input Ulang :");
           String baru = utilInput.getString();
           todo.setTodolist(baru);
       });
        todolistRepository.addTodoList(todo);
    }
    @Override
    public void remove() {
        utilInput utilInput = new utilInput();
        System.out.print("Input Id Todo :");
        Integer id =utilInput.getInt();
        Todolist todolist = new Todolist();
        //optional
        Optional.ofNullable(id).ifPresentOrElse(s -> todolistRepository.removeTodolist(s), () -> {
            System.out.print("Id Tidak Boleh Kosong :");
            Integer baru = utilInput.getInt();
            todolistRepository.removeTodolist(baru);
        });
    }

    @Override
    public void updateTodo() {
        boolean isMatch =false;
        util.utilInput integerutilInput = new utilInput();
        util.utilInput stringutilInput = new utilInput();
        do{
            System.out.print("Input Id yang ingin di update :");
            Integer id = integerutilInput.getInt();
            System.out.print("Input Todo Baru :");
            String todoBaru = stringutilInput.getString();

            if(todolistRepository.isExist(id)){
                if(todoBaru.isEmpty()){
                    todoBaru=null;
                }
                Optional.ofNullable(todoBaru).ifPresentOrElse(s -> todolistRepository.editTodolist(new Todolist(s) , id),() -> {
                    System.out.print("Todolist Tidak Boleh Kosong  :");
                    String baru = stringutilInput.getString();
                    todolistRepository.editTodolist(new Todolist(baru) , id);
                });
                isMatch=true;
            }else{
                System.out.println("Data Tidak ada Input Ulang");
                isMatch=false;
            }
        }while(isMatch==false);
    }
    @Override
    public void showMenuAwal() {
        
        utilInput utilInput = new utilInput();
        System.out.println("TODOLIST");
        showAll();
        System.out.println("Menu");
        System.out.println("1. Add Todolist  ");
        System.out.println("2. Remove Todo");
        System.out.println("3. update Todo");
        System.out.println("x. Exit");
        System.out.print("Chose Menu :");

        String chosedMenu = utilInput.getString();
        switch (chosedMenu){
            case "1" :
                add(new Todolist());
                showMenuAwal();
                break;
            case "2":
                boolean suces=false;
                    remove();
                    showMenuAwal();
                break;
            case "3":
                updateTodo();
                showMenuAwal();
                break;
            case "x":
                System.out.println("Keluar");
                System.exit(0);
            default:
                System.out.println("Your Input Wrong !");
                showMenuAwal();
                break;
        }
    }
}
