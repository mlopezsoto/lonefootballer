package com.mls.lonefootballer.data;

import lombok.Data;
import lombok.Getter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Data
@DynamoDbBean
public abstract class DynamoBaseEntity {

    @Getter(onMethod_={@DynamoDbPartitionKey, @DynamoDbAttribute("partition-key")})
    private String partitionKey;

    @Getter(onMethod_={@DynamoDbSortKey, @DynamoDbAttribute("sort-key")})
    private String sortKey;

    @Getter(onMethod_={@DynamoDbSecondaryPartitionKey(indexNames = {"gsi"}), @DynamoDbAttribute("gsi-partition-key")})
    private String gsiPartitionKey;

    @Getter(onMethod_={@DynamoDbSecondarySortKey(indexNames = {"gsi"}), @DynamoDbAttribute("gsi-sort-key")})
    private String gsiSortKey;

}
