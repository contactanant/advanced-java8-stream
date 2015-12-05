import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CustomCollectorTest {

    List<Person> personList = DataUtils.createPersonList();


    @Test
    public void testAverageAgeUsingCustomCollector() throws Exception {

        Averager averager = personList.stream().map(person -> person.getAge()).collect(Averager::new, Averager::accept, Averager::combine);

        assertThat(averager.average(), equalTo(4.0));
    }
}

