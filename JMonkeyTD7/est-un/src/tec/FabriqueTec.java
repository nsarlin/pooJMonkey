package tec;

/**
 * Realisation d'une fabrique d'Autobus et de PassagerStandard.
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public final class FabriqueTec
{
    private FabriqueTec()
    {
    }

    public static PassagerStandard fairePassagerStandard(String nom, int destination)
    {
        return new PassagerStandard(nom, destination);
    }

    public static Autobus faireAutobus(int nbAssisMax, int nbDeboutMax) throws TecInvalidException
    {
        return new Autobus(nbAssisMax, nbDeboutMax);
    }
}
