package com.company.api;


import com.company.entity.Human;
import com.company.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/human")
public class HumanController {

    private final HumanRepository humanRepository;

    @PostConstruct
    public void init(){
        Human human = new Human();
        human.setName("Pervin");
        human.setSurname("Valizade");
        human.setId("K0002");
        human.setAddress("test");
        human.setBirthday(Calendar.getInstance().getTime());
        humanRepository.save(human);
    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Human>> getHuman(@PathVariable String search){
        List<Human> humans = humanRepository.findByNameLikeOrSurnameLike(search,search);
        return ResponseEntity.ok(humans);
    }
}
