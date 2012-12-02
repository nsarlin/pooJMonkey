package tec;

import java.io.IOException;
import tec.Collecte;

public class Greffon extends Autobus
{
    Collecte collecte;
    
    public Greffon(int nbAssisMax, int nbDeboutMax) throws TecInvalidException
    {
	super(nbAssisMax, nbDeboutMax);
	try
	    {
	    collecte = new CollecteFile();
	    }
	catch(IOException e)
	    {
		System.err.println(e.getMessage());
	    }
    }
   
    @Override
    public void demanderPlaceAssise(Passager p)
    {
	super.demanderPlaceAssise(p);
	collecte.uneEntree();
    }
    
    @Override
	public void demanderPlaceDebout(Passager p)
    {
	super.demanderPlaceDebout(p);
	collecte.uneEntree();
    }
    
    @Override
	public void demanderSortie(Passager p)
    {
	super.demanderSortie(p);
	collecte.uneSortie();
    }
    
    
    @Override
	public void allerArretSuivant() throws TecInvalidException
    {
	super.allerArretSuivant();
	collecte.changerArret();
    }

    public void terminerCollecte() throws IOException
    {
	collecte.terminerCollecte();
    }

}
