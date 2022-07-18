package Entity;

public class Todolist {

    Integer id;
    String todolist;


    public Todolist(Integer id, String todolist) {
        this.id = id;
        this.todolist = todolist;
    }

    public Todolist(String todolist) {
        this.todolist = todolist;
    }

    public Todolist() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTodolist() {
        return todolist;
    }

    public void setTodolist(String todolist) {
        this.todolist = todolist;
    }
}
