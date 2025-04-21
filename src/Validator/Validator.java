package Validator;

import exceptions.InvalidException;

public interface Validator {

    void validate(String str) throws InvalidException;
}
