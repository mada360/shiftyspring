package org.aworley.shifty.shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by adam on 16/02/17.
 */
@RestController
@RequestMapping("/shifts")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    public List getShifts(){
        return shiftService.getAllShifts();
    }

    @RequestMapping(method = POST)
    //@ResponseStatus(HttpStatus.CREATED)
    //@ResponseBody
    public Shift addShift(@RequestBody Shift shift){
        shiftService.addShift(shift);

        return shift;
        //return employee;
    }

}