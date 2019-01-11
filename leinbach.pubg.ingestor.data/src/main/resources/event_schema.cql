CREATE TYPE pubg.location(
    x double,
    y double,
    z double
)

CREATE TYPE pubg.character(
    name text,
    teamId int,
    health double,
    location FROZEN<location>,
    ranking int,
    accountId text,
    isInBlueZone boolean,
    isInRedZone boolean,
    zone set<text>
)

CREATE TABLE pubg.heatMap(
    matchId text,
    character_accountId text,
    damageReason text,
    eventTimestamp timestamp,
    attackId int,
    character_name text,
    damage double,

    PRIMARY KEY ((character_accountId, matchId), attackId, damageReason, eventTimestamp)
);