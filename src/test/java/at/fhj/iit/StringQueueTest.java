package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

/**
 * This class tests the StringQueue class
 *
 * @author Mehrad Sadeghfam
 * @author Lukas Doppelhofer
 * @version %I%, %G%
 */
public class StringQueueTest {

    private StringQueue queue;
    private StringQueue queue1;

    /**
     * inits 2 instances of {@link StringQueue}
     */
    @BeforeEach
    void setup() {
        queue = new StringQueue(2);
        queue1 = new StringQueue();
    }

    /**
     * reset the two instances of {@link StringQueue} after each test
     */
    @AfterEach
    public void tearDown() {
        queue = null;
        queue1 = null;
    }

    /**
     * testing the constructor of {@link StringQueue} with maxSize = 2
     *
     * @result equals 2 because maxSize is 2
     */
    @Test
    @DisplayName("Testing constructor StringsQueue")
    public void testConstructorStringsQueue() {
        assertEquals(2, queue.getMaxSize());
    }

    /**
     * testing the default constructor of {@link StringQueue}
     *
     * @result default value of maxSize should be 5
     */
    @Test
    @DisplayName("Testing default constructor StringsQueue")
    public void testDefaultConstructorStringsQueue() {
        assertEquals(5, queue1.getMaxSize());
    }

    /**
     * testing {@link StringQueue#offer(String)} method
     * checks if return boolean is false if maxSize of queue is reached
     *
     * @result is false because maxSize is reached
     */
    @Test
    @DisplayName("Testing offer method")
    public void testOffer() {
        queue.offer("Text");
        queue.offer("Text1");
        assertFalse(queue.offer("Text2"));

    }

    /**
     * testing {@link StringQueue#peek()} method
     * checks if method return the head element of queue
     *
     * @result {@link StringQueueTest#queue} "Text" expected because head element is "Text"
     * @result {@link StringQueueTest#queue1} "Null" expected because head element is "Null"
     */
    @Test
    @DisplayName("Testing peek method")
    public void testPeek() {

        assertEquals(null, queue1.peek());
        queue.offer("Text");
        assertEquals("Text", queue.peek());
    }

    /**
     * testing {@link StringQueue#element()} method
     * checks if method throws exception if the queue is empty
     * checks if method returns head element
     *
     * @throws NoSuchElementException thrown because {@link StringQueueTest#queue1} is empty
     * @result {@link StringQueueTest#queue} "Text" expected because head element is "Text"
     */
    @Test
    @DisplayName("Testing element method")
    public void testElement() {

        assertThrows(NoSuchElementException.class, () -> {
            queue1.element();
        }, "Queue is empty");
        queue.offer("Text");
        assertEquals("Text", queue.element());

    }

    /**
     * testing {@link StringQueue#poll()} and {@link StringQueue#remove()} method
     * checks if method throws exception if the queue is empty
     * checks if method return the head element and remove it
     *
     * @throws NoSuchElementException thrown because {@link StringQueueTest#queue1} is empty
     * @result {@link StringQueueTest#queue} "Text" expected because head element is "Text"
     * @result {@link StringQueueTest#queue} "1" expected because queueSize should be 1 after removing 1 of 2 elements
     */
    @Test
    @DisplayName("Testing remove method")
    public void testPollAndRemove() {

        assertThrows(NoSuchElementException.class, () -> {
            queue1.remove();
        }, "Queue is empty");
        queue.offer("Text");
        queue.offer("Text1");
        assertEquals("Text", queue.remove());

        assertEquals(queue.getElements().size(), 1);

    }
}