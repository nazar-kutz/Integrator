package vn7.studio.com.integrator.exception;

public class FillFieldException extends RuntimeException {
    public FillFieldException(int message) {
        super(String.valueOf(message));
    }
}
