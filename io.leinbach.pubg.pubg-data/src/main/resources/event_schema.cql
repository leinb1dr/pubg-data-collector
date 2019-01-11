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

CREATE TABLE pubg.attack(
    matchId text,
    eventTimestamp timestamp,
    eventType text,
    attackId int,
    character_name text,
    character_teamId int,
    character_health double,
    character_ranking int,
    character_accountId text,
    character_isInBlueZone boolean,
    character_isInRedZone boolean,
    character_zone set<text>,
    target_name text,
    target_teamId int,
    target_health double,
    target_ranking int,
    target_accountId text,
    target_isInBlueZone boolean,
    target_isInRedZone boolean,
    target_zone set<text>,
    damageTypeCategory text,
    damageReason text,
    damageCauserName text,
    damageCauserNameCategory text,
    distance double,
    PRIMARY KEY (matchId)
);