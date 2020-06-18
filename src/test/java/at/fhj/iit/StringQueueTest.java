package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

/**
 * This class tests the StringQueue class
 */

@DisplayName("Testing String Queue implementation")
class StringQueueTest {

    private StringQueue queue;
    private StringQueue queue1;

    /**
     * inits the queue
     */
    @BeforeEach
    void setup(){
        queue = new StringQueue(2);
        queue.offer("Text");
        queue.offer("Text1");
        queue1 = new StringQueue();
    }

    @Test
    @DisplayName("Testing constructor StringsQueue")
    public void testConstructorStringsQueue(){
       assertEquals(2,queue.getMaxSize());
    }
    @Test
    @DisplayName("Testing default constructor StringsQueue")
    public void testDefaultConstructorStringsQueue(){
        assertEquals(5,queue1.getMaxSize());
    }

    @Test
    @DisplayName("Testing offer method")
    public void testOffer(){
        // assertTrue(queue.offer("Text"));
        assertFalse(queue.offer("Text2"));

    }

    @Test
    @DisplayName("Testing peek method")
    public void testPeek(){

        assertEquals(null,queue1.peek());

        assertEquals("Text",queue.peek());
    }

    @Test
    @DisplayName("Testing element method")
    public void testElement(){

        assertThrows(NoSuchElementException.class, ()->{queue1.element();}, "Queue is empty");

        assertEquals("Text",queue.element());

    }

    @Test
    @DisplayName("Testing remove method")
    public void testPollAndRemove(){

        assertThrows(NoSuchElementException.class, ()->{queue1.remove();}, "Queue is empty");

        assertEquals("Text",queue.remove());

        assertEquals(queue.getElements().size(),1);

    }
}