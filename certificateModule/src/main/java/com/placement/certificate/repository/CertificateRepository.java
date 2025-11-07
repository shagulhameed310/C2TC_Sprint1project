package com.placement.certificate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.certificate.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}