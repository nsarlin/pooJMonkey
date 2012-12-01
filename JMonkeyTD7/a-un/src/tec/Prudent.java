
/**
 * Here is the main package for our project.
 */
package tec;

public class Prudent extends Caractere {

    protected Prudent()
    {
	super();
    }

    @Override
    public void choixChangerPlace(int arret) {
	if(this.b.aPlaceAssise() && this.pa.estDebout() && arret <= this.pa.getDestination() - 5)
	    this.b.demanderChangerEnAssis(this.pa);
	if(this.b.aPlaceDebout() && this.pa.estAssis() && arret >= this.pa.getDestination() -3)
	    this.b.demanderChangerEnDebout(this.pa);
    }
}
