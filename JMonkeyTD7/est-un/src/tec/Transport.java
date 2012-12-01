package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public interface Transport
{
    boolean aPlaceAssise();
    boolean aPlaceDebout();

    void allerArretSuivant() throws TecInvalidException;
}
