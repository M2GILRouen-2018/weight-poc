package io.univ.rouen.smartclass.weightpoc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.univ.rouen.smartclass.weightpoc.entities.ClassroomUserHistoric;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CHURepository extends MongoRepository<ClassroomUserHistoric, Long> {
    ClassroomUserHistoric findByClassroomId(Long id);
    List<ClassroomUserHistoric> findAllByClassroomId(Long id);
}
