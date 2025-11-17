package com.example.billing.controller;

import com.example.billing.model.Bill;
import com.example.billing.repository.BillRepository;
import com.example.billing.feign.CustomerFeignClient;
import com.example.billing.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerFeignClient customerFeignClient;

    @Autowired
    private ProductFeignClient productFeignClient;

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        return ResponseEntity.ok(bills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent()) {
            Bill billData = bill.get();
            // Get customer info via Feign
            Object customer = customerFeignClient.getCustomer(billData.getCustomerId());
            return ResponseEntity.ok(billData);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        // Validate customer exists via Feign
        Object customer = customerFeignClient.getCustomer(bill.getCustomerId());
        if (customer == null) {
            return ResponseEntity.badRequest().build();
        }

        Bill saved = billRepository.save(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        Optional<Bill> existing = billRepository.findById(id);
        if (existing.isPresent()) {
            bill.setId(id);
            Bill updated = billRepository.save(bill);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        if (billRepository.existsById(id)) {
            billRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

