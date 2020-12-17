package prototype.RegistrationHospitalSystem.Model;

import javax.persistence.*;

@Entity
@Table(name = "doctor_schedule")
public class DoctorSchedule {

    @Column(name = "doctor_id")
    private long doctorID;

    @Column(name = "date_time")
    private String dateTime;

    public DoctorSchedule() { }

    public DoctorSchedule(Long doctorID, String dateTime) {
        super();
        this.doctorID = doctorID;
        this.dateTime = dateTime;
    }
    public long getDoctorID() {
        return doctorID;
    }
    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
