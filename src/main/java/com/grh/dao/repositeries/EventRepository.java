package com.grh.dao.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grh.model.entities.Evenement;

public interface EventRepository extends JpaRepository<Evenement, Long> {

}
