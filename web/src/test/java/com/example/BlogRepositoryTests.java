package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.blog.model.BlogEntryModel;
import com.example.blog.repository.BlogEntryRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BlogRepositoryTests {

  @Autowired
  BlogEntryRepository repository;

  @BeforeEach
  public void initH2(){

    BlogEntryModel model1 = new BlogEntryModel();

    model1.setTittle("Ala");

    model1.setContent("Zabawa lorem ipsum dsdsf");

    repository.save(model1);

    BlogEntryModel model2 = new BlogEntryModel();

    model2.setTittle("Ola");

    model2.setContent("Playstation dsdsf sddsfds");

    repository.save(model2);

    BlogEntryModel model3 = new BlogEntryModel();

    model3.setTittle("Zofia");

    model3.setContent("Aezakmi");

    repository.save(model3);
  }

  @Test
  @DisplayName("Saving entry")
  public void saveEntry(){

    BlogEntryModel model = new BlogEntryModel();

    model.setTittle("Testowy");

    model.setContent("lorem ipsum content");

    repository.save(model);

    List<BlogEntryModel> models = repository.findAll();

    Assertions.assertThat(models).extracting(BlogEntryModel::getTittle).contains("Testowy");

    Assertions.assertThat(models).extracting(BlogEntryModel::getContent).contains("lorem ipsum content");

  }


}
