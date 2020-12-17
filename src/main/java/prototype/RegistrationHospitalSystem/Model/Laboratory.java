package prototype.RegistrationHospitalSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "laboratory_name")
    private String laboratoryName;

    public Laboratory() { }

    public Laboratory(String laboratoryName) {
        super();
        this.laboratoryName = laboratoryName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }
    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }
}
