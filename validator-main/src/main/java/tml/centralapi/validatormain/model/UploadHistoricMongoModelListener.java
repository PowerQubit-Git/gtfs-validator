package tml.centralapi.validatormain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import tml.centralapi.validatormain.services.SequenceGeneratorService;

@Component
public class UploadHistoricMongoModelListener extends AbstractMongoEventListener<UploadHistoricMongo> {
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UploadHistoricMongoModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<UploadHistoricMongo> event) {
        if (event.getSource().getFeedId() < 1) {
            event.getSource().setFeedId(sequenceGenerator.generateSequence(UploadHistoricMongo.SEQUENCE_NAME));
        }
    }
}
