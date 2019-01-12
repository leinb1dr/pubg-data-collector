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

CREATE TABLE pubg.matchProcessing(
    matchId text,
    matchProcessing int,
    heatMapProcessing int,
    lastUpdated timestamp,
    PRIMARY KEY (matchId)
);

CREATE TABLE pubg.player(
    playername text,
    accountid text,
    lastupdated timestamp,
    PRIMARY KEY (playername)
);

CREATE TABLE pubg.heatMap(
    matchId text,
    character_accountId text,
    damageReason text,
    eventTimestamp timestamp,
    attackId int,
    character_name text,
    damage double,

    PRIMARY KEY ((character_accountId, matchId), damageReason, attackId, eventTimestamp)
);