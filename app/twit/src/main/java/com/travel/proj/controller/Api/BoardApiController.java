package com.travel.proj.controller.Api;

import com.travel.proj.service.BoardService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    private final BoardService service;

    public BoardApiController(BoardService service){
        this.service = service;
    }



}
