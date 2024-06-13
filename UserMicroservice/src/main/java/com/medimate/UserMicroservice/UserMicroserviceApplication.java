package com.medimate.UserMicroservice;

import com.medimate.UserMicroservice.enums.Gender;
import com.medimate.UserMicroservice.interceptor.SystemEventsInterceptor;
import com.medimate.UserMicroservice.models.*;
import com.medimate.UserMicroservice.repositories.AdminRepository;
import com.medimate.UserMicroservice.repositories.DoctorRepository;
import com.medimate.UserMicroservice.repositories.PatientRepository;
import com.medimate.UserMicroservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

	@Bean
	public SystemEventsInterceptor customInterceptor(){return new SystemEventsInterceptor();}

//	CommandLineRunner runner(UserRepository userRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, AdminRepository adminRepository) {
//		return args -> {
//			// Seed Users
//			List<User> users = new ArrayList<>();
//			users.add(new User(1,"Jane", "Smith", "jane.smith@example.com", "password", Role.PATIENT));
//			users.add(new User(2, "Michael", "Johnson", "michael.johnson@example.com", "password", Role.PATIENT));
//			users.add(new User(3, "Emily", "Williams", "emily.williams@example.com", "password", Role.PATIENT));
//			users.add(new User(4, "Emilyyyy", "Williams", "emilyyy.williams@example.com", "password", Role.PATIENT));
//			users.add(new User(5, "David", "Brown","david.brown@example.com", "password", Role.PATIENT));
//			users.add(new User(6, "Jessica", "Jones", "jessica.jones@example.com", "password", Role.PATIENT));
//			users.add(new User(7, "Robert", "Taylor", "robert.taylor@example.com", "password", Role.DOCTOR));
//			users.add(new User(8, "Olivia", "Miller","olivia.miller@example.com", "password", Role.DOCTOR));
//			users.add(new User(9, "Robert","Taylor","robert.taylor@example.com", "password", Role.DOCTOR));
//			users.add(new User(10, "William","Anderson","william.anderson@example.com", "password", Role.DOCTOR));
//			users.add(new User(11, "Sophia","Martinez","sophia.martinez@example.com", "password", Role.DOCTOR));
//			users.add(new User(12, "Nejla","Martinez","nejla.martinez@example.com", "password", Role.DOCTOR));
//			users.add(new User(13, "Esma","Martinez","esma.martinez@example.com", "password", Role.ADMIN));
//			userRepository.saveAll(users);
//
//			List<Patient> patients = new ArrayList<>();
//			patients.add(new Patient( LocalDate.of(1990, Month.JANUARY, 1), Gender.Female, "123 Main St", "555-1234", 1));
//			patients.add(new Patient(LocalDate.of(1985, Month.FEBRUARY, 2), Gender.Male, "456 Oak St", "555-5678", 2));
//			patients.add(new Patient(LocalDate.of(1992, Month.MARCH, 3), Gender.Female, "789 Pine St", "555-9101", 3));
//			patients.add(new Patient( LocalDate.of(1988, Month.APRIL, 4), Gender.Male, "321 Maple St", "555-1121", 5));
//			patients.add(new Patient( LocalDate.of(1995, Month.MAY, 5), Gender.Female, "654 Cedar St", "555-3141", 6));
//			patientRepository.saveAll(patients);
//
//			List<Doctor> doctors = new ArrayList<>();
//			doctors.add(new Doctor("Cardiologist", 7));
//			doctors.add(new Doctor("Dermatologist", 8));
//			doctors.add(new Doctor("Neurologist", 10));
//			doctors.add(new Doctor("Pediatrician", 11));
//			doctors.add(new Doctor( "Surgeon", 12));
//			doctorRepository.saveAll(doctors);
//
//			List<Admin> admins = new ArrayList<>();
//			admins.add(new Admin(13));
//			adminRepository.saveAll(admins);
//		};}

}
