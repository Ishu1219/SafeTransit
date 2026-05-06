package com.cts.repository;

import com.cts.entity.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatcherRepository extends JpaRepository<Dispatcher, Long> {

    Dispatcher findByEmail(String email);

}