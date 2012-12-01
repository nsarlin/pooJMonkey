/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tec;

/**
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
class Test
{
    protected void jeVeuxVrai(boolean expr, String m)
    {
        assert expr : "\nECHEC jeVeuxVrai <" + m + ">";
    }

    protected void jeVeuxFaux(boolean expr, String m)
    {
        assert !expr : "\nECHEC jeVeuxFaux <" + m + ">";
    }
}
