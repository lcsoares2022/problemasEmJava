import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Criar cursos
        Course courseA = new Course("A");
        Course courseB = new Course("B");
        Course courseC = new Course("C");

        // Criar professor
        User userTeacher = new User(0, "Alex", "123456", Profile.INSTRUCTOR);

        // Adicionar cursos a lista de cursos do professor
        userTeacher.addCourses(courseA);
        userTeacher.addCourses(courseB);
        userTeacher.addCourses(courseC);

        //Adicionar professor a lista de usuários do curso
        courseA.addUser(userTeacher);
        courseB.addUser(userTeacher);
        courseC.addUser(userTeacher);


        Set<User> users = generateStudents();
        Set<User> usersOfTeacher = new HashSet<>();
        for (Course course : userTeacher.getCourses()) {
            System.out.print("How many students for course " + course.getName() + ": ");
            int qtdStudents = sc.nextInt();

            for(int j = 0; j < qtdStudents; j++) {
                int idStudent = sc.nextInt();
                try{
                    User user = findById(idStudent, users);
                    course.addUser(user);
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            usersOfTeacher.addAll(course.getUsers());
        }

        System.out.println("Total students: " + (usersOfTeacher.size() - 1)); // remoção do professor





        sc.close();


    }

    public static User findById(int id, Set<User> users) throws Exception{
        User user = users.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(user == null)
            throw new Exception("Usuário não existe!");
        return user;
    }

    public static Set<User> generateStudents() {
        Set<User> users = new HashSet<>();
        User user21 = new User(21, "Guilherme", "123", Profile.STUDENT);
        users.add(user21);
        User user35 = new User(35, "Lucas", "321", Profile.STUDENT);
        users.add(user35);
        User user22 = new User(22, "Vitor", "789", Profile.STUDENT);
        users.add(user22);
        User user50 = new User(50, "Eduarda", "000", Profile.STUDENT);
        users.add(user50);
        User user42 = new User(42, "João", "543", Profile.STUDENT);
        users.add(user42);
        User user13 = new User(13, "Marlene", "876", Profile.STUDENT);
        users.add(user13);
        return users;
    }


}