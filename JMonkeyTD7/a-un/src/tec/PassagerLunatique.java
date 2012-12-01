package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class PassagerLunatique extends Sportif
{
    public PassagerLunatique(String nom, int destination)
    {
        super(nom, destination, (new FabriqueCaractere()).getNerveux());
    }

}
