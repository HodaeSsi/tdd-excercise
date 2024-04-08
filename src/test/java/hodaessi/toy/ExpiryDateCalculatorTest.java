package hodaessi.toy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void if_you_pay_10000_won_the_expiration_date_will_be_one_month_later() {
        // test01
        assertExpiryDate(
                LocalDate.of(2019, 3, 1),
                10_000,
                LocalDate.of(2019, 4, 1)
        );

        // test02
        assertExpiryDate(
                LocalDate.of(2019, 5, 5),
                10_000,
                LocalDate.of(2019, 6, 5)
        );
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, expiryDate);
    }
}
