package com.sio.javatd3sio2.interfaces;

import java.util.HashMap;

public interface MockClientsApiInterface<Client,String> {
    Client find(String id);
    HashMap<String,Object> findAll();
    boolean create(Client c);
    boolean update(Client c);
    boolean delete(Client c);
}
