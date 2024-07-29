package java_concepts.collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }


}

class Basic {
    /**
     * 
     * base - iterable -> collections -> interfaces
     * 
     */

    public static void main(String[] args) {

        // ArrayList<Integer> list = new ArrayList<>();

        // for (int i = 0; i < 10; i++)
        // list.add(i);

        // Iterator<Integer> iterator = list.iterator();
        // while (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }

        // // make list immutable

        // List<Integer> constList = Collections.unmodifiableList(list);

        // ArrayList<Integer> list2 = (ArrayList) list.clone();
        // System.out.println("list2");
        // System.out.println(list2);
        // list2.add(20);
        // System.out.println(list);
        // System.out.println(list2);

        Student student1 = new Student("A", 1);
        Student student2 = new Student("B", 2);
        Student student3 = new Student("C", 3);
        Student student4 = new Student("D", 4);

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        // System.out.println(list);

        // ArrayList<Student> list2 = (ArrayList) list.clone();

        // Student s1 = list.get(0);
        // s1.name = "sadiq";
        // System.out.println(list2);
        // System.out.println(list);

        // this creates shallow copy
        List<Student> copy = List.copyOf(list);
        System.out.println(copy.get(0).hashCode());
        System.out.println(list.get(0).hashCode());


    }

}
