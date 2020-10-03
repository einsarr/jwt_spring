package jwtspringsec.jwtspring.dao;

import jwtspringsec.jwtspring.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
