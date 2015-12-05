import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DataUtils {

    //data list having two male members and one female member
    public static List<Person> createPersonList() {
        Person person1 = new Person("Harry", LocalDate.of(2011, 01, 01), Person.Sex.MALE, "one@email.com");
        person1.addAddress(new Person.Address("B44", "hangingStreet"));
        Person person2 = new Person("John", LocalDate.of(2010, 01, 01), Person.Sex.MALE, "two@email.com");
        person1.addAddress(new Person.Address("C70", "someOtherStree"));
        Person person3 = new Person("Lianne", LocalDate.of(2012, 01, 01), Person.Sex.FEMALE, "three@email.com");
        person1.addAddress(new Person.Address("C70", "someOtherStree"));
        return Arrays.asList(person1, person2, person3);
    }
}
