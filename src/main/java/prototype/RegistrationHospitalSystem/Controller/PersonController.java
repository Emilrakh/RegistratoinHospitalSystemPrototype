package prototype.RegistrationHospitalSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prototype.RegistrationHospitalSystem.Exception.ResourceNotFoundException;
import prototype.RegistrationHospitalSystem.Model.Doctor;
import prototype.RegistrationHospitalSystem.Model.Patient;
import prototype.RegistrationHospitalSystem.Model.Registrar;
import prototype.RegistrationHospitalSystem.Repository.DoctorRepository;
import prototype.RegistrationHospitalSystem.Repository.PatientRepository;
import prototype.RegistrationHospitalSystem.Repository.RegistrarRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/prototype/")
public class PersonController {

    final
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RegistrarRepository registrarRepository;

    public PersonController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @RequestMapping("/")
    String home() {
        return "<h1>Welcome to Registrar Clinic System</h1>";
    }

    //Doctors

    @GetMapping("/doctors") // get all doctors
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @PostMapping("/doctors") // create doctors
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @GetMapping("/doctors/{id}") // get doctor by id
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) throws ResourceNotFoundException {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
        return ResponseEntity.ok(doctor);
    }

    @PutMapping("/doctors/{id}") // update doctor
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) throws ResourceNotFoundException {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));

        doctor.setFirstName(doctorDetails.getFirstName());
        doctor.setLastName(doctorDetails.getLastName());
        doctor.setGender(doctorDetails.getGender());
        doctor.setBirthDate(doctorDetails.getBirthDate());
        doctor.setHomeAddress(doctorDetails.getHomeAddress());
        doctor.setSpeciality(doctorDetails.getSpeciality());
        doctor.setQualification(doctorDetails.getQualification());

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/doctors/{id}") // delete doctor
    public ResponseEntity<Map<String, Boolean>> deleteDoctor(@PathVariable Long id) throws ResourceNotFoundException {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));

        doctorRepository.delete(doctor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

//    Registrar

//    @GetMapping("/registrars") // get all registrar
//    public List<Registrar> getAllRegistrars(){
//        return registrarRepository.findAll();
//    }
//
//    @PostMapping("/registrars") // create registrar
//    public Registrar createRegistrar(@RequestBody Registrar registrar) {
//        return registrarRepository.save(registrar);
//    }
//
//    @GetMapping("/registrars/{id}") // get registrar by id
//    public ResponseEntity<Registrar> getRegistrarById(@PathVariable Long id) throws ResourceNotFoundException {
//        Registrar registrar = registrarRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Registrar not exist with id :" + id));
//        return ResponseEntity.ok(registrar);
//    }
//
//    @PutMapping("/registrars/{id}") // update registrar
//    public ResponseEntity<Registrar> updateRegistrar(@PathVariable Long id, @RequestBody Registrar patientDetails) throws ResourceNotFoundException {
//        Registrar registrar = registrarRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Registrar not exist with id :" + id));
//
//        registrar.setFirstName(patientDetails.getFirstName());
//        registrar.setLastName(patientDetails.getLastName());
//        registrar.setGender(patientDetails.getGender());
//
//        Registrar updatedRegistrar = registrarRepository.save(registrar);
//        return ResponseEntity.ok(updatedRegistrar);
//    }
//
//    @DeleteMapping("/registrars/{id}") // delete registrar
//    public ResponseEntity<Map<String, Boolean>> deleteRegistrar(@PathVariable Long id) throws ResourceNotFoundException {
//        Registrar registrar = registrarRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Registrar not exist with id :" + id));
//
//        registrarRepository.delete(registrar);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }

    //Patient

    @GetMapping("/patients") // get all patients
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @PostMapping("/patients") // create patients
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/patients/{id}") // get patient by id
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/patients/{id}") // update doctor
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));

        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setGender(patientDetails.getGender());
        patient.setBirthDate(patientDetails.getBirthDate());
        patient.setHomeAddress(patientDetails.getHomeAddress());
        patient.setNationalInsuranceNumber(patientDetails.getNationalInsuranceNumber());
        patient.setPasportNumber(patientDetails.getPasportNumber());
        patient.setPasportSeries(patientDetails.getPasportSeries());
        patient.setAllergies(patientDetails.getAllergies());
        patient.setPrescriptions(patientDetails.getPrescriptions());
        patient.setChronicDisease(patientDetails.getChronicDisease());

        Patient updatedPatient = patientRepository.save(patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/patients/{id}") // delete doctor
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));

        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


//    //Doctors
//
//    @RequestMapping("/doctors")
//    List<Doctor> showAllDoctors(){
//        List<Doctor> listAllDoctors = new ArrayList<>();
//        listAllDoctors = service.showAllDoctors();
//        return listAllDoctors;
//    }
//
//    @RequestMapping("/doctors/viewByName/{name}")
//    List<Map<String, Object>> doctorViewByName(@PathVariable("name") String name ) {
//        return service.searchDoctorByName(name);
//    }
//
//    @RequestMapping("/doctors/viewById/{id}")
//    Doctor doctorViewById(@PathVariable("id") long id) {
//        return service.searchDoctorById(id);
//    }
//
//    @RequestMapping(value="/doctors/addDoctor",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    void addDoctor(@RequestBody Doctor doctor) throws Exception{
//        service.createDoctor(doctor);
//    }
//
//    @RequestMapping(value="/doctors/updateDoctor/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value=HttpStatus.OK)
//    void updateDoctor(@PathVariable("id") long id, @RequestBody Doctor doctor) throws Exception{
//        doctor.setId(id);
//        service.updateDoctor(doctor);
//    }
//
//    @RequestMapping(value="/doctors/deleteDoctor/{id}",method=RequestMethod.DELETE)
//    @ResponseStatus(value=HttpStatus.OK)
//    void deleteDoctor(@PathVariable("id") long id)throws Exception{
//        service.deleteDoctor(id);
//    }
//
//    //Patients
//
//    @RequestMapping("/patients")
//    List<Patient> showAllPatients(){
//        List<Patient> listAllPatients= new ArrayList<Patient>();
//        listAllPatients=service.showAllPatients();
//        return listAllPatients;
//    }
//
//    @RequestMapping("/patients/viewByName/{name}")
//    List<Map<String, Object>> patientViewByName(@PathVariable("name") String name ) {
//        return service.searchPatientByName(name);
//    }
//
//    @RequestMapping("/patients/viewById/{id}")
//    Patient patientViewById(@PathVariable("id") long id) {
//        return service.searchPatientById(id);
//    }
//
//    @RequestMapping(value="/patients/addPatient",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    void addPatient(@RequestBody Patient patient) throws Exception{
//        service.createPatient(patient);
//    }
//
//    @RequestMapping(value="/patients/updatePatient/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value=HttpStatus.OK)
//    void updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) throws Exception{
//        patient.setId(id);
//        service.updatePatient(patient);
//    }
//
//    @RequestMapping(value="/patients/deletePatient/{id}",method=RequestMethod.DELETE)
//    @ResponseStatus(value=HttpStatus.OK)
//    void deletePatient(@PathVariable("id") long id)throws Exception{
//        service.deletePatient(id);
//    }
}
