package com.arabadzhiev.lambda;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RandomSubset {
	
	public static <T> List<T> getRandomSubset(List<T> list	) {
		Random random = new Random();
		
		Predicate<Object> flipCoin = o -> {
			return random.nextBoolean();
		};
		
		List<T> subset = list.stream().filter(flipCoin).collect(Collectors.toList());
		return subset;
		
	}
}
