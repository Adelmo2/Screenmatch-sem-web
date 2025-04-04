package br.com.alura.screenmach;

import br.com.alura.screenmach.model.DadosSerie;
import br.com.alura.screenmach.service.ConsumoApi;
import br.com.alura.screenmach.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Primeiro projeto Spring sem Web");
		//ConsumoAPI consumoAPI = new ConsumoAPI();
		var consumoApi = new ConsumoApi();
		//var json = consumoApi.obterDados("http://www.omdbapi.com/?t=Gladiator&apikey=7d48dedc"); //ok
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=friends&apikey=7d48dedc");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		//em 02/04/2025 parei no minuto 11:00
	}
}
