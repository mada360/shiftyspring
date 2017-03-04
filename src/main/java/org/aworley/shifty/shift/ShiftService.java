package org.aworley.shifty.shift;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adam on 13/02/17.
 */
@Service
public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;


    public List<Shift> getAllShifts() {
        List<Shift> shifts = new ArrayList<>();
        shiftRepository.findAll().forEach(shifts::add);
        return shifts;
    }

    public void addShift(Shift shift) {
        shiftRepository.save(shift);
    }


    public String getShift(){
        return "This";
    }
}
