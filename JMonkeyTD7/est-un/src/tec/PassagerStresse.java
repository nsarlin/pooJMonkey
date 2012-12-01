package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class PassagerStresse extends Fatigue {

    public PassagerStresse(String nom, int destination)
    {
        super(nom, destination, (new FabriqueCaractere()).getPrudent());
    }

}
