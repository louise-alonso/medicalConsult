package br.com.louise.medicalconsult.exception;

public class ExceptionDataIntegrityViolation extends RuntimeException {
    public ExceptionDataIntegrityViolation(String message) {
        super(message);
    }
}

