package use.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class UseString {

    @Test
    public void testConstructor() throws UnsupportedEncodingException {
        log.info("测试String的构造方法开始");
        log.info(new String());
        log.info(new String("original"));
        log.info(new String(new char[]{'a','b','c'}));
        log.info(new String(new char[]{'a','b','c'},1,2));
        log.info(new String(new int[]{324324,43,243,987654},1,3));
        log.info(new String(new byte[]{'a','b','c'},0,0,3));
        log.info(new String(new byte[]{'a','b','c'},0));
        log.info(new String(new byte[]{'d','d','d'},0,3,"UTF8"));
        log.info(new String(new byte[]{'a','b','c'},0,3, StandardCharsets.ISO_8859_1));
        log.info(new String(new byte[]{'f','f','c'},"utf8"));
        log.info(new String(new byte[]{'a','b','c'}, StandardCharsets.UTF_8));
        log.info(new String(new byte[]{'a','b','c'}, 0,3));
        log.info(new String(new byte[]{'a','b','c'}));
        log.info(new String(new StringBuffer("abcBuffer")));
        log.info(new String(new StringBuilder("abcBuilder")));
        log.info("测试String的构造方法结束");
    }
}
