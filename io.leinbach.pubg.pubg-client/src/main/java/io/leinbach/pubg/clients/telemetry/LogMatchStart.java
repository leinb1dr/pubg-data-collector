package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogMatchStart extends TelemetryBase {
    @JsonProperty("mapName")
    private final String mapName;
    @JsonProperty("weatherId")
    private final String weatherId;
    @JsonProperty("characters")
    private final List<Character> characters;
    @JsonProperty("cameraViewBehaviour")
    private final String cameraViewBehaviour;
    @JsonProperty("teamSize")
    private final int teamSize;
    @JsonProperty("isCustomGame")
    private final boolean customGame;
    @JsonProperty("isEventMode")
    private final boolean eventMode;
    @JsonProperty("blueZoneCustomOptions")
    private final String blueZoneCustomOptions;

    public LogMatchStart(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, String mapName, String weatherId, List<Character> characters, String cameraViewBehaviour, int teamSize, boolean customGame, boolean eventMode, String blueZoneCustomOptions) {
        super(eventTimestamp, eventType, common);
        this.mapName = mapName;
        this.weatherId = weatherId;
        this.characters = characters;
        this.cameraViewBehaviour = cameraViewBehaviour;
        this.teamSize = teamSize;
        this.customGame = customGame;
        this.eventMode = eventMode;
        this.blueZoneCustomOptions = blueZoneCustomOptions;
    }

    public String getMapName() {
        return mapName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public String getCameraViewBehaviour() {
        return cameraViewBehaviour;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public boolean isCustomGame() {
        return customGame;
    }

    public boolean isEventMode() {
        return eventMode;
    }

    public String getBlueZoneCustomOptions() {
        return blueZoneCustomOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMatchStart that = (LogMatchStart) o;
        return teamSize == that.teamSize &&
                customGame == that.customGame &&
                eventMode == that.eventMode &&
                Objects.equals(mapName, that.mapName) &&
                Objects.equals(weatherId, that.weatherId) &&
                Objects.equals(characters, that.characters) &&
                Objects.equals(cameraViewBehaviour, that.cameraViewBehaviour) &&
                Objects.equals(blueZoneCustomOptions, that.blueZoneCustomOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapName, weatherId, characters, cameraViewBehaviour, teamSize, customGame, eventMode, blueZoneCustomOptions);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogMatchStart.class.getSimpleName() + "[", "]")
                .add("mapName='" + mapName + "'")
                .add("weatherId='" + weatherId + "'")
                .add("characters=" + characters)
                .add("cameraViewBehaviour='" + cameraViewBehaviour + "'")
                .add("teamSize=" + teamSize)
                .add("customGame=" + customGame)
                .add("eventMode=" + eventMode)
                .add("blueZoneCustomOptions='" + blueZoneCustomOptions + "'")
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
