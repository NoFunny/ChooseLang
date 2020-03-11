package ru.project.chooselang.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.project.chooselang.api.entities.VacanciesAnswer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
@Component
public class RequestHandler {
    public static VacanciesAnswer hhVacancyAnswerSalaries(String lang, String area, String level, Integer page, Integer perPage) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://api.hh.ru/vacancies?text=" + lang + "+" + level + "&per_page=" + perPage+ "&page=" + page;
        if (area != null && !area.equals("-")) {
            url += "&area=" + area;
        }
        url = new String(url.getBytes(), StandardCharsets.UTF_8);
        log.error(url);
        log.error(restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody(),VacanciesAnswer.class);
        return objectMapper.readValue(restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody(),VacanciesAnswer.class);
    }

}
