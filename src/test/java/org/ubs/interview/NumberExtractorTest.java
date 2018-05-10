package org.ubs.interview;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Ignore;

public class NumberExtractorTest {
	NumberExtractor numberExtractor = new NumberExtractor();

	@Test
	public void test1() {
		String testNumbers = "1,2";
		assertEquals(numberExtractor.add(testNumbers), 3);
	}

	@Test
	public void test2() {
		String testNumbers = "";
		assertEquals(numberExtractor.add(testNumbers), 0);
	}

	@Test
	public void test3() {
		String testNumbers = "1\n2,3";
		assertEquals(numberExtractor.add(testNumbers), 6);
	}

	@Test
	public void test4() {
		String testNumbers = "//;\n1;2";
		assertEquals(numberExtractor.add(testNumbers), 3);
	}

	@Test
	public void test5() {
		String testNumbers = "//***\n1***2***3";
		assertEquals(numberExtractor.add(testNumbers), 6);
	}

	@Test
	public void test6() {
		String testNumbers = "//*|%\n1*2%3";
		assertEquals(numberExtractor.add(testNumbers), 6);
	}

	@Test
	public void test7() {
		String testNumbers = "//*|%%%\n1*2%3";
		assertEquals(numberExtractor.add(testNumbers), 6);
	}

	@Test
	public void test8() {
		String testNumbers = "//*|%\n1***2%3";
		assertEquals(numberExtractor.add(testNumbers), 6);
	}

	@Test
	public void test9() {
		String testNumbers = "//*|%\n1*||2%3";
		assertEquals(numberExtractor.add(testNumbers), 6);
	}

	@Test
	public void test10() {
		String testNumbers = "//*|%\n1***2%**3";
		assertEquals(numberExtractor.add(testNumbers), 6);
	}

	@Test
	public void test11() {
		String testNumbers = "1,2,3,6";
		assertEquals(numberExtractor.add(testNumbers), 12);
	}

	@Test
	public void test12() {
		String testNumbers = "1,2,3+6";
		assertEquals(numberExtractor.add(testNumbers), 12);
	}

	@Test
	public void test13() {
		String testNumbers = "1,2,3%6";
		assertEquals(numberExtractor.add(testNumbers), 12);
	}
    @Ignore
	@Test(expected = StringAccumalatorException.class)
	public void test14() {
		String testNumbers = "1,2,-3%6";
		numberExtractor.add(testNumbers);
	}
    
    @Ignore
	@Test(expected = StringAccumalatorException.class)
	public void test15() {
		String testNumbers = "1,2,-3%-6";
		numberExtractor.add(testNumbers);
	}

}
