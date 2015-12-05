import org.junit.Test;

import java.util.List;
import java.util.function.IntConsumer;

public class CustomCollectorTest  {

    List<Person> personList = DataUtils.createPersonList();


    @Test
    public void testAverageAgeUsingCustomCollector() throws Exception {

//        personList.stream().map(person -> person.getAge()).reduce(Averager::new, Averager::accept, Averager::combine);
    }

    static class Averager implements IntConsumer
    {
        private int total = 0;
        private int count = 0;

        public double average() {
            return count > 0 ? ((double) total)/count : 0;
        }

        public void accept(int i) { total += i; count++; }
        public void combine(Averager other) {
            total += other.total;
            count += other.count;
        }
    }
}

