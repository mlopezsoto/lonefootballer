package com.mls.lonefootballer.player;

import java.util.List;

public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerEntity> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public PlayerEntity save(PlayerEntity playerEntity) {
        return playerRepository.save(playerEntity);
    }

    @Override
    public PlayerEntity find(String playerId) {
        return playerRepository.findById(playerId);
    }

}
