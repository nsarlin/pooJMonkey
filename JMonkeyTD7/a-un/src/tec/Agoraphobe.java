/**
 * Here is the main package for our project.
 */
package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class Agoraphobe extends Caractere {

    protected Agoraphobe()
    {
	super();	
    }

    @Override
    public void choixChangerPlace(int arret)
    {
	if(arret >= this.pa.getDestination() || !this.b.aPlaceAssise() || !this.b.aPlaceDebout())
	{
	    this.b.demanderSortie(this.pa);
	}
    }

}
