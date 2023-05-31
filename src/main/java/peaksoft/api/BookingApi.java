//package peaksoft.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import peaksoft.service.BookingService;
//import peaksoft.service.HouseService;
//
//@Controller
//@RequestMapping("/bookings")
//@RequiredArgsConstructor
//public class BookingApi {
//
//    private final BookingService bookingService;
//
//    private final HouseService houseService;
//
//    @GetMapping
//    public String getAllBookings(Model model) {
//        model.addAttribute("bookings", bookingService.getAllBookings());
//        return "Booking";
//    }
//    @GetMapping("/new")
//    public String newBooking(Model model) {
//        model.addAttribute("newBooking",houseService.getAllHouses());
//        return "newBooking";
//    }
//
//}
