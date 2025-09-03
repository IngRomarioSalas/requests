package co.com.romario.model.user.gateways;

import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<Boolean> existsByDocumentNumber(String documentNumber);
}
