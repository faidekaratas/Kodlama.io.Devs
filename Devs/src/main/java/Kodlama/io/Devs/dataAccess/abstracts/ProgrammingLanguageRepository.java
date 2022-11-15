package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;


public interface ProgrammingLanguageRepository {
//ProgrammingLanguage[] getAll();
	List<ProgrammingLanguage> getAll(); //programlama dili listeleme
	void create(ProgrammingLanguage programmingLanguage)throws Exception; //programlama dili ekleme
	void delete(int id)throws Exception ; //programlama dili silme
	void update(ProgrammingLanguage programmingLanguage, int id)throws Exception ; //programlama dili güncelleme
	ProgrammingLanguage getById(int id)throws Exception ;
}
