package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {

    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Adresse */
    private String adresse;

    /** Distance */
    private float distance;

    /** numPhone */
    private String phoneNumber;

    /** Facebook  */
    private String facebook;

    /** Description */
    private String description;


    /**favorite*/
    private boolean isFavorite;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Neighbour(Integer id, String name, String avatarUrl, String adresse, float distance, String phoneNumber, String facebook, String description) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.adresse = adresse;
        this.distance = distance;
        this.phoneNumber = phoneNumber;
        this.facebook = facebook;
        this.description = description;
        this.isFavorite = false;
    }

    public Neighbour(int i, String caroline, String s) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isFavorite() { return isFavorite; }

    public void setFavorite(boolean favorite) { isFavorite = favorite; }
    public String getAddress() { return adresse; }

    public void setAddress(String address) { this.adresse = address; }

    public float getDistance() { return distance; }

    public void setDistance(float distance) { this.distance = distance; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getFacebook() { return facebook; }

    public void setFacebook(String facebook) { this.facebook = facebook; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
