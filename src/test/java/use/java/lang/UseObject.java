package use.java.lang;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Data
class Teacher implements Cloneable{
    private int no;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

@Slf4j
public class UseObject {

    @Test
    public void testGetClass(){
        Object object = new Object();
        log.info(String.valueOf(object.getClass()));
        Teacher teacher = new Teacher();
        log.info(String.valueOf(teacher.getClass()));
    }

    @Test
    public void testHashCode(){
        Teacher teacher = new Teacher();
        teacher.setNo(1);
        log.info(String.valueOf(teacher.hashCode()));
        log.info(String.valueOf(teacher.hashCode()));
        Teacher teacher2 = new Teacher();
        teacher2.setNo(1);
        log.info(String.valueOf(teacher2.hashCode()));//因为teacher.equals(teacher2)
    }

    @Test
    public void testEquals(){
        Teacher a = new Teacher();
        a.setNo(1);
        Teacher b = new Teacher();
        b.setNo(1);
        Teacher c = new Teacher();
        c.setNo(1);
        Teacher d = new Teacher();
        d.setNo(2);
        //自反性
        log.info(String.valueOf(a.equals(a)));
        //对称性
        log.info(String.valueOf(a.equals(b)));
        log.info(String.valueOf(b.equals(a)));
        //传递性
        log.info(String.valueOf(a.equals(b)));
        log.info(String.valueOf(b.equals(c)));
        log.info(String.valueOf(a.equals(c)));
        //一致性
        log.info(String.valueOf(a.equals(b)));
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setNo(1);
        log.info(String.valueOf(teacher.hashCode()));
        Teacher clone = (Teacher)teacher.clone();
        log.info(String.valueOf(clone.hashCode()));//debug查看它的物理地址
    }

    @Test
    public void testToString(){
        Object o = new Object();
        log.info(o.toString());
    }
}
