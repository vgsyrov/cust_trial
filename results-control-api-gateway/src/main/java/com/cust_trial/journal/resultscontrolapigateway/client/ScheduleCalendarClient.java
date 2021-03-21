package com.cust_trial.journal.resultscontrolapigateway.client;

import com.cust_trial.journal.resultscontrolapigateway.Json.AutoAttendanceRequestBodyJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.EventAttendanceFactJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.EventJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${sc.service.name}", url = "${sc.service.url}")
@EnableAsync
public interface ScheduleCalendarClient {

    //EventController
    @GetMapping("/list")
    List<EventJson> getEventsList();

    @GetMapping("/findById/{id}")
    EventJson getEventById(@PathVariable String id);

    @GetMapping("/findByLessionId/{id}")
    List<EventJson> getEventsByLessionId(@PathVariable String id);

    //EventAttendanceFactController
    @GetMapping("/list_ea")
    List<EventAttendanceFactJson> getEventAttendanceFactList();

    @GetMapping("/findByEventId/{id}")
    EventAttendanceFactJson getById(@PathVariable String id);

    @GetMapping("/listByPersonId/{id}")
    List<EventAttendanceFactJson> getListByPersonId(@PathVariable String id);

    @PutMapping("/auto-attendance")
    void autoAttendance(@RequestBody AutoAttendanceRequestBodyJson body);
}
