package io.egen.training.controller;

import io.egen.training.entity.Alerts;
import io.egen.training.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Alerts controller provides methods
* findAll to find all alerts in database
* findAlertsByVin to find a vehicles alerts
* */
@CrossOrigin
@RestController
public class AlertsController {

    @Autowired
    private AlertsService alertsService;

    /*
    * return list of all alerts in database
    * */
    @RequestMapping(method = RequestMethod.GET, value = "/alerts")
    public List<Alerts> findAll() {
        return alertsService.findAll();
    }

    /*
    * takes path variable VIN
    * returns list of alerts associated to that VIN
    * */
    @RequestMapping(method = RequestMethod.GET, value = "/alerts/{vin}")
    public List<Alerts> findAlertsByVin(@PathVariable("vin") String vin) {
        return alertsService.findAllByVin(vin);
    }
}
