package br.com.control.persistence.config;

import br.com.control.core.CurrentContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {

    private String defaultTenant = "public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = CurrentContext.getTenantName();
        if (tenant != null) {
            return tenant;
        } else {
            return defaultTenant;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}