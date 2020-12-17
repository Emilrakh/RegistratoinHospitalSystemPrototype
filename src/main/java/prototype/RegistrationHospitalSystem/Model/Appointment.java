package prototype.RegistrationHospitalSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "doctor_id")
    private long doctorId;

    @Column(name = "laboratory_id")
    private long laboratoryId;

    @Column(name = "date_record")
    private String dateRecord;

    @Column(name = "reception description")
    private String receptionDescription;

    public Appointment() { }

    public Appointment(long patientId, long doctorId, long laboratoryId, String dateRecord, String ward) {
        super();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.laboratoryId = laboratoryId;
        this.dateRecord = dateRecord;
        this.receptionDescription = receptionDescription;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getLaboratoryId() {
        return laboratoryId;
    }
    public void setLaboratoryId(long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getDateRecord() {
        return dateRecord;
    }
    public void setDateRecord(String dateRecord) {
        this.dateRecord = dateRecord;
    }

    public String getReceptionDescription() { return receptionDescription; }
    public void setReceptionDescription(String receptionDescription) {
        this.receptionDescription = receptionDescription;
    }
}
