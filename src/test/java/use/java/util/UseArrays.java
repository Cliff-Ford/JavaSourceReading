package use.java.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

@Data
class Student implements Comparable<Student>{
    private Integer no;

    @Override
    public int compareTo(Student o) {
        if(getNo() == null && o.getNo() == null){
            return 0;
        }
        if(getNo() == null && o.getNo() != null){
            return -1;
        }
        if(getNo() != null && o.getNo() == null){
            return getNo();
        }
        return this.no-o.getNo();
    }
}

@Data
class Teacher{
    private Integer no;
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
        Random random = new Random();
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
        for (int i = 0; i < 9000; i++) {
            students[i] = new Student();
            students[i].setNo(random.nextInt());
        }
        Arrays.parallelSort(students);//超过8192后有时候行，有时候不行？
        log.info(Arrays.toString(students));
    }


}
