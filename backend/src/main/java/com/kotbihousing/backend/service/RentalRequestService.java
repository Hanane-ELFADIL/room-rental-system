package com.kotbihousing.backend.service;

import com.kotbihousing.backend.dto.RentalRequestDTO;
import com.kotbihousing.backend.dto.RentalRequestResponse;
import com.kotbihousing.backend.model.RentalRequest;
import com.kotbihousing.backend.model.RentalRequest.RequestStatus;
import com.kotbihousing.backend.model.Room;
import com.kotbihousing.backend.model.User;
import com.kotbihousing.backend.repository.RentalRequestRepository;
import com.kotbihousing.backend.repository.RoomRepository;
import com.kotbihousing.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalRequestService {

    private static final Logger log = LoggerFactory.getLogger(RentalRequestService.class);

    private final RentalRequestRepository requestRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public RentalRequestService(RentalRequestRepository r,
                                RoomRepository ro,
                                UserRepository u) {
        this.requestRepository = r;
        this.roomRepository = ro;
        this.userRepository = u;
    }

    public RentalRequestResponse createRequest(RentalRequestDTO dto, Long studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée"));

        log.info("==> Création demande: studentId={}, roomId={}, room.ownerId={}",
                studentId, room.getId(), room.getOwnerId());

        RentalRequest req = new RentalRequest();
        req.setStudent(student);
        req.setRoom(room);
        req.setStudentName(dto.getStudentName());
        req.setStudentEmail(dto.getStudentEmail());
        req.setStudentPhone(dto.getStudentPhone());
        req.setMoveInDate(dto.getMoveInDate());
        req.setDuration(dto.getDuration());
        req.setMessage(dto.getMessage());
        req.setStatus(RequestStatus.PENDING);

        return toResponse(requestRepository.save(req));
    }

    public List<RentalRequestResponse> getRequestsForOwner(Long ownerId) {
        List<RentalRequest> results = requestRepository.findByRoom_OwnerId(ownerId);
        log.info("==> getRequestsForOwner(ownerId={}) => {} résultats", ownerId, results.size());
        return results.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public RentalRequestResponse updateStatus(Long id, RequestStatus status) {
        RentalRequest req = requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
        req.setStatus(status);
        return toResponse(requestRepository.save(req));
    }

    public List<RentalRequestResponse> getRequestsByStudent(Long studentId) {
        return requestRepository.findByStudent_Id(studentId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    private RentalRequestResponse toResponse(RentalRequest r) {
        RentalRequestResponse res = new RentalRequestResponse();
        res.setId(r.getId());
        res.setRoomId(r.getRoom().getId());
        res.setRoomTitle(r.getRoom().getTitle());
        res.setStudentId(r.getStudent().getId());
        res.setOwnerId(r.getRoom().getOwnerId());
        res.setStudentName(r.getStudentName());
        res.setStudentEmail(r.getStudentEmail());
        res.setStudentPhone(r.getStudentPhone());
        res.setMoveInDate(r.getMoveInDate());
        res.setDuration(r.getDuration());
        res.setMessage(r.getMessage());
        res.setStatus(r.getStatus());
        res.setCreatedAt(r.getCreatedAt());
        return res;
    }
}