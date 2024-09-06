package br.com.projeto.DailyDiet.service;

import br.com.projeto.DailyDiet.model.Usuario;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {
    @Value("${api.token.secret}")
    private String senhaToken;

    public String getSubject(String tokenJwt) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(senhaToken);
            return JWT.require(algorithm)
                    .withIssuer("API dieta")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Erro ao verificar token");
        }
    }

    public String gerarToken(Usuario usuario) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(senhaToken);
            return JWT.create()
                    .withIssuer("API dieta")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                    .sign(algorithm);
        }catch(JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token");
        }
    }


}
