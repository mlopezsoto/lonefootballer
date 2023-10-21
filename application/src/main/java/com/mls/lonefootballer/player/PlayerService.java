package com.mls.lonefootballer.player;

import java.util.List;

public interface PlayerService {

    List<PlayerEntity> findAll();

    List<PlayerEntity> findAllByCountryAndPostCode(String country, String postCode);

    PlayerEntity save(PlayerEntity playerEntity);

    PlayerEntity findById(String playerId);

    PlayerEntity delete(String playerId);
}
