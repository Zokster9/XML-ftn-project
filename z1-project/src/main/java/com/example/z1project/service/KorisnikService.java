package com.example.z1project.service;

import com.example.z1project.dto.KorisnikDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KorisnikService {

    @Autowired
    private RestTemplate restTemplate;

    public boolean proveriKorisnika(String token, boolean korisnikJeSluzbenik) throws Exception {
        final String uri = "http://localhost:9003/auth/get/" + token;
        ResponseEntity<KorisnikDTO> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<KorisnikDTO>() {
                });
        KorisnikDTO korisnikDTO = responseEntity.getBody();
        if (korisnikDTO != null) {
            return korisnikDTO.isKorisnikJeSluzbenik() == korisnikJeSluzbenik;
        }
        throw new Exception("Session ended!");
    }

    public KorisnikDTO dobaviKorisnika(String token) throws Exception {
        final String uri = "http://localhost:9003/auth/get/" + token;
        ResponseEntity<KorisnikDTO> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<KorisnikDTO>() {
                });
        return responseEntity.getBody();
    }
}
