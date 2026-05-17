package com.kotbihousing.backend.repository;

import com.kotbihousing.backend.model.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RentalRequestRepository extends JpaRepository<RentalRequest, Long> {

    @Query(value = "SELECT rr.* FROM rental_requests rr JOIN rooms r ON rr.room_id = r.id WHERE r.owner_id = :ownerId", nativeQuery = true)
    List<RentalRequest> findByRoom_OwnerId(@Param("ownerId") Long ownerId);

    List<RentalRequest> findByStudent_Id(Long studentId);
}