package co.com.romario.r2dbc;

import java.util.UUID;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import co.com.romario.r2dbc.entity.ApplicationsEntity;

// TODO: This file is just an example, you should delete or modify it
public interface ApplicationsReactiveRepository extends ReactiveCrudRepository<ApplicationsEntity, UUID>, ReactiveQueryByExampleExecutor<ApplicationsEntity> {

}
