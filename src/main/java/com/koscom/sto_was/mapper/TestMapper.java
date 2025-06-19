package com.koscom.sto_was.mapper;

import com.koscom.sto_was.vo.FepStatInfoDtoASIS;
import com.koscom.sto_was.vo.FepStatInfoDtoTOBE;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    FepStatInfoDtoASIS selectFepStatInfoASIS();

    FepStatInfoDtoTOBE selectFepStatInfoTOBE();
}
