package com.mls.lonefootballer.player;

import java.util.List;

public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerEntity> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<PlayerEntity> findAllByCountryAndPostCode(String country, String postCode) {
        return playerRepository.findAllByCountryAndPostCode(country, postCode);
    }

    @Override
    public PlayerEntity save(PlayerEntity playerEntity) {
        return playerRepository.save(playerEntity);
    }

    @Override
    public PlayerEntity findById(String playerId) {
        return playerRepository.findById(playerId);
    }

    @Override
    public PlayerEntity delete(String playerId) {
        return playerRepository.delete(playerId);
    }

}
