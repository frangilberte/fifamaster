package com.fifamaster.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gilbert on 08/05/2014.
 */
public class Player {
    private String resourceId;
    private String firstName;
    private String lastName;
    private String commonName;
    private int height;
    private int age;
    private boolean foot;
    @SerializedName("base_id")
    private String baseId;
    private String clubId;
    private String nationId;

    @SerializedName("attribute1")
    private int pace;
    @SerializedName("attribute2")
    private int shooting;
    @SerializedName("attribute3")
    private int passing;
    @SerializedName("attribute4")
    private int dribbling;
    @SerializedName("attribute5")
    private int defending;
    @SerializedName("attribute6")
    private int heading;

    public Player(String resourceId, String firstName, String lastName, String commonName, int height, int age, boolean foot, String baseId, String clubId, String nationId, int pace, int shooting, int passing, int dribbling, int defending, int heading) {
        this.resourceId = resourceId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.commonName = commonName;
        this.height = height;
        this.age = age;
        this.foot = foot;
        this.baseId = baseId;
        this.clubId = clubId;
        this.nationId = nationId;
        this.pace = pace;
        this.shooting = shooting;
        this.passing = passing;
        this.dribbling = dribbling;
        this.defending = defending;
        this.heading = heading;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCommonName() {
        return commonName;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public boolean isFoot() {
        return foot;
    }

    public String getBaseId() {
        return baseId;
    }

    public String getClubId() {
        return clubId;
    }

    public String getNationId() {
        return nationId;
    }

    public int getPace() {
        return pace;
    }

    public int getShooting() {
        return shooting;
    }

    public int getPassing() {
        return passing;
    }

    public int getDribbling() {
        return dribbling;
    }

    public int getDefending() {
        return defending;
    }

    public int getHeading() {
        return heading;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFoot(boolean foot) {
        this.foot = foot;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }

    public void setDefending(int defending) {
        this.defending = defending;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public String getUrlFotoJugador(){


        String url =  "http://cdn.content.easports.com/fifa/fltOnlineAssets/C74DDF380B1149b0B1992E2A11D1CC13/2014/fut/items/images/players/web/"+this.baseId+".png";
        return url;
    }

    public String getUrlEscudoClub(){
        String url = "http://cdn.content.easports.com/fifa/fltOnlineAssets/C74DDF380B1149b0B1992E2A11D1CC13/2014/fut/items/images/clubbadges/web/s"+this.clubId+".png";
        return url;
    }

    public String getUrlPaisJugador(){
        String url = "http://cdn.content.easports.com/fifa/fltOnlineAssets/C74DDF380B1149b0B1992E2A11D1CC13/2014/fut/items/images/cardflagssmall/web/"+this.nationId+".png";
        return url;
    }
}
