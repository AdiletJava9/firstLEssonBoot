package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.House;
import peaksoft.service.HouseService;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseApi {

    private final HouseService houseService;

    @GetMapping()
    public String getAllHouses(Model model) {
        model.addAttribute("houses", houseService.getAllHouses());
        return "House";
    }

    @GetMapping("/new")
    public String createHouse(Model model) {
        model.addAttribute("newHouse", new House());
        return "newHouse";
    }
    @GetMapping("/{id}")
    public String getHouseById(@PathVariable ("id")Long id,Model model) {
        model.addAttribute("houses", houseService.getHouseById(id));
        return "HouseInfo";
    }

    @PostMapping("/save")
    public String saveHouse(@ModelAttribute("newHouse") House house) {
        houseService.saveHouse(house);
        return "redirect:/houses";
    }

    @PostMapping("/{id}/delete")
    public String deleteHouses(@PathVariable("id") Long id) {
        houseService.deleteHouseById(id);
        return "redirect:/houses";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Long id,
                         Model model) {
        model.addAttribute("editHouse", houseService.getHouseById(id));
        return "updateHouse";
    }

    @PostMapping("/updateHouse/{id}")
    public String saveUpdate(@ModelAttribute("editHouse") House house,
                             @PathVariable("id") Long id) {
        houseService.updateHouse(id, house);
        return "redirect:/houses";
    }
}
