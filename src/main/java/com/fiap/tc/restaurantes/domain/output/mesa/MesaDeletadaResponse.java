package com.fiap.tc.restaurantes.domain.output.mesa;

public class MesaDeletadaResponse {
    private boolean sucesso;

    public MesaDeletadaResponse(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}