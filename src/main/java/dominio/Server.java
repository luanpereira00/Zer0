package dominio;

import java.util.Date;

public class Server {
	private Long id;
	
	private String name;
	
	private Date dataCreated;
	
	private Long languageId;
	
	public Server() {
		
	}

	public Server(Long id, String name, Date dataCreated, Long languageId) {
		this.id = id;
		this.name = name;
		this.dataCreated = dataCreated;
		this.languageId = languageId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDataCreated() {
		return dataCreated;
	}

	public void setDataCreated(Date dataCreated) {
		this.dataCreated = dataCreated;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCreated == null) ? 0 : dataCreated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (dataCreated == null) {
			if (other.dataCreated != null)
				return false;
		} else if (!dataCreated.equals(other.dataCreated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
