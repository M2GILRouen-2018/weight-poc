package io.univ.rouen.smartclass.weightpoc;

import io.univ.rouen.smartclass.weightpoc.entities.ClassroomUserHistoric;
import io.univ.rouen.smartclass.weightpoc.entities.TimeSlot;
import io.univ.rouen.smartclass.weightpoc.repositories.CHURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class WeightPocApplication implements CommandLineRunner {

	@Autowired
	private CHURepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WeightPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		ClassroomUserHistoric class1 = new ClassroomUserHistoric();
		ClassroomUserHistoric class2 = new ClassroomUserHistoric();

		class1.setClassroomId(1L);
		class1.setDate(new Date());
		class1.setTimeSlot(new TimeSlot());
		class1.setUserId(1L);

		class2.setClassroomId(2L);
		class2.setDate(new Date());
		class2.setTimeSlot(new TimeSlot());
		class2.setUserId(2L);

		repository.save(class1);
		repository.save(class2);

		System.out.println("Find All");
		System.out.println("-------------------------------");
		for (ClassroomUserHistoric classrooms : repository.findAll()) {
			System.out.println(classrooms);
		}
		System.out.println();

		System.out.println("Find All By ID 1L");
		System.out.println("--------------------------------");
		System.out.println(repository.findAllByClassroomId(1L));

		System.out.println("Find One by ID 2L");
		System.out.println("--------------------------------");
		System.out.println(repository.findByClassroomId(2L));

	}
}
