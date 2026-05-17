package com.kotbihousing.backend.service;

import com.kotbihousing.backend.model.Room;
import com.kotbihousing.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }
    // ← NOUVEAU : Chambres d'un owner spécifique
    public List<Room> getRoomsByOwnerId(Long ownerId) {
        return roomRepository.findByOwnerId(ownerId);
    }


    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
    

    public Room updateRoom(Long id, Room roomDetails) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        room.setTitle(roomDetails.getTitle());
        room.setDescription(roomDetails.getDescription());
        room.setPrice(roomDetails.getPrice());
        room.setLocation(roomDetails.getLocation());
        room.setImageUrl(roomDetails.getImageUrl());
        room.setAvailable(roomDetails.getAvailable());
        room.setType(roomDetails.getType());
        room.setCapacity(roomDetails.getCapacity());
        room.setSurface(roomDetails.getSurface());
        room.setAmenities(roomDetails.getAmenities());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}