package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.Calendar;
import tml.centralapi.validatormain.repository.CalendarRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CalendarController {
    @Autowired
    CalendarRepository calendarRepository;

    @GetMapping("/calendar/{id}")
    HttpEntity<List<Calendar>> get(@PathVariable String id) throws Exception {
        try {
            List<Calendar> list = calendarRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/calendar")
    public Calendar create(@Valid @RequestBody Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @PutMapping("/calendar/{id}")
    public ResponseEntity<Calendar> update(@PathVariable(value = "id") String id,
                                           @Valid @RequestBody Calendar details) throws Exception {
        try {
            Calendar calendar = calendarRepository.findByServiceId(id);
            calendar.setServiceId(details.getServiceId());
            calendar.setCalendarName(details.getCalendarName());
            calendar.setPeriod(details.getPeriod());
            calendar.setMonday(details.getMonday());
            calendar.setTuesday(details.getTuesday());
            calendar.setWednesday(details.getWednesday());
            calendar.setThursday(details.getThursday());
            calendar.setFriday(details.getFriday());
            calendar.setSaturday(details.getSaturday());
            calendar.setSunday(details.getSunday());
            calendar.setStartDate(details.getStartDate());
            calendar.setEndDate(details.getEndDate());
            final Calendar updatedCalendar = calendarRepository.save(calendar);
            return ResponseEntity.ok(updatedCalendar);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/calendar/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
            throws Exception {
        Calendar calendar = calendarRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        calendarRepository.delete(calendar);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
