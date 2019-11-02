package com.epam.data.homework2;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service

public class ComplainService {

    private static String DATA_FILE = "/data.csv";

    private final CsvMapper csvMapper;
    private final ComplainRepository complainRepository;
    @Value("${batch.size}")
    private int batchSize;

    void loadData() throws IOException {
        complainRepository.deleteAll();
        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();

        try (InputStream inputStream = getClass().getResourceAsStream(DATA_FILE)) {
            ObjectReader reader = csvMapper.readerFor(Complain.class).with(bootstrapSchema);

            try (MappingIterator<Complain> iterator = reader.readValues(inputStream)) {

                List<Complain> list = new ArrayList<>(batchSize);
                while (iterator.hasNext()) {
                    if (list.size() < batchSize) {
                        Complain complain = iterator.next();
                        list.add(complain);
                    } else {
                        complainRepository.saveAll(list);
                        list.clear();
                    }
                }
            }
        }
    }
}
