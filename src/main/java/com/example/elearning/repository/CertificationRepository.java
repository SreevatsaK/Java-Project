package com.example.elearning.repository;

import com.example.elearning.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification, String> {

    List<Certification> findByUserId(String userId);
}
