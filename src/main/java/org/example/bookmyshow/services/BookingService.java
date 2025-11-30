package org.example.bookmyshow.services;

import org.example.bookmyshow.exception.BadRequestException;
import org.example.bookmyshow.model.Booking;
import org.example.bookmyshow.model.Show;
import org.example.bookmyshow.model.ShowSeat;
import org.example.bookmyshow.model.ShowSeatStatus;
import org.example.bookmyshow.repository.BookingRepository;
import org.example.bookmyshow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    /*
     * 1. Begin a transaction at isolation level -> serializable
     * 2. We try to fetch ShowSeat objects based on the showseatIds(present in BookTicketRequestDto).
     * 3. Validate that ids were valid, and we got same number of seats returned
     * == the ids mentioned in the request.
     * 4. Update the status of a show seat from available to blocked.
     * 5. Save that show seat.
     * 6. Close the transaction.
     * */

    public final ShowSeatRepository showSeatRepository;
    public final BookingRepository bookingRepository;

    @Autowired
    public BookingService(ShowSeatRepository showSeatRepository,BookingRepository bookingRepository) {
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(List<Long> showSeatIds){
           List<ShowSeat>showSeats = showSeatRepository.findAllById(showSeatIds);

           if(showSeats.size() != showSeatIds.size()){
               throw new BadRequestException();
           }

           for(ShowSeat showSeat : showSeats) {
               if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                   throw new BadRequestException("Seat not available");
               }

               showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
           }
           showSeatRepository.saveAll(showSeats);

           Show show = showSeats.get(0).getShow();
           Booking booking = Booking.builder()
                   .bookedAt(new Date())
                   .amount(12.0)
                   .showSeatList(showSeats)
                   .show(show)
                   .build();

           bookingRepository.save(booking);

          return booking;
    }
}
