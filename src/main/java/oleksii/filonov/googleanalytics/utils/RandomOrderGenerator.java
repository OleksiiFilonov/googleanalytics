package oleksii.filonov.googleanalytics.utils;

import java.util.Random;

public class RandomOrderGenerator implements OrderGenerator {
	
	private static final long MAX_ORDER_NUM = 999999999;
	
	private static Random random = new Random(MAX_ORDER_NUM); 

	@Override
	public String generateOrderNumber() {
		long randomNumber = random.nextLong();
		return String.format("%09d", randomNumber);
	}
	
}
