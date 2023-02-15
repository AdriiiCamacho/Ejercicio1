import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testThrowExceptionName(){
        assertThrows(RuntimeException.class,()->{new Person("",45,"FEMALE");});
    }
    @Test
    public  void testdThrowExceptionAge(){
        assertThrows(RuntimeException.class,()->{new Person("Kiria",-1,"FEMALE");});
    }
    @Test
    public  void testThrowExceptionGender(){
        assertThrows(RuntimeException.class,()->{new Person("Lola",17,"M");});
    }

    @Test
    public void emptyListes0(){
        List<Person> p = new ArrayList<>();

        double[] averageAge = Person.averageAgePerGender(p);
        assertEquals(0, averageAge[0]);
        assertEquals(0, averageAge[1]);
    }
    @Test
    public void nullList(){
        List<Person> p = null;

        assertThrows(RuntimeException.class,()->Person.averageAgePerGender(p));
    }

    @Test
    void testNombre() {
        Person person = new Person("Lucas", 30, "MALE");
        assertEquals("Lucas", person.getName());
    }

    @Test
    void testEdad() {
        Person p = new Person("Jose", 67, "MALE");
        assertEquals(67, p.getAge());
    }

    @Test
    void testGenero() {
        Person person = new Person("Pedro", 30, "MALE");
        assertEquals("MALE", person.getGender());
    }

    @Test
    void testEdadPromedio() {
        Person p1 = new Person("Juan", 35, "MALE");
        Person p2 = new Person("Miriam", 12, "FEMALE");
        Person p3 = new Person("Pepe", 20, "MALE");
        Person p4 = new Person("Laura", 26, "FEMALE");

        List<Person> people = Arrays.asList(p1, p2, p3, p4);

        double [] avgAges = p1.averageAgePerGender(people);
        assertEquals(27.5, avgAges[0], 0.1);
        assertEquals(19, avgAges[1], 0.1);
    }

    @Test
    public void testNoHombres() {
        Person p1 = new Person("Lupita", 20, "FEMALE");
        Person p2 = new Person("Mara", 25, "FEMALE");
        Person p3 = new Person("Sara", 24, "FEMALE");
        Person p4 = new Person("Mira", 34, "FEMALE");

        List<Person> p = Arrays.asList(p1, p2, p3, p4);

        double [] avgAges = Person.averageAgePerGender(p);
        assertEquals(0.0, avgAges[0], 0.1);
        assertEquals(25.75, avgAges[1], 0.1);
    }

    @Test
    public void testNoMujeres() {
        Person p1 = new Person("Jacobo", 21, "MALE");
        Person p2 = new Person("Lucas", 25, "MALE");
        Person p3 = new Person("Perio", 35, "MALE");
        Person p4 = new Person("Juanfran", 40, "MALE");

        List<Person> p = Arrays.asList(p1, p2, p3);

        double [] avgAges = Person.averageAgePerGender(p);
        assertEquals(27, avgAges[0], 0.1);
        assertEquals(0.0, avgAges[1], 0.1);
    }
}