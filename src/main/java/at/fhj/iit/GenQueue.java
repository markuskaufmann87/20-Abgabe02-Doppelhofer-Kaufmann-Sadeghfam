package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class represents a Queue with Elements of a Generic data type.
 * @author  Markus Kaufmann
 * @version %I%, %G%
 * @param   <T> Describes Generic Type Parameter
 */
public class GenQueue<T> {

    /**
     * List of the Queue elements of the generic data type
     */
    private List<T> elements = new ArrayList<T>();

    /**
     * Maximum Size of Elements which can be stored in this Queue!
     */
    private int maxSize;

    /**
     * Default Constructor of GenQueue.
     * Setting maxSize to default value of 5.
     * Can be changed via setter setMaxSize:
     * @see #setMaxSize(int)
     */
    public GenQueue() {
        this.maxSize = 5;
    }

    /**
     * Constructor with parameter who sets maxSize value.
     * @param maxSize Maximum Size of Elements which can be stored in this Queue!
     * @see #maxSize
     */
    public GenQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Adds the element t to the queue.
     * @param t object of this data type
     * @throws MaxSizeException if the maximum size of Queue is reached!
     */
    public void enqueue(T t) throws MaxSizeException {
        if (elements.size() != maxSize) {
            elements.add(t);
        } else throw new MaxSizeException();

    }

    /**
     * returns the first element of the Queue and deletes it.
     * @return  object of generic data type, first element of Queue.
     */
    public T dequeue() {
        if (elements.size() > 0) {
            T t = elements.get(0);
            elements.remove(0);
            return t;
        } else throw new NoSuchElementException("there's no element any more");
    }

    /**
     * returns the amount of the actual size of the Queue.
     * @return  Amount of actual Queue size.
     */
    public int getQueueSize(){
        return elements.size();
    }

    /**
     * returns the List of Queue Elements stored in this Queue
     * @return List of Queue Elements of this data type.
     */
    public List<T> getElements() {
        return elements;
    }

    /**
     * returns the maximum size value that can be stored in this Queue.
     * @return  maxSize value of Elements that can be stored in this Queue.
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * updates the maximum Size of Elements that can be stored in this Queue
     * @param maxSize Nr of elements that can be stored in this Queue.
     */
    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }


}
