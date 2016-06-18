	.data
	
MatrizA: .word 1,2,3,4,5,6, 7,8,9,10,11,12, 13,14,15,16,17,18, 19,20,21,22,23,24, 25,26,27,28,29,30, 31,32,33,34,35,36
MatrizB: .word 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2
MatrizC: .word 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0
Aux:    .word 0,0,0,0,0,0
	.text
	.globl main
	
main:	
        #enviar as linhas corretas da matriz A
        #o registrador $s0 guarda o id do raspberry que vai receber a linha correspondente ao seu id
        #id=0 recebe a linha 0, id=1 recebe a linha 1, etc...
        li $s0, 0
        #$s1 recebe o n�mero de raspberrys escravos
        li $s1, 1
        #aqui, $s2 � um contador de respostas. Assim que o mestre receber 6 respostas dos 6 escravos, o algoritmo termina
		li $s2, 0
        #$t0 guarda o endere�o de mem�ria do segundo parametro. Nesse caso, "MatrizA"
        la $t0, MatrizA
        #$t1 guarda o endere�o de mem�ria do segundo parametro. Nesse caso, "MatrizB"
        la $t1, MatrizB
        #$t2 guarda o endere�o de mem�ria do segundo parametro. Nesse caso, "MatrizC"
        la $t2, MatrizC        
        #$t3 guarda o endere�o de mem�ria do segundo parametro. Nesse caso, "Aux"
        la $t3, Aux          
        
                        
enviaA: 
		snd $s0, 24, $t0
        addi $s0, $s0, 1
        bne $s0, $s1, enviaA

		li $s0, 0
enviaB: 
		snd $s0, 144, $t1
        addi $s0, $s0, 1
        bne $s0, $s1, enviaB
        

recebeC: 
	rcv $s3, 24, $t3
    #uma vez obtido o id do escravo que enviou a msg, � preciso copiar a linha para o local correto
    #contador de elementos copiados
	li $a0, 0
	#numero total de elementos
	li $a1, 6
	#ajustando o id para servir como multiplicador da linha
	#addi $s3, $s3, 1
	#multiplicando o id pelo endere�o. assim, o id=0 tera sua resposta copiada para o primeiro endere�o, id=1 copiada para o segundo endere�o, etc...
	#$t2 � o endere�o da matriz resultante C
	muli $t4, $s3, 24
	#somando offset ao endereço inicial da MatrizC
	add $a2, $t2, $t4
	#agora $a2 cont�m o endere�o correto
	#precisamos copiar elemento por elemento
copia:	
	lw $a3, 0($t3)
	sw $a3, 0($a2)
	#ajusta o endere�o para apontar para o proximo elemento do vetor Aux
	addi $t3, $t3, 4
	#ajusta o endere�o para apontar para o proximo elemento da linha correspondente da MatrizC
	addi $a2, $a2, 4
	#incrementa o contador de elementos copiados. Se 6 j� tiverem sido copiados, acaba.
	addi $a0, $a0, 1
	bne $a0, $a1, copia
	#uma vez terminada a copia do vetor recem-chegado, � preciso verificar se todos os escravos j� responderam. 
	#incrementa o numero de escravos que responderam
	addi $s2, $s2, 1
	bne $s2, $s1, recebeC

    #terminou o recebimento das respostas de todos os escravos. a matriz C resultante est� pronta.    
                




