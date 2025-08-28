package br.com.mariojp.solid.ocp;

import java.util.Map;

public class DiscountCalculator {
    private Map<CustomerType, DiscountPolicy> policies;
  
      public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = policies;
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.get(type); //pega dentro do mapa a política correspondente ao tipo de cliente
        if (policy == null) {
            return amount; //padrão default
        }
        return policy.apply(amount);
    
    }

    
}
