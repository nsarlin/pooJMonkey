package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class FauxPassager extends Passager implements Usager
{
    private boolean assis;

    final Messages messages = new Messages();

    public FauxPassager(String nom, int destination)
    {
        assis = false;
    }

    @Override
    public String nom()
    {
        return null;
    }

    @Override
    public boolean estDehors()
    {
        return false;
    }

    @Override
    public boolean estAssis()
    {
        return assis;
    }

    @Override
    public boolean estDebout()
    {
        return !assis;
    }

    @Override
    public void accepterSortie()
    {
        messages.add("accepterSortie");
    }

    @Override
    public void accepterPlaceAssise()
    {
        assis = true;
        messages.add("accepterPlaceAssise");
    }

    @Override
    public void accepterPlaceDebout()
    {
        assis = false;
        messages.add("accepterPlaceDebout");
    }

    @Override
    public void nouvelArret(Bus bus, int numeroArret)
    {
        messages.add("nouvelArret");
    }

    @Override
    public void monterDans(Transport t)
    {
        Bus b = (Bus)t;
    }
}
