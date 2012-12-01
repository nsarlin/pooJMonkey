/**
 * Here is the main package for our project.
 */
package tec;

/**
 * Test class for our PassagerStresse class.
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
abstract class TestPassagerAbstrait
{
    protected PassagerAbstrait passagerAbstrait;
    protected int nbTests = 0;

    
    abstract protected PassagerAbstrait creerPassager(String nom, int destination);
    
    
    protected void jeVeuxVrai(boolean expr, String m)
    {
        assert expr : "\nECHEC jeVeuxVrai <" + m + ">";
    }

    
    protected void jeVeuxFaux(boolean expr, String m)
    {
        assert !expr : "\nECHEC jeVeuxFaux <" + m + ">";
    }
    
    
    void lancer() throws TecInvalidException
    {
        nbTests = 0;

        System.out.println(getClass().getName() + " :");

        System.out.println('.');
        testFaussaire();
        
        System.out.println('.');
        testConstructeur();

        System.out.println(".");
        testAccepterSortie();

        System.out.println(".");
        testAccepterPlaceAssise();

        System.out.println(".");
        testAccepterPlaceDebout();
        
        System.out.println(".");
        testNouvelArret();

        System.out.println(".");
	testMonterDans();
    }

    void testFaussaire()
    {
        FauxBus f = new FauxBus(0, 0);
        f.status = FauxBus.ASSIS;

        assert 0 == f.messages.size();

        f.demanderChangerEnDebout(null);

        assert "demanderChangerEnDebout" == f.messages.getLast();

        nbTests++;
    }
    
    public void testConstructeur()
    {
        passagerAbstrait = creerPassager("toto", 5);
        jeVeuxVrai(passagerAbstrait.estDehors(), "Le passager n'est pas dehors");
        jeVeuxVrai(passagerAbstrait.nom() == "toto", "Le passager ne s'appelle pas toto");

        nbTests++;
    }

    public void testAccepterSortie()
    {
        passagerAbstrait = creerPassager("Nom", 10);
        passagerAbstrait.accepterSortie();

        jeVeuxVrai(passagerAbstrait.estDehors(), "Echec : AccepterSortie()");

        nbTests++;
    }
    
    public void testAccepterPlaceAssise()
    {
        passagerAbstrait = creerPassager("Nom", 10);
        passagerAbstrait.accepterPlaceAssise();

        jeVeuxVrai(passagerAbstrait.estAssis(), "Echec : AccepterPlaceAssise()");

        nbTests++;
    }

    public void testAccepterPlaceDebout()
    {
        passagerAbstrait = creerPassager("Nom", 10);
        passagerAbstrait.accepterPlaceDebout();

        jeVeuxVrai(passagerAbstrait.estDebout(), "Echec : AccepterPlaceDebout");

        nbTests++;
    }

    public void testNouvelArret() throws TecInvalidException
    {
        passagerAbstrait = creerPassager("Nom", 10);
        FauxBus faux = new FauxBus(10, 10);
        
        passagerAbstrait.monterDans(faux);
        jeVeuxFaux(passagerAbstrait.estDehors(), "Le passager n'est pas monte dans le bus");

        for(int i = 0 ; i < 10 ; i++)
            faux.allerArretSuivant();

        jeVeuxVrai(passagerAbstrait.estDehors(), "Le passager n'est pas descendu du bus");

        nbTests++;
    }

    public void testMonterDans() throws TecInvalidException
    {
	Transport t = new Transport() {
	        public boolean aPlaceAssise(){return false;}
		public boolean aPlaceDebout(){return false;}

		public void allerArretSuivant() throws TecInvalidException {}
	};

	passagerAbstrait = creerPassager("Nom", 10);

	boolean ex = false;

	try {
	    passagerAbstrait.monterDans(t);
	}
	catch (TecInvalidException e) {
	    ex = true;
	}

	jeVeuxVrai(ex,"TecInvalidException non levée alors qu'elle aurait dû l'être");
	
	t = new Autobus(10,10);
	ex = false;
	try {
	    passagerAbstrait.monterDans(t);
	}
	catch (TecInvalidException e) {
	    ex = true;
	}
	jeVeuxFaux(ex, "TecInvalidException levée alors qu'elle n'aurait pas dû l'être");

	nbTests++;
    }
}
