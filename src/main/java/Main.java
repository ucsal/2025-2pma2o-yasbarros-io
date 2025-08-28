import java.util.HashMap;
import java.util.Map;

import br.com.mariojp.solid.ocp.*;

public class Main {
	public static void main(String[] args) {
		Map<CustomerType,DiscountPolicy> policies = new HashMap<>(); //inicia 
		policies.put(CustomerType.REGULAR, new RegularPolicy());
        policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        policies.put(CustomerType.PARTNER, new PartnerPolicy());

		DiscountCalculator calc = new DiscountCalculator(policies);
		System.out.println("REGULAR 100 -> " + calc.apply(100, CustomerType.REGULAR));
		System.out.println("PREMIUM 100 -> " + calc.apply(100, CustomerType.PREMIUM));
		// PARTNER deveria ter 12%
		System.out.println("PARTNER 100 -> " + calc.apply(100, CustomerType.PARTNER));
	}
}
