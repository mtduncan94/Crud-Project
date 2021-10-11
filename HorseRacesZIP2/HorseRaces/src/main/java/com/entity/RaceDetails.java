package com.entity;

import java.util.Objects;

public class RaceDetails {

    private int ID;
    private String raceName;
    private String trackName;
    private String raceDate;

    public RaceDetails(int ID, String raceName, String trackName, String raceDate) {
        this.ID = ID;
        this.raceName = raceName;
        this.trackName = trackName;
        this.raceDate = raceDate;
    }

    public RaceDetails() {
    }

    public int getID() {
        return ID;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getRaceDate() {
        return raceDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RaceDetails other = (RaceDetails) obj;
        if (!Objects.equals(this.raceName, other.raceName)) {
            return false;
        }
        if (!Objects.equals(this.trackName, other.trackName)) {
            return false;
        }
        if (!Objects.equals(this.raceDate, other.raceDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RaceDetails{" + "ID=" + ID + ", raceName=" + raceName + ", trackName=" + trackName + ", raceDate=" + raceDate + '}';
    }

}
