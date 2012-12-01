/**
 * Here is the main package for our project.
 */
package tec;

//import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Réalisation d'un Autobus qui permet de calculer le nombre de places occupées.
 * <p>
 * Un objet Autobus contient deux jauges. Implémente Bus.
 * <ul>
 * <li>La première contient le nombre de places assises,
 * <li>La deuxième le nombre de places debout.
 * </ul>
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 * @since 2012
 */
class Autobus implements Bus, Transport
{
    JaugeNaturel jaugeAssis;
    JaugeNaturel jaugeDebout;
    int arret;

    ArrayList <Passager> passagers;

    /**
     * Construit une instance en précisant la valeur de **** de Autobus
     *
     * @param nbAssisMax entier indicant le nombre maximal de places assises
     * @param nbDeboutMax entier indicant le nombre maximal de places debout
     */
    public Autobus(int nbAssisMax, int nbDeboutMax) throws TecInvalidException
    {
	// TODO changer pour <=
	if(nbAssisMax < 0 || nbDeboutMax < 0)
	    throw new TecInvalidException("nb max de passagers invalide : nbAssisMax = " + nbAssisMax + ", nbDeboutMax = " + nbDeboutMax);
	jaugeAssis = new JaugeNaturel(0, nbAssisMax, 0);
	jaugeDebout = new JaugeNaturel(0, nbDeboutMax, 0);
	arret = 0;
	passagers = new ArrayList<Passager>();
    }

    @Override
	public boolean aPlaceAssise()
	{
	    return !jaugeAssis.estRouge();
	}

    @Override
	public boolean aPlaceDebout()
	{
	    return !jaugeDebout.estRouge();
	}

    @Override
	public void demanderPlaceAssise(Passager p)
	{
	    jaugeAssis.incrementer();
	    p.accepterPlaceAssise();
	    passagers.add(p);
	}

    @Override
	public void demanderPlaceDebout(Passager p)
	{
	    jaugeDebout.incrementer();
	    p.accepterPlaceDebout();
	    passagers.add(p);
	}

    @Override
	public void demanderSortie(Passager p)
	{
	    if(p.estDebout())
	    {
		jaugeDebout.decrementer();
		p.accepterSortie();
		passagers.remove(p);
	    }
	}

    @Override
	public void demanderChangerEnDebout(Passager p)
	{
	    jaugeAssis.decrementer();
	    jaugeDebout.incrementer();
	    p.accepterPlaceDebout();
	}

    @Override
	public void demanderChangerEnAssis(Passager p)
	{
	    jaugeDebout.decrementer();
	    jaugeAssis.incrementer();
	    p.accepterPlaceAssise();
	}

    @Override
	public void allerArretSuivant() throws TecInvalidException
	{
	    try {
		arret++;

		for(int i=0; i < passagers.size(); i++)
		{
		    passagers.get(i).nouvelArret(this, arret);
		}
	    }
	    catch (IllegalStateException e) {
		throw new TecInvalidException(e);
	    }
	}

    @Override
	public String toString()
	{
	    int nbdebout = 0;
	    int nbassis = 0;

	    Iterator<Passager> it = passagers.iterator();
	    while(it.hasNext())
	    {
		Passager p = it.next();

		if(p.estAssis())
		    nbassis++;
		else if(p.estDebout())
		    nbdebout++;
	    }

	    return ("[arret:" + arret + ", assis:" + nbassis + ", debout:" + nbdebout + "]");
	}
}
