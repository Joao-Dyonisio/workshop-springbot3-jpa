package com.projetospringudemy.curso.entidades.enums;

public enum PedidoStatus {
    AGURADANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int codigo;

    private PedidoStatus(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }

    public static PedidoStatus valueOf (int codigo) {
        for(PedidoStatus value : PedidoStatus.values()) {
            if(value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo Invalido do status do Pedido");
    }
}
