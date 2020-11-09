package Hello.Hellospring.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // jpa가 관리하는 entity
public class Member {

    // pk?
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // identity-> db가 알아서 생성해줌
    private Long id;

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
