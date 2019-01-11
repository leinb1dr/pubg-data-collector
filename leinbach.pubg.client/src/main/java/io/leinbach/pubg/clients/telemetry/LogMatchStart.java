package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogMatchStart extends TelemetryBase {
    @JsonProperty("mapName")
    private String mapName;
    @JsonProperty("weatherId")
    private String weatherId;
    @JsonProperty("characters")
    private List<Character> characters;
    @JsonProperty("cameraViewBehaviour")
    private String cameraViewBehaviour;
    @JsonProperty("teamSize")
    private int teamSize;
    @JsonProperty("isCustomGame")
    private boolean customGame;
    @JsonProperty("isEventMode")
    private boolean eventMode;
    @JsonProperty("blueZoneCustomOptions")
    private String blueZoneCustomOptions;

    @Override
    public EventDto to() {
        return super.to();
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public String getCameraViewBehaviour() {
        return cameraViewBehaviour;
    }

    public void setCameraViewBehaviour(String cameraViewBehaviour) {
        this.cameraViewBehaviour = cameraViewBehaviour;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public boolean isCustomGame() {
        return customGame;
    }

    public void setCustomGame(boolean customGame) {
        this.customGame = customGame;
    }

    public boolean isEventMode() {
        return eventMode;
    }

    public void setEventMode(boolean eventMode) {
        this.eventMode = eventMode;
    }

    public String getBlueZoneCustomOptions() {
        return blueZoneCustomOptions;
    }

    public void setBlueZoneCustomOptions(String blueZoneCustomOptions) {
        this.blueZoneCustomOptions = blueZoneCustomOptions;
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
