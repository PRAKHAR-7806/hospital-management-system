package com.hospital.hms.controller;

import com.hospital.hms.model.BaseEntity;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class CrudController<T extends BaseEntity> {

    protected final JpaRepository<T, Integer> repository;

    protected CrudController(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<T> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<T> getOne(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T entity) {
        entity.setId(null);
        return ResponseEntity.status(201).body(repository.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Integer id,
                                    @Valid @RequestBody T entity) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        entity.setId(id);
        return ResponseEntity.ok(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}