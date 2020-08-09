package com.example.demo.services.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.models.Article;
import com.example.demo.models.Author;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final ArticleRepository articleRepository;

    private final AuthorRepository authorRepository;


    public Optional<Article> article(Long id) {
        return articleRepository.findById(id);
    }

    public Iterable<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Author> author(Long id) {
        return authorRepository.findById(id);
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

}


