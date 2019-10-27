package use.java.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

@Data
class Student implements Comparable<Student>{
    private int no;

    @Override
    public int compareTo(Student o) {
        return this.no-o.getNo();
    }
}

@Data
class Teacher{
    private int no;
}

@Slf4j
public class UseArrays {

    @Test
    public void testSort(){
        int[] a = new int[]{10000,565,234,654,8};
        Arrays.sort(a);
        log.info(Arrays.toString(a));

        int[] b = new int[]{10000,565,234,654,8};
        Arrays.sort(b,1,5);
        log.info(Arrays.toString(b));

        short[] c = new short[]{10000,565,234,654,8};
        Arrays.sort(c);
        log.info(Arrays.toString(c));
        // 支持int[] short[] long[] char[] byte[] float[] double[]等基本类型的升序快速排序
    }

    @Test
    public void testParallelSort(){
        int[] a = new int[9000];
        int[] b = new int[9000];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 9000; i++) {
            a[i] = random.nextInt();
            b[i] = random.nextInt();
        }
        Arrays.parallelSort(a);
        Arrays.parallelSort(b,1,a.length);
        log.info(Arrays.toString(a));
        log.info(Arrays.toString(b));
        // 支持int[] short[] long[] char[] byte[] float[] double[]等基本类型和对象类型的并行升序快速排序
        // 但要求数组长度超过8192 且ForkJoinPool.getCommonPoolParallelism()返回值 != 1
        Student[] students = new Student[9000];
        Teacher[] teachers = new Teacher[9000];
        for (int i = 0; i < 9000; i++) {
            students[i] = new Student();
            students[i].setNo(random.nextInt()%90000);
            teachers[i] = new Teacher();
            teachers[i].setNo(random.nextInt()%90000);
        }
        Arrays.parallelSort(students);//超过8192后有时候行，有时候不行？如果加上%90000，就没问题，但%2100000000也会有问题
        Arrays.parallelSort(teachers, Comparator.comparingInt(Teacher::getNo));
        //Arrays.sort(students);//这个也挺快的，秒出答案
        //Arrays.sort(teachers,Comparator.comparingInt(Teacher::getNo));
        log.info(Arrays.toString(students));
        log.info(Arrays.toString(teachers));
    }

    @Test
    public void test(){
        for (int i = 0; i < 50; i++) {
            log.info(String.valueOf(i));
            testParallelSort();
        }
    }

    @Test
    public void testSumItselfAndTheElementPrefix(){
        int[] a = new int[]{10000,565,234,654,8};
        Arrays.parallelPrefix(a, Integer::sum);
        log.info(Arrays.toString(a));
        Teacher[] teachers = new Teacher[5];
        for (int i = 0; i < 5; i++) {
            teachers[i] = new Teacher();
            teachers[i].setNo(i);
        }
        log.info(Arrays.toString(teachers));
        Arrays.parallelPrefix(teachers, (teacher, teacher2) -> {
            Teacher temp = new Teacher();
            temp.setNo(teacher.getNo() + teacher2.getNo());
            return temp;
        });
        log.info(Arrays.toString(teachers));
    }

    @Test
    public void testSearch(){
        int[] a = new int[]{1,2,3,4,8};
        int index = Arrays.binarySearch(a,3);
        log.info(String.valueOf(index));
        int[] b = new int[]{10000,654,565,234,8};
        index = Arrays.binarySearch(b,8);
        log.info(String.valueOf(index));
        index = Arrays.binarySearch(a,1,a.length-1,8);
        log.info(String.valueOf(index));
        // 没有实现Comparable接口的对象
        Teacher[] teachers = new Teacher[5];
        for (int i = 0; i < 5; i++) {
            teachers[i] = new Teacher();
            teachers[i].setNo(i);
        }
        Teacher key = new Teacher();
        key.setNo(3);
        index = Arrays.binarySearch(teachers, key, Comparator.comparingInt(Teacher::getNo));
        if(index > 0){
            log.info(String.valueOf(teachers[index]));
        }
        // 实现了Comparable接口的对象
        Student[] students = new Student[5];
        for (int i = 0; i < 5; i++) {
            students[i] = new Student();
            students[i].setNo(i);
        }
        Student student = new Student();
        student.setNo(2);
        index = Arrays.binarySearch(students,student);
        if(index > 0){
            log.info(students[index].toString());
        }
    }

    @Test
    public void testEquals(){
        int[] a = new int[]{1,2,3,4,8};
        int[] b = new int[]{1,2,3,4,8};
        boolean isEquals = Arrays.equals(a, b);
        log.info(String.valueOf(isEquals));
        //支持long[],int[],short[],char[],byte[],boolean[],double[],float[],Object[]类型的等价判断
    }

    @Test
    public void testFill(){
        int[] a = new int[5];
        Arrays.fill(a,8);
        log.info(Arrays.toString(a));
        int[] b = new int[5];
        Arrays.fill(b,2,4,8);
        log.info(Arrays.toString(b));
        //支持long[],int[],short[],char[],byte[],boolean[],double[],float[],Object[]类型的等价判断
    }

    @Test
    public void testCopy(){
        Teacher[] teachers = new Teacher[5];
        for (int i = 0; i < 5; i++) {
            teachers[i] = new Teacher();
            teachers[i].setNo(i);
        }
        Teacher[] copy = Arrays.copyOf(teachers, 3);
        Teacher[] range = Arrays.copyOfRange(teachers, 2, 4);
        log.info(Arrays.toString(copy));
        log.info(Arrays.toString(range));
        //支持byte[],short[],int[],long[],char[],float[],double[],boolean[]等类型数组的复制
    }

    @Test
    public void testArrayList(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        integers.set(0,5);
        log.info(String.valueOf(integers));
    }

    @Test
    public void testOther(){
        int[] a = new int[]{1,2,3,4,8};
        int[] aa = new int[]{1,2,3,4,8};
        log.info(String.valueOf(Arrays.hashCode(a)));
        int[][] b = new int[1][1];
        int[][] bb = new int[1][1];
        b[0][0] = 1;
        bb[0][0] = 1;
        log.info(String.valueOf(Arrays.deepHashCode(b)));
        log.info(Arrays.toString(a));
        log.info(Arrays.toString(aa));
        log.info(Arrays.deepToString(b));
        log.info(String.valueOf(Arrays.deepEquals(b,bb)));
        log.info(Arrays.toString(a));
        Arrays.setAll(a, i -> i + 2);//i是索引，i+2是计算结果，将计算结果赋值给对应元素
        log.info(Arrays.toString(a));
        Student[] students = new Student[5];
        Arrays.parallelSetAll(students, value -> {
            Student temp = new Student();
            temp.setNo(value * value);
            return temp;
        });
        log.info(Arrays.toString(students));
    }

    @Test
    public void testSpliterator(){
        int[] a = new int[]{1,2,3,4,8};
        Spliterator.OfInt spliterator = Arrays.spliterator(a);
        spliterator.tryAdvance((IntConsumer) value -> System.out.println(value * value));
        spliterator.tryAdvance((IntConsumer) value -> System.out.println(value * value));
        spliterator.forEachRemaining((IntConsumer) System.out::println);
    }

    @Test
    public void testStream(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 8);
        List<Integer> collect = integers.stream().map(e -> e * e).collect(Collectors.toList());
        log.info(collect.toString());
    }
}
