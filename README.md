# Decodiﬁcador de Instruções do MIPS

Este trabalho faz parte de uma série que tem como objetivo final a construção de um simulador de um processador MIPS

Nesta primeira etapa, será implementado um programa, em Java, que que decodifica comandos em linguagem de montagem para instruções de máquina do MIPS

## Como usar

Primeiro compile o programa no seu diretorio raiz

```bash
javac *.java
```

Em seguida execute o programa passando o arquivo de entrada com as instruçoes MIPS e o arquivo onde serao escritas as saidas

```bash
java Mips32decode [arq_entrada] [arq_saida]
```

### Instruçoes suportadas

* Aritméticas: add, addi sub, mult, div, neg

* Lógicas: and, andi, or, ori, xor, nor, slt, slti

* Deslocamento Bit a Bit: sll, srl

* Acesso à Memória: lw, sw

* Desvio Condicional: beq, bne

* Desvio Incondicional: j, jr, jal
