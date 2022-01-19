package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.CalendarDates;
import tml.centralapi.validatormain.repository.CalendarDateRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CalendarDateController {
    @Autowired
    CalendarDateRepository calendarDateRepository;

    @GetMapping("/calendarDates/{id}")
    HttpEntity<List<CalendarDates>> get(@PathVariable String id) throws Exception {
        try {
            List<CalendarDates> list = calendarDateRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/calendarDates")
    public CalendarDates create(@Valid @RequestBody CalendarDates calendardate) {
        return calendarDateRepository.save(calendardate);
    }

    @PutMapping("/calendarDates/{id}")
    public ResponseEntity<CalendarDates> update(@PathVariable(value = "id") String id,
                                                @Valid @RequestBody CalendarDates details) throws Exception {
        try {
            CalendarDates calendarDate = calendarDateRepository.findByServiceId(id);
            calendarDate.setDate(details.getDate());
            calendarDate.setCalendarName(details.getCalendarName());
            calendarDate.setPeriod(details.getPeriod());
            calendarDate.setHoliday(details.getHoliday());
            calendarDate.setExceptionType(details.getExceptionType());
            calendarDate.setServiceId(details.getServiceId());
            final CalendarDates updatedCalendarDate = calendarDateRepository.save(calendarDate);
            return ResponseEntity.ok(updatedCalendarDate);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/calendarDates/{id}")
    public Map<String, Boolean> deleteCalendarDate(@PathVariable(value = "id") Long id)
            throws Exception {
        CalendarDates calendarDate = calendarDateRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        calendarDateRepository.delete(calendarDate);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
