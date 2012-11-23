/**
 * Here is the main package for our project.
 */
package tec;

/**
 * Test class for our PassagerStresse class.
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class TestPassagerLunatique extends TestPassagerAbstrait
{
    private FauxBus bus;

    protected PassagerAbstrait creerPassager(String nom, int destination)
    {
        return new PassagerLunatique(nom, destination);
    }

    /**
     * Launches our series of test.
     */
    void lancer() throws TecInvalidException
    {
        super.lancer();

        System.out.println(".");
        testChoixPlaceMontee();

        System.out.println(".");
        testChoixChangerPlace();

        System.out.println("OK : " + nbTests);
        System.out.println();
    }

    /**
     * Test de choix place montee
     */
    private void testChoixPlaceMontee() throws TecInvalidException
    {
        passagerAbstrait = new PassagerLunatique("Roger", 10);
        
        bus = new FauxBus(0,1);
        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estDebout(), "Passager lunatique n'est pas debout dans le bus alors qu'il devrait l'être");
        
	passagerAbstrait = new PassagerLunatique("Roger", 10);
 
        bus = new FauxBus(1,0);
        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estAssis(), "Passager lunatique n'est pas assis dans le bus alors qu'il devrait");

        nbTests++;
    }

    /**
     * Test de choix changer place
     */
    private void testChoixChangerPlace() throws TecInvalidException
    { 
        //Initialisation du test
        bus = new FauxBus(1,1);
        passagerAbstrait = new PassagerLunatique("Roger", 10);
        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estDebout(), "Passager lunatique n'est pas debout dans le bus alors qu'il devrait");
        
        bus.allerArretSuivant();
        jeVeuxVrai(passagerAbstrait.estAssis(), "Le passagerAbstrait ne s'est pas assis à l'arrêt suivant");
        
        bus.allerArretSuivant();
        jeVeuxVrai(passagerAbstrait.estDebout(), "Le passagerAbstrait ne s'est pas levé à l'arrêt suivant");
        
        bus.allerArretSuivant();
        jeVeuxVrai(passagerAbstrait.estAssis(), "Le passagerAbstrait ne s'est pas assis à l'arrêt suivant");
        
        bus.allerArretSuivant();
        jeVeuxVrai(passagerAbstrait.estDebout(), "Le passagerAbstrait ne s'est pas levé à l'arrêt suivant");

        nbTests++;
    }
}
