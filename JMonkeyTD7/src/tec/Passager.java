package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
abstract class Passager
{
    abstract String nom();
    abstract boolean estDehors();

    abstract boolean estAssis();
    abstract boolean estDebout();

    abstract void accepterSortie();
    abstract void accepterPlaceAssise();
    abstract void accepterPlaceDebout();

    abstract void nouvelArret(Bus b, int numeroArret) throws IllegalStateException;
}
