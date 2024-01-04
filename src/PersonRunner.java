import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonRunner {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Louis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );



        /*
        //Step 1: sort list by last name
        Collections.sort(people, (a,b) ->  (a.getLast().compareTo(b.getLast()) ));
        //Step 2: create a method that prints entire list
        printConditionally(people, p -> true);
        //Step 3: create a method that prints the names of people whose lasts names start with 'c'
        printConditionally(people, p -> p.getLast().startsWith("C"));
        //Step 4: create a method that prints the names of people whose first names start with 'c'
        printConditionally(people, p -> p.getFirst().startsWith("C"));


        for(int i = 0; i < people.size(); i++){
            System.out.println(people.get(i));
        }
        for(Person p : people){
            System.out.println(p);
        }

        Iterator<Person> pIt = people.iterator();
        while(pIt.hasNext()){
            System.out.println(pIt.next());
        }

        people.forEach( System.out::println);

        /*
        int [] data = {5,6,9,2};
        doMath(data, 0, (v,k) ->
        {
            try {
                System.out.println(k/v);
            }
            catch (ArithmeticException a){
                System.out.println("Arithmetic Error");
            }
        });

         */
        performConditionally(people, p -> true, System.out::println);
        String s = "abcdef";

        String t = s.toUpperCase()
                .substring(0,3)
                .trim();

        List<Person> cPeople = people.stream()
                .filter(p -> p.getLast().startsWith("C")) // only prints the ppl w surnames that begin with C
                               .collect(Collectors.toList());

        List<String> lastNames = people.stream()
                .map(p -> p.getLast()) // only prints the ppl w surnames that begin with C
                .collect(Collectors.toList());

        System.out.println(cPeople);
        System.out.println(lastNames);
    }

    public static void main2(String [] args){
        Thread t1 = new Thread(PersonRunner::printMessage);
        t1.start();
    }

    public static void multiply(int [] nums, int key){
        try{
            for (int a: nums) {
                System.out.print(a * key + " ");
            }
        }
        catch(ArithmeticException a){
            System.out.println("Arithmetic Error");
        }
    }

    public static void doMath(int [] nums, int key, BiConsumer<Integer, Integer> bic){
        for(int n : nums) {
            bic.accept(n, key);
        }
    }

    public static void printMessage(){
        System.out.println("Hello");
    }

    public static void printConditionally(List<Person>people, Condition c ){
        for(Person p : people){
            if(c.test(p)){
                System.out.println(p);
            }
        }
    }
    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p : people){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }

    }
}

@FunctionalInterface interface sort{
    int compareTo(Person a, Person b);
}

@FunctionalInterface interface print{
    void foo();
}

@FunctionalInterface interface Condition{
   boolean test(Person p);
}