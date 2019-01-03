package com.users;

import com.users.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class UserApplication extends Application<Configuration> {

    public static void main(final String[] args) throws Exception {
        new UserApplication().run(args);
    }

    @Override
    public void run(final Configuration configuration,
                    final Environment environment) {
        JerseyEnvironment jersey = environment.jersey();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.users");
        UserResource userResource = applicationContext.getBean(UserResource.class);
        jersey.register(userResource);
    }

}
