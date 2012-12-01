package tec;

import java.io.IOException;

interface Collecte{
    void uneEntree();
    void uneSortie();
    void changerArret();
    public void terminerCollecte() throws IOException;
}