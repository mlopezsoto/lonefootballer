package com.mls.lonefootballer.player;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfig {

    @Bean
    public PlayerService userService(PlayerRepository playerRepository) {
        return new PlayerServiceImpl(playerRepository);
    }
}
