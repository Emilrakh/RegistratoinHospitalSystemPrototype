package prototype.RegistrationHospitalSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prototype.RegistrationHospitalSystem.Model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
//    @Query("select * from public.patient first_name where first_name.name = :name")
//    Patient  findByName(@Param("name") String name);
}
