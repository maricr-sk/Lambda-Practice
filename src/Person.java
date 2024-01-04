public class Person {

    private String first;
    private String last;
    private int age;

    public Person(String firstName, String lastName, int age) {
        super();
        this.first = firstName;
        this.last = lastName;
        this.age = age;
    }

    public String getFirst() { return first; }

    public void setFirst(String first) { this.first = first; }

    public String getLast() { return last; }

    public void setLast(String last) { this.last = last; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", age=" + age +
                '}';
    }
}
