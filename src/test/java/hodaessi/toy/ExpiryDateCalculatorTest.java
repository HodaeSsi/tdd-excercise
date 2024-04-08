package hodaessi.toy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void if_you_pay_10000_won_the_expiration_date_will_be_one_month_later() {
        // test01
        this.assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2019, 3, 1))
                .payAmount(10_000)
                .build(), LocalDate.of(2019, 4, 1));

        // test02
        this.assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2019, 5, 5))
                .payAmount(10_000)
                .build(), LocalDate.of(2019, 6, 5));
    }

    @Test
    void the_payment_date_and_the_date_one_month_later_ar_not_the_same() {
        this.assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2019, 1, 31))
                .payAmount(10_000)
                .build(), LocalDate.of(2019, 2, 28));
        this.assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2019, 5, 31))
                .payAmount(10_000)
                .build(), LocalDate.of(2019, 6, 30));
        this.assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2020, 1, 31))
                .payAmount(10_000)
                .build(), LocalDate.of(2020, 2, 29));
    }

    //TODO: 연도가 바뀌면?

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, expiryDate);
    }
}
