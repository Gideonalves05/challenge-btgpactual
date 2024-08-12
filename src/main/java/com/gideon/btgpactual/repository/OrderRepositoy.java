package com.gideon.btgpactual.repository;

import com.gideon.btgpactual.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepositoy extends MongoRepository<OrderEntity, Long > {
}
