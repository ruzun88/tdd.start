package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    private ExpiryDateCalculator calculator = new ExpiryDateCalculator();

    @Test
    public void getMonthFromPay() {
        long paidMonth = calculator.getMonthFromPay(10000);
        assertEquals(1, paidMonth);

        long paidMonth2 = calculator.getMonthFromPay(20000);
        assertEquals(2, paidMonth2);
    }

    @Test
    public void addMonth() {
        assertExpiryDate(LocalDate.of(2019,3,1), 3, LocalDate.of(2019,6,1));
        assertExpiryDate(LocalDate.of(2020,1,31), 3, LocalDate.of(2020,4,30));
        assertExpiryDate(LocalDate.of(2020,2,29), 3, LocalDate.of(2020,5,29));
    }
    private void assertExpiryDate (LocalDate start, long month, LocalDate end){
        LocalDate endCalculated = calculator.addMonth(start, month);
        assertEquals(end, endCalculated);
    }

    @Test
    public void calc() {
        LocalDate expiryDate = calculator.calc(10000, LocalDate.of(2020,2,29));
        assertEquals(LocalDate.of(2020,3,29), expiryDate);

        LocalDate expiryDate2 = calculator.calc(50000, LocalDate.of(2019,1,31));
        assertEquals(LocalDate.of(2019,6,30), expiryDate2);

        LocalDate expiryDate3 = calculator.calc(10000, LocalDate.of(2019,4,30));
        assertEquals(LocalDate.of(2019,5,30), expiryDate3);
    }
}
