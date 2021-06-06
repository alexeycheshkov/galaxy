package team.nti.test.galaxy.model;


import javax.persistence.*;

@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "lord_id", nullable = false)
    private Lord lord;

    public Planet(Long id, String name, Lord lord) {
        Id = id;
        this.name = name;
        this.lord = lord;
    }

    public Planet(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Planet() {
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

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }
}
