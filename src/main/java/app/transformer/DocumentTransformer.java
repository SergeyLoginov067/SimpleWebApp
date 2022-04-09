package app.transformer;

import app.entity.Document;
import app.model.DocumentModel;
import org.springframework.stereotype.Component;

@Component
public class DocumentTransformer {

    public DocumentModel transform(Document document) {
        DocumentModel model = new DocumentModel();
        model.setId(document.getId());
        model.setSenderId(document.getSenderId());
        model.setReceiverId(document.getReceiverId());
        model.setSentDate(document.getSentDate());
        return model;
    }

}
