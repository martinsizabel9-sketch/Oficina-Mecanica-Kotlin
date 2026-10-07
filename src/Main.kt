fun main() {

    val veiculo = Veiculo(
        modelo = "Honda Civic",
        placa = "ABC1D23"
    )

    val filtroOleo = Peca("Filtro de óleo", 45.00)
    val oleoMotor = Peca("Óleo do motor", 180.00)

    val trocaOleo = ServicoMecanico("Troca de óleo", 120.00)
    val alinhamento = ServicoMecanico("Alinhamento", 90.00)

    val ordem = OrdemServico(
        veiculo = veiculo,
        codigoStatus = 2,
        pagamentoAVista = true
    )

    ordem.pecas.add(filtroOleo)
    ordem.pecas.add(oleoMotor)

    ordem.servicos.add(trocaOleo)
    ordem.servicos.add(alinhamento)

    ordem.pecaAdicional = Peca("Filtro de ar", 65.00)

    println("=== OFICINA MECÂNICA ===")
    println("Veículo: ${ordem.veiculo.modelo}")
    println("Placa: ${ordem.veiculo.placa}")
    println("Status: ${ordem.descricaoStatus()}")
    println("Subtotal: R$ %.2f".format(ordem.calcularSubtotal()))
    println("Desconto à vista: 5%")
    println("Total: R$ %.2f".format(ordem.calcularTotal()))
}
