package hiago.com.passin.services;

import hiago.com.passin.domain.attendee.Attendee;
import hiago.com.passin.domain.checkin.CheckIn;
import hiago.com.passin.dto.attendee.AttendeeDetails;
import hiago.com.passin.dto.attendee.AttendeesListResponseDTO;
import hiago.com.passin.repositories.AttendeeRepository;
import hiago.com.passin.repositories.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final CheckinRepository checkinRepository;
    public List<Attendee> getALlAttendeesFromEvent(String eventId){
        return this.attendeeRepository.findByEventId(eventId);

    }
public AttendeesListResponseDTO getEventsAttendee(String eventId){
        List<Attendee> attendeeList= this.getALlAttendeesFromEvent(eventId);

        List<AttendeeDetails> attendeeDetailsList= attendeeList.stream()
                .map(attendee -> {
                    Optional<CheckIn> checkIn= this.checkinRepository.findByAttendeeId(attendee.getId());
                    LocalDateTime checkedInAt= checkIn.isPresent() ? checkIn.get().getCreatedAt() : null;
                    return new AttendeeDetails(
                            attendee.getId(),
                            attendee.getName(),
                            attendee.getEmail(),
                            attendee.getCreatedAt(),
                            checkedInAt
                    );
                }).toList();
        return new AttendeesListResponseDTO(attendeeDetailsList);
}

}
