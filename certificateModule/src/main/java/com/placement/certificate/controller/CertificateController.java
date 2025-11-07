package com.placement.certificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.placement.certificate.entity.Certificate;
import com.placement.certificate.service.CertificateService;

import java.util.List;
import java.util.Optional;

@RestController
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // ✅ Get all certificates
    @GetMapping("/certificate")
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }


    @GetMapping("/certificate/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        Optional<Certificate> certificate = certificateService.getCertificateById(id);
        return certificate.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/certificate")
    public ResponseEntity<Certificate> createCertificate(@RequestBody Certificate certificate) {
        Certificate createdCertificate = certificateService.createCertificate(certificate);
        return ResponseEntity.ok(createdCertificate);
    }


    @PutMapping("/certificate/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable Long id, @RequestBody Certificate certificateDetails) {
        Optional<Certificate> certificateOptional = certificateService.getCertificateById(id);
        if (certificateOptional.isPresent()) {
            Certificate certificate = certificateOptional.get();
            certificate.setName(certificateDetails.getName());
            certificate.setIssuer(certificateDetails.getIssuer());
            certificate.setIssueDate(certificateDetails.getIssueDate());
            certificate.setExpiryDate(certificateDetails.getExpiryDate());
            Certificate updatedCertificate = certificateService.updateCertificate(certificate);
            return ResponseEntity.ok(updatedCertificate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Delete certificate
    @DeleteMapping("/certificate/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
        return ResponseEntity.noContent().build();
    }
}
