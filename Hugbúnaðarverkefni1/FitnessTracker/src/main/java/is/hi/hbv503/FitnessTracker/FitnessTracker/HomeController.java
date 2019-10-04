package is.hi.hbv503.FitnessTracker.FitnessTracker;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class HomeController {

    private ExerciseService exerciseService;
    @Autowired
    public HomeController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
        @RequestMapping("/")
        public String Home(Model model){
            model.addAttribute("exercises", exerciseService.findAll());
            return "Velkominn";
        }

        @RequestMapping(value="/addexercise", method = RequestMethod.POST)
        public String addExercise(@Valid Exercise exercise, BindingResult result, Model model){
            if(result.hasErrors()){
                return "add-exercise";
            }
            exerciseService.save(exercise);
            model.addAttribute("exercises", exerciseService.findAll());
            return "Velkominn";
        }

        @RequestMapping(value="/addexercise", method = RequestMethod.GET)
        public String addExerciseForm(Exercise exercise){
            return "add-exercise";
        }

        @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
        public String deleteExercise(@PathVariable("id") long id, Model model){
            Exercise exercise = exerciseService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid exercise ID"));
            exerciseService.delete(exercise);
            model.addAttribute("exercises", exerciseService.findAll());
            return "Velkominn";
        }
        @RequestMapping("login")
        public String loginPage(){
            return "LoginPage";
        }
    @RequestMapping(value="/stats", method = RequestMethod.GET)
    public String statsPage(Exercise exercise){
        return "Stats";
    }
    }
