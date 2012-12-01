
/**
 * Here is the main package for our project.
 */
package tec;

public class Nerveux extends Caractere {

    protected Nerveux() {
	super();
    }

    @Override
    public void choixChangerPlace(int arret)
    {
	if(this.pa.estAssis() && this.b.aPlaceDebout())
	    this.b.demanderChangerEnDebout(this.pa);
	else if(this.pa.estDebout() && this.b.aPlaceAssise())
	    this.b.demanderChangerEnAssis(this.pa);
    }
}
