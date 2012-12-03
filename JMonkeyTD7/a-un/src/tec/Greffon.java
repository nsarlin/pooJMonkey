package tec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class Greffon implements Transport, Bus
{
    Collecte collecte;
    Autobus autobus;
    int arret;
    /*Le greffon doit tenir à jour la liste des passagers car ce sont eux qui
      demanderont la sortie*/
    ArrayList <Passager> passagers;    

    public Greffon(int nbAssisMax, int nbDeboutMax) throws TecInvalidException
    {
	/*Ce try/catch est à utiliser dans le cas d'un CollecteFile
	 
	  try {*/
	    collecte = new CollecteMem();
	    /*}
	catch(IOException e)
	    {
		System.err.println(e.getMessage());
		}*/

	autobus = new Autobus(nbAssisMax, nbDeboutMax);
	passagers = new ArrayList<Passager>();
	arret = 0;
    }
    
    @Override
	public boolean aPlaceAssise()
    {
	return autobus.aPlaceAssise();
    }
    
    @Override
	public boolean aPlaceDebout()
    {
	return autobus.aPlaceDebout();
    }
    
    @Override
	public void demanderPlaceAssise(Passager p)
    {
	autobus.demanderPlaceAssise(p);
	collecte.uneEntree();
	passagers.add(p);
    }
    
    @Override
	public void demanderPlaceDebout(Passager p)
    {
	autobus.demanderPlaceDebout(p);
	collecte.uneEntree();
	passagers.add(p);
    }
    
    @Override
	public void demanderSortie(Passager p)
    {
	collecte.uneSortie();
	passagers.remove(p);
    }
    
    @Override
	public void demanderChangerEnDebout(Passager p)
    {
	autobus.demanderChangerEnDebout(p);
    }
    
    @Override
	public void demanderChangerEnAssis(Passager p)
    {
	autobus.demanderChangerEnAssis(p);
    }
    
    @Override
	public void allerArretSuivant() throws TecInvalidException
    {
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
	autobus.allerArretSuivant();
    }
    
    @Override
	public String toString()
    {
	return autobus.toString();
    }

    public void terminerCollecte() throws IOException
    {
	collecte.terminerCollecte();
    }
}
