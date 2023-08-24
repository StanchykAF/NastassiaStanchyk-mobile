package hw2.utils;

import hw2.dto.User;

import static hw2.utils.PropertiesReader.readProperty;

public class DtoGenerator {

    public static User generateUser() {
        return User.builder()
                .email(readProperty("user.email"))
                .username(readProperty("user.username"))
                .password(readProperty("user.password"))
                .build();
    }
}
