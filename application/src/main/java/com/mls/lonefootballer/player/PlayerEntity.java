package com.mls.lonefootballer.player;

import com.mls.lonefootballer.data.DynamoBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PlayerEntity extends DynamoBaseEntity {

    public static final String PLAYER_PREFIX = "PLAYER";

    private String firstName;

    private String lastName;

    private String intro;

    private String email;

    private String addressCountry;

    private String addressCity;

    private String addressState;

    private String addressPostCode;

    private String phone;

    private String preferredPositions;

    private String preferredFoot;

    private Boolean lookingForTeam;

    private String birthDate;

    private String sex;

    private String currenTeam;

    private String youTubeChannelUrl;

}
