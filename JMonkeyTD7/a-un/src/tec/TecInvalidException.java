/**
 * Here is the main package for our project.
 */
package tec;


/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class TecInvalidException extends Exception {
/*
    TecInvalidException(IllegalStateException ise) {
	super(ise.getMessage());
    }
*/
    private static final long serialVersionUID = 42L;

    TecInvalidException (String message) {
	super(message);
    }

    TecInvalidException (Throwable e) {
	super(e);
    }

}
