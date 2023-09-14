package kapparov.murat.springProject.Controllers;

import kapparov.murat.springProject.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import kapparov.murat.springProject.dao.CarDAO;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/cars")
public class Controller {
    private final CarDAO carDao;
    @Autowired
    public Controller(CarDAO carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String select_all(Model model){
        model.addAttribute("cars" , carDao.select_all());
        return "/selectAll";
    }
    @GetMapping("/{id}")
    public String select_one(@PathVariable("id") int id , Model model){
        model.addAttribute("car" , carDao.select_one(id));
        return "/selectOne";
    }
    @GetMapping("/new")
    public String create_new(Model model){
        model.addAttribute("car" , new Car());
        return "/new";
    }
    @PostMapping("/new")
    public String create(@ModelAttribute("car") @Valid Car car , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/new";
        }
        carDao.create(car);
        return "redirect:/cars";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("car" , carDao.select_one(id));
        return "/edit";
    }
    @PatchMapping("/{id}/edit")
    public String edit_car(@ModelAttribute("car") @Valid Car car , BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "/edit";
        }
        carDao.edit(car, id);
        return "redirect:/cars";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id , Model model){
        carDao.remove(id);
        return "redirect:/cars";
    }
}
