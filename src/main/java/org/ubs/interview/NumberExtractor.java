package org.ubs.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class NumberExtractor {
	
	private static final String TOKEN_STRING = ";*%|\n//,+";


	public int add(String numbers) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> invalidNumberlist = new ArrayList<Integer>();
		StringTokenizer stringTokenizer = new StringTokenizer(numbers, TOKEN_STRING);
		while (stringTokenizer.hasMoreElements()) {
			String tempStringValue = stringTokenizer.nextElement().toString();
			tempStringValue = tempStringValue.replace("\n", "");
			int tempNumber = 0;
			if (StringUtils.isEmpty(tempStringValue)) {
				tempNumber = 0;
			} else {
				tempNumber = Integer.parseInt(tempStringValue);
				if (tempNumber < 0) {
					invalidNumberlist.add(tempNumber);
				}
			}

			list.add(tempNumber > 1000 ? 0 : tempNumber);
		}

		if (invalidNumberlist.size() > 0) {
			String negativeNumber = invalidNumberlist.stream().map(Object::toString).collect(Collectors.joining(","));
			try {
				throw new StringAccumalatorException("Negatives not allowed " + negativeNumber);
			} catch (StringAccumalatorException e) {
				e.printStackTrace();
			}
		}
		return list.stream().mapToInt(Integer::intValue).sum();

	}

}
