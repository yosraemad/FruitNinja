package fruitNinja.data.services;

import java.util.ArrayList;

// INTERFACE THE MANAGES THE READ AND WRITE FROM FILES
public interface Service<T> {
    // READS THE ENTITIES
    ArrayList<T> readData();

    // WRITES AN ENTITY
    void writeData(T data);

    // UPDATES THE ENTITIES
    void updateData(ArrayList<T> data);
}
