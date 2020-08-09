package com.example.demo.services.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.models.Article;
import com.example.demo.models.Author;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;


    public Article newArticle(String title, String text, Long authorId) {

        return articleRepository.save(Article.builder()
                .text(text)
                .title(title)
                .author(Author.builder()
                        .authorId(authorId)
                        .build())
                .build());

    }

    public Optional<Article> updateArticle(Long id, String title, String text, Long authorId) {
        Optional<Article> article = articleRepository.findById(id);

        article.ifPresent(a -> {
            a.setTitle(title);
            a.setText(text);
            a.setAuthor(Author.builder()
                    .authorId(authorId)
                    .build());
            articleRepository.save(a);
        });

        return article;
    }

    public boolean deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return true;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = Author.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return authorRepository.save(author);

    }

    public Optional<Author> updateAuthor(Long id, String firstName, String lastName) {
        Optional<Author> author = authorRepository.findById(id);

        author.ifPresent(a -> {
            a.setFirstName(firstName);
            a.setLastName(lastName);
            authorRepository.save(a);
        });

        return author;
    }

    public boolean deleteAuthor(Long id) {
        authorRepository.deleteById(id);
        return true;
    }
}
