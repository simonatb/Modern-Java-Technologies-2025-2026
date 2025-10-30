package bg.sofia.uni.fmi.mjt.show;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;
import bg.sofia.uni.fmi.mjt.show.date.DateEvent;
import bg.sofia.uni.fmi.mjt.show.elimination.EliminationRule;

public interface ShowAPI {


    Ergenka[] getErgenkas();
    void playRound(DateEvent dateEvent);
    void eliminateErgenkas(EliminationRule[] eliminationRules);
    void organizeDate(Ergenka ergenka, DateEvent dateEvent);

}