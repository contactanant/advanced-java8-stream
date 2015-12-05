import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;

public class ListToMapTest {
    List<Person> personList = DataUtils.createPersonList();


    @Test
    public void testCovertToMapUsingCollectors() throws Exception {
        Map<Person.Sex, List<Person>> map = personList.stream().collect(Collectors.groupingBy(Person::getGender));

        Assert.assertThat(map.size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).get(0).getName(), equalTo("Harry"));
        Assert.assertThat(map.get(Person.Sex.MALE).get(1).getName(), equalTo("John"));
        Assert.assertThat(map.get(Person.Sex.FEMALE).get(0).getName(), equalTo("Lianne"));

    }

    @Test
    public void testCovertToMapUsingReduction() throws Exception {
        Map<Person.Sex, List<Person>> map = personList.stream().collect(HashMap::new, Person::addToList, (h1, h2) -> h1.putAll(h2));

        Assert.assertThat(map.size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).get(0).getName(), equalTo("Harry"));
        Assert.assertThat(map.get(Person.Sex.MALE).get(1).getName(), equalTo("John"));
        Assert.assertThat(map.get(Person.Sex.FEMALE).get(0).getName(), equalTo("Lianne"));

    }

    @Test
    public void testCovertToMapOnlyUseNameReduction() throws Exception {
        Map<Person.Sex, List<String>> map = personList.stream().collect(HashMap::new, Person::addToNameList, (h1, h2) -> h1.putAll(h2));

        Assert.assertThat(map.size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).get(0), equalTo("Harry"));
        Assert.assertThat(map.get(Person.Sex.MALE).get(1), equalTo("John"));
        Assert.assertThat(map.get(Person.Sex.FEMALE).get(0), equalTo("Lianne"));
    }

    @Test
    public void testCovertToMapOnlyUseNameCollectors() throws Exception {
        Map<Person.Sex, List<String>> map = personList.stream().collect(Collectors.groupingBy(Person::getGender,
                Collectors.mapping(Person::getName, Collectors.toList())));

        Assert.assertThat(map.size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).size(), equalTo(2));
        Assert.assertThat(map.get(Person.Sex.MALE).get(0), equalTo("Harry"));
        Assert.assertThat(map.get(Person.Sex.MALE).get(1), equalTo("John"));
        Assert.assertThat(map.get(Person.Sex.FEMALE).get(0), equalTo("Lianne"));
    }

}
