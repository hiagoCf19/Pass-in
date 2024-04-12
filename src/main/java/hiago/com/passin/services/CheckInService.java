package hiago.com.passin.services;

import hiago.com.passin.domain.attendee.Attendee;
import hiago.com.passin.domain.checkin.CheckIn;
import hiago.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsExeption;
import hiago.com.passin.repositories.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());

        CheckIn newCheckIn= new CheckIn();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());

        this.checkinRepository.save(newCheckIn);

    }
    public Optional<CheckIn> getCheckIn(String attendeeId){
        return this.checkinRepository.findByAttendeeId(attendeeId);
    }
    private void verifyCheckInExists(String attendeeId){
        Optional< CheckIn> isCheckedIn= this.getCheckIn(attendeeId);

        if(isCheckedIn.isPresent()) throw new CheckInAlreadyExistsExeption("The participant has already checked in!");

    }
}
