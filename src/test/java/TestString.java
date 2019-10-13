import org.junit.Assert;
import org.junit.Test;


public class TestString {

    @Test
    public void testStringConstructorWithoutParameter(){
        String string = new String();
        Assert.assertEquals("不为空", "", string);
    }

    @Test
    public void testStringConstructorWithParameterOfString(){
        String abc = "abc";
        String string = new String(abc);
        Assert.assertEquals("值不相等", "abc", string);
    }

    @Test
    public void testStringConstructorWithParameterOfCharArray(){
        String s = new String(new char[]{'a', 'b', 'c'});
        Assert.assertEquals("值不相等", "abc", s);
        String ss = new String(new char[]{'a', 'b', 'c'}, 0, 2);
        Assert.assertEquals("值不相等", "ab", ss);
    }

    @Test
    public void testStringConstructorWithParameterOfIntArray(){
        String s = new String(new int[]{65, 66, 67}, 0, 3);
        Assert.assertEquals("值不相等", "ABC", s);
    }


    @Test
    public void testStringConstructorWithParameterOfByteArray(){
        String s = new String(new byte[]{65, 66, 67}, 0);
        Assert.assertEquals("值不相等", "ABC", s);
    }

    @Test
    public void testCodePointAt(){
        Assert.assertEquals("值不相等", 65, "ABC".codePointAt(0));
    }

    @Test
    public void testCodePointBefore(){
        System.out.println("ABC".codePointBefore(1));
    }

    @Test
    public void testCodePointCount(){
        System.out.println("\uD835\uDD6B".length());
        System.out.println("\uD835\uDD6B".codePointCount(0, 2));
    }

    @Test
    public void testOffsetByCodePoints(){
        String string = "a\uD835\uDD6Ba";
        System.out.println(string.offsetByCodePoints(0, 0));//0

        System.out.println(string.offsetByCodePoints(0, 1));//1

        System.out.println(string.offsetByCodePoints(0, 2));//3

        System.out.println(string.offsetByCodePoints(0, 3));//4


        //System.out.println("a\uD835\uDD6Ba".offsetByCodePoints(0, 4));
        System.out.println(string.codePointAt(0));
        System.out.println(string.codePointAt(1));
        System.out.println(string.codePointAt(2));
        System.out.println(string.codePointAt(3));
        //System.out.println("a\uD835\uDD6Ba".codePointAt(4));
    }


    @Test
    public void testIndexOf(){
        //System.out.println("abc".indexOf(97));
        //System.out.println("a\uD835\uDD6Ba".indexOf(120171));
        //System.out.println("a\uD835\uDD6Ba".indexOf(56683));
        String abc = "abc";
        System.out.println(abc.indexOf("b", 80));
    }


    @Test
    public void testSubSequence(){
        CharSequence charSequence = "abc".subSequence(1, 3);
        System.out.println(charSequence);
    }

    @Test
    public void testFormat(){
        String str=null;
        str=String.format("Hi,%s", "小超");
        System.out.println(str);
        str=String.format("Hi,%s %s %s", "小超","是个","大帅哥");
        System.out.println(str);
        System.out.printf("字母c的大写是：%c %n", 'C');
        System.out.printf("布尔结果是：%b %n", "小超".equals("帅哥"));
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
    }
}
