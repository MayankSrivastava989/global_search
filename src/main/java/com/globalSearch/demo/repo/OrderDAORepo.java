package com.globalSearch.demo.repo;

import com.globalSearch.demo.elastic.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAORepo extends ElasticsearchRepository<OrderDAO,String> {
}
