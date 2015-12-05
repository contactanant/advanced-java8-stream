import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    List<Address> addresses = new ArrayList<>();

    public static class Address {

        String houseNumber;
        String street;

        public Address(String houseNumber, String street) {
            this.houseNumber = houseNumber;
            this.street = street;
        }
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", addresses=" + addresses +
                '}';
    }
    public static void addToList(Map<Sex, List<Person>> map, Person person) {
        if (map.containsKey(person.getGender())) {
            map.get(person.getGender()).add(person);
        } else {
            map.put(person.getGender(), new ArrayList<Person>() {{
                add(person);
            }});
        }

    }

    public static void addToNameList(Map<Sex, List<String>> map, Person person) {
        if (map.containsKey(person.getGender())) {
            map.get(person.getGender()).add(person.getName());
        } else {
            map.put(person.getGender(), new ArrayList<String>() {{
                add(person.getName());
            }});
        }

    }

}
