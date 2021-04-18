package com.bruno.hrworker.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bruno.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
