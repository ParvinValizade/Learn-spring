package com.company.repository;

import com.company.entity.Human;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanRepository extends ElasticsearchRepository<Human,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Human> getByCustomQuery(String search);

    List<Human> findByNameLikeOrSurnameLike(String name,String surname);
}
