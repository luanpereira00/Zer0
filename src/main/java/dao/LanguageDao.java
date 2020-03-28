package dao;

import java.util.List;

import dominio.Language;
import exception.DataBaseException;

public class LanguageDao extends UtilDao<LanguageDao, Language> implements Dao<Language>{

	@Override
	public Language get(Long id) throws DataBaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> getAll() throws DataBaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Language t) throws DataBaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Language t, String[] params) throws DataBaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Language t) throws DataBaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String returnFieldsBD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String returnFieldValuesBD(Language t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String returnValuesBD(Language t) {
		// TODO Auto-generated method stub
		return null;
	}

}
