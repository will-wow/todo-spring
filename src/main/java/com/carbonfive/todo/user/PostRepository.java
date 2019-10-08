package com.carbonfive.todo.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface PostRepository extends JpaRepository<Post, Integer> {

}