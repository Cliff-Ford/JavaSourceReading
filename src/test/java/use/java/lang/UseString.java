package use.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

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
        log.warn(new String(new byte[]{'a','b','c'},0,0,3));
        log.warn(new String(new byte[]{'a','b','c'},0));
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

    @Test
    public void testFunctions(){
        log.info("测试String的public方法开始");
        Assert.assertEquals(11,"hello world".length());
        Assert.assertEquals(2,"\uDB84\uDE06".length());
        // 󱈆 == \uDB84\uDE06
        log.info("\uDB84\uDE06");
        Assert.assertFalse("empty".isEmpty());
        Assert.assertEquals('a',"abc".charAt(0));
        Assert.assertEquals(987654,"\uDB84\uDE06".codePointAt(0));
        Assert.assertEquals(97,"a\uDB84\uDE06".codePointBefore(1));
        Assert.assertEquals(2,"a\uDB84\uDE06".codePointCount(0,2));
        log.info("a\uDB84\uDE06");
        Assert.assertEquals(1,"a\uDB84\uDE06".codePointCount(0,1));
        log.info("a\uDB84\uDE06".substring(0,1));
        Assert.assertEquals(3,"a\uDB84\uDE06b".offsetByCodePoints(1,1));
        char[] dst = new char[3];
        "cliff".getChars(0,3, dst,0);
        log.info(String.valueOf(dst));
        byte[] bytes = new byte[5];
        "f\uDB84\uDE06ord".getBytes(0,3,bytes,0);
        log.warn(Arrays.toString(bytes));
        log.info(String.valueOf("world".getBytes().length));
        Assert.assertFalse("abc".equals("abcd"));
        Assert.assertTrue("abc".contentEquals("aabc".substring(1,4)));
        Assert.assertTrue("abc".equalsIgnoreCase("ABC"));
        Assert.assertTrue("abc".compareTo("bcd") < 0);
        Assert.assertEquals(0,"abc".compareToIgnoreCase("AbC"));
        Assert.assertTrue("cliff".regionMatches(3,"ffuck",0,2));
        Assert.assertTrue("cliff".regionMatches(true,3,"FFuck",0,2));
        Assert.assertTrue("abc".startsWith("ab"));
        Assert.assertFalse("abc".endsWith("ab"));
        log.info(String.valueOf("abc".hashCode()));
        log.info(String.valueOf("abc".indexOf(97)));
        log.info(String.valueOf("abc".indexOf(97,1)));
        log.info(String.valueOf("abc".lastIndexOf(97)));
        log.info(String.valueOf("cba".lastIndexOf(97,1)));
        log.info(String.valueOf("aCliff".indexOf("li")));
        log.info(String.valueOf("aClifyf".indexOf("f",5)));
        log.info(String.valueOf("abc".lastIndexOf("b")));
        log.info(String.valueOf("bcCliffFordb".lastIndexOf("b",1)));
        log.info("ok".substring(1));
        log.info("world".substring(1,3));
        CharSequence charSequence = "abc".subSequence(1,3);
        log.info((String) charSequence);
        log.info("a".concat("bc"));
        log.info("abc".replace('a','b'));
        log.info(String.valueOf("abc".matches("^a[b]c$")));
        log.info(String.valueOf("abc".contains("b")));
        log.info("abcabc".replaceFirst("abc","ABC"));
        log.info("abcabc".replaceAll("abc","ABC"));
        log.info("abcHaHa".replace("a".subSequence(0,1),"A".subSequence(0,1)));
        log.info(Arrays.toString("abc,abce,abcf".split(",")));
        log.info("AbC".toLowerCase(Locale.JAPAN));
        log.info("测试String的public方法结束,并且所有方法的返回值在预料之中");
    }
}
