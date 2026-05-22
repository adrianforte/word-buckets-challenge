package com.forte.challenge.wordbuckets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Write a function that divides a phrase into word buckets with each bucket containing N or fewer characters.
 * - Each bucket must include full words.
 * - Spaces count as one character.
 * - Trim beginning and end spaces for each word bucket (see bucketize4 test).
 * - If buckets are too small to hold a single word, throw a runtime exception (see bucketize5 test).
 */
class WordBucketsChallengeTest {

    private final WordBucketsChallenge challenge = new WordBucketsChallenge();

    @Test
    void bucketize1() {
        String input = "she sells sea shells by the sea";
        List<String> result = challenge.bucketize(input, 10);
        assertEquals(List.of("she sells", "sea shells", "by the sea"), result);
    }

    @Test
    void bucketize2() {
        String input = "the mouse jumped over the cheese";
        List<String> result = challenge.bucketize(input, 7);
        assertEquals(List.of("the", "mouse", "jumped", "over", "the", "cheese"), result);
    }

    @Test
    void bucketize3() {
        String input = "fairy dust coated the air";
        List<String> result = challenge.bucketize(input, 20);
        assertEquals(List.of("fairy dust coated", "the air"), result);
    }

    @Test
    void bucketize4() {
        String input = "a b c d e";
        List<String> result = challenge.bucketize(input, 2);
        assertEquals(List.of("a", "b", "c", "d", "e"), result);
    }

    @Test
    void bucketize5() {
        String input = "assertThrows returns the exception";
        Exception exception = assertThrows(RuntimeException.class, () -> challenge.bucketize(input, 2));
        assertEquals("maxSize too small", exception.getMessage());
    }
}
