/**
 * Here is the main package for our project.
 */
package tec;

/**
 * Test class for our PassagerStresse class.
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class TestPassagerStresse extends TestPassagerAbstrait
{
    private FauxBus bus;

    protected PassagerAbstrait creerPassager(String nom, int destination)
    {
        return new PassagerStresse(nom, destination);
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
        bus = new FauxBus(0,1);
        passagerAbstrait = new PassagerStresse("Roger", 10);
        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estDehors(), "Passager stressé monté dans le bus alors qu'il ne devrait pas");

        bus = new FauxBus(1,1);
        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estAssis(), "Passager stessé n'est pas assis dans le bus alors qu'il devrait");

        nbTests++;
     }

    /**
     * Test de choix changer place
     */
    private void testChoixChangerPlace() throws TecInvalidException
    {
        bus = new FauxBus(1,1);
        passagerAbstrait = new PassagerStresse("Albert", 10);
        passagerAbstrait.monterDans(bus);
        jeVeuxVrai(passagerAbstrait.estAssis(), "Passager stressé n'est pas assis dans le bus alors qu'il devrait");
        for(int i = 0; i < 6; i++)
            bus.allerArretSuivant();
        jeVeuxVrai(passagerAbstrait.estAssis(), "Passager stressé n'est pas assis dans le bus alors qu'il devrait");
        bus.allerArretSuivant();
        jeVeuxVrai(passagerAbstrait.estDebout(), "Passager stressé n'est pas debout alors qu'il devrait");

        nbTests++;
    }
}
