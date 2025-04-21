package Validator;

import exceptions.InvalidTimeException;

public class TimeValidator implements Validator {
    @Override
    public void validate(String str) throws InvalidTimeException {
        String[] time =  str.split(":");

        if (time.length != 2)
            throw new InvalidTimeException("Invalid time format");
        if (Integer.parseInt(time[0]) > 23 || Integer.parseInt(time[0]) < 0)
            throw new InvalidTimeException("Invalid hour format");
        if (Integer.parseInt(time[1]) > 59 || Integer.parseInt(time[1]) < 0)
            throw new InvalidTimeException("Invalid minute format");
    }
}
