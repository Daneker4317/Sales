package org.example.util;

public interface Application {
    void start();
    default void exit(){
        System.out.println("app closing");
        System.exit(0);
    }
}
