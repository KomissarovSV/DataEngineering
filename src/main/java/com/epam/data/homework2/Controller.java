package com.epam.data.homework2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final ComplainService complainService;

    @GetMapping("load")
    public void load() throws IOException {
        complainService.loadData();
    }
}
