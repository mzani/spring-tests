package bddgof;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import cucumber.api.java.pt.Entao;

import bddgof.SpringTeste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

import org.json.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Stepdefs {

    private static String id_aluno;

    /*************************************************************************/

    @Dado("Que Secretaria cadastra um aluno")
    public void que_Secretaria_cadastra_um_aluno() {

    }

    @Quando("Escolhe a opcao de consultar: {string}")
    public void escolhe_a_opcao_de_consultar(String string) {
        Stepdefs.id_aluno = string;
    }

    @Quando("clica em consultar aluno:")
    public void clica_em_consultar_aluno() {

    }

    @Entao("A consulta deve retornar o aluno cadastrado: {string}")
    public void a_consulta_deve_retornar_o_aluno_cadastrado(String string) {

       RestTemplate restTemplate = new RestTemplate();
       String url = "http://localhost:8080/fiap/v1/alunos/" + id_aluno;

       String s = restTemplate.getForObject(url, String.class);

       JsonObject obj = new JsonParser().parse(s).getAsJsonObject();

        System.out.print(obj);

        assertEquals(obj.get("nome").toString() , "\"" + string + "\"") ;

    }

    @Entao("O cadastro deve retornar o aluno cadastrado: {string}")
    public void o_cadastro_deve_retornar_o_aluno_cadastrado(String string) {

       RestTemplate restTemplate = new RestTemplate();
       String url = "http://localhost:8080/fiap/v1/alunos";

       String s = restTemplate.getForObject(url, String.class);

       //restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(aluno), Aluno.class);

       JsonObject obj = new JsonParser().parse(s).getAsJsonObject();

        System.out.print(obj);

        assertEquals(obj.get("nome").toString() , "\"" + string + "\"") ;

    }

}
