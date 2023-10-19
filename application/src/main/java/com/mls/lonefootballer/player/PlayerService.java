package com.mls.lonefootballer.player;

import java.util.List;

public interface PlayerService {

    List<PlayerEntity> findAllPlayers();

    PlayerEntity save(PlayerEntity playerEntity);

    PlayerEntity find(String playerId);
}
