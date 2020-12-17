package prototype.RegistrationHospitalSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "home_address")
    private String homeAddress;

    @Column(name = "national_insurance_number")
    private String nationalInsuranceNumber;

    @Column(name = "pasport_number")
    private String pasportNumber;

    @Column(name = "pasport_series")
    private String pasportSeries;

    @Column(name = "allergies")
    private String allergies;

    @Column(name = "prescriptions")
    private String prescriptions;

    @Column(name = "chronic_disease")
    private String chronicDisease;

    public Patient() { }

    public Patient(String firstName, String lastName, String gender, String birthDate, String homeAddress, String nationalInsuranceNumber, String pasportNumber, String pasportSeries, String allergies, String prescriptions, String chronicDisease) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.homeAddress = homeAddress;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
        this.pasportNumber = pasportNumber;
        this.pasportSeries = pasportSeries;
        this.allergies = allergies;
        this.prescriptions = prescriptions;
        this.chronicDisease = chronicDisease;
    }

    public long getId() {
        return id;
    }
    public void setId(long patientID) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }
    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber; }

    public String getPasportNumber() {
        return pasportNumber;
    }
    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public String getPasportSeries() {
        return pasportSeries;
    }
    public void setPasportSeries(String pasportSeries) {
        this.pasportSeries = pasportSeries;
    }

    public String getAllergies() {
        return allergies;
    }
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPrescriptions() {
        return prescriptions;
    }
    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }
    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }
}
