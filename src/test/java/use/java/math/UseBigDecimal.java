package use.java.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

@Slf4j
public class UseBigDecimal {

    @Test
    public void howToNewBigDecimalObject(){
        BigDecimal first = new BigDecimal(new char[]{'1', '2', '.', '3'}, 0, 4);
        log.info(first.toString());
        BigDecimal second = new BigDecimal(new char[]{'1', '2', '.', '3'}, 0, 4, MathContext.DECIMAL64);
        log.info(second.toString());
        BigDecimal third = new BigDecimal(new char[]{'1', '2', '.', '3'});
        log.info(third.toString());

    }
}
