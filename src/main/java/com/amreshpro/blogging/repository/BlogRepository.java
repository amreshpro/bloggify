package com.amreshpro.blogging.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.amreshpro.blogging.model.Blog;

@Repository
public interface BlogRepository extends MongoRepository<Blog,ObjectId>{

}