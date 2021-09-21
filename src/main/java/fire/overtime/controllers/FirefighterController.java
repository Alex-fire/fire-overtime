package fire.overtime.controllers;

import fire.overtime.commands.FirefighterSaveCommand;
import fire.overtime.commands.FirefighterUpdateCommand;
import fire.overtime.models.Firefighter;
import fire.overtime.repositories.FirefighterRepository;
import fire.overtime.services.FirefighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/firefighter")
public class FirefighterController {

    FirefighterService firefighterService;

    @Autowired
    FirefighterRepository firefighterRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Firefighter save(@RequestBody FirefighterSaveCommand firefighterSaveCommand) {
        //можно добавить валидацию чуть позже
        return firefighterService.saveFirefighter(firefighterSaveCommand);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Firefighter updateFirefighter(@RequestBody FirefighterUpdateCommand firefighterUpdateCommand) {
        //можно добавить валидацию чуть позже
        return firefighterService.updateFirefighter(firefighterUpdateCommand);
    }

    @DeleteMapping(value = "/{firefighterId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFirefighter(@PathVariable Integer firefighterId) {
        firefighterRepository.deleteById(firefighterId);
    }

    @GetMapping(value = "/{firefighterId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void getFirefighter(@PathVariable Integer firefighterId) {
        firefighterRepository.getById(firefighterId);
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Firefighter> all() {
        Firefighter firefighter = new Firefighter();
        firefighter.setLastName("kjjk");
        firefighter.setPatronymic("kij");
        return Arrays.asList(firefighter);
    }
//    @GetMapping(value = "/all", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public List getAllFirefighters() throws IOException {
////        return firefighterRepository.findAll();
//
//    }
}

