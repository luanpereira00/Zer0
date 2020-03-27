package dao.general;

import dao.Dao;
import net.dv8tion.jda.core.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@entity
public class LanguageServerDAO implements Dao<LanguageServer> {

    private List<LanguageServer> languagesByServers = new ArrayList<>();

    public LanguageServerDAO() {
        //users.add(new User("John", "john@domain.com"));
        //users.add(new User("Susan", "susan@domain.com");
    }

    @Override
    public Optional<LanguageServer> get(long id) {
        //return Optional.ofNullable(languagesByServers.get((int) id));
        return null;
    }

    @Override
    public List<LanguageServer> getAll() {
        return languagesByServers;
    }

    @Override
    public void save(LanguageServer languageServer) {
        languagesByServers.add(languageServer);
    }

    @Override
    public void update(LanguageServer languageServer, String[] params) {
        /*languageServer.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        languageServer.setEmail(Objects.requireNonNull(
                params[1], "Email cannot be null"));

        users.add(languageServer);*/
    }

    @Override
    public void delete(LanguageServer languageServer) {
        languagesByServers.remove(languageServer);
    }
}