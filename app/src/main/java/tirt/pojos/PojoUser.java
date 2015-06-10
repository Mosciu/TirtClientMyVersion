package tirt.pojos;

/**
 * Created by Marcin on 2015-06-10.
 */
public class PojoUser {
    private long id;
    private String name;
    private String password;

    public PojoUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
