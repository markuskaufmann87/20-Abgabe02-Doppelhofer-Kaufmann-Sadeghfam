package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class GenQueueTest {

    GenQueue<Integer> queue;
    GenQueue<Character> queue1;

    /**
     * inits the queue
     */
    @BeforeEach
    void setup() throws MaxSizeException {
        queue = new GenQueue<>(2);
        queue.enqueue(3);
        queue.enqueue(10);
        queue1 = new GenQueue<>();
    }

    @Test
    @DisplayName("Testing constructor GenQueue")
    public void testConstructorGenQueue(){
        assertEquals(2,queue.getMaxSize());
    }

    @Test
    @DisplayName("Testing default constructor GenQueue")
    public void testDefaultConstructorGenQueue(){
        assertEquals(5,queue1.getMaxSize());
    }

    @Test
    @DisplayName("Testing enqueue method")
    public void testEnqueue(){
        assertThrows(MaxSizeException.class, ()->{queue.enqueue(6);}, "Queue's max size reached");

        assertEquals(3,queue.dequeue());
    }

    @Test
    @DisplayName("Testing dequeue method")
    public void testDequeue(){
        assertThrows(NoSuchElementException.class, ()->{queue1.dequeue();}, "Queue is empty");

        assertEquals(3,queue.dequeue());

        assertEquals(1,queue.getQueueSize());
    }

    @Test
    @DisplayName("Testing getElements method")
    public void testGetElements(){
        assertEquals("[3, 10]",queue.getElements().toString());
    }

    @Test
    @DisplayName("Testing setMaxSize method")
    public void testSetMaxSize(){
        queue1.setMaxSize(4);
        assertEquals(4, queue1.getMaxSize());
    }

}
