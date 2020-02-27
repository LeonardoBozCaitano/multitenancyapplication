package br.com.multitenancy.persistence.repositories;

import br.com.multitenancy.persistence.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
