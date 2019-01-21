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

CREATE TABLE pubg.player(
    playerName text,
    accountId text,
    lastUpdated timestamp,
    PRIMARY KEY (playerName)
);

CREATE INDEX playerByAccount on pubg.player(accountId);

CREATE TABLE pubg.playerMatch(
    accountId text,
    matchId text,
    playername text,
    teamId int,
    rank int,
    stats text,
    PRIMARY KEY ((accountId), matchId)
);

create index matchById on pubg.playerMatch(matchId);
create index matchByTeam on pubg.playerMatch(teamId);

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
    seasonStats text,
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