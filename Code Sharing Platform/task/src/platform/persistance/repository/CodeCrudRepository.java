package platform.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import platform.businesslayer.entity.Code;

import java.util.UUID;

public interface CodeCrudRepository extends CrudRepository<Code, UUID> {}
