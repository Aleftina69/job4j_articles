package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenAlreadySortedThenSameArrayIsReturned() {
        int[] array = {-13, 2, 3, 4, 4, 6, 8, 10};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSingleElementArrayThenSameArrayIsReturned() {
        int[] array = {42};
        assertThat(Merge.mergesort(array)).containsExactly(42);
    }

    @Test
    void whenEmptyArrayThenSameArrayIsReturned() {
        int[] array = {};
        assertThat(Merge.mergesort(array)).isEmpty();
    }

    @Test
    void whenArrayWithNegativeNumbersThenSortedArrayIsReturned() {
        int[] array = {3, -1, -4, 2, 0};
        assertThat(Merge.mergesort(array)).containsExactly(-4, -1, 0, 2, 3);
    }

    @Test
    void whenArrayWithDuplicatesThenSortedArrayIsReturned() {
        int[] array = {5, 2, 2, 8, 1, 1};
        assertThat(Merge.mergesort(array)).containsExactly(1, 1, 2, 2, 5, 8);
    }

    @Test
    void whenArrayWithAllIdenticalElementsThenSameArrayIsReturned() {
        int[] array = {7, 7, 7, 7, 7};
        assertThat(Merge.mergesort(array)).containsExactly(7, 7, 7, 7, 7);
    }
}