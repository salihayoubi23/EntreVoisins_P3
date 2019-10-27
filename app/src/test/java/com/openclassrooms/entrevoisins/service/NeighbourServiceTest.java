package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }
    @Test
    public void getNeighbourDetailsWithSuccess() {

        Neighbour neighbourDetails = service.getNeighbours().get(0);
        Neighbour neighbour = service.getNeighbour(1);
        assertTrue(neighbour.equals(neighbourDetails));
    }
    @Test
    public void addFavoriteWithSuccess() {
        Neighbour neighbour = service.getNeighbour(3);

        if(!neighbour.isFavorite()) {
            service.changeFavoriteStatus(neighbour);
        }
        assertTrue(service.getFavorites().contains(neighbour));
    }


    @Test
    public void removeFavoriteWithSuccess() {
        Neighbour neighbour = service.getNeighbour(1);
        if(neighbour.isFavorite()) {
            service.changeFavoriteStatus(neighbour); }
        assertFalse(service.getFavorites().contains(neighbour));
    }
    @Test
    public void getFavoriteWithSuccess() {

        List<Neighbour> neighboursToAddToFavorites = new ArrayList<>();
        neighboursToAddToFavorites.add(service.getNeighbour(1));
        neighboursToAddToFavorites.add(service.getNeighbour(2));
        for(int i = 0; i < neighboursToAddToFavorites.size(); i++) {
            if (!neighboursToAddToFavorites.get(i).isFavorite())
            { service.changeFavoriteStatus(neighboursToAddToFavorites.get(i)); } }
    }

}
