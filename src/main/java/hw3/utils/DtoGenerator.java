package hw3.utils;

import hw3.dto.User;

import static hw3.utils.PropertiesReader.readProperty;

public class DtoGenerator {

    public static User generateUser() {
        return User.builder()
                .email(readProperty("user.email"))
                .username(readProperty("user.username"))
                .password(readProperty("user.password"))
                .build();
    }
}
