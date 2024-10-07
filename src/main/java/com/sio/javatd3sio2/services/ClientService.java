package com.sio.javatd3sio2.services;

import com.sio.javatd3sio2.apis.MockClientsApiClient;
import com.sio.javatd3sio2.interfaces.MockClientsApiInterface;
import com.sio.javatd3sio2.models.Client;

import java.util.HashMap;

public class ClientService implements MockClientsApiInterface<Client,String> {

    private final MockClientsApiClient client = new MockClientsApiClient();

    @Override
    public Client find(String siret) {
        return client.getClient(siret);
    }

    @Override
    public HashMap<String, Object> findAll() {
        return client.getClients();
    }

    @Override
    public boolean create(Client c) {
        return client.createClient(c);
    }

    @Override
    public boolean update(Client c) {
        return client.updateClient(c);
    }

    @Override
    public boolean delete(Client c) {
        return client.deleteClient(c);
    }

}
