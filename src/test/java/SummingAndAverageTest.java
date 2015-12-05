import org.junit.Test;

import java.util.List;

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
    public void testAverageUsingMethods() throws Exception {
        double averageAge = personList.stream().mapToInt(person -> person.getAge()).average().orElseGet(() -> 0.0);

        assertThat(averageAge, equalTo(4.0));
    }

}
