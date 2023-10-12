package com.mls.lonefootballer.player;

public record PlayerRecord(String name, String intro, String email, String addressCountry, String addressCity,
                           String addressState, String addressPostCode, String phone, String preferredPositions,
                           String preferredFoot, Boolean lookingForTeam, String birthDate, String sex, String currenTeam,
                           String youTubeChannelUrl) {}
