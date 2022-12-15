package com.mobi7.desafio.load;

import com.mobi7.desafio.entity.POI;
import com.mobi7.desafio.entity.Posicoes;
import com.mobi7.desafio.repository.POIRepository;
import com.mobi7.desafio.repository.PosicoesRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Configuration
public class LoadCSV {
    private static final Logger log = LoggerFactory.getLogger(LoadCSV.class);

    private List<String[]> readPOICSV() {
        List<String[]> base_pois_def = null;

        try {
            Reader reader = Files.newBufferedReader(Paths.get(".\\csv\\base_pois_def.csv"));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            base_pois_def = csvReader.readAll();
            csvReader.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base_pois_def;
    }

    private List<String[]> readPosicoesCSV() {
        List<String[]> posicoes = null;

        try {
            Reader reader = Files.newBufferedReader(Paths.get(".\\csv\\posicoes.csv"));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            posicoes = csvReader.readAll();
            csvReader.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posicoes;
    }

    @Bean
    CommandLineRunner initDatabase(POIRepository poiRepository, PosicoesRepository posicoesRepository) {

        List<String[]> base_pois_def = readPOICSV();
        List<String[]> posicoes = readPosicoesCSV();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'z '(Hora oficial do Brasil)'", Locale.ENGLISH); // Wed Dec 19 2018 15:07:19 GMT-0200 (Hora oficial do Brasil)

        return args -> {
            for (String[] record : base_pois_def) {
                log.info("Preloading " + poiRepository.save(new POI(record[0], Integer.parseInt(record[1]), Double.parseDouble(record[2]), Double.parseDouble(record[3]))));
            }
            for (String[] record : posicoes) {
                // swapping latitude and longitude as they are swapped on the csv file
                log.info("Preloading " + posicoesRepository.save(new Posicoes(record[0], dateFormat.parse(record[1]), Integer.parseInt(record[2]), Double.parseDouble(record[4]), Double.parseDouble(record[3]), Boolean.parseBoolean(record[5]))));
            }
        };
    }
}
