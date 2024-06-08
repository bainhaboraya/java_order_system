package com.order.order_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

    @Modifying
    @Transactional
    @Query("update #{#entityName} t set t.statusCode = :statusCode where t.id = :id")
    void updateStatus(@Param("id") ID id, @Param("statusCode") Integer statusCode);
}
