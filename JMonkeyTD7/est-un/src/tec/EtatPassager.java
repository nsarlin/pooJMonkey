/**
 * Here is the main package for our project.
 */
package tec;

/**
 * This class represents the state of a passenger inside
 * a bus.
 * There is a state outside the transport (dehors) and
 * two states inside (assis, debout).
 *
 * The instances of this class are constant objects
 *
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
class EtatPassager
{
    static final EtatPassager DEBOUT = new EtatPassager(Etat.DEBOUT);
    static final EtatPassager ASSIS = new EtatPassager(Etat.ASSIS);
    static final EtatPassager DEHORS = new EtatPassager(Etat.DEHORS);

    private final Etat monEtat;
    /**
     * Constructs an instance providing the state
     * of the passenger.
     *
     * @param e is the default state of the passenger.
     */
    private EtatPassager(Etat e)
    {
        monEtat = e;

        /**
         * A class constructor make it possible to
         * instanciate the created object.
         *
         * Its name is always the class name, and
         * it does not have a return type.
         */
    }

    /**
     * Is the passenger outside the transport?
     *
     * @return true if instanciated with Etat.DEHORS,
     * false otherwise.
     */
    public boolean estExterieur()
    {
        return (monEtat == Etat.DEHORS);
    }

    /**
     * Is the passenger sitting inside the transport?
     *
     * @return true if instanciated with Etat.ASSIS,
     * false otherwise.
     */
    public boolean estAssis()
    {
        return (monEtat == Etat.ASSIS);
    }

    /**
     * Is the passenger standing inside the transport?
     *
     * @return true if instanciated with Etat.DEBOUT,
     * false otherwise.
     */
    public boolean estDebout()
    {
        return (monEtat == Etat.DEBOUT);
    }

    /**
     * Is the passenger inside the transport?
     *
     * @return true if instanciated with any value other
     * than Etat.DEHORS, false otherwise.
     */
    public boolean estInterieur()
    {
        return (monEtat != Etat.DEHORS);
    }

    /**
     * This method is inherited from the class
     * {@link java.lang.Object}
     *
     * Very useful while debugging, it provides a
     * string describing the state of the object.
     *
     * A default code is provided inside
     * {@link java.lang.Object}.
     * It is paramount to adapt (i.e. redefine) its code
     * for each class.
     *
     * When dealing with strings, the "+" operator means
     * "concatenate".
     *
     * @return a string describing the state of the object.
     */
    @Override
    public String toString()
    {
        return (("" + monEtat).toLowerCase());
    }
}
