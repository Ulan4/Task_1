package org.example;
import org.example.menu.Menu;
import org.example.menu.MenuManager;
public class Main {
    public static void main(String[] args) {
        Menu menu = new MenuManager();
        menu.run();
    }
}