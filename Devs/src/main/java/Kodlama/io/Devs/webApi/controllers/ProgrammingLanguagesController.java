package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController // bilgilendirme
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired /*
				 * parametreye bakar prog.lang.ser. ; uygulamayı tarar; prlanserv implemente
				 * eden sınıfı bulur programminglanguagemanager ın new halini getirir.
				 */
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable() int id) throws Exception{
        return programmingLanguageService.getById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody ProgrammingLanguage language) throws Exception {
        programmingLanguageService.create(language);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProgrammingLanguage language,@PathVariable int id) throws Exception {
        programmingLanguageService.update(language,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) throws Exception {
        programmingLanguageService.delete(id);
    }
}
