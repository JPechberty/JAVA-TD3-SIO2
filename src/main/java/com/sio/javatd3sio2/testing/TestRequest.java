package com.sio.javatd3sio2.testing;

import com.sio.javatd3sio2.apis.MockClientsApiClient;
import com.sio.javatd3sio2.models.Client;

public class TestRequest {

    public static void main(String[] args) {
        MockClientsApiClient mockClientsApiClient = new MockClientsApiClient();
        Client test = mockClientsApiClient.getClient("51539879000052");
        System.out.println(test);
        System.out.println(test.getSiret());
    }
}
