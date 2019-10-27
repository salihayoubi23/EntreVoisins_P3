package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {
    public static String APROPOS = "Bonjour,jesouhaiterais faire de la marche nordique.Pas initié je cherches une ou plusieurs personnes succeptible de m'accompagner.J'aime les jeux de carte tel que la belotte et le tarot";
    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/caroline",APROPOS),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Jacque",APROPOS),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Chloé",APROPOS),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Vincent",APROPOS),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Elodie",APROPOS),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Sylvain",APROPOS),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Laetitia",APROPOS),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Dan",APROPOS),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Joseph",APROPOS),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Emma",APROPOS),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Patrick",APROPOS),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d","Saint Pierre Du Mont",5,"+33686579014","www.facebook.fr/Ludovik",APROPOS)
    );
    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}
