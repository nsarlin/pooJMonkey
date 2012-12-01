/**
 * Here is the main package for our project.
 */
package tec;

/**
 * Test class for our Autobus class.
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class TestAutobus
{
    // Fields
    private Autobus autobus;
    private int nbTests;

    /**
     * Constructor
     */
    public TestAutobus() {}


    protected void jeVeuxVrai(boolean expr, String m)
    {
	assert expr : "\nECHEC jeVeuxVrai <" + m + ">";
    }

    protected void jeVeuxFaux(boolean expr, String m)
    {
	assert !expr : "\nECHEC jeVeuxFaux <" + m + ">";
    }

    /**
     * Launches our series of test.
     */
    public void lancer() throws TecInvalidException
    {
        // Sets our nbTests variable to zero.
        nbTests = 0;

        System.out.println("Autobus:");

        System.out.println(".");
        testAvoirPlace();

        System.out.println(".");
        testDemanderPlace();

        System.out.println(".");
        testDemanderSortie();

        System.out.println(".");
        testAllerArretSuivant();

        System.out.println(".");
        testDemanderChangerEtat();

        System.out.println("OK : " + nbTests);
        System.out.println();
    }

    /**
     * Makes sure aPlaceAssise() and aPlaceDebout() are working properly.
     */
    public void testAvoirPlace() throws TecInvalidException
    {
        autobus = new Autobus(1, 0);

        assert(autobus.aPlaceAssise() == true);
        assert(autobus.aPlaceDebout() == false);

        autobus = new Autobus(0, 1);

        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == true);

        nbTests++;
    }

    /**
     * Makes sure demanderPlaceAssise() and demanderPlaceDebout() are working properly.
     */
    public void testDemanderPlace() throws TecInvalidException
    {
        autobus = new Autobus(1, 0);

        FauxPassager fakePassager = new FauxPassager("gérard", 42);

        assert(autobus.aPlaceAssise() == true);
        assert(autobus.aPlaceDebout() == false);

        autobus.demanderPlaceAssise(fakePassager);
        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == false);


        autobus = new Autobus(0, 1);
        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == true);

        autobus.demanderPlaceDebout(fakePassager);
        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == false);

        nbTests++;
    }

    /**
     * Makes sure demanderSortie() is working properly.
     */
    public void testDemanderSortie() throws TecInvalidException
    {
        autobus = new Autobus(1, 1);
        FauxPassager fakePassagerAssis = new FauxPassager("gérard", 13);
        FauxPassager fakePassagerDebout = new FauxPassager("colette", 37);

        autobus.demanderPlaceAssise(fakePassagerAssis);
        autobus.demanderPlaceDebout(fakePassagerDebout);

        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == false);

        autobus.demanderSortie(fakePassagerAssis);

        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == false);

        autobus.demanderSortie(fakePassagerDebout);

        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == true);

        nbTests++;
    }

    /**
     * Makes sure allerArretSuivant() is working properly.
     */
    public void testAllerArretSuivant() throws TecInvalidException
    {
        autobus = new Autobus(0, 10);

        FauxPassager tableauFakePassager[] = new FauxPassager[10];

        for(int i = 0; i < 10; i++)
        {
            tableauFakePassager[i] = new FauxPassager("Dupont", 51);
            autobus.demanderPlaceDebout(tableauFakePassager[i]);
        }

        autobus.allerArretSuivant();

        for(int i = 0; i < 10; i++)
            assert(tableauFakePassager[i].messages.getLast() == "nouvelArret");

        nbTests++;
    }

    /**
     * Makes sure demanderChangerEnDebout() and demanderChangerEnAssis() are working properly.
     */
    public void testDemanderChangerEtat() throws TecInvalidException
    {
        autobus = new Autobus(1, 1);
        FauxPassager fakePassager = new FauxPassager("gérard", 13);

        autobus.demanderPlaceDebout(fakePassager);

        autobus.demanderChangerEnAssis(fakePassager);
        assert(autobus.aPlaceAssise() == false);
        assert(autobus.aPlaceDebout() == true);
        assert(fakePassager.messages.getLast() == "accepterPlaceAssise");

        autobus.demanderChangerEnDebout(fakePassager);
        assert(autobus.aPlaceAssise() == true);
        assert(autobus.aPlaceDebout() == false);
        assert(fakePassager.messages.getLast() == "accepterPlaceDebout");

        nbTests++;
    }
}
