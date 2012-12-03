package tec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class Greffon implements Transport, Bus
{
    Collecte collecte;
    Bus bus;
    int arret;
    /*Le greffon doit tenir à jour la liste des passagers car ce sont eux qui
      demanderont la sortie*/
    ArrayList <Passager> passagers;    

    public Greffon(Bus bus, Collecte collecte) throws TecInvalidException
    {
		this.collecte = collecte;
		this.bus = bus;
		passagers = new ArrayList<Passager>();
		arret = 0;
    }
    
    @Override
	public boolean aPlaceAssise()
    {
		return bus.aPlaceAssise();
    }
    
    @Override
	public boolean aPlaceDebout()
    {
		return bus.aPlaceDebout();
    }
    
    @Override
	public void demanderPlaceAssise(Passager p)
    {
		bus.demanderPlaceAssise(p);
		collecte.uneEntree();
		passagers.add(p);
    }
    
    @Override
	public void demanderPlaceDebout(Passager p)
    {
		bus.demanderPlaceDebout(p);
		collecte.uneEntree();
		passagers.add(p);
    }
    
    @Override
	public void demanderSortie(Passager p)
    {
		bus.demanderSortie(p);
		collecte.uneSortie();
		passagers.remove(p);
    }
    
    @Override
	public void demanderChangerEnDebout(Passager p)
    {
		bus.demanderChangerEnDebout(p);
    }
    
    @Override
	public void demanderChangerEnAssis(Passager p)
    {
		bus.demanderChangerEnAssis(p);
    }
    
    @Override
	public void allerArretSuivant() throws TecInvalidException
    {
		Transport transport = null;

	try {
		transport = (Transport) bus;
	} catch (ClassCastException e) {
		throw new TecInvalidException(e);
	}

	try {
	    arret++;
	    

	    /*Il est necessaire d'indiquer aux passagers du greffon que l'on change 
	      d'arret pour que la méthode demanderSortie soit appelée*/
	    ArrayList<Passager> passagersCopie = new ArrayList<Passager>(passagers);
	    for(int i=0, n=passagersCopie.size(); i < n; i++)
		{
		    passagersCopie.get(i).nouvelArret(this, arret);
		}
	    }
	    catch (IllegalStateException e) {
		throw new TecInvalidException(e);
	    }
		collecte.changerArret();
		transport.allerArretSuivant();
    }
    
    @Override
	public String toString()
    {
		return bus.toString();
    }

    public void terminerCollecte() throws IOException
    {
		collecte.terminerCollecte();
    }
}
