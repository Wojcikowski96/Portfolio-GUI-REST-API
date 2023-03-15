package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.blog.impl.BlogEntryDomainImpl;
import com.example.blog.mapper.BlogEntryMapper;
import com.example.blog.mapper.BlogEntryMapperImpl;
import com.example.blog.model.BlogEntryModel;
import com.example.blog.repository.BlogEntryRepository;
import com.example.blog.specification.BlogSearchSpecification;
import com.example.model.RequestData;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@DataJpaTest
public class BlogRepositoryTests {

  @Autowired
  BlogEntryRepository repository;

  @Spy
  BlogSearchSpecification searchSpecification;

  @Spy
  BlogEntryMapper mapper;

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

  @Test
  @DisplayName("Getting entry sorting asc by tittle")
  public void getEntriesASCByTittleWhenSearchCriteriaEmpty(){
    RequestData data = new RequestData();

    data.setSortBy("tittle");

    Sort sort = Sort.by(Sort.Direction.valueOf(data.getSortDir().getValue()),
        data.getSortBy());

    Pageable pageable =
        PageRequest.of(data.getPageNo() - 1, data.getPageSize(), sort);

    BlogEntryDomain domain = new BlogEntryDomainImpl();

    Page<BlogEntryModel> models = repository.findAll(searchSpecification.getEntries(domain), pageable);

    assertEquals("Ala", models.get().findFirst().get().getTittle());

  }

  @Test
  @DisplayName("Getting entry sorting desc by tittle")
  public void getEntriesDESCByTittleWhenSearchCriteriaEmpty(){
    RequestData data = new RequestData();

    data.setSortBy("tittle");

    data.setSortDir(RequestData.SortDirEnum.DESC);

    Sort sort = Sort.by(Sort.Direction.valueOf(data.getSortDir().getValue()),
        data.getSortBy());

    Pageable pageable =
        PageRequest.of(data.getPageNo() - 1, data.getPageSize(), sort);

    BlogEntryDomain domain = new BlogEntryDomainImpl();

    Page<BlogEntryModel> models = repository.findAll(searchSpecification.getEntries(domain), pageable);

    assertEquals("Zofia", models.get().findFirst().get().getTittle());

  }

  @Test
  @DisplayName("Getting entry sorting asc by content")
  public void getEntriesASCByContentWhenSearchCriteriaEmpty(){
    RequestData data = new RequestData();

    data.setSortBy("content");

    Sort sort = Sort.by(Sort.Direction.valueOf(data.getSortDir().getValue()),
        data.getSortBy());

    Pageable pageable =
        PageRequest.of(data.getPageNo() - 1, data.getPageSize(), sort);

    BlogEntryDomain domain = new BlogEntryDomainImpl();

    Page<BlogEntryModel> models = repository.findAll(searchSpecification.getEntries(domain), pageable);

    assertEquals("Aezakmi", models.get().findFirst().get().getContent());

  }

  @Test
  @DisplayName("Getting entry sorting desc by content")
  public void getEntriesDESCByContentWhenSearchCriteriaEmpty(){
    RequestData data = new RequestData();

    data.setSortDir(RequestData.SortDirEnum.DESC);

    data.setSortBy("content");

    Sort sort = Sort.by(Sort.Direction.valueOf(data.getSortDir().getValue()),
        data.getSortBy());

    Pageable pageable =
        PageRequest.of(data.getPageNo() - 1, data.getPageSize(), sort);

    BlogEntryDomain domain = new BlogEntryDomainImpl();

    Page<BlogEntryModel> models = repository.findAll(searchSpecification.getEntries(domain), pageable);

    assertEquals("Zabawa lorem ipsum dsdsf", models.get().findFirst().get().getContent());

  }

  @Test
  @DisplayName("Getting entry sorting desc by content")
  public void getEntriesDESCByContentSearchByContentMixedCase(){
    RequestData data = new RequestData();

    data.setSortDir(RequestData.SortDirEnum.DESC);

    data.setSortBy("content");

    data.setContent("aEz");

    Sort sort = Sort.by(Sort.Direction.valueOf(data.getSortDir().getValue()),
        data.getSortBy());

    Pageable pageable =
        PageRequest.of(data.getPageNo() - 1, data.getPageSize(), sort);

    mapper = new BlogEntryMapperImpl();

    BlogEntryDomain domain = mapper.filterRestToDomain(data);


    Page<BlogEntryModel> models = repository.findAll(searchSpecification.getEntries(
       domain), pageable);

    assertEquals("Aezakmi", models.get().findFirst().get().getContent());

  }


}
