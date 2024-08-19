package com.alkozlov.microSOne.controller;

import com.alkozlov.microSOne.DTO.CatDTO;
import com.alkozlov.microSOne.entity.Cat;
import com.alkozlov.microSOne.repository.CatRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MainController {

//   @Autowired
   private final ObjectMapper objectMapper;

//    @Autowired
    private final CatRepo catRepo;



//    @GetMapping("/api/main")
//    public String mainListener() {
//        return "Hello from Main Listener";
//    }

//   @GetMapping("/api/cat")
//    public String giveCat() {
//        String jsonData = null;
//        Cat cat = new Cat("Barsik", 5, 8);
//        try {
//            jsonData = objectMapper.writeValueAsString(cat);
//        } catch (JsonProcessingException e) {
//            jsonData = e.getMessage();
//        }
//        return jsonData;
//    }

//    @PostMapping("/api/special")
//    public String giveSpecialCat(@RequestParam String name) {
//        String jsonData = null;
//        Cat cat = new Cat(name, 5, 8);
//        try {
//            jsonData = objectMapper.writeValueAsString(cat);
//        } catch (JsonProcessingException e) {
//            jsonData = e.getMessage();
//        }
//        return jsonData;
//    }

    @PostMapping("api/add")
    public void addCat(@RequestBody CatDTO catDTO) {
      log.info(
              "new row:  " +  catRepo.save(Cat.builder()
                      .name(catDTO.getName())
                      .age(catDTO.getAge())
                      .weight(catDTO.getWeight())
                      .build())
              );
    }


    @GetMapping("api/all")
    public String getAllCats() {
        List<Cat> cats = catRepo.findAll();

        try {
            return objectMapper.writeValueAsString(cats);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api")
    public String getById(@RequestParam long id) {
        Cat cat = catRepo.findById(id).orElseThrow();
        return cat.toString();
        }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam long id) {
        catRepo.deleteById(id);
    }

    @PutMapping("/api")
    public String changeCat(@RequestBody Cat cat) {

        if (!catRepo.existsById(cat.getId())) {
            return "Such row does not exist";
        }
        return catRepo.save(cat).toString();
    }


}
