package br.com.consultacarros.principal;

import br.com.consultacarros.model.*;
import br.com.consultacarros.services.ConsumoApi;
import br.com.consultacarros.services.ConverteDadosImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

            var json = consumoApi.obterDadosRequisicao(ENDERECO + veiculo + "/marcas");

            try {
                List<Marcas> marcasList = converteDados.converterDados(json, new TypeReference<List<Marcas>>(){});

                System.out.println("Exibindo lista de veículo: ");
                Map<String, String> mapaMarcas = marcasList.stream()
                        .collect(Collectors.toMap(Marcas::codigoMarca, Marcas::nome));
                mapaMarcas.forEach((codigo, nome) -> System.out.println("Codigo: " + codigo + " " + "Marca: " + nome));

                System.out.println("Por favor selecione uma marca pelo seu respectivo código: ");
                opcao = teclado.nextLine();

                json = consumoApi.obterDadosRequisicao(ENDERECO + veiculo + "/marcas/"
                        + opcao + "/modelos");

                ObjectMapper mapper = new ObjectMapper();

                Resultado resultado = mapper.readValue(json, new TypeReference<Resultado>(){});
                List<DadosModelos> listModelos = resultado.modelosList();
                List<Ano> listAnos = resultado.anosList();


                System.out.println("Por favor digite um trecho do veiculo procurado: ");
                var modeloProcurado = teclado.nextLine();

                List<Modelo> modelosFiltrados = listModelos.stream()
                        .map(lm -> new Modelo(lm))
                        .filter(m -> m.getModelo().toLowerCase().contains(modeloProcurado.toLowerCase()))
                        .collect(Collectors.toList());
                modelosFiltrados.forEach(System.out::println);


                List<Veiculo> veiculoList = new ArrayList<>();
                System.out.println("Por favor digite o codigo do veiculo em questão: ");
                var codigoModeloProcurado = teclado.nextLine();


                json = consumoApi.obterDadosRequisicao(ENDERECO + veiculo + "/marcas/"
                        + opcao + "/modelos/" + codigoModeloProcurado + "/anos");

                listAnos.clear();

                listAnos = converteDados.converterDados(json, new TypeReference<List<Ano>>(){});

                List<String> anosProcurados = listAnos.stream()
                        .map(Ano::codigoAno)
                        .collect(Collectors.toList());

                for (int i = 0; i < anosProcurados.size(); i++) {
                    json = consumoApi.obterDadosRequisicao(ENDERECO + veiculo + "/marcas/"
                            + opcao + "/modelos/" + codigoModeloProcurado + "/anos/" + anosProcurados.get(i));
                    veiculoList.add(mapper.readValue(json, Veiculo.class));
                }
                veiculoList.forEach(System.out::println);


            } catch (Exception e ) {
                System.out.println(e.getMessage());
            }

        }catch (IllegalArgumentException e ) {
            System.out.println(e.getMessage());
        }

    }
}
