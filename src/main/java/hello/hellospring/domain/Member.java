package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity //JPA가 관리하는 entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; //system에서 저장하는 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}