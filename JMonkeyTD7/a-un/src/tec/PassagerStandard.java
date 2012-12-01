package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class PassagerStandard extends Repos
{
    public PassagerStandard(String nom, int destination)
    {
        super(nom, destination, (new FabriqueCaractere()).getCalme());
    }
}
