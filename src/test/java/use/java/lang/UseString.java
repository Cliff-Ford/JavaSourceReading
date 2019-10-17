package use.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class UseString {

    @Test
    public void testConstructor() throws UnsupportedEncodingException {
        System.out.println("开始测试String的构造方法");
        System.out.println(new String());
        System.out.println(new String("original"));
        System.out.println(new String(new char[]{'a','b','c'}));
        System.out.println(new String(new char[]{'a','b','c'},1,2));
        System.out.println(new String(new int[]{324324,43,243,987654},1,3));
        System.out.println(new String(new byte[]{'a','b','c'},0,0,3));
        System.out.println(new String(new byte[]{'a','b','c'},0));
        System.out.println(new String(new byte[]{'a','b','c'},0,3,"UTF8"));
        System.out.println(new String(new byte[]{'a','b','c'},0,3, StandardCharsets.ISO_8859_1));
        System.out.println(new String(new byte[]{'a','b','c'},"utf8"));
        System.out.println(new String(new byte[]{'a','b','c'}, StandardCharsets.UTF_8));
        System.out.println(new String(new byte[]{'a','b','c'}, 0,3));
        System.out.println(new String(new byte[]{'a','b','c'}));
        System.out.println(new String(new StringBuffer("abc")));
        System.out.println(new String(new StringBuilder("abc")));
        System.out.println("测试String的构造方法结束");
    }
}
