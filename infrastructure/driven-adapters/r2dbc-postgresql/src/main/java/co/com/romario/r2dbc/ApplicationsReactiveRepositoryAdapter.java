package co.com.romario.r2dbc;

import co.com.romario.model.applications.Applications;
import co.com.romario.r2dbc.entity.ApplicationsEntity;
import co.com.romario.r2dbc.helper.ReactiveAdapterOperations;

import java.util.UUID;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationsReactiveRepositoryAdapter extends ReactiveAdapterOperations<
    Applications/* change for domain model */,
    ApplicationsEntity/* change for adapter model */,
    UUID,
    ApplicationsReactiveRepository
> {
    public ApplicationsReactiveRepositoryAdapter(ApplicationsReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Applications.class/* change for domain model */));
    }

}
