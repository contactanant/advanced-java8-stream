import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SummingAndAverageTest {

    List<Person> personList = DataUtils.createPersonList();

    @Test
    public void testSummingUpAgeUsingReduction() throws Exception {
        Integer totalAge = personList.stream().map(person -> person.getAge()).reduce(0, (a, b) -> a + b);

        assertThat(totalAge, equalTo(12));
    }

    @Test
    public void testAverageAge() throws Exception {
        double averageAge = personList.stream().mapToInt(person -> person.getAge()).average().orElseGet(() -> 0.0);

        assertThat(averageAge, equalTo(4.0));
    }


    @Test
    public void testAverageAgePerGender() throws Exception {
        Map<Person.Sex, Double> averageAgeByGender = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.averagingInt(Person::getAge)));

        assertThat(averageAgeByGender.get(Person.Sex.FEMALE), equalTo(3.0));
        assertThat(averageAgeByGender.get(Person.Sex.MALE), equalTo(4.5));
    }

}
