package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.blog.model.BlogEntryModel;
import com.example.blog.repository.BlogEntryRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BlogRepositoryTests {

  @Autowired
  BlogEntryRepository repository;

  @Test
  public void saveEntry(){

    BlogEntryModel model = new BlogEntryModel();

    model.setTittle("Testowy");

    model.setContent("lorem ipsum content");

    repository.save(model);

    List<BlogEntryModel> models = repository.findAll();

    assertNotNull(models);

    models.stream().forEach(modelAdded->assertEquals("Testowy", modelAdded.getTittle()));

  }


}
