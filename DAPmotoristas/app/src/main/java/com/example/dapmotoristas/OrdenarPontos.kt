package com.example.dapmotoristas

class OrdenarPontos {
    /*
    /*
        OBS: O CÓDIGO ESTA COM ERRO, POIS AINDA FALTA A PARTE DE IMPLEMENTAR A API DE PONTO A PONTO DO TOM TOM.
            ENTÃO.... A CLASSE FICARÁ APENAS COMENTADA PARA GARANTIR QUE NÃO TENHA ERROS DURANTE A EXECUÇÃO DO APP
            NOS DEMAIS TESTES. O_O
     */
    fun main (enderecoEscola: String, enderecoMotorista: String, enderecos: MutableList<String>) { // fun main(args: ){}

        var enderecoEscola: String = "Rua final"
        var enderecoMotorista: String = "Rua inicial"
        var enderecos: MutableList<String> = mutableListOf()
        var ordem: MutableList<String> = mutableListOf()
        var ordemFinal: MutableList<String> = mutableListOf()
        var distanciaCasaEscola: MutableList<Double> = mutableListOf()

        //preenchimento manual para teste
        enderecos.add("Sesi - São José dos Campos")
        enderecos.add("Shopping Jd.Oriente")
        enderecos.add("Supermercados Coop")
        enderecos.add("Vale Sul Shopping")
        var indice: Int = enderecos.size - 1

        preencheVetorDistancia(enderecos,enderecoEscola, distanciaCasaEscola, indice)
        //preenchimento manual para teste
        distanciaCasaEscola.add(14.014)
        distanciaCasaEscola.add(9.130)
        distanciaCasaEscola.add(9.309)
        distanciaCasaEscola.add(11.172)

//Teste retorno da API do Tomtom usando nossa Key:
//https://api.tomtom.com/routing/1/calculateRoute/47.460858,-122.292098:47.595409,-122.328979/json?key=2XhCWUOz93KHvOjIGSoZ6D8liAgYjcrq
//Trocar as coordenadas para obter o resultado ^-^

        while (enderecos.isNotEmpty()) {
            ordenarCasas(enderecos, distanciaCasaEscola, ordem, indice)
            indice -= 1
        }
        ordem.reverse()
        calculaOrdemFinal(enderecoMotorista, ordem, indice, ordemFinal)
        ordemFinal.add(enderecoEscola)
        println(ordemFinal)
    }


    // chama a API do TomTom passando 2 endereços
    fun calculaDistanciaOD(origem:String, destino: String): Double {
        var distancia: Double
        distancia = PaP(origem, destino) //Imagino que seja em Km...
        return distancia
    }

    // Adiciona a distancia de cada Casa para escola no array distanciaCasaEscola
    fun preencheVetorDistancia(enderecos : MutableList<String>, enderecoEscola: String,
                               distanciaCasaEscola : MutableList<Double>, indice: Int) {
        var distancia: Double
        for (i in 0..indice) {
            distancia = calculaDistanciaOD(enderecos[i], enderecoEscola)
            distanciaCasaEscola.add(distancia)
        }
    }

    // Adiciona a lista ordem e remove de endereco de acordo com a casa mais longe para a mais perto da escola
    fun ordenarCasas(enderecos : MutableList<String>, distanciaEscola: MutableList<Double>,
                     ordem: MutableList<String>, indice:Int) {
        var distancia: Double = 0.0
        var menorDistancia: Double = 0.0
        var indiceC: Int = 0

        for (i in 0..indice) {
            distancia = distanciaEscola[i]
            if(i == 0){
                menorDistancia = distancia
            } else if (distancia < menorDistancia){
                menorDistancia = distancia
                indiceC = i
            }
        }
        ordem.add(enderecos[indiceC])
        enderecos.remove(enderecos[indiceC])
        distanciaEscola.remove(distanciaEscola[indiceC])
    }

    // Otimiza o vetor ordem em um novo vetor ordemFinal
    fun calculaOrdemFinal(enderecoMotorista: String, ordem: MutableList<String>, indice: Int, ordemFinal: MutableList<String>){
        for (i in 0..indice){

            var testeI: Int = i - 1
            var l: Int = 0
            var j: Int = 0 + 1
            var k: Int = 0 + 2
            var distancia1: Double = 0.0
            var distancia2: Double = 0.0
            var distancia3: Double = 0.0
            var menordistancia: Double = 0.0


            if (i == 0){
                distancia1 = calculaDistanciaOD(enderecoMotorista, ordem[i])
                distancia2 = calculaDistanciaOD(enderecoMotorista, ordem[j])
                distancia3 = calculaDistanciaOD(enderecoMotorista, ordem[k])
                if (distancia1 < distancia2 && distancia1 < distancia3){
                    ordemFinal.add(ordem[i])
                    ordem.remove(ordem[i])
                } else if (distancia2 < distancia1 && distancia2 < distancia3){
                    ordemFinal.add(ordem[j])
                    ordem.remove(ordem[j])
                } else {
                    ordemFinal.add(ordem[k])
                    ordem.remove(ordem[k])
                }
            }

            else if (i == indice-2){
                distancia1 = calculaDistanciaOD(ordemFinal[testeI], ordem[l])
                distancia2 = calculaDistanciaOD(ordemFinal[testeI], ordem[j])
                if (distancia1 < distancia2){
                    ordemFinal.add(ordem[l])
                    ordem.remove(ordem[l])
                } else {
                    ordemFinal.add(ordem[j])
                    ordem.remove(ordem[j])
                }
            }

            else if (i == indice-1){
                ordem.add(ordem[i])
                ordem.remove(ordem[i])
            }

            else {
                distancia1 = calculaDistanciaOD(ordemFinal[testeI], ordem[l])
                distancia2 = calculaDistanciaOD(ordemFinal[testeI], ordem[j])
                distancia3 = calculaDistanciaOD(ordemFinal[testeI], ordem[k])
                if (distancia1 < distancia2 && distancia1 < distancia3){
                    ordemFinal.add(ordem[l])
                    ordem.remove(ordem[l])
                } else if (distancia2 < distancia1 && distancia2 < distancia3){
                    ordemFinal.add(ordem[j])
                    ordem.remove(ordem[j])
                } else {
                    ordemFinal.add(ordem[k])
                    ordem.remove(ordem[k])
                }
            }
        }

    }
    */
}
     