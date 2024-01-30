package peaksoft;

import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService =  new UserServiceImpl();

//        userService.saveUser("Mirlan", "Arstanbekov", (byte) 20);
//        userService.saveUser("Aliaskar", "Temirbekov", (byte) 20);

//        userService.removeUserById(1L);
//        System.out.println(userService.getAllUsers());
//        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
