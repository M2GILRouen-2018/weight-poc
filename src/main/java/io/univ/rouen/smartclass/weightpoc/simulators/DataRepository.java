package io.univ.rouen.smartclass.weightpoc.simulators;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, Long> {
}
