package com.koscom.sto_was.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class FepStatInfoDtoTOBE {
    FepStatCode fepStatCode;
    LocalDateTime firmAfirSrtDttm;
    LocalDateTime firmAfirEndNtcDttm;
    LocalDateTime firmAfirFltNotiDttm;
}
