package Repository;

import Entity.Todolist;
import com.zaxxer.hikari.HikariDataSource;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodolistRepositoryImpl implements  TodolistRepository{


    HikariDataSource dataSource = DatabaseUtil.dataSource();
    @Override
    public List<Todolist> getAll() {
       String sql="select id , todo from todolist";
       List<Todolist> list = new ArrayList<>();
       try(Connection con= dataSource.getConnection();
       Statement statement = con.createStatement();
       ResultSet res = statement.executeQuery(sql)){


           while(res.next()){
               Todolist todolist = new Todolist();
               todolist.setTodolist(res.getString("todo"));
               todolist.setId(res.getInt("id"));
               list.add(todolist);
           }

       }catch (SQLException e){

       }
       return list;
    }

    @Override
    public void addTodoList(Todolist todo) {

        String sql ="INSERT into todolist (todo) values(?)";

        try(Connection con = dataSource.getConnection()){

            try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
                preparedStatement.setString(1 , todo.getTodolist());
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                System.out.println("gagal Add Todolist");
            }

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public boolean isExist(Integer number){
        String sql ="SELECT id FROM todolist where id=?";

        boolean isExist=false;
        try(Connection con = dataSource.getConnection();
        PreparedStatement statement = con.prepareStatement(sql)){

            statement.setInt(1 , number);

            try(ResultSet res = statement.executeQuery()){
                if(res.next()){
                   return true;
                }
                else{
                   return false;
                }
            }


        }catch (SQLException e){
            System.out.println(e);
        }
        return  isExist;
    }

    @Override
    public boolean removeTodolist(Integer id) {

       String sql ="delete from todolist where id =?";

       try(Connection con = dataSource.getConnection();
       PreparedStatement preparedStatement = con.prepareStatement(sql)){
           if(isExist(id)){
               preparedStatement.setInt(1 ,id);
               preparedStatement.executeUpdate();
               System.out.println("berhasil dihapus");

               return true;
           }else{
               System.out.println("Gagal Dihapus Todo Tidak Dimengerti");
               System.out.println("Input Ulang");
               return false;
           }
       }catch (SQLException e){

       }
       return false;
    }

    @Override
    public boolean editTodolist(Todolist todo , Integer number) {


        String sql = "UPDATE todolist set todo =? where id =? ";
        boolean isMatch;

            if (isExist(number)) {

                try (Connection con = dataSource.getConnection();
                     PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setString(1, todo.getTodolist());
                    preparedStatement.setInt(2, number);
                    preparedStatement.executeUpdate();
                    System.out.println("Berhasil Update");
                    isMatch = true;
                    return true;
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                isMatch = false;
                System.out.println("Data Tidak ada");
                System.out.println("Input Ulang !");
                return  false;


            }

        return false;

    }
}
