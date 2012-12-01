package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public abstract class PassagerAbstrait extends Passager implements Usager
{
    private String nom;
    private int destination;
    private EtatPassager monEtat;
    private Caractere car;

    /* on veut forcer l'utilisateur
     * à passer en parametre un
     * caractere ou null explicitement
     *
    public PassagerAbstrait(String nom, int destination)
    {
        this.destination = destination;
        this.nom = nom;
        monEtat = EtatPassager.DEHORS;
    }
     */

    public PassagerAbstrait(String nom, int destination, Caractere c)
    {
        this.destination = destination;
        this.nom = nom;
        monEtat = EtatPassager.DEHORS;
	this.car = c;
	if(this.car != null)
	    this.car.setPassagerAbstrait(this);
    }

    public abstract void choixPlaceMontee(Bus b);

    public void choixChangerPlace(int arret)
    {
	this.car.choixChangerPlace(arret);
    }

    @Override
    public String nom()
    {
        return nom;
    }

    @Override
    public boolean estDehors()
    {
        return monEtat.estExterieur();
    }

    @Override
    public boolean estAssis()
    {
        return monEtat.estAssis();
    }

    @Override
    public boolean estDebout()
    {
        return monEtat.estDebout();
    }

    @Override
    public void accepterSortie()
    {
        monEtat = EtatPassager.DEHORS;
    }

    @Override
    public void accepterPlaceAssise()
    {
        monEtat = EtatPassager.ASSIS;
    }

    @Override
    public void accepterPlaceDebout()
    {
        monEtat = EtatPassager.DEBOUT;
    }

    @Override
    public String toString()
    {
        return (nom + " " + monEtat.toString());
    }

    protected int getDestination()
    {
	return destination;
    }

    @Override
    public void nouvelArret(Bus bus, int numeroArret) throws IllegalStateException
    {
        if(numeroArret >= destination)
        {
            bus.demanderSortie(this);
        }
        else
        {
            choixChangerPlace(numeroArret);
        }

    }

    @Override
    public void monterDans(Transport t) throws TecInvalidException
    {

	// il est possible de déclencher l'exception grâce à un mécanisme
	// try catch
	// décommenter le code du try catch si vous le souhaitez
	if(!(t instanceof Bus))
	    throw new TecInvalidException("conversion Transport -> Bus impossible");

	/*
	try {
	*/
	    Bus b = (Bus)t;
	    this.car.setBus(b);
	    choixPlaceMontee(b);
	/*
	}
	catch(ClassCastException e)
	{
	    throw new TecInvalidException(e.getMessage());
	}
	*/
    }
}
