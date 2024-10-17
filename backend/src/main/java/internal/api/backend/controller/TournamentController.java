package internal.api.backend.controller;

import internal.api.backend.utils.NameUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/tournaments")
public class TournamentController {

    @GetMapping
    public void test(){
        NameUtils.generateNames(1);
    }
}
