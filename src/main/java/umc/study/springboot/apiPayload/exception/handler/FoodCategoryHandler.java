package umc.study.springboot.apiPayload.exception.handler;

import umc.study.springboot.apiPayload.code.BaseErrorCode;
import umc.study.springboot.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
