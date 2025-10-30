package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public interface EliminationRule {

    Ergenka[] eliminateErgenkas(Ergenka[] ergenkas);

}
