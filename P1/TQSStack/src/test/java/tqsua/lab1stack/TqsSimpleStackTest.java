package tqsua.lab1stack;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TqsSimpleStackTest {

    private Logger log = Logger.getLogger("TQS Stack");
    private TqsSimpleStack<Integer> testStack;


    @BeforeEach
    void setUp() {
        log.info("======Preparing for new Test======");
        testStack = new TqsSimpleStack<>();
    }

    @DisplayName("Stack is Empty on Construction")
    @Test
    void emptyOnConstruction() {
        log.info("======Testing if Stack is Empty on Construction======");
        assertTrue(testStack.isEmpty());

        log.info("TEST PASSED");
    }

    @DisplayName("Stack has Size 0 on Construction")
    @Test
    void sizeOnConstruction() {
        log.info("======Testing if Stack is Size 0 on Construction======");
        assertEquals(0, testStack.size());

        log.info("TEST PASSED");
    }

    @DisplayName("Size after pushes")
    @Test
    void sizeAfterPush() {
        log.info("======Testing if Size is the same as the amount of elements Pushed======");

        //Push 10 elements into the stack
        for(int i = 0 ; i < 10 ; i++){
            testStack.push(i);
        }

        assertFalse(testStack.isEmpty());
        assertEquals(10, testStack.size());

        log.info("TEST PASSED");
    }


    @DisplayName("Push-Pop x")
    @Test
    void pushThenPop() {
        log.info("======Testing if Value Pushed then immediately Popped is the same======");

        //Push element to Stack
        testStack.push(420);
        assertEquals(420,testStack.pop());

        log.info("TEST PASSED");
    }

    @DisplayName("Push-Peek Check Size")
    @Test
    void valSizeAfterPushPeek() {
        log.info("======Testing if Value Pushed then immediately Popped is the same======");

        //Push element to Stack
        testStack.push(420);
        int currentSize = testStack.size();

        assertEquals(420,testStack.peek());
        assertEquals(currentSize,testStack.size());

        log.info("TEST PASSED");
    }

    @DisplayName("Pop from empty")
    @Test
    void popEmpty() {
        log.info("======Testing Exception when Popping empty stack======");

        assertThrows(NoSuchElementException.class, () -> {
            testStack.pop();
        });

        log.info("TEST PASSED");
    }

    @DisplayName("Peek from empty")
    @Test
    void peekEmpty() {
        log.info("======Testing Exception when Peeking empty stack======");

        assertThrows(NoSuchElementException.class, () -> {
            testStack.peek();
        });

        log.info("TEST PASSED");
    }

    @DisplayName("Push to full")
    @Test
    void pushFull() {
        log.info("======Testing Exception when Pushing into Full Stack======");

        //Override the stack created by the setup with one with a Limit
        testStack = new TqsSimpleStack<>(5);

        //Push 5 elements into the stack
        for(int i = 0 ; i < 5 ; i++){
            testStack.push(i);
        }

        assertThrows(IllegalStateException.class, () -> {
            testStack.push(1);
        });

        log.info("TEST PASSED");
    }

}