import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        Human h1 = new Human("Абдул", "Евгеньевич", "Бобров", 40);
        Human h2 = new Human("Абдул", "Евгеньевич", "Бобров", 41);
        Human h3 = new Human("Иван", "Михайлович", "Короткий", 24);
        Human h4 = new Human("Пирог", "Глупович", "Ягодов", 4);
        Human h5 = new Human("Крекер", "-", "Хрустящий", 1);
        LinkedList<Human> humans = new LinkedList<>();

        humans.add(h1);
        humans.add(h2);
        humans.add(h3);
        humans.add(h4);
        humans.add(h5);

        Collections.sort(humans);
        for (Human human : humans)
            System.out.printf("%s %s %s %s\n", human.first_name, human.second_name, human.last_name, human.age);
    }
}