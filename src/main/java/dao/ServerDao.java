package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dominio.Server;
import exception.DataBaseException;

public class ServerDao extends UtilDao<ServerDao, Server> implements Dao<Server>{
	
	private static ServerDao serverDao;
	
	private ServerDao() {

	}
	
	public synchronized ServerDao getInstance() {
		if (serverDao == null) {
			serverDao = new ServerDao();
		}
		return serverDao;
	}

	@Override
	public Server get(Long id) throws DataBaseException {
		try {
			this.startConnection();
			
			String sql = "SELECT * FROM address WHERE id_address = " +
					returnValueStringBD(String.valueOf(id));
			
			ResultSet rs = command.executeQuery(sql);

			Server a = null;
			if (rs.next()) {
				String name  		= rs.getString("name");
				Long languageId 	= Long.parseLong(rs.getString("language_id"));
				//Precisa do formater
				Date dateCreated = new Date();
				//Date dateCreated 	= new Date(rs.getString("data_created"));
				a = new Server(id, name, dateCreated, languageId);
			} 
			
			return a;
		} catch (SQLException e) {
			throw new DataBaseException(e.getMessage());
		} finally {
			this.closeConnection();
		}
	}

	@Override
	public List<Server> getAll() throws DataBaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Server t) throws DataBaseException {
		try {
			this.startConnection();
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("INSERT INTO server (");
			buffer.append(this.returnFieldsBD());
			buffer.append(") VALUES (");
			buffer.append(returnValuesBD(t));
			buffer.append(")");
			
			String sql = buffer.toString();
			command.execute(sql);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void update(Server t, String[] params) throws DataBaseException {
		try {
			this.startConnection();
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("UPDATE server SET ");
			buffer.append(returnFieldValuesBD(t));
			buffer.append(" WHERE id=");
			buffer.append(t.getId());
			
			String sql = buffer.toString();
			command.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DataBaseException(e.getMessage());
		} finally {
			this.closeConnection();
		}		
	}

	@Override
	public void delete(Server t) throws DataBaseException {
		try {
			this.startConnection();
			String sql = "DELETE FROM server WHERE id"+ returnValueStringBD(String.valueOf(t.getId()));
			command.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}		
	}

	@Override
	protected String returnFieldsBD() {
		return "name, language_id";
	}

	@Override
	protected String returnFieldValuesBD(Server t) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("name=");
		buffer.append(returnValueStringBD(t.getName()));
		buffer.append(", language_id=");
		buffer.append(String.valueOf(t.getLanguageId()));
		
		return buffer.toString();
	}

	@Override
	protected String returnValuesBD(Server t) {
		return returnValueStringBD(t.getName()) + ", " + String.valueOf(t.getLanguageId());
	}

}
