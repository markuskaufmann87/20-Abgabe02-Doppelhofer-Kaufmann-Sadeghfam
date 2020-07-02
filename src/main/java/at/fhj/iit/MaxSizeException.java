package at.fhj.iit;

/**
 * MaxSizeException informs the user when the maximum size of the Queue
 * is reached. Thrown with special Error message!
 * @author Markus Kaufmann
 * @version %I%, %G%
 */
public class MaxSizeException extends Exception{

    MaxSizeException(){
        super("No adding possible! Maximum Size reached!");
    }
}
