package com.mls.lonefootballer.player;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository  {

    private List<PlayerRecord> players;

    public List<PlayerRecord> findAll() {
        return players;
    }

    @PostConstruct
    private void loadPlayers() {
        PlayerRecord p1 = new PlayerRecord("Jose Aldo",
                "Great striker",
                "jaldo@gmail.com",
                "Australia",
                "Muswellbrook",
                "NSW",
                "2333",
                "123456789",
                "CAM",
                "Both",
                true,
                "10/10/2008",
                "Male",
                "Eagles",
                null);

        PlayerRecord p2 = new PlayerRecord("Carla Perez",
                "Loves running",
                "carla@gmail.com",
                "Australia",
                "Muswellbrook",
                "NSW",
                "2333",
                "987654321",
                "GK",
                "Left",
                true,
                "10/10/2008",
                "Female",
                "Strikers",
                "http://youtube.com/mychannel");

        PlayerRecord p3 = new PlayerRecord("Patricia Gomez",
                "Juggler",
                "pgomez@gmail.com",
                "Colombia",
                "Medellin",
                "Antioquia",
                "64605",
                "88888888",
                "LB",
                "Right",
                true,
                "10/10/2009",
                "Female",
                "Weston",
                "http://youtube.com/mychannel");

        players = List.of(p1, p2, p3);
    }
}
