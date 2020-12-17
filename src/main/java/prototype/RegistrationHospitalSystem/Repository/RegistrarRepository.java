package prototype.RegistrationHospitalSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.RegistrationHospitalSystem.Model.Registrar;

@Repository
public interface RegistrarRepository extends JpaRepository<Registrar, Long>{

}