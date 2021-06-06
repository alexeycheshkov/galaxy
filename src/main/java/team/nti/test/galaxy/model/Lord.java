package team.nti.test.galaxy.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lords")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private int age;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lord", cascade = CascadeType.REFRESH)
    private List<Planet> planetsList;

    public Lord(Long id, String name, int age, List<Planet> planetsList) {
        Id = id;
        this.name = name;
        this.age = age;
        this.planetsList = planetsList;
    }
    public Lord(Long id, String name, int age) {
        Id = id;
        this.name = name;
        this.age = age;

    }

    public Lord() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public List<Planet> getPlanetsList() {
        return planetsList;
    }

    public void setPlanetsList(List<Planet> planetsList) {
        this.planetsList = planetsList;
    }
}
