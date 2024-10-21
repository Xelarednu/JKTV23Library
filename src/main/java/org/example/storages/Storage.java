package org.example.storages;

import org.example.repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage<T> implements Repository<T> {

    //private List<T> entities = new ArrayList<>();
    private String fileName = "users";

    public Storage(String fileName) {
        this.fileName = fileName;
//        entities = this.load();
    }

    @Override
    public void save(List<T> entities) {

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file: "+e.toString());
        } catch (IOException e) {
            System.out.println("I/O error: "+e.toString());
        }
    }

    @Override
    public List<T> load() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file: "+e.toString());
        } catch (IOException e) {
            System.out.println("I/O error: "+e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: "+e.toString());
        }
        return new ArrayList<T>();
    }

//    public List<T> getEntities() {
//        return entities;
//    }
//
//    public void setUsers(List<T> entities) {
//        this.entities = entities;
//    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
