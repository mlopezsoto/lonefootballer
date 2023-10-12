package com.mls.lonefootballer.player;

import lombok.Data;

@Data
public class PlayerEntity {

    private String name;

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
