package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     *
     * @return  favorite
     */

    List<Neighbour> getFavorites();

    /**
     *
     * @param neighbour
     */

    void changeFavoriteStatus(Neighbour neighbour);

    /**
     * @param idNeighbour
     * @return id
     */

    Neighbour getNeighbour(int idNeighbour);
}
