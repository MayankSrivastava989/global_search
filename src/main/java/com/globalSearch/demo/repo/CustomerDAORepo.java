package com.globalSearch.demo.repo;

import com.globalSearch.demo.elastic.CustomerDAO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAORepo extends ElasticsearchRepository<CustomerDAO,String> {
}
