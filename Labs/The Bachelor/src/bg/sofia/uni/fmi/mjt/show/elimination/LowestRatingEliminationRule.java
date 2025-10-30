package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

import java.util.Arrays;

public class LowestRatingEliminationRule implements  EliminationRule {

    public LowestRatingEliminationRule(){}

    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int lowestRating = getLowestRating(ergenkas);
        int count = getLowestRatedErgenkasCount(ergenkas, lowestRating);
        Ergenka[] remainingErgenkas = new Ergenka[ergenkas.length - count];
        int newIndex = 0;
        for(Ergenka e : ergenkas){
            if(e.getRating() > lowestRating){
                remainingErgenkas[newIndex] = e;
                newIndex++;
            }
        }
        return remainingErgenkas;
    }

    int getLowestRating(Ergenka[] ergenkas){
        int rating = ergenkas[0].getRating();
        for (Ergenka e : ergenkas) {
            if(e.getRating() < rating){
                rating = e.getRating();
            }
        }
        return rating;
    }

    int getLowestRatedErgenkasCount(Ergenka[] ergenkas, int lowestRating){
        int count = 0;
        for(Ergenka e : ergenkas){
            if(e.getRating() == lowestRating){
                count++;
            }
        }
        return count;
    }
}
