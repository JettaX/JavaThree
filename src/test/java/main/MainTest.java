package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findLastFourAndCopyAfter_one() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = {5, 6, 7, 8, 9, 10};
        int[] actual = Main.findLastFourAndCopyAfter(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastFourAndCopyAfter_two() {
        int[] input = {1, 4, 2, 3, 4, 5, 6};
        int[] expected = {5, 6};
        int[] actual = Main.findLastFourAndCopyAfter(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastFourAndCopyAfter_three() {
        int[] input = {1, 2, 3, 6, 5, 6};
        assertThrows(RuntimeException.class, () -> Main.findLastFourAndCopyAfter(input));
    }

    @Test
    void findLastFourAndCopyAfter_four() {
        int[] input = {};
        assertThrows(RuntimeException.class, () -> Main.findLastFourAndCopyAfter(input));
    }

    @Test
    void checkSequence_one() {
        int[] input = {1, 4, 1, 4, 1, 4};
        boolean expected = true;
        boolean actual = Main.checkSequence(input);
        assertEquals(expected, actual);
    }

    @Test
    void checkSequence_two() {
        int[] input = {1, 1, 1, 4};
        boolean expected = true;
        boolean actual = Main.checkSequence(input);
        assertEquals(expected, actual);
    }

    @Test
    void checkSequence_three() {
        int[] input = {4};
        boolean expected = false;
        boolean actual = Main.checkSequence(input);
        assertEquals(expected, actual);
    }

    @Test
    void checkSequence_four() {
        int[] input = {};
        boolean expected = false;
        boolean actual = Main.checkSequence(input);
        assertEquals(expected, actual);
    }

    @Test
    void checkSequence_five() {
        int[] input = {5, 3, 3};
        boolean expected = false;
        boolean actual = Main.checkSequence(input);
        assertEquals(expected, actual);
    }

    @Test
    void checkSequence_six() {
        int[] input = {5, 1, 3, 4};
        boolean expected = false;
        boolean actual = Main.checkSequence(input);
        assertEquals(expected, actual);
    }
}