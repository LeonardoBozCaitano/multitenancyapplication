package br.com.multitenancy.core;

import br.com.multitenancy.persistence.entities.Tenant;
import br.com.multitenancy.persistence.repositories.TenantRepository;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DatabaseMigration {

    @Autowired
    private TenantRepository tenantRepository;
    private String scriptsLocation = "db/migration/";

    /**
     * Starts the migration
     */
    public void run(){
        this.migratePublicSchema();
        this.migrateSchemas();
    }

    /**
     * Start the public schema migration
     */
    private void migratePublicSchema() {
        migrate("public", scriptsLocation.concat("public"));
    }

    /**
     * Start the migration of all the schemas founded on <code>public.tenant</code> table
     */
    private void migrateSchemas() {
        List<Tenant> tenants = tenantRepository.findAll();
        tenants.forEach(tenant -> {
            migrate(tenant.getName(), scriptsLocation.concat("tenants"));
        });
    }

    /**
     * Migrate the schema.
     * @param schema schema to be migrated
     * @param location location where the migration files are.
     */
    private void migrate(String schema, String location) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/multitenant", "postgres", "postgres")
                .schemas(schema)
                .baselineOnMigrate(true)
                .locations(location)
                .load();

        flyway.migrate();
    }
}
