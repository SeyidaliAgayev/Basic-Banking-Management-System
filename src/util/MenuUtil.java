package util;

import static util.InputUtil.intInput;

public class MenuUtil {
    public static int entryMenu() {
        System.out.println("""
                           -------------------------
                           [0].Exit System!
                           [1].Register
                           [2].Log In
                           [3].Increase the Balance
                           -------------------------
                           """
        );
        return intInput("Choose an option: ");

    }
    public static int logInMenu() {
        System.out.println("""
                           -------------------------
                           [1].Show My Details
                           [2].Update My Details
                           [3].Operations
                           [4].Log Out!
                           -------------------------
                           """
        );
        return intInput("Choose an option: ");

    }
    public static int operationsMenu() {
        System.out.println("""
                           -------------------------
                           [1].Show Balance
                           [2].Cashing Out!
                           [3].Back to the main page!
                           -------------------------
                           """
        );
        return intInput("Choose an option: ");

    }
}
