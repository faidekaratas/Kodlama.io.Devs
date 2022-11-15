package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

//iş kuralları

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();

	void create(ProgrammingLanguage programmingLanguage)throws Exception; // programlama dili ekleme

	void delete(int id)throws Exception; // programlama dili silme

	void update(ProgrammingLanguage programmingLanguage, int id) throws Exception; // programlama dili güncelleme

	ProgrammingLanguage getById(int id) throws Exception;
}
