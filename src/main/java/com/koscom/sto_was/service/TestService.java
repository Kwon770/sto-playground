package com.koscom.sto_was.service;

import com.koscom.sto_was.mapper.TestMapper;
import com.koscom.sto_was.vo.FepStatInfoDtoASIS;
import com.koscom.sto_was.vo.FepStatInfoDtoTOBE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestMapper testMapper;

    public FepStatInfoResVo getFepStatInfoASIS() {
        FepStatInfoDtoASIS fepStatInfoDtoASIS = testMapper.selectFepStatInfoASIS();

        String statCode = fepStatInfoDtoASIS.feqStatCode();
        String statName = "";
        if (statCode.equals("F101")) {
            statName = "이용사 업무개시(재개시포함)";
        } else if (statCode.equals("F102")) {
            statName = "이용사 업무종료예고";
        } else if (statCode.equals("F103")) {
            statName = "이용사 업무종료";
        } else if (statCode.equals("F111")) {
            statName = "이용사 장애통지";
        } else if (statCode.equals("F112")) {
            statName = "이용사 장애복구통지";
        } else if (statCode.equals("S111")) {
            statName = "STO 장애통지";
        } else if (statCode.equals("S112")) {
            statName = "STO 장애복구통지";
        }

        return FepStatInfoResVo.builder()
                .fepStatCode(fepStatInfoDtoASIS.feqStatCode())
                .fepStatName(statName)
                .build();
    }

    public FepStatInfoResVo getFepStatInfoTOBE() {
        FepStatInfoDtoTOBE fepStatInfoDtoTOBE = testMapper.selectFepStatInfoTOBE();

        return FepStatInfoResVo.builder()
                .fepStatCode(fepStatInfoDtoTOBE.getFepStatCode().getCode())
                .fepStatName(fepStatInfoDtoTOBE.getFepStatCode().getName() + "--TOBE")
                .build();
    }
}
