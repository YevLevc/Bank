package com.solvd.laba.bank.exeptions;

public class PinCodeException extends RuntimeException {
    public PinCodeException() {
    }

    public PinCodeException(String message) {
        super(message);
    }

    public PinCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PinCodeException(Throwable cause) {
        super(cause);
    }

    public PinCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
