import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        Long stream = persons.stream()
                .filter(age -> age.getAge() < 18)
                .count();
        System.out.println(stream);

        List<String> stream1 = persons.stream()
                .filter(age -> age.getAge() > 18 && age.getAge() < 27)
                .filter(sex -> sex.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(stream1);

        List<Person> stream2 = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 60 && person.getSex() == Sex.WOMAN || person.getAge() > 18 && person.getAge() < 65 && person.getSex() == Sex.MAN)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(stream2);


    }
}