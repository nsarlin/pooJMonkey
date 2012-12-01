/**
 * Here is the main package for our project.
 */
package tec;

public class Tetu extends PassagerAbstrait {

	public Tetu(String nom, int destination, Caractere c) {
	    super(nom, destination, c);
	}
	
	@Override
	public void choixPlaceMontee(Bus b)
	{
	    b.demanderPlaceDebout(this);
	}

}
