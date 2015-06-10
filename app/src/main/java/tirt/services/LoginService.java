package tirt.services;

import retrofit.http.Body;
import retrofit.http.POST;
import tirt.pojos.PojoUser;

/**
 * Created by Marcin on 2015-06-10.
 */
public interface LoginService {

    @POST("/login/check")
    public PojoUser login(@Body PojoUser user);
}
