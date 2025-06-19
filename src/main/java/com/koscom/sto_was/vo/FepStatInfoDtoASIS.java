package com.koscom.sto_was.vo;

import java.time.LocalDateTime;

public record FepStatInfoDtoASIS(
        String feqStatCode,
        LocalDateTime firmAfirSrtDttm,
        LocalDateTime firmAfirEndNtcDttm,
        LocalDateTime firmAfirFltNotiDttm
) {
}
