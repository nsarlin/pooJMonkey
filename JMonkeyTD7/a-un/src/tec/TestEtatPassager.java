/**
 * Here is the main package for our project.
 */
package tec;

/**
 * Test class for our EtatPassager class.
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
class TestEtatPassager
{
    // Fields
    private EtatPassager etatPassager;
    private int nbTests;

    /**
     * Constructor
     */
    public TestEtatPassager() {}
    
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
    private void lancer()
    {
        // Sets our nbTests variable to zero.
        nbTests = 0;

        System.out.println("EtatPassager:");

        System.out.println(".");
        testAssis();

        System.out.println(".");
        testDebout();

        System.out.println(".");
        testExterieur();

        System.out.println(".");
        testInterieur();

        System.out.println("OK:" + nbTests);
    }

    /**
     * Makes sure testAssis() is working properly.
     */
    public void testAssis()
    {
        etatPassager = EtatPassager.ASSIS;

        jeVeuxFaux(etatPassager.estExterieur(), "estExterieur() devrait retourner faux");
        jeVeuxVrai(etatPassager.estAssis(), "estAssis() devrait retourner vrai");
        jeVeuxFaux(etatPassager.estDebout(), "estDebout() devrait retourner faux");

        nbTests++;
    }

    /**
     * Makes sure testDebout() is working properly.
     */
    public void testDebout()
    {
        etatPassager = EtatPassager.DEBOUT;

        jeVeuxFaux(etatPassager.estExterieur(), "estExterieur() devrait retourner faux");
        jeVeuxFaux(etatPassager.estAssis(), "estAssis() devrait retourner faux");
        jeVeuxVrai(etatPassager.estDebout(), "estDebout() devrait retourner vrai");

        nbTests++;
    }

    /**
     * Makes sure testExterieur() is working properly
     */
    public void testExterieur()
    {
        etatPassager = EtatPassager.DEHORS;

        jeVeuxVrai(etatPassager.estExterieur(), "estExterieur() devrait retourner vrai");
        jeVeuxFaux(etatPassager.estAssis(), "estAssis() devrait retourner faux");
        jeVeuxFaux(etatPassager.estDebout(), "estDebout() devrait retourner faux");

        nbTests++;
    }

    /**
     * Makes sure testInterieur() is working properly.
     */
    public void testInterieur()
    {
        etatPassager = EtatPassager.ASSIS;
        jeVeuxVrai(etatPassager.estInterieur(), "estInterieur() devrait retourner vrai");

        etatPassager = EtatPassager.DEBOUT;
        jeVeuxVrai(etatPassager.estInterieur(), "estInterieur() devrait retourner vrai");

        etatPassager = EtatPassager.DEHORS;
        jeVeuxFaux(etatPassager.estInterieur(), "estInterieur() devrait retourner faux");

        nbTests++;
    }
}
