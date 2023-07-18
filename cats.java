import java.util.HashSet;

public class Cat {
    private String name;
    private int age;
    
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cat)) {
            return false;
        }
        Cat cat = (Cat) obj;
        return Objects.equals(name, cat.name) && age == cat.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class Main {
    public static void main(String[] args) {
        HashSet<Cat> cats = new HashSet<>();
        cats.add(new Cat("Tom", 5));
        cats.add(new Cat("Jerry", 3));
        
        // Создание двух котов с одинаковыми полями
        Cat tom = new Cat("Tom", 5);
        tom.age = 10;
        Cats jerry = new Cat("Jerry", tom.age);
        jerry.name = "Jerry2";
        
        cats.add(tom);
        cats.add(jerry);
        
        System.out.println("Множество до удаления дубликатов: " + cats);
        System.out.println();
        
        Set<Cat> uniqueCats = new HashSet<>(cats); // создание нового множества уникальных котов
        uniqueCats.remove(tom); // удаление единственного дубликата
        uniqueCats.