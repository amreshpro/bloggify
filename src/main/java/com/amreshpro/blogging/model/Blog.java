package com.amreshpro.blogging.model;

import java.nio.file.Path;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Blog
 */

@Document(collection = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    private ObjectId blogId;

    @NonNull
    private String title;

    @NonNull
    private String description;

    private String imageUrl;
    private long imageLength;

    private LocalDateTime date;

}
