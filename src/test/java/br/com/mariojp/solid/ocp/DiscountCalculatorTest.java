package br.com.mariojp.solid.ocp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import br.com.mariojp.solid.ocp.RegularPolicy;
import br.com.mariojp.solid.ocp.PremiumPolicy;
import br.com.mariojp.solid.ocp.PartnerPolicy;

public class DiscountCalculatorTest {
    
    private DiscountCalculator createCalculator(){
        Map<CustomerType, DiscountPolicy> policies = new HashMap<>();
        policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        policies.put(CustomerType.PARTNER, new PartnerPolicy());
        policies.put(CustomerType.REGULAR, new RegularPolicy());
        return new DiscountCalculator(policies);
    }

    @Test
    void partner_gets_12_percent() {
        var calc = createCalculator();
        assertEquals(88.0, calc.apply(100.0, CustomerType.PARTNER), 0.0001,
            "PARTNER deveria ter 12% de desconto");
    }
}
