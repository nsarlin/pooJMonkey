package tec;

/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public interface Usager
{
    String nom();
    void monterDans(Transport b) throws TecInvalidException;
}
