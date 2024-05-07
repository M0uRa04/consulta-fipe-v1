package br.com.consultacarros.principal;

import br.com.consultacarros.model.Marcas;
import br.com.consultacarros.services.ConsumoApi;
import br.com.consultacarros.services.ConverteDadosImpl;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();

    private ConverteDadosImpl converteDados = new ConverteDadosImpl();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";


    public void exibeMenu() {
        try {
            String opcao;
            System.out.println("Por favor selecione o tipo de veículo abaixo: ");
            System.out.println("1 - Carros");
            System.out.println("2 - Motos");
            System.out.println("3 - Caminhões");
            opcao = teclado.nextLine();
            String veiculo = switch (opcao) {
                case "1" -> "carros";
                case "2" -> "motos";
                case "3" -> "caminhoes";
                default -> "Opção inválida";
            };

            var json = consumoApi.obterDados(ENDERECO + veiculo + "/marcas");
            System.out.println(json);
            try {
                List<Marcas> marcasList = converteDados.obterDados(json, new TypeReference<List<Marcas>>(){});

                System.out.println("Exibindo lista de carros.");
                Map<String, String> mapaMarcas = marcasList.stream()
                        .collect(Collectors.toMap(Marcas::codigoMarca, Marcas::nome));
                mapaMarcas.forEach((codigo, nome) -> System.out.println("Codigo: " + codigo + " " + "Marca: " + nome));

                System.out.println("Por favor selecione uma marca pelo seu respectivo código: ");
                opcao = teclado.nextLine();

                json = consumoApi.obterDados(ENDERECO + veiculo + "/marcas/"
                        + opcao + "/modelos");

                System.out.println(json);




            } catch (Exception e ) {
                System.out.println(e.getMessage());
            }


        }catch (IllegalArgumentException e ) {
            System.out.println(e.getMessage());
        }

    }
}
