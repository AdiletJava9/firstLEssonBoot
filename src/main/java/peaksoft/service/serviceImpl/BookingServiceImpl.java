//package peaksoft.service.serviceImpl;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import peaksoft.entity.Booking;
//import peaksoft.repository.BookingRepository;
//import peaksoft.service.BookingService;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class BookingServiceImpl implements BookingService {
//
//    private final BookingRepository bookingRepository;
//
//    @Override
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//}
