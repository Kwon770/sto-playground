package com.koscom.sto_was.controller;

import com.koscom.sto_was.service.FepStatInfoResVo;
import com.koscom.sto_was.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/fep/stat")
    public FepStatInfoResVo getFepStatInfo() {
        return testService.getFepStatInfoTOBE();
    }
}
