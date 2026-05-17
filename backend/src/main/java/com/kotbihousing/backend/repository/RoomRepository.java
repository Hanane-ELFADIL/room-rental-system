package com.kotbihousing.backend.repository;

import java.util.List;
import com.kotbihousing.backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByOwnerId(Long ownerId);

}