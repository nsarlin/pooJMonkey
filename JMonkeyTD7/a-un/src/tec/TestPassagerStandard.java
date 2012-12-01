package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
class TestPassagerStandard extends TestPassagerAbstrait
{
    private FauxBus bus;

    protected PassagerAbstrait creerPassager(String nom, int destination)
    {
        return new PassagerStandard(nom, destination);
    }


    void lancer() throws TecInvalidException
    {
        super.lancer();

        System.out.println(".");
        testChoixPlaceMontee();

        System.out.println("OK : " + nbTests);
        System.out.println();
    }
    
    public void testChoixPlaceMontee() throws TecInvalidException
    {
        passagerAbstrait = new PassagerStandard("toto", 5);
        bus = new FauxBus(1, 1);

        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estAssis(), "PassagerStandard n'est pas assis alors qu'il devrait l'etre");
        
        
        passagerAbstrait = new PassagerStandard("toto", 5);
        bus = new FauxBus(0, 1);
        
        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estDebout(), "PassagerStandard n'est pas debout alors qu'il devrait l'etre");

        nbTests++;
    }  
}
