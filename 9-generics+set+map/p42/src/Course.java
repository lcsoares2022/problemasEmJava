import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Course implements Comparable<Course>{
    private Integer id;
    private static Integer PROX_ID = 0;
    private String name;

    private Set<User> users;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
        this.users = new HashSet<>();
        this.id = PROX_ID++;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {

        if(user.getProfile() == Profile.INSTRUCTOR) {

            boolean hasAnInstructor = this.getUsers().stream().anyMatch(x -> x.getProfile() == Profile.INSTRUCTOR);

            if(hasAnInstructor)
                throw new IllegalArgumentException("O curso já possui um professor cadastrado!");
        }

        this.users.add(user);
    }


    @Override
    public int compareTo(Course other) {
        return name.toUpperCase().compareTo(other.getName().toUpperCase());
    }



}
