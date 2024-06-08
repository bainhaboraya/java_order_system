package com.order.order_system.service;

import com.order.order_system.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T, ID> {

    @Autowired
    private BaseRepository<T, ID> baseRepository;

    public T save(T entity) {
        return baseRepository.save(entity);
    }

    public List<T> saveAll(Iterable<T> entities) {
        return baseRepository.saveAll(entities);
    }

    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }

    public boolean existsById(ID id) {
        return baseRepository.existsById(id);
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public List<T> findAllById(Iterable<ID> ids) {
        return baseRepository.findAllById(ids);
    }

    public List<T> findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    public long count() {
        return baseRepository.count();
    }

    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    public void delete(T entity) {
        baseRepository.delete(entity);
    }

    public void deleteAll(Iterable<? extends T> entities) {
        baseRepository.deleteAll(entities);
    }

    public void deleteAll() {
        baseRepository.deleteAll();
    }

    public void updateStatus(ID id, Integer statusCode) {
        baseRepository.updateStatus(id, statusCode);
    }
}
