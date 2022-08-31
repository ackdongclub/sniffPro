package project01.sniffPro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project01.sniffPro.domain.item.Pet;
import project01.sniffPro.service.ItemService;


@Controller
@RequiredArgsConstructor
public class PetController {

    private final ItemService itemService;

    @GetMapping("/petList")
    public String choicesForm() {
        return "items/choiceForm";
    }
    //입양 신청 or 유기견 등록 선택 form

    //신청 폼
    @GetMapping("/Items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new PetForm());
        return "Items/createItemForm";
    }

    @PostMapping("Items/new")
    public String create(PetForm form) {
        Pet pet = new Pet();
        pet.setName(form.getName());
        pet.setPrice(form.getPrice());
        pet.setStock(form.getStockQuantity());
        pet.setAge(form.getAge());
        pet.setGender(form.getGender());

        itemService.saveItem(pet);
        return "redirect:/";
    }




}
