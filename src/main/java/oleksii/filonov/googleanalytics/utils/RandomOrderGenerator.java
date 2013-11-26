package oleksii.filonov.googleanalytics.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomOrderGenerator implements OrderGenerator {

	private static final int MAX_ORDER_NUM = 999999999;

	private static Random random = new Random(123);

	@Override
	public String generateOrderNumber() {
		final long randomNumber = random.nextInt(MAX_ORDER_NUM);
		return String.format("%09d", randomNumber);
	}

	public static void main(final String[] args) {
		final RandomOrderGenerator randomOrderGenerator = new RandomOrderGenerator();
		for (int i = 0; i < 10; i++) {
			System.out.println(randomOrderGenerator.generateOrderNumber());
		}
	}

}
