package ru.gb.sem06_homework02.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.sem06_homework02.configs.DefaultVariables;
import ru.gb.sem06_homework02.domain.Characters;
import ru.gb.sem06_homework02.domain.Result;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class ServiceApiImpl implements ServiceApi {
    @Autowired
    private RestTemplate template;
    @Autowired
    private HttpHeaders headers;

    @Autowired
    private DefaultVariables defVar;

    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(defVar.getUrl(), HttpMethod.GET, entity, Characters.class);

        return response.getBody();
    }

    @Override
    public Result getCharacterById(Long id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(defVar.getUrl() + "/" + id, HttpMethod.GET, entity, Result.class);

        return response.getBody();
    }
}
