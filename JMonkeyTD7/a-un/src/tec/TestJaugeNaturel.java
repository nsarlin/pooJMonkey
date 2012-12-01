package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
class TestJaugeNaturel
{
    long depart;
    long vigieMin;
    long vigieMax;
    JaugeNaturel jauge;

    TestJaugeNaturel()
    {
        this.depart = 100;
        this.vigieMin = -345;
        this.vigieMax = 67899;
        this.jauge = new JaugeNaturel(vigieMin, vigieMax, depart);
    }

    void lancer()
    {
        int nbTest = 0;
        System.out.print("Test de JaugeNaturel:\n");

        testDansIntervalle();
        System.out.println(".");
        nbTest++;
        testDeplacement();
        System.out.println(".");
        nbTest++;

        // De la meme maniere, appel aux autres methodes de test.

        System.out.println("OK : " + nbTest);
        System.out.println();
    }

    public void jeVeuxVrai(boolean expr, String m)
    {
        assert expr : "\nECHEC jeVeuxVrai <" + m + ">";
    }

    public void jeVeuxFaux(boolean expr, String m)
    {
        assert !expr : "\nECHEC jeVeuxFaux <" + m + ">";
    }

    public void testDansIntervalle()
    {
        jeVeuxFaux(this.jauge.estBleu(), "La jauge est bleue");
        jeVeuxVrai(this.jauge.estVert(), "La jauge n'est pas verte");
        jeVeuxFaux(this.jauge.estRouge(), "La jauge est rouge");
    }

    public void testDeplacement()
    {
        // on decremente la jauge jusqu'à vigieMin +1
        for(int i = 0; i < this.depart - this.vigieMin - 1 ; i++)
            this.jauge.decrementer();

        jeVeuxFaux(this.jauge.estBleu(), "La jauge est bleue");
        jeVeuxVrai(this.jauge.estVert(), "La jauge n'est pas verte");
        jeVeuxFaux(this.jauge.estRouge(), "La jauge est rouge");

        // on sort de l'intervalle
        this.jauge.decrementer();
        jeVeuxVrai(this.jauge.estBleu(), "La jauge n'est pas bleue");
        jeVeuxFaux(this.jauge.estVert(), "La jauge est verte");
        jeVeuxFaux(this.jauge.estRouge(), "La jauge est rouge");

        // on incremente jusqu'à vigieMax -1
        for(int i = 0; i < this.vigieMax - this.vigieMin - 1; i++)
            this.jauge.incrementer();

        jeVeuxFaux(this.jauge.estBleu(), "La jauge est bleue");
        jeVeuxVrai(this.jauge.estVert(), "La jauge n'est pas verte");
        jeVeuxFaux(this.jauge.estRouge(), "La jauge est rouge");

        this.jauge.incrementer();
        jeVeuxFaux(this.jauge.estBleu(), "La jauge est bleue");
        jeVeuxFaux(this.jauge.estVert(), "La jauge est verte");
        jeVeuxVrai(this.jauge.estRouge(), "La jauge n'est pas rouge");
    }
}
