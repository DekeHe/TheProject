package com.example.acccountmanagementsystem.repository;

import com.example.acccountmanagementsystem.entity.PosStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaPosStatusRepository extends JpaRepository<PosStatus,String>
{
    //
    @Query(value="select p.status from PosStatus as p where p.token=?1")
    String readStatusByToken(String token);
}
