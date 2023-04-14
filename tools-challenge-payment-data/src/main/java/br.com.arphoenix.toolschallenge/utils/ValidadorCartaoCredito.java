package br.com.arphoenix.toolschallenge.utils;

import org.springframework.stereotype.Component;

@Component
public class ValidadorCartaoCredito {

    public static Boolean validate(String creditCardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(creditCardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}

