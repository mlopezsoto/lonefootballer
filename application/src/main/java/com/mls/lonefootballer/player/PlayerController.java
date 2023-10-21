package com.mls.lonefootballer.player;

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

    @GetMapping(path = {"", "/"})
    public List<PlayerEntity> findAll() {
        return playerService.findAll();
    }

    @GetMapping(path = {"/country/{country}/postcode/{postCode}"})
    public List<PlayerEntity> findByCountryAndPostCode(@PathVariable String country, @PathVariable String postCode) {
        return playerService.findAllByCountryAndPostCode(country, postCode);
    }

    @GetMapping(path = {"/{id}"}    )
    public PlayerEntity findById(@PathVariable String id) {
        return playerService.findById(id);
    }

    @PostMapping
    public PlayerEntity save(@RequestBody PlayerEntity playerEntity) {
        return playerService.save(playerEntity);
    }

    @DeleteMapping(path = {"/{id}"}    )
    public PlayerEntity delete(@PathVariable String id) {
        return playerService.delete(id);
    }
}
