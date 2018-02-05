package com.airbus.example.delegate.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: stevedavis
 * Date: 05/02/2018
 * Time: 19:10
 * Description:
 */
@Repository
public class GenericRepository<T, ID extends Serializable> implements JpaRepository<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repo;

    public <S extends T> S save(S s) {
        return this.repo.save(s);
    }

    public void deleteAll() {
        this.repo.deleteAll();
    }

    public <S extends T> boolean exists(Example<S> example) {
        return this.repo.exists(example);
    }

    public <S extends T> S saveAndFlush(S s) {
        return this.repo.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<T> iterable) {
        this.repo.deleteInBatch(iterable);
    }

    public void delete(Iterable<? extends T> iterable) {
        this.repo.delete(iterable);
    }

    public T findOne(ID id) {
        return this.repo.findOne(id);
    }

    public <S extends T> S findOne(Example<S> example) {
        return this.repo.findOne(example);
    }

    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return this.repo.findAll(example, pageable);
    }

    public boolean exists(ID id) {
        return this.repo.exists(id);
    }

    public <S extends T> List<S> save(Iterable<S> iterable) {
        return this.repo.save(iterable);
    }

    public T getOne(ID id) {
        return this.repo.getOne(id);
    }

    public void delete(T t) {
        this.repo.delete(t);
    }

    public List<T> findAll(Sort sort) {
        return this.repo.findAll(sort);
    }

    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return this.repo.findAll(example, sort);
    }

    public <S extends T> List<S> findAll(Example<S> example) {
        return this.repo.findAll(example);
    }

    public List<T> findAll(Iterable<ID> iterable) {
        return this.repo.findAll(iterable);
    }

    public void flush() {
        this.repo.flush();
    }

    public Page<T> findAll(Pageable pageable) {
        return this.repo.findAll(pageable);
    }

    public long count() {
        return this.repo.count();
    }

    public void deleteAllInBatch() {
        this.repo.deleteAllInBatch();
    }

    public List<T> findAll() {
        return this.repo.findAll();
    }

    public <S extends T> long count(Example<S> example) {
        return this.repo.count(example);
    }

    public void delete(ID id) {
        this.repo.delete(id);
    }
}
