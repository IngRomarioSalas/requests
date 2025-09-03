package co.com.romario.model.applications.gateways;

import co.com.romario.model.applications.Applications;
import reactor.core.publisher.Mono;

public interface ApplicationsRepository {
    Mono<Applications> save(Applications applications);
}
