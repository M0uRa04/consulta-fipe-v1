package br.com.consultacarros.model;

import java.util.Objects;

public class Modelo {

    private String modelo;
    private String codigoModelo;

    public Modelo(DadosModelos dadosModelos) {
        this.modelo = dadosModelos.nomeModelo();
        this.codigoModelo = dadosModelos.codigoModelo();
    }

    public String getModelo() {
        return modelo;
    }

    public String getCodigoModelo () {
        return codigoModelo;
    }

    @Override
    public String toString() {
        return
                "Modelo: " + modelo + "  -  " + "Codigo do Modelo: " + codigoModelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo1 = (Modelo) o;
        return Objects.equals(modelo, modelo1.modelo) && Objects.equals(codigoModelo, modelo1.codigoModelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, codigoModelo);
    }
}
