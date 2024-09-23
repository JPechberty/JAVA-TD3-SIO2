package com.sio.javatd3sio2.interfaces;

import java.util.HashMap;

public interface MockClientsApiInterface<Client,String> {
    Client find(String id);
    HashMap<String,Object> findAll();
}
