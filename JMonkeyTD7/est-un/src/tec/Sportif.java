/**
 * Here is the main package for our project.
 */
package tec;

public class Sportif extends PassagerAbstrait {

	public Sportif(String nom, int destination, Caractere c) {
	    super(nom, destination, c);
	}
	
	@Override
	public void choixPlaceMontee(Bus b)
	{
	    if(b.aPlaceDebout())
		b.demanderPlaceDebout(this);
	    else if(b.aPlaceAssise())
		b.demanderPlaceAssise(this);
	}

}
