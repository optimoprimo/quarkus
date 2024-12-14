package org.acme;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadyResource implements HealthCheck{

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("READY");
    }
    
}
