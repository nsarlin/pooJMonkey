
/**
 * Here is the main package for our project.
 */
package tec;

public class Poli extends Caractere {

    protected Poli()
    {
	super();
    }

    public void choixChangerPlace(int arret)
    {
	if(this.b.aPlaceDebout() && this.pa.estAssis() && !this.b.aPlaceAssise())
	    this.b.demanderChangerEnDebout(this.pa);
    }

}
