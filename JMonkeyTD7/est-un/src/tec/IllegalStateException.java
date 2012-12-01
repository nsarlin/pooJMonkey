/**
 * Here is the main package for our project.
 */
package tec;


/*
 * @author aduforat, anadif, nsarlin, slaxalde, xmalicieux
 */
public class IllegalStateException extends Exception {

    IllegalStateException(String message) {
	super(message);
    }

    IllegalStateException(Throwable e) {
	super(e);
    }

}
