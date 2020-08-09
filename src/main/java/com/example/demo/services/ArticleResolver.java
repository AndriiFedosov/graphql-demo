package com.example.demo.services;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.models.Article;
import com.example.demo.models.Author;
import com.example.demo.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArticleResolver implements GraphQLResolver<Article> {

    private AuthorRepository authorRepository;

    public Author getAuthor(Article article) {
        return authorRepository.findById(article.getAuthor().getAuthorId()).orElse(null);
    }
}