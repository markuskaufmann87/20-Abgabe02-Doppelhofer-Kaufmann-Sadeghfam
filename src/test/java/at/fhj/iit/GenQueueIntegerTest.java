package at.fhj.iit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class tests the GenQueue - generic version of Queue
 * with an Integer data type.
 * @author Markus Kaufmann
 * @author Lukas Doppelhofer
 * @version %I%, %G%
 */
public class GenQueueIntegerTest {

    GenQueue<Integer> queue;
    GenQueue<Integer> queue1;

    /**
     * inits 2 instances of {@link GenQueue} with type Integer
     */
    @BeforeEach
    void setup() throws MaxSizeException {
        queue = new GenQueue<Integer>(2);
        queue1 = new GenQueue<Integer>();
    }

    /**
     * resets the two instances of {@link GenQueue} after each test
     */
    @AfterEach
    void tearDown(){
        queue = null;
        queue1 = null;
    }

    /**
     * testing the constructor of {@link GenQueue} with maxSize = 2
     * @result equals 2 because maxSize is 2
     */
    @Test
    @DisplayName("Testing constructor GenQueue")
    public void testConstructorGenQueue(){

        assertEquals(2,queue.getMaxSize());
    }

    /**
     * testing the default constructor of {@link GenQueue}
     * @result default value of maxSize should be 5
     */
    @Test
    @DisplayName("Testing default constructor GenQueue")
    public void testDefaultConstructorGenQueue(){
        assertEquals(5,queue1.getMaxSize());
    }

    /**
     * testing {@link GenQueue#enqueue(Object)}
     * checks if return boolean is false if maxSize of queue is reached
     * @result {@link MaxSizeException} thrown if maxSize of queue is reached!
     * @result is 3 because head Element is 3 (FiFo)
     */
    @Test
    @DisplayName("Testing enqueue method")
    public void testEnqueue() throws MaxSizeException {
        queue.enqueue(3);
        queue.enqueue(10);
        assertThrows(MaxSizeException.class, ()->{queue.enqueue(6);}, "Queue's max size reached");
        assertEquals(3,queue.getHeadElement());
    }

    /**
     * testing {@link GenQueue#getHeadElement()}
     * @result {@link NoSuchElementException} if queue is empty
     * @result 3 because 3 is head element of queue
     */
    @Test
    @DisplayName(("Testing getHeadElement()"))
    public void testGetHeadElement() throws MaxSizeException{
        assertThrows(NoSuchElementException.class, ()->{queue1.getHeadElement();}, "Queue is empty");
        queue.enqueue(3);
        assertEquals(3, queue.getHeadElement());
    }

    /**
     * testing {@link GenQueue#dequeue()}  method
     * checks if method throws exception if the queue is empty
     * checks if method return the head element and remove it
     * @result {@link NoSuchElementException} thrown because {@link GenQueueIntegerTest#queue1} is empty
     * @result {@link GenQueueIntegerTest#queue} "3" expected because head element is "3"
     * @result {@link GenQueueIntegerTest#queue} "1" expected because queueSize should be "1" after removing 1 of 2 elements
     */
    @Test
    @DisplayName("Testing dequeue method")
    public void testDequeue() throws MaxSizeException{
        assertThrows(NoSuchElementException.class, ()->{queue1.dequeue();}, "Queue is empty");
        queue.enqueue(3);
        queue.enqueue(10);
        assertEquals(3,queue.dequeue());

        assertEquals(1,queue.getQueueSize());
    }

    /**
     * testing {@link GenQueue#getElements()}
     * @result String with content "[3, 10]", because the 2 Elements are 3 and 10.
     */
    @Test
    @DisplayName("Testing getElements method")
    public void testGetElements() throws MaxSizeException{
        queue.enqueue(3);
        queue.enqueue(10);
        assertEquals("[3, 10]",queue.getElements().toString());
    }

    /**
     * testing {@link GenQueue#setMaxSize(int)}
     * @result 4 because maxSize set to 4.
     */
    @Test
    @DisplayName("Testing setMaxSize method")
    public void testSetMaxSize(){
        queue1.setMaxSize(4);
        assertEquals(4, queue1.getMaxSize());
    }

}
