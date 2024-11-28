package umc.study.springboot.apiPayload.exception.handler;

import umc.study.springboot.apiPayload.code.BaseErrorCode;
import umc.study.springboot.apiPayload.exception.GeneralException;

public class ErrorHandler extends GeneralException {

    public ErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
