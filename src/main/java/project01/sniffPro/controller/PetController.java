package project01.sniffPro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class PetController {

    @GetMapping("/petList")
    public String choicesForm() {
        return "items/choiceForm";
    }
    //입양 신청 or 유기견 등록 선택 form

    //신청 폼
    @PostMapping("/petList")
    public String createPetList() {

    }




}
