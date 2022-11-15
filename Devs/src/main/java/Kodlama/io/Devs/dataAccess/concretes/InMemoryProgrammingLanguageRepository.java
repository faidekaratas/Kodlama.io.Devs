package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository //bu sınıf datAccess nesnesidir (new yapar)
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	
	List<ProgrammingLanguage> programmingLanguages;
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages=new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Python"));
	}
	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}
	@Override
	public void create(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		
	}
	@Override
	public void delete(int id) throws Exception {
		ProgrammingLanguage programmingLanguageDelete=getById(id);
		programmingLanguages.remove(programmingLanguageDelete);
		
	}
	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
		ProgrammingLanguage programmingLanguage1=getById(programmingLanguage.getId());
		programmingLanguage1.setName(programmingLanguage.getName());
		
	}
	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if(programmingLanguage.getId()==id) {
				return programmingLanguage;
			}
		}
		throw new Exception("Bu id değerinde kayıt bulunamadı");
	}
	
	

}
