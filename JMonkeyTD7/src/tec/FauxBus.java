package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class FauxBus implements Bus, Transport
{

    Etat status;

    static Etat ASSIS = Etat.ASSIS;
    static Etat DEHORS = Etat.DEHORS;
    static Etat DEBOUT = Etat.DEBOUT;

    Messages messages = new Messages();
    
    private int max_assis;
    private int max_debout;
    private int nb_assis;
    private int nb_debout;
    private int arret;
    private Passager[] passagers;
    

    public FauxBus(int max_assis, int max_debout)
    {
        this.max_assis = max_assis;
        this.max_debout = max_debout;
        nb_assis = 0;
        nb_debout = 0;
        arret = 0;
        passagers = new Passager[max_assis + max_debout];
    }

    @Override
    public boolean aPlaceAssise()
    {
        return nb_assis < max_assis;
    }

    @Override
    public boolean aPlaceDebout()
    {
        return nb_debout < max_debout;
    }

    @Override
    public void demanderPlaceAssise(Passager p)
    {
        if(aPlaceAssise())
        {
            p.accepterPlaceAssise();
            passagers[nb_assis + nb_debout] = p;
            nb_assis++;
        }
        
        messages.add("demanderPlaceAssise");
    }

    @Override
    public void demanderPlaceDebout(Passager p)
    {
        if(aPlaceDebout())
        {
            p.accepterPlaceDebout();
            passagers[nb_assis + nb_debout] = p;
            nb_debout++;
        }
        
        messages.add("demanderPlaceDebout");
    }

    @Override
    public void demanderSortie(Passager p)
    {
        if(p.estAssis())
            nb_assis--;
        else
            nb_debout--;
    
        p.accepterSortie();
        
        int i = 0;
        
        while(passagers[i] != p && i < nb_assis + nb_debout)
            i++;
        
        while(i < nb_assis + nb_debout)
            passagers[i] = passagers[i+1];
        
        messages.add("demanderSortie");
    }

    @Override
    public void demanderChangerEnDebout(Passager p)
    {
        if(aPlaceDebout())
        {
            p.accepterPlaceDebout();
            nb_assis--;
            nb_debout++;
        }
    
        messages.add("demanderChangerEnDebout");
    }

    @Override
    public void demanderChangerEnAssis(Passager p)
    {
        if(aPlaceAssise())
        {
            p.accepterPlaceAssise();
            nb_assis++;
            nb_debout--;
        }
    
        messages.add("demanderChangerEnAssis");
    }

    @Override
    public void allerArretSuivant() throws TecInvalidException
    {
	try {
        arret++;
    
        for(int i = 0; i < nb_assis + nb_debout ; i++)
            passagers[i].nouvelArret(this, arret);
    
        messages.add("allerArretSuivant");
	}
	catch (IllegalStateException e)
	{
	    throw new TecInvalidException(e.getMessage());
	}

    }
}
