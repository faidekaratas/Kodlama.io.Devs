package Kodlama.io.Devs.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service // service katmanı olarak otomatik new'ler
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {

		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public void create(ProgrammingLanguage programmingLanguage) throws Exception{
		if (programmingLanguage.getName().isEmpty()){
            throw new Exception("Programlama dili ismi boş bırakılamaz");
        }
        for(ProgrammingLanguage programmingLanguage2: getAll()){
            if(programmingLanguage2.getId() == programmingLanguage.getId()){
                throw new Exception("Programlama isimleri tekrar edemez");
            }
        }
        programmingLanguageRepository.create(programmingLanguage);

	}

	@Override
	public void delete(int id) throws Exception{
		programmingLanguageRepository.delete(id);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception{
		if(programmingLanguageRepository.getById(id) == null){
            throw new Exception("Bu programlama dili sistemde kayıtlı değil.");
        }
        programmingLanguageRepository.update(programmingLanguage, id);

	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		return programmingLanguageRepository.getById(id);
	}

}
