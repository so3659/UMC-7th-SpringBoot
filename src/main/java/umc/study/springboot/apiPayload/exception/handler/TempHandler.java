package umc.study.springboot.apiPayload.exception.handler;

import umc.study.springboot.apiPayload.code.BaseErrorCode;
import umc.study.springboot.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}