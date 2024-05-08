package br.com.consultacarros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Veiculo {
    @JsonAlias("TipoVeiculo")
    private Integer tipoVeiculo;
    @JsonAlias("Valor")
    private String valor;
    @JsonAlias("Marca")
    private String marca;
    @JsonAlias("Modelo")
    private String modeloVeiculo;
    @JsonAlias("AnoModelo")
    private Integer anoModelo;
    @JsonAlias("Combustivel")
    private String combustivel;
    @JsonAlias("CodigoFipe")
    private String codigoFipe;
    @JsonAlias("MesReferencia")
    private String mesReferencia;
    @JsonAlias("SiglaCombustivel")
    private char siglaCombustivel;

    public Integer getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(Integer tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public char getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(char siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
                "Modelo: " + modeloVeiculo + "\n" +
                "Ano: " + anoModelo + "\n" +
                "Valor: " + valor + "\n" +
                "Combustível: " + combustivel + "\n" +
                "Código FIPE: " + codigoFipe + "\n";
    }
}
