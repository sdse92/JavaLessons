package lesson19.annotation;


//данный класс должны использовать только пользователи с User.Permission.ADMIN
//использование
@PermissionRequired(User.Permission.ADMIN)
public class DeleteAction {
    public void delete(User user){
        System.out.println("del user");
    }
}
