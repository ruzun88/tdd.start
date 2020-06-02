package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public long getMonthFromPay(long i) {
        return i / 10000;
    }

    public LocalDate addMonth(LocalDate start, long month) {
        return start.plusMonths(month);
    }

    public LocalDate calc(long pay, LocalDate start) {
        long month = getMonthFromPay(pay);
        return addMonth(start, month);
    }
}
