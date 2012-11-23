/**
 * Here is the main package for our project.
 */
package tec;

import java.lang.Class;
import java.lang.reflect.*;

/**
 * This class launches a series of tests
 * in order to make sure everything works
 * properly.
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class LancerTests
{
    public static void main(String... args)
    {
        boolean estMisAssertion = false;
        assert(estMisAssertion = true);

        if(!estMisAssertion)
        {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        try
        {
            // Tests JaugeNaturel
            lancer(TestJaugeNaturel.class);

            // Tests Autobus
            (new TestAutobus()).lancer();
            
            // Tests EtatPassager
            lancer(TestEtatPassager.class);
            
            // Tests PassagerStandard
            (new TestPassagerStandard()).lancer();

            // Tests PassagerStresse
            (new TestPassagerStresse()).lancer();
            // Tests PassagerLunatique
            (new TestPassagerLunatique()).lancer();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @SuppressWarnings("non-varargs")
    static private void lancer(Class c) throws Exception
    {
        int nbTests = 0;
        System.out.println(c.getName() + " : ");
    
        // On cree une instance de la classe c
        Object instance = c.newInstance();

        // On recupere les methodes de de la classe c
        Method[] methods = c.getMethods();

        for(int i = 0 ; i < methods.length ; i++)
        {
            // Si le nom de la methode commence par "test"
            if(methods[i].getName().indexOf("test") == 0)
            {
                // On lance la methode
                
                methods[i].invoke(instance, null);
                
                System.out.println(".");
                nbTests++;
            }
        }
        
        System.out.println("OK : " + nbTests);
        System.out.println();
    }
}
