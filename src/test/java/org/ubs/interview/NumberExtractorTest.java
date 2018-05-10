package org.ubs.interview;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberExtractorTest {
	NumberExtractor numberExtractor = new NumberExtractor();

	@Test
	public void test1() {
		String expectedName = "1,2";
		assertEquals(numberExtractor.add(expectedName), 3);
	}

	@Test
	public void test2() {
		String expectedName = "";
		assertEquals(numberExtractor.add(expectedName), 0);
	}

	@Test
	public void test3() {
		String expectedName = "1\n2,3";
		assertEquals(numberExtractor.add(expectedName), 6);
	}

	@Test
	public void test4() {
		String expectedName = "//;\n1;2";
		assertEquals(numberExtractor.add(expectedName), 3);
	}

	@Test
	public void test5() {
		String expectedName = "//***\n1***2***3";
		assertEquals(numberExtractor.add(expectedName), 6);
	}

	@Test
	public void test6() {
		String expectedName = "//*|%\n1*2%3";
		assertEquals(numberExtractor.add(expectedName), 6);
	}

	@Test
	public void test7() {
		String expectedName = "//*|%%%\n1*2%3";
		assertEquals(numberExtractor.add(expectedName), 6);
	}

	@Test
	public void test8() {
		String expectedName = "//*|%\n1***2%3";
		assertEquals(numberExtractor.add(expectedName), 6);
	}

	@Test
	public void test9() {
		String expectedName = "//*|%\n1*||2%3";
		assertEquals(numberExtractor.add(expectedName), 6);
	}

	@Test
	public void test10() {
		String expectedName = "//*|%\n1***2%**3";
		assertEquals(numberExtractor.add(expectedName), 6);
	}

	@Test
	public void test11() {
		String expectedName = "1,2,3,6";
		assertEquals(numberExtractor.add(expectedName), 12);
	}

	@Test
	public void test12() {
		String expectedName = "1,2,3+6";
		assertEquals(numberExtractor.add(expectedName), 12);
	}

	@Test
	public void test13() {
		String expectedName = "1,2,3%6";
		assertEquals(numberExtractor.add(expectedName), 12);
	}

	@Test(expected = StringAccumalatorException.class)
	public void test14() {
		String expectedName = "1,2,-3%6";
		assertEquals(numberExtractor.add(expectedName), 3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test15() {
		String expectedName = "1,2,-3%-6";
		assertEquals(numberExtractor.add(expectedName), 3);
	}

}
