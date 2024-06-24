public abstract class Conta {
    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    public void transferir(double valor, Conta destino) {
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor de transferência inválido.");
        }
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta " + numero);
        System.out.println("Saldo: R$ " + saldo);
    }
}

