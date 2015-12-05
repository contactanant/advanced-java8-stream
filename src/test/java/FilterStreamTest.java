import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FilterStreamTest {
    List<Person> personList = DataUtils.createPersonList();

    @Test
    public void testFilterAppliedCorrectly() throws Exception {
        List<Person> persons = personList.stream().filter(p -> p.getGender() == Person.Sex.FEMALE).collect(Collectors.toList());

        assertThat(persons.size(), equalTo(1));
        assertThat(persons.get(0).getName(), equalTo("Lianne"));
    }
}
