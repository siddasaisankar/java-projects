import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + age + " | " + course);
    }
}

public class StudentManagement {
    private static Map<Integer, Student> students = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Student\n2. View All\n3. Search\n4. Update\n5. Delete\n6. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exited!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.put(id, new Student(id, name, age, course));
        System.out.println("Student added!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found!");
            return;
        }

        for (Student s : students.values()) {
            s.display();
        }
    }

    private static void searchStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Student s = students.get(id);
        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (students.containsKey(id)) {
            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new course: ");
            String course = sc.nextLine();

            students.put(id, new Student(id, name, age, course));
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        if (students.remove(id) != null) {
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}