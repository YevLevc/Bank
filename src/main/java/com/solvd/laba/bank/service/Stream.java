package com.solvd.laba.bank;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static List <Client> filterByName (List <Client> clients, String name) {
        return clients.stream()
                .filter(client -> client.getFullName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
    public static List <Client> sortByName (List <Client> clients) {
        return clients.stream()
                .sorted(Comparator.comparing(Client::getFullName)) //.reversed()
                .collect(Collectors.toList());
    }
    public static Client getByName (List <Client> clients, String name) {
        for (Client client : clients) {
            if (client.getFullName().equalsIgnoreCase(name))
                return client;
        }
        return null;
    }
}
