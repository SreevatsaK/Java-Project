package com.example.elearning.service;

import com.example.elearning.model.Certification;
import com.example.elearning.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    public Certification issueCertificate(String userId, String courseId) {
        Certification c = new Certification();
        String id = "CERT" + UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
        c.setCertificateId(id);
        c.setUserId(userId);
        c.setCourseId(courseId);
        c.setIssueDate(LocalDate.now());
        c.setCertificateCode(courseId + "-" + id);
        return certificationRepository.save(c);
    }

    public List<Certification> getCertificatesForUser(String userId) {
        return certificationRepository.findByUserId(userId);
    }
}
