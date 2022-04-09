package app.dao;

import app.entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentDAO extends CrudRepository<Document, Long> {
}
