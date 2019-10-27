package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;


public class FavoriteNeighbourEvent {

    public Neighbour neighbour;
        public FavoriteNeighbourEvent(Neighbour neighbour) {
            this.neighbour = neighbour;
            DI.getNeighbourApiService().changeFavoriteStatus(neighbour);
        }
}
