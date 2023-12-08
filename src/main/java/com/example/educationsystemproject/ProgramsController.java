package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/program")
public class ProgramsController {

    @Autowired
    private ProgramsRepository programsRepository;


    @PostMapping("/add")
    public @ResponseBody Programs addProgram(@RequestBody Programs program) {
        return programsRepository.save(program);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Programs> getAllPrograms() {
        return programsRepository.findAll();
    }

    @GetMapping("/view/{id}")
    public @ResponseBody Programs getProgramById(@PathVariable Integer id) {
        return programsRepository.findById(id).orElse(null);
    }

    @PutMapping("/modify/{id}")
    public @ResponseBody Programs modifyProgram(@PathVariable Integer id, @RequestBody Programs modifiedProgram) {
        return modifiedProgram;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProgram(@PathVariable Integer id) {
        return "Program Deleted Successfully";
    }
}

