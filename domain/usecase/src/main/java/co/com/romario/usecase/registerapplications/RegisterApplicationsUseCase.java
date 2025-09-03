package co.com.romario.usecase.registerapplications;

import co.com.romario.model.applications.Applications;
import co.com.romario.model.applications.StatusRequest;
import co.com.romario.model.applications.gateways.ApplicationsRepository;
import co.com.romario.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegisterApplicationsUseCase {
    
    private final ApplicationsRepository applicationsRepository;
    private final UserRepository userRepository;

    public Mono<Applications> registerApplication(Applications application) {

        // 1. Validar datos del préstamo
        if (application.getAmount() == null || application.getAmount() <= 0) {
            return Mono.error(new IllegalArgumentException("El monto debe ser mayor a 0"));
        }
        if (application.getDeadline() == null || application.getDeadline() <= 0) {
            return Mono.error(new IllegalArgumentException("El plazo debe ser mayor a 0"));
        }
        if (application.getLoanType() == null) {
            return Mono.error(new IllegalArgumentException("El tipo de préstamo es obligatorio"));
        }

        // 2. Validar existencia del cliente
        return userRepository.existsByDocumentNumber(application.getDocumentNumber())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new IllegalStateException("El cliente no existe"));
                    }
                    application.setStatus(StatusRequest.PENDIENTE_REVISION);
                    return applicationsRepository.save(application);
                });
    }
}

