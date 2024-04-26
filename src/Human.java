public class Human implements Comparable<Human> {
    public String first_name;
    public String last_name;
    public String second_name;
    public int age;
    public Human(String first_name, String last_name, String second_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.age = age;
    }

    @Override
    public int compareTo(Human human) {
        String th = second_name + " " + first_name + " " + last_name;
        String other = human.second_name + " " + human.first_name + " " + human.last_name;
        if (th.compareTo(other) == 0)
            return this.age - human.age;
        return th.compareTo(other);
    }
}
