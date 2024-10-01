package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.ListAssert.assertThatList;
import static org.assertj.core.api.MapAssert.assertThatMap;
import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckerTest {
    @Test
    void testAnagramNegative1() {
        assertFalse(AnagramChecker.isAnagram(null, "ghdjskl"));
    }

    @Test
    void testAnagramNegative2() {
        assertFalse(AnagramChecker.isAnagram("null", null));
    }

    @Test
    void testAnagramNegative3() {
        assertFalse(AnagramChecker.isAnagram(null, null));
    }

    @Test
    void testAnagramNegative4() {
        assertFalse(AnagramChecker.isAnagram(null, ""));
    }
    @Test
    void testAnagramNegative5() {
        assertFalse(AnagramChecker.isAnagram("", null));
    }
    @Test
    void testAnagramNegative6() {
        assertFalse(AnagramChecker.isAnagram("", ""));
    }
    @Test
    void testAnagramNegative7() {
        assertFalse(AnagramChecker.isAnagram("  ", "  "));
    }

    @Test
    void testAnagramNegative8() {
        assertFalse(AnagramChecker.isAnagram("  ", ""));
    }

    @Test
    void testAnagramNegative9() {
        assertFalse(AnagramChecker.isAnagram("", "               "));
    }

    @Test
    void testAnagramNegative10() {
        assertFalse(AnagramChecker.isAnagram("", "qwert"));
    }

    @Test
    void testAnagramPositive1() {
        assertTrue(AnagramChecker.isAnagram("race", "care"));
    }
    @Test
    void testAnagramPositive2() {
        assertTrue(AnagramChecker.isAnagram("race ", " care"));
    }
    @Test
    void testAnagramPositive3() {
        String str1 = "xyz";
        String str2 = "xyz";
        assertTrue(AnagramChecker.isAnagram(str2, str1));
    }

    @Test
    void testAnagramPositive4() {
        assertTrue(AnagramChecker.isAnagram("xyz","xyz"));
    }
    @Test
    void testAnagramPositive5() {
        assertTrue(AnagramChecker.isAnagram("xyz","zyx"));
    }

    @Test
    void testAnagramPositive6() {
        assertTrue(AnagramChecker.isAnagram("xyz","yzx"));
    }
    @Test
    void testAnagramPositive7() {
        AnagramChecker.clearAnagramsMap();
        AnagramChecker.isAnagram("xyz","xyz");
        AnagramChecker.isAnagram("xyz","zyx");
        AnagramChecker.isAnagram("xyz","yzx");
        AnagramChecker.isAnagram("xyz","zyx");
        AnagramChecker.isAnagram("vyx","yzx");
        AnagramChecker.isAnagram(null,"zyx");
        AnagramChecker.isAnagram("xyz"," ");
        AnagramChecker.isAnagram("xyz",null);
        AnagramChecker.isAnagram("caba","baac");
        AnagramChecker.isAnagram("baac","caba");
        AnagramChecker.isAnagram("caba","baca");
        AnagramChecker.isAnagram("baac","baca");
        AnagramChecker.isAnagram("caba","baaac");
        AnagramChecker.isAnagram("baac","acaba");
        assertThatMap(AnagramChecker.getProcessedAnagrams()).hasSize(3);
        assertThatList(AnagramChecker.anagramsOf("xyz")).containsExactly("xyz","yzx","zyx");
        assertThatList(AnagramChecker.anagramsOf("caba")).containsExactly("baac","baca");
        assertThatList(AnagramChecker.anagramsOf("baac")).containsExactly("caba", "baca");
    }
}