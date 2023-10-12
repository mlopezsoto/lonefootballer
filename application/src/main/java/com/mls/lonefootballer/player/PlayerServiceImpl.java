package com.mls.lonefootballer.player;

import java.util.List;

public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerRecord> findAllPlayers() {
        return playerRepository.findAll();
    }

}
