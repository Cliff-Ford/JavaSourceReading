package use.java.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
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
        BigDecimal fourth = new BigDecimal(new char[]{'1', '.', '3'}, new MathContext(4));
        log.info(fourth.toString());
        BigDecimal fifth = new BigDecimal("-1.23E-12");
        log.info(fifth.toString());
        BigDecimal sixth = new BigDecimal("-1.23E-12", MathContext.UNLIMITED);
        log.info(sixth.toString());
        BigDecimal seventh = new BigDecimal(8.8);
        log.info(seventh.toString());
        BigDecimal eighth = new BigDecimal(9.1, MathContext.DECIMAL32);
        log.info(eighth.toString());
        BigDecimal ninth = new BigDecimal(new BigInteger("128"));
        log.info(ninth.toString());
        BigDecimal tenth = new BigDecimal(new BigInteger("256"), MathContext.DECIMAL128);
        log.info(tenth.toString());
        BigDecimal eleventh = new BigDecimal(new BigInteger("159"), 2);
        log.info(eleventh.toString());
        BigDecimal twelfth = new BigDecimal(new BigInteger("67"), 1, MathContext.UNLIMITED);
        log.info(twelfth.toString());
        BigDecimal thirteenth = new BigDecimal(19);
        log.info(thirteenth.toString());
        BigDecimal fourteenth = new BigDecimal(29, MathContext.UNLIMITED);
        log.info(fourteenth.toString());
        BigDecimal fifteenth = new BigDecimal(2L);
        log.info(fifteenth.toString());
        BigDecimal sixteenth = new BigDecimal(5L, MathContext.DECIMAL32);
        log.info(sixteenth.toString());
        log.info("综合来说，第五种方法是最常用的，还可以科学计数法");
    }
}
