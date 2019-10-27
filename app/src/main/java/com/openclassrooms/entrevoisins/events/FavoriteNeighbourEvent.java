package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;


public class FavoriteNeighbourEvent {

        public FavoriteNeighbourEvent(Neighbour neighbour) {
            DI.getNeighbourApiService().changeFavoriteStatus(neighbour);
        }

}
