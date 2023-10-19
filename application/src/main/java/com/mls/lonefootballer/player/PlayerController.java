package com.mls.lonefootballer.player;

import com.amazonaws.services.lambda.runtime.Context;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@Slf4j
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = {"", "/"}    )
    public List<PlayerEntity> getAllUsers() {
        return playerService.findAllPlayers();
    }

    @GetMapping(path = {"/{id}"}    )
    public PlayerEntity find(@PathVariable String id) {
        return playerService.find(id);
    }

    @PostMapping
    public PlayerEntity save(@RequestBody PlayerEntity playerEntity) {
        return playerService.save(playerEntity);
    }
}
