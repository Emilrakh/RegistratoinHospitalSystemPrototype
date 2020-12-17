package prototype.RegistrationHospitalSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prototype.RegistrationHospitalSystem.Repository.*;

import prototype.RegistrationHospitalSystem.Exception.ResourceNotFoundException;
import prototype.RegistrationHospitalSystem.Model.Doctor;
import prototype.RegistrationHospitalSystem.Model.Patient;
import prototype.RegistrationHospitalSystem.Model.Registrar;
import prototype.RegistrationHospitalSystem.Model.Appointment;
import prototype.RegistrationHospitalSystem.Model.Laboratory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/prototype/")
public class AppointmentController {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RegistrarRepository registrarRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Autowired
    DoctorScheduleRepository doctorScheduleRepository;

    public AppointmentController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public AppointmentController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public AppointmentController(RegistrarRepository registrarRepository) {
        this.registrarRepository = registrarRepository;
    }

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentController(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    @RequestMapping("/")
    String home() {
        return "<h1>Welcome to Registrar Hospital System | Appointment</h1>";
    }

    @GetMapping("/appointments") // get all appointments
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    @PostMapping("/appointments") // create appointments
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/appointments/{id}") // get appointment by id
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not exist with id :" + id));
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/appointments/{id}") // update appointment
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not exist with id :" + id));

        appointment.setPatientId(appointmentDetails.getPatientId());
        appointment.setDoctorId(appointmentDetails.getDoctorId());
        appointment.setLaboratoryId(appointmentDetails.getLaboratoryId());
        appointment.setDateRecord(appointmentDetails.getDateRecord());
        appointment.setReceptionDescription(appointmentDetails.getReceptionDescription());

        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/appointments/{id}") // delete appointment
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not exist with id :" + id));

        appointmentRepository.delete(appointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
