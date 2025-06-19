package com.koscom.sto_was.vo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FepStatCode implements CmnCodeEnum {
    FIRM_AFIR_SRT("F101", "이용사 업무개시(재개시포함)"),
    FIRM_AFIR_END_NTC("F102", "이용사 업무종료예고"),
    FIRM_AFIR_END("F103", "이용사 업무종료"),
    FIRM_FLT_NOTI("F111", "이용사 장애통지"),
    FIRM_FLT_RECOV_NOTI("F112", "이용사 장애복구통지"),
    STO_FLT_NOTI("S111", "STO 장애통지"),
    STO_FLT_RECOV_NOTI("S112", "STO 장애복구통지"),;

    private final String code;
    private final String name;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
