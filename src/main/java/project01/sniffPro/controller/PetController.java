package project01.sniffPro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project01.sniffPro.domain.User;
import project01.sniffPro.domain.item.Item;
import project01.sniffPro.service.ItemService;
import project01.sniffPro.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PetController {

    @GetMapping("/petList")
    public String choicesForm(Model model) {

        model

        return "items/choiceForm";
    }


}
