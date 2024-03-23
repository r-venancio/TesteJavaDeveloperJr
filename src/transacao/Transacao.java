package transacao;

import usuario.Usuario;

class Transacao {
    private Usuario usuario;
    private double valor;

    public Transacao(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getValor() {
        return valor;
    }
}
