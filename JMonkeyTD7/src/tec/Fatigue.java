/**
 * Here is the main package for our project.
 */
package tec;

public class Fatigue extends PassagerAbstrait {

	
	public Fatigue(String nom, int destination, Caractere c) {
	    super(nom, destination, c);
	}
	
	@Override
	public void choixPlaceMontee(Bus b)
	{
	    if(b.aPlaceAssise())
		b.demanderPlaceAssise(this);
	}

}
