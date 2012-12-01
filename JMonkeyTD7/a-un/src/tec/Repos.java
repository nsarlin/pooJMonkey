/**
 * Here is the main package for our project.
 */
package tec;

public class Repos extends PassagerAbstrait {

	public Repos(String nom, int destination, Caractere c) {
	    super(nom, destination, c);
	}
	
	@Override
	public void choixPlaceMontee(Bus b)
	{
	    if(b.aPlaceAssise())
		b.demanderPlaceAssise(this);
	    else if(b.aPlaceDebout())
		b.demanderPlaceDebout(this);
	}

}
