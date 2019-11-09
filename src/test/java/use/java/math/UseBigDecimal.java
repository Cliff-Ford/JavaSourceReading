package use.java.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

@Slf4j
public class UseBigDecimal {

    @Test
    public void howToNewBigDecimalObject() {
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

    @Test
    public void valueOfMethod() {
        BigDecimal first = BigDecimal.valueOf(1000L);
        log.info(first.toString());
        BigDecimal second = BigDecimal.valueOf(1000L, 2);
        log.info(second.toString());
        BigDecimal third = BigDecimal.valueOf(9.9);
        log.info(third.toString());
    }

    @Test
    public void arithmeticOperations() {
        BigDecimal a = new BigDecimal("18.9");
        BigDecimal b = new BigDecimal("11.11");
        BigDecimal c = a.add(b);
        log.info("debug模式看一下加法的实现过程，scale缩放比例的作用");
        log.info(a.toString());
        log.info(b.toString());
        log.info(c.toString() + "=" + a.toString() + "+" + b.toString());
        BigDecimal d = a.add(b, MathContext.UNLIMITED);
        BigDecimal e = a.add(b, MathContext.DECIMAL32);
        BigDecimal f = a.add(b, MathContext.DECIMAL64);
        BigDecimal g = a.add(b, MathContext.DECIMAL128);
        log.info(d.toString());
        log.info(e.toString());
        log.info(f.toString());
        log.info(g.toString());
        log.info("没发现这四个MathContext有什么区别");
        BigDecimal h = a.subtract(b);
        log.info(h.toString() + "=" + a.toString() + "-" + b.toString());
        BigDecimal i = a.multiply(b);
        log.info(i.toString() + "=" + a.toString() + "*" + b.toString());
        BigDecimal j = new BigDecimal("4");
        BigDecimal k = new BigDecimal("2");
        BigDecimal l = j.divide(k, 10, RoundingMode.HALF_UP);
        log.info(l.toString() + "=" + j.toString() + "/" + k.toString());
        BigDecimal m = j.divide(k, 1);
        log.info(m.toString() + "=" + j.toString() + "/" + k.toString());
        BigDecimal n = j.divide(k, RoundingMode.HALF_UP);
        log.info(n.toString() + "=" + j.toString() + "/" + k.toString());
        BigDecimal o = new BigDecimal("1");
        BigDecimal p = new BigDecimal("3");
//        BigDecimal q = o.divide(p);
//        BigDecimal q = j.divide(k);
        log.info("divide方法除不尽时，如果没有设置舍入模式会抛异常");
        BigDecimal r = o.divideToIntegralValue(p);
        log.info("divideToIntegralValue方法要求除数不为0，默认向下取整" + r.toString());
        BigDecimal s = o.remainder(p);
        log.info("remainder求模运算" + s.toString());
        BigDecimal[] t = o.divideAndRemainder(p);
        log.info("商是" + t[0] + "余数是" + t[1]);
        BigDecimal u = k.pow(j.intValue());
        log.info("幂函数pow" + u.toString());
        BigDecimal abs = new BigDecimal("-1").abs();
        log.info(abs.toString());
        BigDecimal negate1 = new BigDecimal("-999").negate();
        BigDecimal negate2 = new BigDecimal("+999").negate();
        log.info("negate1: " + negate1.toString() + " negate2: " + negate2.toString());
        int signum1 = new BigDecimal("8").signum();
        log.info(String.valueOf(signum1));
        log.info("signum方法只返回-1，0，1三个值，-1代表对象是负数，0代表对象是0，1代表对象是正数");
        BigDecimal v = new BigDecimal("-12.56");
        int scale = v.scale();
        int precision = v.precision();
        BigInteger unscaledValue = v.unscaledValue();
        log.info(String.valueOf(scale));
        log.info(String.valueOf(precision));
        log.info(String.valueOf(unscaledValue));
        log.info(v.toString());
    }
}
