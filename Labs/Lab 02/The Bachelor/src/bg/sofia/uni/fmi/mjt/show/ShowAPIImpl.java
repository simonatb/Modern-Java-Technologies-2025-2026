package bg.sofia.uni.fmi.mjt.show;

import bg.sofia.uni.fmi.mjt.show.elimination.EliminationRule;
import bg.sofia.uni.fmi.mjt.show.date.DateEvent;
import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class ShowAPIImpl implements ShowAPI{
    private Ergenka[] ergenkas;
    private EliminationRule[] defaultEliminationRules;

    public ShowAPIImpl(Ergenka[] ergenkas, EliminationRule[] defaultEliminationRules){
        this.ergenkas = ergenkas;
        this.defaultEliminationRules = defaultEliminationRules;
    }
    @Override
    public Ergenka[] getErgenkas() {
        return ergenkas;
    }

    @Override
    public void playRound(DateEvent dateEvent) {
        if (ergenkas == null) return;
        for (Ergenka ergenka : ergenkas) {
            ergenka.reactToDate(dateEvent);
        }
    }

    @Override
    public void eliminateErgenkas(EliminationRule[] eliminationRules) {
        if (eliminationRules == null || eliminationRules.length == 0) {
            eliminationRules = defaultEliminationRules;
        }
        for (EliminationRule rule : eliminationRules) {
            ergenkas = rule.eliminateErgenkas(ergenkas);
        }
    }

    @Override
    public void organizeDate(Ergenka ergenka, DateEvent dateEvent) {
        if (ergenka != null) {
            ergenka.reactToDate(dateEvent);
        }
    }
}
