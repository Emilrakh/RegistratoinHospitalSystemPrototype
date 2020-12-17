package prototype.RegistrationHospitalSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.RegistrationHospitalSystem.Model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
