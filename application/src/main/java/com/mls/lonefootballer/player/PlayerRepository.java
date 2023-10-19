package com.mls.lonefootballer.player;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.mls.lonefootballer.data.Constants.DYNAMO_DATA_DELIMITER;
import static com.mls.lonefootballer.player.PlayerEntity.PLAYER_PREFIX;

@Slf4j
@Repository
public class PlayerRepository  {

    private final DynamoDbTable<PlayerEntity> playerEntityDynamoTable;


    public PlayerRepository(DynamoDbTable<PlayerEntity> playerEntityDynamoTable) {
        this.playerEntityDynamoTable = playerEntityDynamoTable;
    }

    public PlayerEntity save(final PlayerEntity player) {
        if(Objects.isNull(player)) {
            return null;
        }

        if(Objects.isNull(player.getPartitionKey())) {
            player.setPartitionKey(PLAYER_PREFIX);
            player.setSortKey(PLAYER_PREFIX + DYNAMO_DATA_DELIMITER + UlidCreator.getUlid().toString());
        }

        player.setGsiPartitionKey(player.getAddressCountry());
        player.setGsiSortKey(player.getAddressPostCode());

        log.info("Before saving item");
        playerEntityDynamoTable.putItem(player);
        log.info("After saving item");
        return player;
    }

    public PlayerEntity findById(final String playerID) {
        // Construct the key with partition and sort key
        Key key = Key.builder().partitionValue(PLAYER_PREFIX)
                .sortValue(playerID)
                .build();

        log.info("Before retrieving item");
        PlayerEntity playerEntity = playerEntityDynamoTable.getItem(key);
        log.info("After retrieving item");

        return playerEntity;
    }

    public List<PlayerEntity> findAll() {
        QueryConditional allPLayerConditional = QueryConditional.keyEqualTo(builder -> builder.partitionValue(PLAYER_PREFIX));
        QueryEnhancedRequest allPlayersQuery = QueryEnhancedRequest.builder()
                .queryConditional(allPLayerConditional).build();

        // Query the table
        log.info("Before retrieving items");
        PageIterable<PlayerEntity> players = playerEntityDynamoTable.query(allPlayersQuery);
        log.info("After retrieving items");
        return players.stream().flatMap(playerEntityPage -> playerEntityPage.items().stream()).collect(Collectors.toList());
    }
}
