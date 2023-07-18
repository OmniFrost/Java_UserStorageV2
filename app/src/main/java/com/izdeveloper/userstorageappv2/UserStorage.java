package com.izdeveloper.userstorageappv2;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {
    private static UserStorage single;
    private ArrayList<User> list;

    private UserStorage() {
        list = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return list;
    }
    public void addUser(User user) {
        list.add(user);
    }
    public static UserStorage getSingle() {
        if (single == null) {
            single = new UserStorage();
        }
        return single;
    }

    public void listSave(Context context) {
        try {
            ObjectOutputStream userSaver = new ObjectOutputStream(context.openFileOutput("UserStorage.data", Context.MODE_PRIVATE));
            userSaver.writeObject(UserStorage.getSingle().getUsers());

            userSaver.close();

        } catch (IOException e) {
            System.out.println("Käyttäjälistan tallentaminen epäonnistui.");
            e.printStackTrace();
        }
    }
    public void createList(ArrayList<User> list) {
        this.list = list;
    }

    public void readSavedList(Context context) {
        try {
            FileInputStream userReader = context.openFileInput("UserStorage.data");
            ObjectInputStream objectInputStream = new ObjectInputStream(userReader);

            ArrayList<User> users = (ArrayList<User>) objectInputStream.readObject();
            createList(users);

            objectInputStream.close();

        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui.");
            e.printStackTrace();
        }
    }
}
