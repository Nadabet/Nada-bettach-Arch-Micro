package com.example.billing.repository;

import com.example.billing.model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillItemRepository extends JpaRepository<BillItem, Long> {
}

