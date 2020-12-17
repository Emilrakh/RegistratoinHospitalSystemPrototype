package prototype.RegistrationHospitalSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.RegistrationHospitalSystem.Model.Laboratory;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

}
