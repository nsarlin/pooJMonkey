package tec;

import java.io.IOException;

public class Greffon implements Transport, Bus
{
    Collecte collecte;
    Autobus autobus;
    
    public Greffon(int nbAssisMax, int nbDeboutMax) throws TecInvalidException
    {
	try
	    {
	    collecte = new CollecteFile();
	    }
	catch(IOException e)
	    {
		System.err.println(e.getMessage());
	    }

	autobus = new Autobus(nbAssisMax, nbDeboutMax);
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
    }
    
    @Override
	public void demanderPlaceDebout(Passager p)
    {
	autobus.demanderPlaceDebout(p);
	collecte.uneEntree();
    }
    
    @Override
	public void demanderSortie(Passager p)
    {
	autobus.demanderSortie(p);
	collecte.uneSortie();
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
	autobus.allerArretSuivant();
	collecte.changerArret();
    }
    
    @Override
	public String toString()
    {
	return autobus.toString();
    }
}
