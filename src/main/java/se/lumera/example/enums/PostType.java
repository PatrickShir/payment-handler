package main.java.se.lumera.example.enums;

import java.util.Arrays;

public enum PostType {
    POST_TYPE_O("O"),
    POST_TYPE_B("B"),
    POST_TYPE_ZERO("0"),
    POST_TYPE_THREE("3"),
    POST_TYPE_NINE("9");

    private final String type;

    PostType(String type) {
        this.type = type;
    }

    public static PostType getByType(String type) {
        if (type.isBlank()) {
            throw new IllegalArgumentException("Type is blank");
        }

        return Arrays.stream(PostType.values())
                .filter(postType -> postType.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unsupported post type"));
    }
}