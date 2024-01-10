import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Profile profile;
    private Set<Course> courses;

    public User() {
    }

    /**
     * Construtor de usuário que além de setar os atributos com os devidos valores passados como argumento também
     * inicializa a lista de cursos utilizando a implementação TreeSet que aplica ordem natural com base no método
     * compareTo da interface Comparable.
     * @param id
     * @param username
     * @param password
     * @param profile
     */
    public User(Integer id, String username, String password, Profile profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.id = id;
        this.courses = new TreeSet<Course>();
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        this.courses.add(course);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
