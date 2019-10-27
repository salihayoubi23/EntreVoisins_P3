package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }
    public Neighbour getNeighbour(int id){

        Neighbour neighbour = null;

        for (int i = 0; i < neighbours.size(); i++) {
            Neighbour n = neighbours.get(i);
            if(n.getId() == id) {
                neighbour = n;
                break;
            }
        }

        return neighbour;
    }

    /**
     *
     * @param neighbour is favorite
     */
    public void changeFavoriteStatus(Neighbour neighbour) {

        neighbour.setFavorite(!neighbour.isFavorite());
    }

    /**
     *
     * @return favorite list
     */

    public List<Neighbour> getFavorites() {
        List<Neighbour> favorites = new ArrayList();

        for(int i = 0; i < neighbours.size(); i++) {
            Neighbour neighbour = neighbours.get(i);
            if(neighbour.isFavorite()) {
                favorites.add(neighbour);
            }
        }

        return favorites;
    }
}
