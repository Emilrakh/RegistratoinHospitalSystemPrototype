package prototype.RegistrationHospitalSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.RegistrationHospitalSystem.Model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}